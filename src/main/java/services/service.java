package services;

import java.util.List;

import pojo.EmpPojo;

public interface service {
	public boolean addEmp(EmpPojo e);
	public boolean deleteEmp(int emp_Id);
	public boolean updateEmp(EmpPojo e);
	public EmpPojo getEmp(int emp_Id);
	public List<EmpPojo> getAllEmp();
}
