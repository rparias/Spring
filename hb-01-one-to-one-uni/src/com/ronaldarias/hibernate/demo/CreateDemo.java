package com.ronaldarias.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ronaldarias.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {

		//crear session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		//crear session
		Session session = factory.getCurrentSession();
		
		try {
			
			//uso de session para guardar los objetos
			
			//crear objeto Student
			Student student = new Student("Ronald", "Arias", "rarias@info.com");
			
			//iniciar la transaccion
			session.beginTransaction();
			
			//guardar el objeto student
			System.out.println("Almacenando el estudiante...");
			session.save(student);
			
			//realizar un commit de la transaccion
			session.getTransaction().commit();
			System.out.println("Transaccion realizada!");
			
		} finally {
			factory.close();
		}

	}

}
