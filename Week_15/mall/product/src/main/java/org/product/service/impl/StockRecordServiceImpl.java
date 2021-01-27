package org.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.common.base.BaseCustomServiceInterfaceImpl;
import org.product.dao.StockRecordMapper;
import org.product.entity.StockRecordEntity;
import org.product.service.StockRecordService;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * StockRecordServiceImpl
 *
 * @author duansg
 * @version 1.0
 * @date 2021/1/27 下午4:41
 */
@Service
public class StockRecordServiceImpl extends BaseCustomServiceInterfaceImpl<StockRecordMapper, StockRecordEntity> implements StockRecordService {

    @Override
    public StockRecordEntity selectById(Long id) {
        return super.selectById(id);
    }

    @Override
    public StockRecordEntity selectOne(Wrapper<StockRecordEntity> queryWrapper) {
        return super.selectOne(queryWrapper);
    }

    @Override
    public IPage<StockRecordEntity> selectPage(IPage<StockRecordEntity> page, Wrapper<StockRecordEntity> queryWrapper) {
        return super.selectPage(page, queryWrapper);
    }

    @Override
    public List<StockRecordEntity> selectList(Wrapper<StockRecordEntity> queryWrapper) {
        return super.selectList(queryWrapper);
    }

    @Override
    public boolean insert(StockRecordEntity stockRecordEntity) {
        return super.insert(stockRecordEntity);
    }

    @Override
    public StockRecordEntity updateByDataId(StockRecordEntity stockRecordEntity) {
        return super.updateByDataId(stockRecordEntity);
    }

    @Override
    public boolean deleteById(StockRecordEntity stockRecordEntity) {
        return super.deleteById(stockRecordEntity);
    }
}
