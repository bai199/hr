package com.icss.hr.analysis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.icss.hr.common.DbUtil;

/**
 * 数据分析dao
 * 
 * @author DLETC
 *
 */
public class AnaDao {
	/**
	 * 统计每年入职的员工人数
	 * 
	 * @throws SQLException
	 */
	public ArrayList<HashMap<String, Object>> queryEmpCount() throws SQLException {
		Connection conn = DbUtil.getConnection();

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT d.dept_name,COUNT(e.emp_id) emp_count ");
		sql.append("FROM emp e ");
		sql.append("RIGHT OUTER JOIN dept d ON e.emp_dept_id=d.dept_id ");
		sql.append("GROUP BY d.dept_name");

		
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();

		ArrayList<HashMap<String, Object>> list = new ArrayList<>();

		while (rs.next()) {
			HashMap<String, Object> map = new HashMap<>();
			map.put("deptName", rs.getString(1));
			map.put("empCount", rs.getInt(2));

			list.add(map);
		}
		rs.close();
		pstmt.close();
		conn.close();

		return list;

	}

	/**
	 * 统计每个部门的平均工资
	 * @throws SQLException 
	 */
	public ArrayList<HashMap<String, Object>> queryEmpYearCount() throws SQLException {
		Connection conn = DbUtil.getConnection();

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT COUNT(emp.emp_id) empCount ,TO_CHAR(emp.emp_hiredate,'yyyy') Year ");
		sql.append("from emp ");
		sql.append("GROUP  BY TO_CHAR(emp.emp_hiredate,'yyyy') ");
		
		
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();

		ArrayList<HashMap<String, Object>> list = new ArrayList<>();

		while (rs.next()) {
			HashMap<String, Object> map = new HashMap<>();
			map.put("empCount", rs.getString(1));
			map.put("year", rs.getInt(2));

			list.add(map);
		}
		rs.close();
		pstmt.close();
		conn.close();

		return list;

	}
	
	/**
	 * 统计每个部门的最高工资，最低工资
	 * @throws SQLException 
	 */
	public ArrayList<HashMap<String, Object>> queryEmpSal() throws SQLException {
		Connection conn = DbUtil.getConnection();

		StringBuffer sql = new StringBuffer();
		sql.append("select dept.dept_name,max(emp.emp_salary) emp_max_sal,min(emp.emp_salary) emp_min_sal ");
		sql.append("from emp ");
		sql.append("right outer join dept on emp.emp_dept_id=dept.dept_id ");
		sql.append("group by dept.dept_name");
		
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();

		ArrayList<HashMap<String, Object>> list = new ArrayList<>();

		while (rs.next()) {
			HashMap<String, Object> map = new HashMap<>();
			map.put("deptName", rs.getString(1));
			map.put("empMaxSal", rs.getDouble(2));
			map.put("empMinSal", rs.getDouble(3));

			list.add(map);
		}
		rs.close();
		pstmt.close();
		conn.close();

		return list;

	}
}
