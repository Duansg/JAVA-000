package org.example.routing.base;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

/**
 * @author Duansg
 * @desc 自定义操作
 */
@Slf4j
public class BaseCustomServiceInterfaceImpl<M extends BaseMapper<T>, T extends BaseEntity> extends ServiceImpl<M, T> {

    public final static int DEFAULT_DATA_CHANGE_LIMIT = 200;

    /**
     *
     * @param id
     * @return
     */
    public T selectById(Long id) {
        return this.getById(id);
    }

    /**
     *
     * @param queryWrapper
     * @return
     */
    public T selectOne(Wrapper<T> queryWrapper) {
        return this.getOne(queryWrapper);
    }

    /**
     *
     * @param page
     * @param queryWrapper
     * @return
     */
    public IPage<T> selectPage(IPage<T> page, Wrapper<T> queryWrapper) {
        return this.page(page,queryWrapper);
    }

    /**
     *
     * @param queryWrapper
     * @return
     */
    public List<T> selectList(Wrapper<T> queryWrapper) {
        return this.list(queryWrapper);
    }

    /**
     *
     * @param t
     * @return
     */
    public boolean insert(T t) {
        return this.save(t);
    }

    /**
     *
     * @param t
     * @return
     */
    public T updateByDataId(T t) {
        this.updateById(t);
        return getById(t.getId());
    }

    /**
     * @param t
     * @return
     */
    public boolean deleteById(T t) {
        return this.removeById(t.getId());
    }

}
