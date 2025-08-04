package com.br.viniciuspadovam.planningpoker.room.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.viniciuspadovam.planningpoker.room.dto.CreateRoomRequest;
import com.br.viniciuspadovam.planningpoker.room.entity.Room;
import com.br.viniciuspadovam.planningpoker.room.service.RoomService;

@RestController
@RequestMapping("/api/v1/room")
public class RoomController {

	private final RoomService roomService;

	public RoomController(RoomService roomService) {
		this.roomService = roomService;
	}
	
	@GetMapping
	public ResponseEntity<Boolean> hasRoom() {
		return ResponseEntity.ok(this.roomService.hasRoom());
	}
	
	@PostMapping
	public ResponseEntity<Room> createRoom(@RequestBody CreateRoomRequest request) {
		var createdRoom = this.roomService.createRoom(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdRoom);
	}
	
}
