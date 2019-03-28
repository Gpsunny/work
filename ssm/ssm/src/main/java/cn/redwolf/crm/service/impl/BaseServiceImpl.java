package cn.redwolf.crm.service.impl;

import cn.redwolf.crm.domain.Department;
import cn.redwolf.crm.mapper.BaseMapper;
import cn.redwolf.crm.query.BaseQuery;
import cn.redwolf.crm.service.IBaseService;
import cn.redwolf.crm.util.PageResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BaseServiceImpl<T> implements IBaseService<T> {

    @Autowired
    private BaseMapper<T> baseMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return baseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(T t) {
        return baseMapper.insert(t);
    }

    @Override
    public T selectByPrimaryKey(Long id) {
        return baseMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<T> selectAll() {
        return baseMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(T t) {
        return baseMapper.updateByPrimaryKey(t);
    }

    @Override
    public PageResult<T> selectPage(BaseQuery baseQuery){
//        使用分页助手
        Page<T> pages = PageHelper.startPage(baseQuery.getPage(), baseQuery.getRows());
        baseMapper.selectPage(baseQuery);
//            构造分页 所需要的数据
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setRows(pages);
        pageResult.setTotal(pages.getTotal());
        return pageResult;

    }
}
