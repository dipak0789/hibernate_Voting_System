package com.election.voter;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class VoterOperation {
	static Scanner sc = new Scanner(System.in);
	static Voter vt = new Voter();
	static SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	static int x;
	public static void setVoter() {
		System.out.println("Enter voter Id");
		int id = sc.nextInt();
		vt.setId(id);
		
		System.out.println("Enter voter name");
		String name = sc.next();
		vt.setName(name);
		
		System.out.println("Enter voter age");
		int age = sc.nextInt();
		vt.setAge(age);
		
		System.out.println("Enter voter gender");
		String gender= sc.next();
		vt.setGender(gender);
		
		System.out.println("Enter voter area");
		String area = sc.next();
		vt.setArea(area);
	}
	
	public static void insertVoter() {
		VoterOperation.setVoter();
		Session sn =  factory.getCurrentSession();
		Transaction ts= sn.beginTransaction();
		sn.save(vt);
		ts.commit();
		System.out.println("Done");
		System.out.println("Press 1 for add more Voter\nPress 2 exit");
		x=sc.nextInt();
		if(x==1) {
			VoterOperation.insertVoter();
		}
		sn.close();
		factory.close();
	}
	
	
	public static void updateVoter() {
		Session sn = factory.getCurrentSession();
		Transaction ts = sn.beginTransaction();
		System.out.println("Enter voter id to update");
		x=sc.nextInt();
		Voter vt = sn.get(Voter.class, x);
		System.out.println("Pres 1 for update name\npRess 2 for update age\nPress 3 for update gender\nPress 3 for update area");
		int ch = sc.nextInt();
		switch(ch) {
		case 1:
			System.out.println("Enter new name");
			vt.setName(sc.next());
			System.out.println("Name Updated");
			break;
		case 2:
			System.out.println("Enter new  age");
			vt.setAge(sc.nextInt());
			System.out.println("Age Updated");
			break;
		case 3:
			System.out.println("Enter new gender");
			vt.setGender(sc.next());
			System.out.println("Gender Updated");
			break;
		case 4:
			System.out.println("Enter new area");
			vt.setArea(sc.next());
			System.out.println("Area Updated");
			break;
		default:
			System.out.println("Invalid Operation");
		}
		ts.commit();
		sn.close();
		factory.close();
	}
	
	public static void searchVoter() {
		Session sn =  factory.openSession();
		System.out.println("Enter voter id to search");
		x=sc.nextInt();
		Voter vr= sn.get(Voter.class, x);
		System.out.println("Voter ID: "+vr.getId()+" Voter Name: "+vr.getName()+" Voter Age: "+vr.getAge()+" Voter Gender: "+vr.getGender()+" Voter Area: "+vr.getArea());
		sn.close();
		factory.close();
	}
	
	public static void deleteVoter() {
		Session sn =  factory.getCurrentSession();
		Transaction ts = sn.beginTransaction();
		System.out.println("Enter id to delete");
		x=sc.nextInt();
		Voter vr = sn.get(Voter.class, x);
		System.out.println(vr.getName());
		sn.delete(vr);
		System.out.println("Deleted Successfully");
		ts.commit();
		sn.close();
		factory.close();
	}
}
