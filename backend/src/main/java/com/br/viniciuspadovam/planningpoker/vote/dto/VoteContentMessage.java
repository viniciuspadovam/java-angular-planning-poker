package com.br.viniciuspadovam.planningpoker.vote.dto;

public record VoteContentMessage(
	String userId,
	int voteValue
) {}
