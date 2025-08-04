package com.br.viniciuspadovam.planningpoker.room.interfaces;

import com.br.viniciuspadovam.planningpoker.room.entity.Room;
import com.br.viniciuspadovam.planningpoker.vote.enums.EstimateType;

public interface RoomRepository {
	
	boolean hasRoom();
	String getRoomVoteType();
	Room create(String name, EstimateType estimateValue);

}
