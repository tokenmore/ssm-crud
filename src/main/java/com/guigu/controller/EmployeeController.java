package com.guigu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guigu.bean.Employee;
import com.guigu.bean.Msg;
import com.guigu.service.EmployeeService;

@Controller
public class EmployeeController {
	/**
	 * 查询员工数据（分页查询）
	 * @return
	 */
	@Autowired
	EmployeeService employeeService;
	
	
	
	/**
	 * 批量删除和单个删除二合一
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/emp/{ids}",method=RequestMethod.DELETE)
	public Msg deleteEmp(@PathVariable("ids") String ids){
		if(ids.contains("-")){
			List<Integer> del_ids = new ArrayList<>();
			String[] str_ids = ids.split("-");
			for (String del_id : str_ids) {
				del_ids.add(Integer.parseInt(del_id));
			}
			employeeService.deleteEmpBatch(del_ids);
		}else{
			int id = Integer.parseInt(ids);
			employeeService.deleteEmp(id);
		}
		return Msg.success();
	}
	//修改员工信息
	@ResponseBody
	@RequestMapping(value="/emp/{empId}",method=RequestMethod.PUT)
	public Msg updateEmp(Employee employee){
		System.out.println(employee);
		employeeService.updateEmp(employee);
		return Msg.success();
	}
	//通过ID查询员工信息
	@RequestMapping(value="/emp/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Msg getEmp(@PathVariable Integer id){
		Employee employee = employeeService.getEmp(id);
		return Msg.success().add("emp",employee);
	}
	//检查用户名是否可用
	@RequestMapping("/checkUser")
	@ResponseBody
	public Msg checkUsername(String empName){
		String reg = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";
		if(!empName.matches(reg)){
			return Msg.fail().add("va_msg", "用户名必须为6-16位数字和英文组合或者2-5位中文");
		}
		boolean b = employeeService.checkUser(empName);
		if(b){
			return Msg.success();
		}else{
			return Msg.fail().add("va_msg","用户名不可用");
		}
	}
	//遍历所有员工
	@RequestMapping("/emps")
	@ResponseBody
	public Msg getEmpsWithJson(@RequestParam(value="pn",defaultValue="1")Integer pn,Model model){
		//引入分页插件 pageHelper
				//引入工具包之后，可直接调用startPage方法，传入当前页码，传入每页显示的参数
				PageHelper.startPage(pn, 5);
				// startPage之后的查询结果就是分页查询的结果
				List<Employee> list = employeeService.getAll();
				//使用pageingo包装查询后的结果，只需要将pageinfo交给页面
				//封装了相信的分页信息，包括查询出来的数据,第二个参数是表示连续显示的页数
				PageInfo page = new PageInfo(list,5);
				return Msg.success().add("pageinfo",page);
	}
	
	//插入新员工信息
	@RequestMapping(value="/emp",method=RequestMethod.POST)
	@ResponseBody
	public Msg save_emp(@Valid Employee employee,BindingResult result){
		if(result.hasErrors()){
			Map<String, Object> map = new HashMap<>();
			List<FieldError> list = result.getFieldErrors();
			for (FieldError fieldError : list) {
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return Msg.fail().add("errorFiled", map);
		}else{
			employeeService.saveEmp(employee);
			return Msg.success();
		}
	}
	
}
