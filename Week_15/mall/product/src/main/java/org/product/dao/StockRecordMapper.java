package org.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.product.entity.StockRecordEntity;

@Mapper
public interface StockRecordMapper extends BaseMapper<StockRecordEntity> {

}
