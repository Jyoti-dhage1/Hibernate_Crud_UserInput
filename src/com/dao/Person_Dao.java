package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.entity.Person;

import jakarta.persistence.criteria.AbstractQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class Person_Dao {

	public void insertData(int age, String name, String city) {

		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Person.class);
		
		SessionFactory sf= cfg.buildSessionFactory();
		Session ss= sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		Person p = new Person();
		p.setAge(age);
		p.setName(name);
		p.setCity(city);
		
		ss.persist(p);
		System.out.println("Data inserted");
		tr.commit();
		ss.close();
	}

	public void deleteData(int id) {
		Configuration cf = new Configuration();
		cf.configure("hibernate.cfg.xml");
		cf.addAnnotatedClass(Person.class);
		
		SessionFactory sf = cf.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr= ss.beginTransaction();
				
		//Get the record which you want to delete
		Person e = ss.get(Person.class, id);
		
		ss.remove(e);
		
		//ss.delete(e);//Deprecated, same work as remove method
		System.out.println("Record has been deleted....");
		tr.commit();
	}
	
	public void updateData(int id, String name) {
		//Create Configuration object
		Configuration cf = new Configuration();
		cf.configure("hibernate.cfg.xml");
		cf.addAnnotatedClass(Person.class);
		
		
		SessionFactory sf = cf.buildSessionFactory(); //
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		int emp_id = 2;
		
		Person e = ss.get(Person.class, id);//Get the record which you want to update
		e.setName(name);//setter
		
		//ss.merge(e);//update multiple field same time
		ss.update(e);////Deprecated, same work as merge method
		
		System.out.println("Data updated......");
		tr.commit();//Set Permanent
		ss.close();//close session
	}
	public void fetchAllRecord() {
		Configuration  cf = new Configuration();
		cf.configure("hibernate.cfg.xml");
		cf.addAnnotatedClass(Person.class);
		
		SessionFactory sf = cf.buildSessionFactory();
		Session ss = sf.openSession();
		
		Transaction tr= ss.beginTransaction();
		
		
		CriteriaBuilder cb = ss.getCriteriaBuilder();
		CriteriaQuery<Person> cq = cb.createQuery(Person.class);
		Root<Person> root = ((AbstractQuery<Person>)cq).from(Person.class);
		cq.select(root);
		Query query = ss.createQuery(cq);
		
		List<Person> list = query.getResultList();
		
		//Get All Person records
		for(Person ee :list) {
			System.out.println(ee);
		}
	}
	public void fetchSingleRecord(int id) {
		Configuration cf = new Configuration();
		cf.configure("hibernate.cfg.xml");
		cf.addAnnotatedClass(Person.class);
		
		SessionFactory sf = cf.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr= ss.beginTransaction();
				
		//Get single record which you want to fetch by using passing id
		Person e = ss.get(Person.class, id);
		System.out.println(e);
	}
	
}
