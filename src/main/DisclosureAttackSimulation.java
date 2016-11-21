package main;

import java.util.ArrayList;
import java.util.Random;

public class DisclosureAttackSimulation {

	private int b;
	private int m;
	private int N;
	
	public DisclosureAttackSimulation(int b, int m, int N ) {
		// Alice has m communication partners, i.e., receivers that she regularly sends messages to
		// The total number of users in the anonymity system is N
		// The number of senders in each batch is denoted b
		// The number of receivers in a batch is denoted n
		// This is done until m mutually disjoint sets are recorded
		
		this.b = b;
		this.m = m;
		this.N = N;
	}
	
	private ArrayList<Integer> generateObservation() {
		Random rand =  new Random();
		int communicationPartnerOfAlice = rand.nextInt(m + 1) + 1;
		ArrayList<Integer> receivers = new ArrayList<Integer>();
		receivers.add(communicationPartnerOfAlice);
		int rand1toN;
		for(int i = 0; i < b; i++) {
			rand1toN = rand.nextInt(N + 1) + 1;
			receivers.add(rand1toN);
		}
		
		for(int re: receivers) {
			System.out.println("Receiver: " + re);
		}
		return receivers;
	}
	
	private int learningPhase() {
		int t = 0;
		ArrayList<ArrayList<Integer>> listOfObservations = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> disjointSets = new ArrayList<ArrayList<Integer>>();
		while(disjointSets.size() == 0) {
			t++;
			ArrayList<Integer> observation = generateObservation();
			listOfObservations.add(observation);
			disjointSets = findDisjointSets(listOfObservations, m);
		}
		
		return t;
	}
	
	private ArrayList<ArrayList<Integer>> findDisjointSets(ArrayList<ArrayList<Integer>> list, int m) {
		ArrayList<ArrayList<Integer>> disjointSets = new ArrayList<ArrayList<Integer>>();
		return disjointSets;
	}
	
	
	
	public static void main(String[] args) {
		DisclosureAttackSimulation da = new DisclosureAttackSimulation(10, 10, 100);
		da.generateObservation();
		da.learningPhase();
	}
}
