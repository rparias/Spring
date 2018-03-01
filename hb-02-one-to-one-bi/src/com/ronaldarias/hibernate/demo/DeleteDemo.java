package com.ronaldarias.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ronaldarias.demo.entity.Instructor;
import com.ronaldarias.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {

		//crear session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		//crear session
		Session session = factory.getCurrentSession();
		
		try {
			
			//iniciar la transaccion
			session.beginTransaction();
			
			//obtener el PK del instructor
			int theID = 3;
			Instructor instructor = session.get(Instructor.class, theID);
			
			System.out.println("Instructor encontrado: " + instructor);
			
			//borrar el instructor en cascada junto con instructorDetail por el CascadeType.ALL
			if(instructor != null) {
				System.out.println("Borrando el instructor " + instructor);
				session.delete(instructor);
			} else {
				System.out.println("No se encontro el instructor!");
			}
			
			//realizar un commit de la transaccion
			session.getTransaction().commit();
			System.out.println("Transaccion realizada!");
			
		} finally {
			factory.close();
		}

	}

}
