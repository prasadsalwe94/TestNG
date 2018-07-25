package appcontroller;

import java.util.List;

import applevelconstants.constants;
import pojo.EmpPojo;
import serviceimpl.ServImpl;
import services.service;

public class EmpController {
	public String validateUserCredentials(String uName,String pwd){
		
		// chk uNndki pwd for null if null return ur msh else check in db
		
		
	String dbUserName =null;
	String dbUserPassword=null;
	try{
		service s=new ServImpl();
		List<EmpPojo> emps=s.getAllEmp();
		for (EmpPojo empPojo : emps) {
			dbUserName=empPojo.getEmp_Name();
			dbUserPassword=empPojo.getEmp_Password();
			break;
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}finally{
		if(dbUserName==null){
			dbUserName="";
		}
		if(dbUserPassword==null){
			dbUserPassword="";
		}
	}
	if(uName==null){
		return constants.USERNAME_INVALID;
	}else if(pwd==null){
		return constants.PASSWORD_INVALID;
	}else if((dbUserName.equals(uName))&&dbUserPassword.equals(pwd)){
		return constants.LOGIN_SUCCESS;
	}
	return constants.INVALID_CREDENTIALS;
	}
}
