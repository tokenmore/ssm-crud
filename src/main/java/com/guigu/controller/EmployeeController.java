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
	 * ��ѯԱ�����ݣ���ҳ��ѯ��
	 * @return
	 */
	@Autowired
	EmployeeService employeeService;
	
	
	
	/**
	 * ����ɾ���͵���ɾ������һ
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
	//�޸�Ա����Ϣ
	@ResponseBody
	@RequestMapping(value="/emp/{empId}",method=RequestMethod.PUT)
	public Msg updateEmp(Employee employee){
		System.out.println(employee);
		employeeService.updateEmp(employee);
		return Msg.success();
	}
	//ͨ��ID��ѯԱ����Ϣ
	@RequestMapping(value="/emp/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Msg getEmp(@PathVariable Integer id){
		Employee employee = employeeService.getEmp(id);
		return Msg.success().add("emp",employee);
	}
	//����û����Ƿ����
	@RequestMapping("/checkUser")
	@ResponseBody
	public Msg checkUsername(String empName){
		String reg = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";
		if(!empName.matches(reg)){
			return Msg.fail().add("va_msg", "�û�������Ϊ6-16λ���ֺ�Ӣ����ϻ���2-5λ����");
		}
		boolean b = employeeService.checkUser(empName);
		if(b){
			return Msg.success();
		}else{
			return Msg.fail().add("va_msg","�û���������");
		}
	}
	//��������Ա��
	@RequestMapping("/emps")
	@ResponseBody
	public Msg getEmpsWithJson(@RequestParam(value="pn",defaultValue="1")Integer pn,Model model){
		//�����ҳ��� pageHelper
				//���빤�߰�֮�󣬿�ֱ�ӵ���startPage���������뵱ǰҳ�룬����ÿҳ��ʾ�Ĳ���
				PageHelper.startPage(pn, 5);
				// startPage֮��Ĳ�ѯ������Ƿ�ҳ��ѯ�Ľ��
				List<Employee> list = employeeService.getAll();
				//ʹ��pageingo��װ��ѯ��Ľ����ֻ��Ҫ��pageinfo����ҳ��
				//��װ�����ŵķ�ҳ��Ϣ��������ѯ����������,�ڶ��������Ǳ�ʾ������ʾ��ҳ��
				PageInfo page = new PageInfo(list,5);
				return Msg.success().add("pageinfo",page);
	}
	
	//������Ա����Ϣ
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
