package org.example.shardingsphere.base;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface BaseCustomServiceInterface<T,K> extends IService<T> {
    /**
     * @param id
     * @return
     */
    T selectById(K id);

    /**
     *
     * @param queryWrapper
     * @return
     */
    T selectOne(Wrapper<T> queryWrapper);

    /**
     * @param page
     * @param queryWrapper
     * @return
     */
    IPage<T> selectPage(IPage<T> page, Wrapper<T> queryWrapper);

    /**
     * @param queryWrapper
     * @return
     */
    List<T> selectList(Wrapper<T> queryWrapper);

    /**
     * @param data
     * @return
     */
    boolean insert(T data);

    /**
     * @param data
     * @return
     */
    T updateByDataId(T data);

    /**
     *
     * @param t
     * @return
     */
    boolean deleteById(T t);
}
