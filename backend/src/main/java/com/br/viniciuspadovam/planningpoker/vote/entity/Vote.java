package com.br.viniciuspadovam.planningpoker.vote.entity;

import java.util.UUID;

public class Vote {
	
	private String id;
	private int vote;
	
	public Vote(int vote) {
		this.id = UUID.randomUUID().toString();
		this.vote = vote;
	}

	public String getId() {
		return id;
	}

	public int getVote() {
		return vote;
	}
	
}
