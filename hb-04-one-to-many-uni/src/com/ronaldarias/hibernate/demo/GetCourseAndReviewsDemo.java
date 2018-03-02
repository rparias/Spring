package com.ronaldarias.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ronaldarias.demo.entity.Course;
import com.ronaldarias.demo.entity.Instructor;
import com.ronaldarias.demo.entity.InstructorDetail;
import com.ronaldarias.demo.entity.Review;

public class GetCourseAndReviewsDemo {

	public static void main(String[] args) {

		//crear session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)	
									.addAnnotatedClass(Review.class)	//se añade review para esta clase
									.buildSessionFactory();
		
		//crear session
		Session session = factory.getCurrentSession();
		
		try {
			//iniciar la transaccion
			session.beginTransaction();
			
			//obtener el curso
			int theId = 10;
			Course course = session.get(Course.class, theId);
			//mostrar los reviews de ese curso
			System.out.println("Curso: " + course);
			System.out.println("Reviews: " + course.getReviews());
			
			//realizar un commit de la transaccion
			session.getTransaction().commit();
			System.out.println("Transaccion realizada!");
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
