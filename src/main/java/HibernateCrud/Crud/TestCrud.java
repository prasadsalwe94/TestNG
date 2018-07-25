package HibernateCrud.Crud;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import pojo.EmpPojo;
import serviceimpl.ServImpl;
import services.service;
 
public class TestCrud {
	private static void init() {
		PropertyConfigurator.configure("log4j.properties");
	}
	public static Logger logger = Logger.getLogger(TestCrud.class);
	public static void main(String[] args) throws InterruptedException {
		EmpPojo e1 = new EmpPojo(1, "Abcd", "Prasad", true);
//		EmpPojo e2 = new EmpPojo(2, "Abcdefg", "Prasad2", true);
//		EmpPojo e3 = new EmpPojo(3, "Abcd", "Prasad", true);
//
//		EmpPojo e4 = new EmpPojo(4, "Abcd", "Prasad", true);
//
//		EmpPojo e5 = new EmpPojo(5, "Abcd", "Prasad", true);
//
//		EmpPojo e6 = new EmpPojo(6, "Abcd", "Prasad", true);

		service service1 = new ServImpl();
		service1.addEmp(e1);
//		service1.addEmp(e2);
//		service1.addEmp(e3);
//		service1.addEmp(e4);
//		service1.addEmp(e5);
//		service1.addEmp(e6);

		
		System.out.println(" Element Added:");
//		service1.deleteEmp(2);
//		System.out.println("Element deleted.......");
		System.out.println(service1.getAllEmp());
		System.out.println(service1.getEmp(2));
		for (int i=0;i<10;i++){
			logger.fatal("This is fatal msg");
			logger.error("This is error msg");
//			logger.log(MyOwnLevel.DISASTER, "my disaster message");
			logger.warn("This is warn msg");
			logger.info("This is info msg");
			logger.debug("This is debug msg");
			logger.trace("This is trace msg");
			TimeUnit.SECONDS.sleep(2);
		}
	}
}
