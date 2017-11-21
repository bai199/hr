package com.icss.test;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.icss.hr.common.Pager;
import com.icss.hr.dept.pojo.Dept;
import com.icss.hr.emp.dao.EmpDao;
import com.icss.hr.emp.pojo.Emp;
import com.icss.hr.job.pojo.Job;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 员工Dao测试
 * @author DLETC
 *
 */
public class TestEmpDao {
	
	private EmpDao dao = new EmpDao();
	
	@Test
	public void testInsert() throws SQLException {
		
		Dept dept = new Dept();
		dept.setDeptId(3);
		
		Job job = new Job();
		job.setJobId(1);
		Emp emp = new Emp("tom1", "tom1", "123456", "tom@163.com", "13012345678", 3600, Date.valueOf("1995-10-21"), dept, job, null, "精通java");
		
		dao.insert(emp);
	}
	
	@Test
	public void testUpdate() throws SQLException {
		
		Dept dept = new Dept();
		dept.setDeptId(3);
		
		Job job = new Job();
		job.setJobId(1);
		Emp emp = new Emp(2, "rose", "rose", "123456", "jack@163.com", "13012345678", 3600, Date.valueOf("1995-10-21"), dept, job, null, "精通java");
		
		dao.update(emp);
	}
	@Test
	public void testDelete() throws SQLException{
		dao.delete(3);
	}
	@Test
	public void testQueryById() throws SQLException{
		Emp emp = dao.queryById(2);
		System.out.println(emp);
	}
	@Test
	public void testQueryByLoginName() throws SQLException{
		Emp emp = dao.queryByLoginName("jack11");
		System.out.println(emp);
	}
	
	@Test
	public void testInsertMany() throws SQLException {

		Dept dept = new Dept();
		dept.setDeptId(3);

		for (int i = 1; i <= 20; i++) {
			Job job = new Job();
			job.setJobId(1);
			Emp emp = new Emp("jack" + i, "jack" + i, "123456", "jack@163.com", "13012345678", 4700,
					Date.valueOf("2000-10-1"), dept, job, null, "精通java");

			dao.insert(emp);
		}

	}
	
	@Test
	public void testGetCount() throws SQLException{
		int count = dao.getCount();
		System.out.println(count);
	}
	
	@Test
	public void testQueryByPage() throws SQLException{
		Pager pager = new Pager(dao.getCount(), 5, 20);
		List<Emp> list = dao.queryByPage(pager);
		for(Emp emp:list){
			System.out.println(emp);
		}
	}
	
	@Test
	public void testUpdateEmpPic() throws SQLException{
		dao.updateEmpPic("tom", "sfcdsf");
	}
	
	
}
