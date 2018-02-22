package com.ronaldarias.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ronaldarias.demo.entity.Student;

public class ReadStudentDemo {

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
			Student student = new Student("Chandler", "Bing", "cbing@info.com");
			
			//iniciar la transaccion
			session.beginTransaction();
			
			//guardar el objeto student
			System.out.println("Almacenando el estudiante...");
			System.out.println(student);
			session.save(student);
			
			//realizar un commit de la transaccion
			session.getTransaction().commit();
			System.out.println("Transaccion realizada!");
			
			
			//RECUPERAR OBJETO STUDENT//
			//imprimo clave primaria
			System.out.println("Student guardado, ID: " + student.getId());
			
			//get a session para iniciar la transaccion
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//recupero el objeto
			System.out.println("\nObteniendo student con ID: " + student.getId());
			
			Student myStudent = session.get(Student.class, student.getId());
			
			System.out.println("Obtenido: " + myStudent);
			
			//commit
			session.getTransaction().commit();
			System.out.println("Transaccion realizada!");
			
		} finally {
			factory.close();
		}

	}

}
