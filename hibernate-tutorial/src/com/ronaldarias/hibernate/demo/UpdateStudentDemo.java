package com.ronaldarias.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ronaldarias.demo.entity.Student;

public class UpdateStudentDemo {

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
			System.out.println("Nombre Anterior: " + myStudent.getFirstName());
			myStudent.setFirstName("Steven");
			System.out.println("Nombre Nuevo: " + myStudent.getFirstName());
			
			//realizar un commit de la transaccion
			session.getTransaction().commit();
			System.out.println("Transaccion realizada!");
			
			
			//actualizar todos los emails
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("update Student set email = 'foo@gmail.com'").executeUpdate();
			
			session.getTransaction().commit();
			System.out.println("Emails actualizados!");
			
		} finally {
			factory.close();
		}

	}

}
