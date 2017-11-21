package com.icss.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import com.icss.hr.analysis.dao.AnaDao;

/**
 * �������ݷ���dao
 * @author DLETC
 *
 */
public class TestAnaDao {
	
	private AnaDao dao = new AnaDao();
	
	@Test
	public void test(){
		//����ListǶ��Map���ݽṹ���洢��ѯ���
		HashMap<String,Object> map1 = new HashMap<>();
		map1.put("deptName","��Ʋ�");
		map1.put("empCount",7);
		
		HashMap<String,Object> map2 = new HashMap<>();
		map2.put("deptName","���ز�");
		map2.put("empCount",5);
		
		HashMap<String,Object> map3 = new HashMap<>();
		map3.put("deptName","�з���");
		map3.put("empCount",3);
		
		ArrayList<HashMap<String,Object>> list = new ArrayList<>();
		list.add(map1);
		list.add(map2);
		list.add(map3);
		
		System.out.println(list);
		
	}
	
	@Test
	public void testQueryEmpCount() throws SQLException{
		
		ArrayList<HashMap<String,Object>> list = dao.queryEmpCount();		
		
		System.out.println(list);
		
	}
	@Test
	public void testQueryEmpAvgSal() throws SQLException{
		
		ArrayList<HashMap<String,Object>> list = dao.queryEmpYearCount();		
		
		System.out.println(list);
		
	}
	
	@Test
	public void testQueryEmpSal() throws SQLException{
		
		ArrayList<HashMap<String,Object>> list = dao.queryEmpSal();		
		
		System.out.println(list);
		
	}
}
