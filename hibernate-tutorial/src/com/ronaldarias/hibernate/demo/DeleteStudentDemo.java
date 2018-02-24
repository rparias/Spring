package com.ronaldarias.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ronaldarias.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		//crear session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		//crear session
		Session session = factory.getCurrentSession();
		
		try {
			
			//iniciar la transaccion
			session.beginTransaction();
			
			//actualizar nombre por ID
			int studentID = 4;
			Student myStudent = session.get(Student.class, studentID);
			session.delete(myStudent);
			
			//realizar un commit de la transaccion
			session.getTransaction().commit();
			System.out.println("Transaccion realizada!");
			
			
			//actualizar todos los emails
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("delete from Student where id = 5").executeUpdate();
			
			session.getTransaction().commit();
			System.out.println("Student eliminado!");
			
		} finally {
			factory.close();
		}

	}

}
