package com.election.candidate;

import java.util.Scanner;

public class CandidateTest {
	public static void Candidate() {
		Scanner sc = new Scanner(System.in);
		boolean a= true;
		System.out.println("Press 1 for Add Candidate\nPress 2 for Update Candidate\nPress 3 for display candidate\nPress 4 for Delete Candidate");
		int ch=  sc.nextInt();
		switch(ch) {
		case 1:
			CandidateOperation.insert();
			break;
		case 2:
			CandidateOperation.update();
			break;
		case 3:
			CandidateOperation.search();
			break;
		case 4:
			CandidateOperation.delete();
			break;
		default:
			System.out.println("Invslid Operation");
				
		}
	}
}
