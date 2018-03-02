package com.ronaldarias.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ronaldarias.demo.entity.Course;
import com.ronaldarias.demo.entity.Instructor;
import com.ronaldarias.demo.entity.InstructorDetail;
import com.ronaldarias.demo.entity.Review;
import com.ronaldarias.demo.entity.Student;

public class AddCoursesForOneStudentDemo {

	public static void main(String[] args) {

		//crear session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)	
									.addAnnotatedClass(Review.class)	
									.addAnnotatedClass(Student.class)	//se añade student para esta clase
									.buildSessionFactory();
		
		//crear session
		Session session = factory.getCurrentSession();
		
		try {
			//iniciar la transaccion
			session.beginTransaction();
			
			//obtener un estudiante de la base de datos
			int theId = 3;
			Student andrea = session.get(Student.class, theId);
			System.out.println("Estudiante obtenido: " + andrea);
			System.out.println("Cursos actuales: " + andrea.getCourses());
			
			//crear mas cursos
			Course cursoJava = new Course("Curso intermedio de Java");
			Course cursoIos = new Course("Curso basico de iOS");
			
			//agregar al estudiante a los cursos
			cursoJava.agregarStudent(andrea);
			cursoIos.agregarStudent(andrea);
			
			//guardar los cursos
			System.out.println("Guardando los cursos");
			session.save(cursoJava);
			session.save(cursoIos);
			
			//realizar un commit de la transaccion
			session.getTransaction().commit();
			System.out.println("Transaccion realizada!");
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
