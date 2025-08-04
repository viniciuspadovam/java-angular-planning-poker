package com.br.viniciuspadovam.planningpoker.user.entity;

import java.util.UUID;

import com.br.viniciuspadovam.planningpoker.vote.entity.Vote;

public class User {

	private String id;
	private String name;
	private Vote vote;
	
	public User(String name) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Vote getVote() {
		return vote;
	}
	
	public void setVote(int voteValue) {
		this.vote = new Vote(voteValue);
	}
	
}
