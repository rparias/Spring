package com.ronaldarias.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.ronaldarias.demo.entity.Course;
import com.ronaldarias.demo.entity.Instructor;
import com.ronaldarias.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {

		//crear session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)	//se añade el curso para esta clase
									.buildSessionFactory();
		
		//crear session
		Session session = factory.getCurrentSession();
		
		try {
			//iniciar la transaccion
			session.beginTransaction();
			
			//-------Hibernate query con HQL--------//
			//obtener el instructor de la base de datos
			int theID = 1;
			
			Query<Instructor> query = 
					session.createQuery("select i from Instructor i "
							+ "JOIN FETCH i.courses "
							+ "where i.id =:theInstructorId", 
							Instructor.class);
			//asigno el parametro de la consulta
			query.setParameter("theInstructorId", theID);
			
			//ejecuto la consulta
			Instructor instructor = query.getSingleResult();
			System.out.println("Instructor: " + instructor);			
			
			//realizar un commit de la transaccion
			session.getTransaction().commit();

			session.close();
			
			System.out.println("\nLa session ha sido cerrada!\n");
			
			System.out.println("COURSES: " + instructor.getCourses());
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
