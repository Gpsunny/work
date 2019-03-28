package cn.redwolf.crm.service.impl;

import cn.redwolf.crm.domain.Department;
import cn.redwolf.crm.query.DepartmentQuery;
import cn.redwolf.crm.service.IDepartmentService;
import cn.redwolf.crm.util.PageResult;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DepartmentServiceImplTest extends BaseTest{
    @Autowired
    private IDepartmentService departmentService;

    @Test
    public void selectAll() {
        PageHelper.startPage(1, 2);
        List<Department> departments = departmentService.selectAll();
        for (Department department : departments) {
            System.out.println(department);
        }
    }

    @Test
    public void selectPage() {
        DepartmentQuery departmentQuery = new DepartmentQuery();
        PageResult<Department> result = departmentService.selectPage(departmentQuery);
        List<Department> rows = result.getRows();
        for (Department row : rows) {
            System.out.println(row);

        }
    }
}