package com.ronaldarias.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ronaldarias.demo.entity.Course;
import com.ronaldarias.demo.entity.Instructor;
import com.ronaldarias.demo.entity.InstructorDetail;

public class DeleteCourseDemo {

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
			
			//obtener un curso para borrar
			int courseID = 10;
			Course course = session.get(Course.class, courseID);
			
			//borrar el curso
			System.out.println("Curso a borrar: " + course);
			session.delete(course);
			
			//realizar un commit de la transaccion
			session.getTransaction().commit();
			System.out.println("Transaccion realizada!");
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
