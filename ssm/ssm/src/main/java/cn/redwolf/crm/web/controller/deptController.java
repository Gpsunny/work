package cn.redwolf.crm.web.controller;

import cn.redwolf.crm.domain.Department;
import cn.redwolf.crm.query.BaseQuery;
import cn.redwolf.crm.query.DepartmentQuery;
import cn.redwolf.crm.service.IDepartmentService;
import cn.redwolf.crm.util.AjaxResult;
import cn.redwolf.crm.util.PageResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/department")
public class deptController {
    @Autowired
    private IDepartmentService departmentService;

    @RequestMapping("/index")
    public String index() {
        return "department/department";
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<Department> list() {
        return departmentService.selectAll();
    }

    @RequestMapping("/page")
    @ResponseBody
    public PageResult<Department> page(DepartmentQuery departmentQuery) {
        return departmentService.selectPage(departmentQuery);
    }

    /**
     * @param id 前台传过来需要删除的数据的id
     * @return 返回给前台的状态
     */
    @RequestMapping("/delete")
    @ResponseBody
    public AjaxResult delete(Long id) {
        if (id != null) {
            try {
                departmentService.deleteByPrimaryKey(id);
            } catch (Exception e) {
                e.printStackTrace();
                return new AjaxResult(e.getMessage());
            }
            return new AjaxResult();
        }
        return new AjaxResult("操作失败");
    }

    //    saveorupdate
    @RequestMapping("/saveorupdate")
    @ResponseBody
    public AjaxResult saveorupdate(Department department) {
//        严谨
        if (department == null) {
            return new AjaxResult("操作失败");
        }
        try {
//        判断有没有id，有就是更新，没有就是增加
            if (department.getId() != null) {
                departmentService.updateByPrimaryKey(department);
            } else {
                departmentService.insert(department);
            }
            return new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(e.getMessage());
        }
    }
}
