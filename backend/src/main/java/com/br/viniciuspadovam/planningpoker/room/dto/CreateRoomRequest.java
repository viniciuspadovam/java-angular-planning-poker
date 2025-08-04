package com.br.viniciuspadovam.planningpoker.room.dto;

import com.br.viniciuspadovam.planningpoker.vote.enums.EstimateType;

public record CreateRoomRequest(
	String roomName, 
	EstimateType estimateValue
) {}
