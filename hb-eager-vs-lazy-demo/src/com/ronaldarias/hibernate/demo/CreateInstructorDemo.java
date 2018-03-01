package com.ronaldarias.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ronaldarias.demo.entity.Course;
import com.ronaldarias.demo.entity.Instructor;
import com.ronaldarias.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

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
			
			//crear objetos
			Instructor instructor = new Instructor("Ronald", "Arias", "rarias@udla.edu.ec");
			InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/user/ronaldmetalero", "Escuchar Metal");
		
//			Instructor instructor = new Instructor("Gabby", "Sanmartin", "rsanmartin@uce.edu.ec");
//			InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/user/Gxbby7", "Tocar guitarra");
			
//			Instructor instructor = new Instructor("Juan", "Perez", "jperez@uce.edu.ec");
//			InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/user/juan", "Stalkear");
			
			//asocio los objetos
			instructor.setInstructorDetail(instructorDetail);
			
			//iniciar la transaccion
			session.beginTransaction();
			
			/* usar CascadeType.ALL
			 * hace que se guarde tambien
			 * en instructorDetail 
			 * debido a la relacion 1 a 1*/
			
			System.out.println("Guardando el instructor: " + instructor);
			session.save(instructor);
			
			//realizar un commit de la transaccion
			session.getTransaction().commit();
			System.out.println("Transaccion realizada!");
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
