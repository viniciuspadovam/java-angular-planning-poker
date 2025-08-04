package com.br.viniciuspadovam.planningpoker.user.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.br.viniciuspadovam.planningpoker.user.entity.User;
import com.br.viniciuspadovam.planningpoker.user.interfaces.UserRepository;
import com.br.viniciuspadovam.planningpoker.user.persistence.UserRepositoryInMemory;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	private final UserRepository repository;

	public UserService(UserRepositoryInMemory repository) {
		this.repository = repository;
	}
	
	public Set<User> getAllUsers() {
		return this.repository.getAllUsers();
	}
	
	public Set<String> getAllUsernames() {
		return this.repository.getAllUsers().stream()
			.map(user -> user.getName())
			.collect(Collectors.toSet());
	}
	
	public User add(String username) {
		var newUser = new User(username);
		return this.repository.add(newUser);
	}
	
	public void remove(String username) {
		this.repository.remove(username);
	}
	
	public void vote(String userId, int voteValue) {
		this.repository.vote(userId, voteValue);
	}
	
}
