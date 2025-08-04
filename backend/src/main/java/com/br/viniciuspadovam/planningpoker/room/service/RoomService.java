package com.br.viniciuspadovam.planningpoker.room.service;

import org.springframework.stereotype.Service;

import com.br.viniciuspadovam.planningpoker.room.dto.CreateRoomRequest;
import com.br.viniciuspadovam.planningpoker.room.entity.Room;
import com.br.viniciuspadovam.planningpoker.room.interfaces.RoomRepository;

@Service
public class RoomService {

	private final RoomRepository roomRepository;

	public RoomService(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}
	
	public boolean hasRoom() {
		return this.roomRepository.hasRoom();
	}
	
	public Room createRoom(CreateRoomRequest request) {
		return this.roomRepository.create(request.roomName(), request.estimateValue());
	}
	
	public boolean hasEstimateType() {
		return this.roomRepository.getRoomVoteType() != null;
	}
	
}
