package com.icss.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import com.icss.hr.analysis.dao.AnaDao;

/**
 * 测试数据分析dao
 * @author DLETC
 *
 */
public class TestAnaDao {
	
	private AnaDao dao = new AnaDao();
	
	@Test
	public void test(){
		//利用List嵌套Map数据结构来存储查询结果
		HashMap<String,Object> map1 = new HashMap<>();
		map1.put("deptName","会计部");
		map1.put("empCount",7);
		
		HashMap<String,Object> map2 = new HashMap<>();
		map2.put("deptName","公关部");
		map2.put("empCount",5);
		
		HashMap<String,Object> map3 = new HashMap<>();
		map3.put("deptName","研发部");
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
