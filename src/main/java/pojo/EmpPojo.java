package pojo;

public class EmpPojo {
	private int emp_Id;
	private String emp_Password;
	private String emp_Name;
	private boolean isAlive;
	public EmpPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmpPojo(int emp_Id, String emp_Password, String emp_Name,
			boolean isAlive) {
		super();
		this.emp_Id = emp_Id;
		this.emp_Password = emp_Password;
		this.emp_Name = emp_Name;
		this.isAlive = isAlive;
	}
	@Override
	public String toString() {
		return "EmpPojo [emp_Id=" + emp_Id + ", emp_Password=" + emp_Password
				+ ", emp_Name=" + emp_Name + ", isAlive=" + isAlive + "]";
	}
	public int getEmp_Id() {
		return emp_Id;
	}
	public void setEmp_Id(int emp_Id) {
		this.emp_Id = emp_Id;
	}
	public String getEmp_Password() {
		return emp_Password;
	}
	public void setEmp_Password(String emp_Password) {
		this.emp_Password = emp_Password;
	}
	public String getEmp_Name() {
		return emp_Name;
	}
	public void setEmp_Name(String emp_Name) {
		this.emp_Name = emp_Name;
	}
	public boolean getIsAlive() {
		return isAlive;
	}
	public void setIsAlive(Boolean isAlive) {
		this.isAlive = isAlive;
	}
	
}
