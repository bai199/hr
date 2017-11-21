package com.icss.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.icss.hr.job.dao.JobDao;
import com.icss.hr.job.pojo.Job;

/**
 * 职务dao测试类
 * @author DLETC
 *
 */
public class TestJobDao {
	private JobDao dao = new JobDao();
	
	@Test
	public void testInsert() throws SQLException{
		Job job = new Job("播报员", 8000,3900);
		dao.insert(job);
	}
	
	@Test
	public void testUpdate() throws SQLException{
		Job job = new Job(2, "会计", 3000, 3200);
		dao.update(job);
				
	}
	
	@Test
	public void testDelete() throws SQLException{
		dao.delete(4);
	}
	
	@Test
	public void testQueryById() throws SQLException{
		Job job = dao.queryById(2);
		System.out.println(job);
	}
	@Test
	public void testQuery() throws SQLException{
		List<Job> list = dao.query();
		for(Job job:list){
			System.out.println(job);
		}
	}
	
}
