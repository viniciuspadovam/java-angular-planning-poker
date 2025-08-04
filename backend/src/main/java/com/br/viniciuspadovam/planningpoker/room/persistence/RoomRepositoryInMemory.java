package com.br.viniciuspadovam.planningpoker.room.persistence;

import org.springframework.stereotype.Repository;

import com.br.viniciuspadovam.planningpoker.room.entity.Room;
import com.br.viniciuspadovam.planningpoker.room.exception.RoomAlreadyExistsException;
import com.br.viniciuspadovam.planningpoker.room.interfaces.RoomRepository;
import com.br.viniciuspadovam.planningpoker.vote.enums.EstimateType;

@Repository
public class RoomRepositoryInMemory implements RoomRepository {
	
	private Room room;
	
	@Override
	public boolean hasRoom() {
		return Room.getInstanceSituation() != null;
	}
	
	@Override
	public String getRoomVoteType() {
		return this.room.getVoteType().name();
	}

	@Override
	public Room create(String name, EstimateType estimateValue) {
		if(this.hasRoom())
			throw new RoomAlreadyExistsException();
		
		Room newRoom = Room.getInstance();
		newRoom.setName(name);
		newRoom.setVoteType(estimateValue);
		return newRoom;
	}

}
