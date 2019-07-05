package com.guigu.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.guigu.bean.Employee;
import com.guigu.dao.EmployeeMapper;

/**
 * 测试dao层的工作
 * @author 曲涛
 *
 */
public class MapperTest {
	/**
	 * 测试DepartmentMapper
	 */
	@Test
	public void testCrud(){
		//1.创建Spring的配置文件
		ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2.c从容器中获取mapper
		//批量插入员工信息，使用批量操作 sqlsession
		SqlSession sqlSession = (SqlSession) ioc.getBean("sqlSession");
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		for(int i = 0;i<1000;i++){
		String uid = UUID.randomUUID().toString().substring(0,5)+i;
		String gender;
		if(i%2==0){
			gender="男";
		}else{
			gender="女";
		}
			mapper.insertSelective(new Employee(null,uid,gender,uid+"@guigu.com",1));
		}
		System.out.println("批量完成！");
	}
}
