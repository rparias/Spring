package com.ronaldarias.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ronaldarias.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//necesito inyectar el session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		//obtener la sessionFactory actual, importar libreria de hibernate
		Session currentSession = sessionFactory.getCurrentSession();
		
		//crear la consulta
		Query<Customer> consulta = currentSession.createQuery("from Customer", Customer.class);
		
		//ejecutar la consulta
		List<Customer> customers = consulta.getResultList();
		
		//retornar los resultados
		return customers;
	}

}
