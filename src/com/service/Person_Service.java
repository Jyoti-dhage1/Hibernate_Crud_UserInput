package com.service;

import com.dao.Person_Dao;

public class Person_Service {
	public void insertData(int age, String name, String city) {
		Person_Dao pd= new Person_Dao();
		pd.insertData(age,name,city);
	}
	public void deleteData(int id) {
		Person_Dao pd= new Person_Dao();
		pd.deleteData(id);
	}
	public void updateData(int id, String name) {
		Person_Dao pd= new Person_Dao();
		pd.updateData(id,name);
	}
	public void fetchAllRecord() {
		Person_Dao pd= new Person_Dao();
		pd.fetchAllRecord();
	}
	public void fetchSingleRecord(int id) {
		Person_Dao pd= new Person_Dao();
		pd.fetchSingleRecord(id);
	}
	
	
	
}
