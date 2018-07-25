package serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.EmpEntity;
import pojo.EmpPojo;
import services.service;
import util.HibernateUtil;

public class ServImpl implements service {
	public static Logger logger = Logger.getLogger(ServImpl.class);
	public static SessionFactory sessionFactory=null;
 static{
	sessionFactory= HibernateUtil.getSessionFactory();
 }
	@Override
	public boolean addEmp(EmpPojo e) {
		Session session =null;
		Transaction transaction = null;
		try{
			session=sessionFactory.openSession();
			transaction = session.beginTransaction();
			int a =(Integer) session.save(mapPojoToEntity(e));
			//int aa=mapPojoToEntity(session.save(e));
			HibernateUtil.flushNCommit(session, transaction);
			return a!=0; 
		}
		catch(Exception ex){
			transaction.rollback();
		}
		finally{
			HibernateUtil.closeSession(session);	
		}
		return false;
	}

	@Override
	public boolean deleteEmp(int emp_Id) {
		
		Session session =null;
		Transaction transaction = null;
		try{
			session=sessionFactory.openSession();
			transaction = session.beginTransaction();
			EmpEntity dbEntity= session.get(EmpEntity.class, emp_Id);
			if(dbEntity==null)
				return false;
			session.delete(dbEntity);
			//int aa=mapPojoToEntity(session.save(e));
			HibernateUtil.flushNCommit(session, transaction);
			return true; 
		}
		catch(Exception ex){
			transaction.rollback();
		}
		finally{
			HibernateUtil.closeSession(session);	
		}
		return false;	}

	@Override
	public boolean updateEmp(EmpPojo e) {
		Session session =null;
		Transaction transaction = null;
		try{
			session=sessionFactory.openSession();
			transaction = session.beginTransaction();
			EmpEntity dbEntity= (EmpEntity) session.merge(mapPojoToEntity(e));
			if(dbEntity==null)
				return false;
			//int aa=mapPojoToEntity(session.save(e));
			HibernateUtil.flushNCommit(session, transaction);
			return dbEntity!=null; 
		}
		catch(Exception ex){
			transaction.rollback();
		}
		finally{
			HibernateUtil.closeSession(session);	
		}
		return false;
		
	}

	@Override
	public EmpPojo getEmp(int emp_Id) {
	Session session = null;
	Transaction transaction = null;
	try{
		session = sessionFactory.openSession();
		transaction= session.beginTransaction();
		return mapEntityToPojo(session.get(EmpEntity.class,emp_Id ));
	}
	catch(Exception e){
		transaction.rollback();
	}
	finally{
		HibernateUtil.closeSession(session);
	}
		return null;
	}

	@Override
	public List<EmpPojo> getAllEmp() {
		Session session =null;
		Transaction transaction = null;
		try{
			session=sessionFactory.openSession();
			transaction = session.beginTransaction();
			List<EmpEntity> listOfEntity=session.createQuery("from EmpEntity").list();
			HibernateUtil.flushNCommit(session, transaction);
			return listOfEntityToPojo(listOfEntity); 
		}
		catch(Exception ex){
			transaction.rollback();
		}
		finally{
			HibernateUtil.closeSession(session);	
		}
		return null;
	}
	public EmpEntity mapPojoToEntity(EmpPojo e){
		 if(e==null){
			 return null;
		 }
		 EmpEntity entity = new EmpEntity();
		 entity.setEmp_Id(e.getEmp_Id());
		 entity.setEmp_Name(e.getEmp_Name());
		 entity.setEmp_Password(e.getEmp_Password());
		 String yesOrNo= e.getIsAlive()?"yes":"No";
		 entity.setIsAlive(yesOrNo);
		return entity;
		
	}
	public EmpPojo mapEntityToPojo(EmpEntity e){
		 if(e==null){
			 return null;
		 }
		 EmpPojo pojo = new EmpPojo();
		 pojo.setEmp_Id(e.getEmp_Id());
		 pojo.setEmp_Name(e.getEmp_Name());
		 pojo.setEmp_Password(e.getEmp_Password());
		 pojo.setIsAlive(e.getIsAlive().equals("yes"));
		return pojo;
	}
	public List<EmpPojo>listOfEntityToPojo(List<EmpEntity> listOfEntity){
		List<EmpPojo> listOfPojo=null;
		if(listOfEntity==null || listOfEntity.isEmpty())
			return null;
		listOfPojo = new ArrayList<EmpPojo>();
		for (EmpEntity entity : listOfEntity) {
			listOfPojo.add(mapEntityToPojo(entity));
		}
		return listOfPojo;
		
	}
}
