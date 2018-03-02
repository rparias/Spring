package com.ronaldarias.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ronaldarias.demo.entity.Course;
import com.ronaldarias.demo.entity.Instructor;
import com.ronaldarias.demo.entity.InstructorDetail;
import com.ronaldarias.demo.entity.Review;
import com.ronaldarias.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

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
			
			//crear un curso
			Course course = new Course("Android basico");
			
			//guardar el curso
			System.out.println("Guardando el curso: " + course);
			session.save(course);
			
			//crear los estudiantes
			Student student1 = new Student("Juan", "Perez", "jperez@student.com");
			Student student2 = new Student("Mike", "Ruano", "mruano@student.com");
			Student student3 = new Student("Andrea", "Pancho", "apancho@student.com");
			
			//agregarlos al curso
			course.agregarStudent(student1);
			course.agregarStudent(student2);
			course.agregarStudent(student3);
			
			//guardar los estudiantes
			System.out.println("Guardando estudiantes");
			session.save(student1);
			session.save(student2);
			session.save(student3);
			System.out.println("Estudiantes ingresados: " + course.getStudents());
			
			//realizar un commit de la transaccion
			session.getTransaction().commit();
			System.out.println("Transaccion realizada!");
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
