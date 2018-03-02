package com.ronaldarias.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ronaldarias.demo.entity.Course;
import com.ronaldarias.demo.entity.Instructor;
import com.ronaldarias.demo.entity.InstructorDetail;
import com.ronaldarias.demo.entity.Review;
import com.ronaldarias.demo.entity.Student;

public class DeleteStudentDemo {

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
			
			//obtener un estudiante
			int idEstudiante = 3;
			Student estudiante = session.get(Student.class, idEstudiante);
			System.out.println("Student Obtenido: " + estudiante);
			
			//eliminar el curso sin que deban eliminarse los estudiantes que estan inscritos
			System.out.println("Borrando el estudiante");
			session.delete(estudiante);
			
			//realizar un commit de la transaccion
			session.getTransaction().commit();
			System.out.println("Transaccion realizada!");
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
