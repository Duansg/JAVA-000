package org.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.product.entity.ProductInfoEntity;

/**
 * ProductInfoMapper
 *
 * @author duansg
 * @version 1.0
 * @date 2021/1/27 下午2:16
 */
@Mapper
public interface ProductInfoMapper extends BaseMapper<ProductInfoEntity> {

    ProductInfoEntity getForUpdate(@Param("id")Long id);
}
