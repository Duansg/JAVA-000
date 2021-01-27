-- @author Duansg
-- @desc return -2:商品不存在,-1:库存不足,0:重复执行,1:成功
-- 成功函数
local function successFun(success, msg, data)
    success = success or 1
    msg = msg or ""
    data = data or {}
    return cjson.encode({success = success, msg = msg, data = data})
end
-- 错误函数
local function response(errno, msg, data)
    errno = errno or 0
    msg = msg or ""
    data = data or {}
    return cjson.encode({errno = errno, msg = msg, data = data})
end
-- 校验批次是否执行过
local batchno = redis.call('EXISTS', KEYS[2])
if batchno > 0 then
    return response(0, "重复执行")
end
-- 校验商品库存是否存在
local stockKey = redis.call('EXISTS', KEYS[1])
if stockKey <= 0 then
    return response(-2, "商品不存在")
end
-- 校验库存数量
local stock = redis.call('GET', KEYS[1])
local stockNum = tonumber(stock);
if (stockNum<=0)then
    return response(-1, "暂无库存")
end

--校验是否满足可扣库存
local finalStockNum =  tonumber(stockNum) - tonumber(ARGV[1])
if (finalStockNum<0)then
    return response(-1, "超出可售库存")
end

-- 记录流水(扣减值,批次号,当前值,版本号)
-- local record = {num = tonumber(ARGV[1]), batchno = ARGV[2], stock = stockNum, version = ARGV[3] }
-- redis.call('SET', KEYS[2],cjson.encode(record))

--修改库存总数
redis.call("DECRBY", KEYS[1], tonumber(ARGV[1]))

-- 更新流水
local stockFinal = redis.call('GET', KEYS[1])
local stockNumFinal = tonumber(stockFinal);
local recordFinal = {num = ARGV[1], batchno = ARGV[2], stock = stockNumFinal, version = ARGV[3] + 1}
-- redis.call('SET', KEYS[2],cjson.encode(recordFinal))
redis.call('LPUSH', 'STOCK:STOCK_RECORD',cjson.encode(recordFinal))
-- 结果
local result = {batchno = ARGV[2], stock = stockNumFinal ,version = ARGV[3] + 2}

if  stockNum ==  tonumber(ARGV[1]) + tonumber(stockNumFinal) then
    return cjson.encode(result)
else
    return response(-1, "暂无库存")
end


