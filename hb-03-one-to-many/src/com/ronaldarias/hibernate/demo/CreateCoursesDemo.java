package com.ronaldarias.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ronaldarias.demo.entity.Course;
import com.ronaldarias.demo.entity.Instructor;
import com.ronaldarias.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

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
			
			//obtener el instructor de la base de datos
			int theID = 1;
			Instructor instructor = session.get(Instructor.class, theID);
			System.out.println(instructor);
			
			//crear algunos cursos
			Course curso1 = new Course("Curso de java basico");
			Course curso2 = new Course("Curso de Spring framework");
			Course curso3 = new Course("Curso de Android");
			
			//agregar los cursos al instructor
			instructor.agregarCurso(curso1);
			instructor.agregarCurso(curso2);
			instructor.agregarCurso(curso3);
			
			//guardar los cursos			
			System.out.println("Guardando los cursos");
			session.save(curso1);
			session.save(curso2);
			session.save(curso3);
			
			//realizar un commit de la transaccion
			session.getTransaction().commit();
			System.out.println("Transaccion realizada!");
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
