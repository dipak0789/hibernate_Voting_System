package com.election.Voting;

import java.util.Scanner;
import com.election.candidate.*;
import com.election.voter.VoterTest;


public class App {
    public static void main( String[] args ){
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Press 1 for Candidate\nPress 2 for Voter");
    	int ch =  sc.nextInt();
    	switch(ch){
    	case 1:
    		CandidateTest.Candidate();
    		break;
    	case 2:
    		VoterTest.Voter();
    		break;
    	}
    	
    }
}
