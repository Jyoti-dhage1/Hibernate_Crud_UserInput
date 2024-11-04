package com.controller;

import java.util.Scanner;

import com.service.Person_Service;

public class Person_Controller {

	public static void main(String[] args) {
		
		int age,id;
		boolean status=true;
		String name,city;
	

		Person_Service ps = new Person_Service();
		//Ask user input
		Scanner sc = new Scanner(System.in);

		
		do {
			System.out.println("Which Operation would you like to perform? please select below option\n");
			System.out.println("1. InsertRecord\n2. DeleteRecord\n3. UpdateRecord\n4. FetchAllRecord\n5. FetchSingleRecord\n6. Exit");
			int option = sc.nextInt();
		
			//take iput from user 
			switch(option) {
				case 1:
					  //Take age, name,city from user
					  System.out.println("Please enter Person Age");
					  age = sc.nextInt();			
					  System.out.println("Please enter Person Name");
					  name = sc.next();				  
					  System.out.println("Please enter Person City");
					  city = sc.next();
					  ps.insertData(age,name,city);

					  break;
				case 2:
					  //Take id from user based on id we will delete record
					  System.out.println("Please enter Person ID");
					  id = sc.nextInt();
					  ps.deleteData(id);

					  break;
				case 3:
					  //Take id from user and based on id we will name of person
					  System.out.println("Please enter Person ID");
					  id = sc.nextInt();			
					  System.out.println("Please enter Person Name");
					  name = sc.next();	
					  ps.updateData(id, name);

					  break;
				case 4:
					  ps.fetchAllRecord(); //Fetch All Person records
					  break;
				case 5:
					  System.out.println("Please enter Person ID");
					  id = sc.nextInt();
					  ps.fetchSingleRecord(id); //Fetch single Person record
					  break;
				case 6:
					  status = false;//exit program
					  System.exit(0);
					  break;
				default:
					  System.out.println("Please Select valid Option");
					  break;
			}
			
			//Ask user wants to continue or no
			do {
				System.out.println("\nWould you like to Continue? Y / N");
				String str = sc.next();
				if(str.startsWith("n")) {
					status = false;
				}
				else if(str.startsWith("y")) {
					break;		
				}
				
				
			}while(status);
			
		}while(status);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
