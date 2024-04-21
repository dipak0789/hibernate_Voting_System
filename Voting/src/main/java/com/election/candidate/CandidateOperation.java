package com.election.candidate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.Embeddable;



public class CandidateOperation {
	static int x;
	static Candidate cd = new Candidate();
	static Scanner sc = new Scanner(System.in);
	static SessionFactory factory =new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	public static void setData() {
		System.out.println("Enter Candidate Id");
		int id = sc.nextInt();
		cd.setId(id);
		
		System.out.println("Enter Candidate Name");
		String name = sc.next();
		cd.setName(name);
		
		System.out.println("Enter Candidate Age");
		int age = sc.nextInt();
		cd.setAge(age);
		
		System.out.println("Enter Candidate Party");
		String party = sc.next();
		cd.setParty(party);
	}
	
	public static void insert() {
		
		CandidateOperation.setData();
        Session sn =factory.getCurrentSession();
        Transaction ts = sn.beginTransaction();
        sn.save(cd);
        ts.commit();
        System.out.println("Done");
        System.out.println("Press 1 for add more candidate\nPress 2 for exit");
        x=sc.nextInt();
        if(x==1) {
        	CandidateOperation.insert();
        }
        sn.close();
        factory.close();

	}
	
	public static void update() {
		Session sn = factory.getCurrentSession();
		Transaction ts = sn.beginTransaction();
		System.out.println("Enter id to update");
		x=sc.nextInt();
		Candidate cn = sn.get(Candidate.class, x);
		System.out.println("Press 1 foe update name\nPress 2 for update party\nPress 3 for update age");
		int ch= sc.nextInt();
		switch(ch) {
		case 1:
			System.out.println("Enter New name");
			cn.setName(sc.next());
			System.out.println("updated");
			break;
		case 2:
			System.out.println("Enter new Party");
			cn.setParty(sc.next());
			System.out.println("Updated");
			break;
		case 3:
			System.out.println("Enter new age");
			cn.setAge(sc.nextInt());
			System.out.println("Updated");
			break;
	    default:
	    	System.out.println("Invalid Operation");
		}
		ts.commit();
		sn.close();
        factory.close();

	}
	
	public static void search() {
		Session sn = factory.openSession();
		System.out.println("Enter Id to search");
		x=sc.nextInt();
		Candidate cd= sn.get(Candidate.class, x);
		System.out.println("Candidate Id: "+cd.getId()+" Candidate Name: "+cd.getName()+" Candidate Age: "+cd.getAge()+" Candidate Party: "+cd.getParty());
		sn.close();
        factory.close();
	}
	
	public static void delete() {
		Session sn = factory.getCurrentSession();
		Transaction ts = sn.beginTransaction();
		System.out.println("Enter id to delete");
		x=sc.nextInt();
		Candidate cd = sn.get(Candidate.class, x);
		System.out.println(cd.getName());
		sn.delete(cd);
		System.out.println("Deleted");
		ts.commit();
		sn.close();
		factory.close();
	}
}
