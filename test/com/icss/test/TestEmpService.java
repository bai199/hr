package com.icss.test;

import java.sql.SQLException;

import org.junit.Test;

import com.icss.hr.emp.service.EmpService;

/**
 * Ա��ҵ�����
 * @author DLETC
 *
 */
public class TestEmpService {
	private EmpService service = new EmpService();
	
	@Test
	public void testCheckLogin() throws SQLException{
		
		int result = service.checkLogin("rose", "123456");
		System.out.println(result);
	}
}
