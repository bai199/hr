package com.icss.hr.emp.service;
/**
 * Ա��ҵ��
 */
import java.sql.SQLException;
import java.util.List;

import com.icss.hr.common.Pager;
import com.icss.hr.emp.dao.EmpDao;
import com.icss.hr.emp.pojo.Emp;

public class EmpService {
	
	private EmpDao dao = new EmpDao();
	
	/**
	 * �����û������룬��֤�û���¼
	 * @param empLoginName �û���
	 * @param empPwd ����
	 * @return ����1�����û��������ڣ�����2����������󣬷���3�����¼�ɹ�
	 * @throws SQLException 
	 * 
	 */
	public int checkLogin(String empLoginName,String empPwd) throws SQLException {
		Emp emp = dao.queryByLoginName(empLoginName);
		if (emp == null) {
			return 1;
		}else if (!empPwd.equals(emp.getEmpPwd())) {
			return 2;
		}else{
			return 3;
		}
	}

	// ��������
	public void addEmp(Emp emp) throws SQLException {
		dao.insert(emp);
	}

	// �޸�����
	public void updateEmp(Emp emp) throws SQLException {
		dao.update(emp);
	}

	// ɾ������
	public void deleteEmp(int empId) throws SQLException {
		dao.delete(empId);
	}

	// ��ѯ����
	public Emp queryEmpById(int empId) throws SQLException {
		return dao.queryById(empId);
	}

	// ��¼��ѯ
	public Emp queryEmpByLoginName(String empLoginName) throws SQLException {
		return dao.queryByLoginName(empLoginName);
	}
	
	public List<Emp> queryEmpByPage(Pager pager) throws SQLException{
		return dao.queryByPage(pager);
	}
	public Emp queryByLoginName(String empLoginName) throws SQLException {
		return dao.queryByLoginName(empLoginName);
	}
	
	public int getEmpcount() throws SQLException {
		return dao.getCount();
	}
	public void updateEmpPwd(Emp emp) throws SQLException {
		dao.updatePwd(emp);
	}
	/**
	 * �޸��û�ͷ��
	 * @throws SQLException 
	 */
	public void updateEmpPic(String empLoginName,String empPic) throws SQLException {
		dao.updateEmpPic(empLoginName, empPic);
	}
}
