package com.guigu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guigu.bean.Department;
import com.guigu.bean.Msg;
import com.guigu.service.DepartmentService;

@Controller
public class DepartmentController {
	
	@Autowired
	public DepartmentService departmentService;
	
	@RequestMapping("/depts")
	@ResponseBody
	public Msg getDepts(){
		List<Department> depts = departmentService.getDepts();
		return Msg.success().add("depts",depts);
	}
}
