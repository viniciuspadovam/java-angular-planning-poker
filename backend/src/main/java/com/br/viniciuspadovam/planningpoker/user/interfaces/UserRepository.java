package com.br.viniciuspadovam.planningpoker.user.interfaces;

import java.util.Set;

import com.br.viniciuspadovam.planningpoker.user.entity.User;

public interface UserRepository {

	Set<User> getAllUsers();
	User add(User user);
	void remove(String username);
	void vote(String userId, int voteValue);
	
}
