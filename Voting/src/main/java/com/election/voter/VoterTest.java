package com.election.voter;

import java.util.Scanner;

public class VoterTest {
	public static void Voter() {
		Scanner sc = new Scanner (System.in);
		System.out.println("Press 1 add Voter\nPress 2 for Update Voter\nPress 3 for search voter\nPress 4 for delete voter");
  	    int ch = sc.nextInt();
  	    switch(ch) {
  	    case 1: 
  	    	VoterOperation.insertVoter();
  	    	break;
  	    case 2:
  	    	VoterOperation.updateVoter();
  	    	break;
  	    case 3:
  	    	VoterOperation.searchVoter();
  	    	break;
  	    case 4:
  	    	VoterOperation.deleteVoter();
  	    	break;
  	    default :
  	    	System.out.println("Invalid Operation");	
  	    }
	}

}
