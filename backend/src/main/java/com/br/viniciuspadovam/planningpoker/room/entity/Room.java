package com.br.viniciuspadovam.planningpoker.room.entity;

import java.util.UUID;

import com.br.viniciuspadovam.planningpoker.vote.enums.EstimateType;

public class Room {
	
	private static Room instance;

	private String id;
	private String name;
	private EstimateType voteType;
	
	private Room() {
		this.id = UUID.randomUUID().toString();
	}
	
	public static Room getInstance() {
		if(instance == null) {
			instance = new Room();
		}
		return instance;
	}
	
	public static Room getInstanceSituation() {
		return instance;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EstimateType getVoteType() {
		return voteType;
	}

	public void setVoteType(EstimateType voteType) {
		this.voteType = voteType;
	}
	
}
