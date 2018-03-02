package com.ronaldarias.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ronaldarias.demo.entity.Course;
import com.ronaldarias.demo.entity.Instructor;
import com.ronaldarias.demo.entity.InstructorDetail;
import com.ronaldarias.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

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
			
			//crear un curso
			Course course = new Course("Android basico");
			//agregar reviews
			course.agregarReview(new Review("Buen Curso"));
			course.agregarReview(new Review("Recomendado completamente"));
			course.agregarReview(new Review("El mejor curso de Android"));
			//guardar el curso
			System.out.println("Guardando el curso: " + course);
			System.out.println("REVIEWS: " + course.getReviews());
			session.save(course);
			
			//realizar un commit de la transaccion
			session.getTransaction().commit();
			System.out.println("Transaccion realizada!");
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
