package com.albert.springboot03web.dao;

import com.albert.springboot03web.pojo.Department;
import com.albert.springboot03web.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {

    @Autowired
    private DepartmentDao departmentDao;
    // 模拟数据库中的数据
    private static Map<Integer, Employee> employees = null;

    static {
        employees = new HashMap<>();
        employees.put(1001, new Employee(1001, "AA", "AA1001@qq.com", 1, new Department(101, "市场部")));
        employees.put(1002, new Employee(1002, "BB", "BB1002@qq.com", 0, new Department(102, "运营部")));
        employees.put(1003, new Employee(1003, "CC", "CC1003@qq.com", 1, new Department(103, "产品部")));
        employees.put(1004, new Employee(1004, "DD", "DD1004@qq.com", 0, new Department(104, "研发部")));
        employees.put(1005, new Employee(1005, "EE", "EE1005@qq.com", 1, new Department(105, "后勤部")));
    }

    // 主键自增
    private static Integer initId = 106;

    // 新增员工
    public void save(Employee employee){
        if (employee.getId()==null){
            employee.setId(initId);
            initId++;
        }

        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }

    // 删除员工
    public void delete(Integer id){
        employees.remove(id);
    }

    // 查询全部员工
    public Collection<Employee> getAll(){
        return employees.values();
    }

    // 根据id查询员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }
}
