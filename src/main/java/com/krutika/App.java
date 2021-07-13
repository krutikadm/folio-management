package com.krutika;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.krutika.pojo.StudentBean;

public class App 
{
    public static void main( String[] args )
    {
    	//Create a configuration object
    	
    	Configuration cfg = new Configuration();
        System.out.println(cfg.getProperty("hibernate.connection.driver_class"));
        cfg.configure("com\\krutika\\config\\hibernate.cfg.xml");
        System.out.println(cfg.getProperty("hibernate.connection.driver_class"));
        
        //Build SessionFactory
        
        SessionFactory factory = cfg.buildSessionFactory();
        
        //Create Session Object
        
        Session ses = factory.openSession();
        Transaction tx =ses.beginTransaction();
        
        //Perform persistence operation
        
        StudentBean stu = new StudentBean();//Transient state
        stu.setSno(105);
        stu.setSname("Somi");
        stu.setSadd("INDIA");
        
        ses.saveOrUpdate(stu);
        tx.commit();
        
       /* StudentBean stu1=(StudentBean)ses.merge(stu);
        System.out.println(stu1.getSno()+"\t"+stu.getSname()+"\t"+stu.getSadd());
        tx.commit();*/
        
        
        
        /*ses.update(stu);
        tx.commit();
        
        ses.persist(stu);
        tx.commit();
        
        Integer id= (Integer)ses.save(stu);//persistence state
        System.out.println("Generated Identifier "+id);
        tx.commit();
        System.out.println(ses.contains(stu));
        ses.evict(stu);
        System.out.println(ses.contains(stu));
        ses.close();
        factory.close();*/
        
    }
}
