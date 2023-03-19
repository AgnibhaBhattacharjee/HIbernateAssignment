package com.gl.HibernateAssignment;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import config.HibernateConfig;

import entity.Teacher;

/**
 * Hello world!
 *
 */
public class App 
{private static SessionFactory factory = HibernateConfig.getSessionFactory();
    public static void main( String[] args )
    {
       
		System.out.println("config loaded");
		Teacher teacher= new Teacher();
		teacher.setF_name("Ankan");
		teacher.setL_name("Biswas");
		teacher.setEmail("ankan@gmail.com");
		
		
		//Inserting a Record
		//insertTeacher(teacher);
		
		
		//Getting record
//		Teacher t1= getTeacherById(1);
//		System.out.println(t1.toString());
		
		
		//Updating a record
//		Teacher t2= getTeacherById(2);
//		t2.setL_name("Kumar Biswas");
//		t2.setEmail("ankan1998@gmail.com");
//		System.out.println(updateTeacher(t2).toString());
		
		
		//Deleting a record
//		Teacher t3= getTeacherById(2);
//		System.out.println(t3.toString());
//		deleteTeacher(t3);
//		
		
		//Get all Teachers
//		getAllteachers();
		
		
		//Loading record
//		Teacher proxy=loadTeacherById(1);
//		System.out.println(proxy.getId());
//		System.out.println("*************************************");
//		System.out.println(proxy.getClass().getName());
//		System.out.println(proxy.getF_name()+" "+proxy.getL_name());
		
    }
    private static void getAllteachers() {
		// TODO Auto-generated method stub
    	List<Teacher> teachers= new ArrayList<Teacher>();
    	Session session= factory.openSession();
		teachers=session.createQuery("from Teacher",Teacher.class ).getResultList();
		for(Teacher t1: teachers){
			System.out.println(t1.toString());
		}
		session.close();
	}
	private static void deleteTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
    	Session session= factory.openSession();
		Transaction tx= session.beginTransaction();
		
		session.remove(teacher);
		tx.commit();
		session.close();
		System.out.println("Teacher record deleted");

		
}
	private static Teacher getTeacherById(int id) {
		// TODO Auto-generated method stub
    	Session session= factory.openSession();
    	Teacher t1=session.get(Teacher.class, id);
    	session.close();
    	return t1;
    	
	}
    private static Teacher loadTeacherById(int id) {
		// TODO Auto-generated method stub
    	Session session= factory.openSession();
    	Teacher t1= new Teacher();
    	t1=session.load(Teacher.class, id);
    	//session.close();
    	return t1;
	}
	public static void  insertTeacher(Teacher teacher){
		Session session= factory.openSession();
		Transaction tx= session.beginTransaction();
		session.save(teacher);
		tx.commit();
		session.close();
		System.out.println("Teacher record inserted");
	}
    public static Teacher  updateTeacher(Teacher teacher){
		Session session= factory.openSession();
		Transaction tx= session.beginTransaction();
		Teacher updatedTeacher= (Teacher) session.merge(teacher);
		//session.update(teacher);
		tx.commit();
		session.close();
		System.out.println("Teacher record updated");
		//return updatedTeacher;
		return updatedTeacher;
	}
}
