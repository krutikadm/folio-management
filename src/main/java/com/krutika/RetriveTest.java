package com.krutika;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.krutika.pojo.StudentBean;

public class RetriveTest {
	public static void main(String[]args) {
		Configuration cfg = new Configuration();
		cfg.configure("com\\krutika\\config\\hibernate.cfg.xml");
		System.out.println(cfg.getProperty("hibernate.connection.driver_class"));
		
		SessionFactory factory= cfg.buildSessionFactory();
		Session ses = factory.openSession();
		Transaction tx = ses.beginTransaction();
		
		
		
		/* Using get() and load() we can fetch data from DB.Load() returns ObjectNotFoundException if records
		 *  not there in database but get() returns nullPointerException if records not there in DB*/
		
		StudentBean stu= (StudentBean)ses.get(StudentBean.class, 105);
		System.out.println(stu.getSno()+"\t"+stu.getSname()+"\t"+stu.getSadd());
		
		stu.setSname("Mike");
		tx.commit();
			
		/*StudentBean stu= (StudentBean)ses.load(StudentBean.class, 108);
		System.out.println(stu.getSno()+"\t"+stu.getSname()+"\t"+stu.getSadd());*/
		
		
		
		
	}
}
