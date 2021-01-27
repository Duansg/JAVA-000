package org.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.common.base.BaseCustomServiceInterfaceImpl;
import org.product.dao.ProductInfoMapper;
import org.product.entity.ProductInfoEntity;
import org.product.service.ProductInfoService;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * ProductInfoServiceImpl
 * @author Duansg
 * @version 1.0
 */
@Service
public class ProductInfoServiceImpl extends BaseCustomServiceInterfaceImpl<ProductInfoMapper, ProductInfoEntity> implements ProductInfoService {

    @Override
    public ProductInfoEntity selectById(Long id) {
        return super.selectById(id);
    }

    @Override
    public ProductInfoEntity selectOne(Wrapper<ProductInfoEntity> queryWrapper) {
        return super.selectOne(queryWrapper);
    }

    @Override
    public IPage<ProductInfoEntity> selectPage(IPage<ProductInfoEntity> page, Wrapper<ProductInfoEntity> queryWrapper) {
        return super.selectPage(page, queryWrapper);
    }

    @Override
    public List<ProductInfoEntity> selectList(Wrapper<ProductInfoEntity> queryWrapper) {
        return super.selectList(queryWrapper);
    }

    @Override
    public boolean insert(ProductInfoEntity productInfoEntity) {
        return super.insert(productInfoEntity);
    }

    @Override
    public ProductInfoEntity updateByDataId(ProductInfoEntity productInfoEntity) {
        return super.updateByDataId(productInfoEntity);
    }

    @Override
    public boolean deleteById(ProductInfoEntity productInfoEntity) {
        return super.deleteById(productInfoEntity);
    }

    @Override
    public ProductInfoEntity getForUpdate(Long id) {
        return super.baseMapper.getForUpdate(id);
    }
}
