package cn.redwolf.crm.service;

import cn.redwolf.crm.query.BaseQuery;
import cn.redwolf.crm.util.PageResult;

import java.util.List;

public interface IBaseService<T>{

    int deleteByPrimaryKey(Long id);

    int insert(T t);

    T selectByPrimaryKey(Long id);

    List<T> selectAll();

    int updateByPrimaryKey(T t);

    PageResult<T> selectPage(BaseQuery baseQuery);
}
