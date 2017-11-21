package com.icss.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.icss.hr.pic.dao.PicDao;
import com.icss.hr.pic.pojo.Pic;

/**
 * Õº∆¨dao≤‚ ‘¿‡
 * 
 * @author DLETC
 *
 */
public class TestPicDao {

	private PicDao dao = new PicDao();

	@Test
	public void testInsert() throws FileNotFoundException, SQLException {

		File file = new File("e:3.jpg");

		FileInputStream fis = new FileInputStream(file);

		Pic pic = new Pic("3.jpg", "Œ‚“‡∑≤4", file.length(), "tom", fis, new Date());

		dao.insert(pic);
	}

	@Test
	public void testQuery() throws FileNotFoundException, SQLException {

		List<Pic> list = dao.query();

		for (Pic pic : list) {
			System.out.println(pic);
		}
	}
	
	@Test
	public void testQueryById() throws SQLException, IOException {

		Pic pic = dao.queryById(2);
			System.out.println(pic);
			
			InputStream is = pic.getPicData();
			FileOutputStream fis = new FileOutputStream("e:\\4.jpg");
			
			byte[] b = new byte[1024*8];
			int len = is.read(b);
			
			while(len != -1){
				fis.write(b,0,len);
				len=is.read(b);
			}
			fis.close();
			is.close();
		
	}
	
	@Test
	public void testDelete() throws FileNotFoundException, SQLException {

		dao.delete(4);
	}
}
