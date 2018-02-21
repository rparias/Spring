package com.ronaldarias.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ronaldarias.demo.entity.Student;

public class PrimaryKeyDemo {

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
			
			//crear 3 objetos Student
			System.out.println("Creando 3 estudiantes");
			Student student1 = new Student("Erick", "Arias", "earias@info.com");
			Student student2 = new Student("Gabby", "Sanmartin", "rougs@info.com");
			Student student3 = new Student("Bryan", "Zuniga", "bzuniga@info.com");
			
			//iniciar la transaccion
			session.beginTransaction();
			
			//guardar el objeto student
			System.out.println("Almacenando los estudiantes...");
			session.save(student1);
			session.save(student2);
			session.save(student3);
			
			//realizar un commit de la transaccion
			session.getTransaction().commit();
			System.out.println("Transaccion realizada!");
			
		} finally {
			factory.close();
		}

	}
	
}
