package com.guigu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guigu.bean.Employee;
import com.guigu.bean.EmployeeExample;
import com.guigu.bean.EmployeeExample.Criteria;
import com.guigu.dao.EmployeeMapper;
@Service
public class EmployeeService {

	@Autowired
	EmployeeMapper employeeMapper;
	
	//查询所有员工
	public List<Employee> getAll() {
		return employeeMapper.selectByExampleWithDept(null);
	}

	public void saveEmp(Employee employee) {
		// TODO Auto-generated method stub
		employeeMapper.insertSelective(employee);
	}

	public boolean checkUser(String name) {
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmpNameEqualTo(name);
		long l = employeeMapper.countByExample(example);
		return l ==0;
	}

	public Employee getEmp(Integer id) {
		Employee employee = employeeMapper.selectByPrimaryKey(id);
		return employee;
	}

	public void updateEmp(Employee employee) {
		employeeMapper.updateByPrimaryKeySelective(employee);
	}

	public void deleteEmp(Integer id) {
		employeeMapper.deleteByPrimaryKey(id);
	}

	public void deleteEmpBatch(List<Integer> del_ids) {
		EmployeeExample example = new EmployeeExample();
				Criteria criteria = example.createCriteria();
				criteria.andEmpIdIn(del_ids);
		employeeMapper.deleteByExample(example);
	}

}
