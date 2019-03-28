package cn.redwolf.crm.mapper;

import cn.redwolf.crm.domain.Department;
import cn.redwolf.crm.query.BaseQuery;

import java.util.List;

public interface BaseMapper <T>{
    int deleteByPrimaryKey(Long id);

    int insert(T t);

    T selectByPrimaryKey(Long id);

    List<T> selectAll();

    int updateByPrimaryKey(T t);

    List<T> selectPage(BaseQuery baseQuery);
}
