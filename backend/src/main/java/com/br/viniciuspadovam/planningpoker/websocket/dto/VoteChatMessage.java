package com.br.viniciuspadovam.planningpoker.websocket.dto;

import com.br.viniciuspadovam.planningpoker.vote.dto.VoteContentMessage;
import com.br.viniciuspadovam.planningpoker.vote.enums.EstimateType;

public record VoteChatMessage(
	String sender,
	EstimateType type,
	VoteContentMessage content
) {}
