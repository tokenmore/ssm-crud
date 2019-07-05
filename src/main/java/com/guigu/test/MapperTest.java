package com.guigu.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.guigu.bean.Employee;
import com.guigu.dao.EmployeeMapper;

/**
 * ����dao��Ĺ���
 * @author ����
 *
 */
public class MapperTest {
	/**
	 * ����DepartmentMapper
	 */
	@Test
	public void testCrud(){
		//1.����Spring�������ļ�
		ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2.c�������л�ȡmapper
		//��������Ա����Ϣ��ʹ���������� sqlsession
		SqlSession sqlSession = (SqlSession) ioc.getBean("sqlSession");
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		for(int i = 0;i<1000;i++){
		String uid = UUID.randomUUID().toString().substring(0,5)+i;
		String gender;
		if(i%2==0){
			gender="��";
		}else{
			gender="Ů";
		}
			mapper.insertSelective(new Employee(null,uid,gender,uid+"@guigu.com",1));
		}
		System.out.println("������ɣ�");
	}
}
