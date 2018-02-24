package com.ronaldarias.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ronaldarias.demo.entity.Student;

public class QueryStudentDemo {

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
			
			//query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			imprimirStudents(theStudents);
			
			//students con lastName='Arias'
			theStudents = session.createQuery("from Student s where s.lastName = 'Arias'").getResultList();
			System.out.println("\nStudents con lastName: Arias");
			imprimirStudents(theStudents);
			
			//students con lastName='Arias' OR firstName='Erick'
			theStudents = session.createQuery("from Student s where s.lastName = 'Sanmartin' OR s.firstName = 'Erick'").getResultList();
			System.out.println("\nStudents con lastName: Sanmartin OR firstName: Erick");
			imprimirStudents(theStudents);
			
			//students con email like '%s@info.com'
			theStudents = session.createQuery("from Student s where s.email like '%s@info.com'").getResultList();
			System.out.println("\nStudents con email like '%s@info.com'");
			imprimirStudents(theStudents);			
			
			//realizar un commit de la transaccion
			session.getTransaction().commit();
			System.out.println("\nTransaccion realizada!");
			
		} finally {
			factory.close();
		}

	}
	
	private static void imprimirStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
