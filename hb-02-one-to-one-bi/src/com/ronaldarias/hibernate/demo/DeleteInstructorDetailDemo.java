package com.ronaldarias.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ronaldarias.demo.entity.Instructor;
import com.ronaldarias.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {

		// crear session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// crear session
		Session session = factory.getCurrentSession();

		try {

			// iniciar la transaccion
			session.beginTransaction();

			// obtener el PK del instructorDetail
			int theID = 5;

			InstructorDetail instructorDetail = session.get(InstructorDetail.class, theID);

			System.out.println("instructorDetail: " + instructorDetail);
			System.out.println("Instructor asociado: " + instructorDetail.getInstructor());
			
			//borrar el instructor pero borrando primero el instructorDetail en cascada bidireccional
			System.out.println("Borrando instuctorDetail: " + instructorDetail);
			
				//CON ESTO SE QUITA EL NULL POINTER EXCEPTION DE EJECUCION AL BORRAR
				//borrar el objeto de referencia asociado para romper el link bi-direccional
				instructorDetail.getInstructor().setInstructorDetail(null);
			
			session.delete(instructorDetail);

			// realizar un commit de la transaccion
			session.getTransaction().commit();
			System.out.println("Transaccion realizada!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}

}
