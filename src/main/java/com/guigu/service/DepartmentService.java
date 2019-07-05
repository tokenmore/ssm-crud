package com.guigu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guigu.bean.Department;
import com.guigu.dao.DepartmentMapper;
@Service
public class DepartmentService {
	@Autowired
	private DepartmentMapper  mapper;
	//查找所有部门信息
	public List<Department> getDepts() {
		 return mapper.selectByExample(null);
	}
	
}
