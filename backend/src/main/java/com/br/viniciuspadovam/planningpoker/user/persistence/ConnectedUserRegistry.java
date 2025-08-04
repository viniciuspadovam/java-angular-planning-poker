package com.br.viniciuspadovam.planningpoker.user.persistence;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import com.br.viniciuspadovam.planningpoker.shared.exception.EntityNotFoundException;
import com.br.viniciuspadovam.planningpoker.user.entity.User;
import com.br.viniciuspadovam.planningpoker.user.interfaces.UserRepository;

@Component
public class ConnectedUserRegistry implements UserRepository {
	
	private final Set<User> users = ConcurrentHashMap.newKeySet();
	
	public Set<User> getAllUsers() {
		return Collections.unmodifiableSet(this.users);
	}
	
	public User add(User user) {
		this.users.add(user);
		return user;
	}
	
	public void remove(String username) {
		Optional<User> existingUser = this.users.stream()
			.filter(user -> user.getName().equals(username))
			.findFirst();
		
		if(existingUser.isEmpty())
			throw new EntityNotFoundException("Usuário " + username + " não encontrado.");
		
		this.users.remove(existingUser.get());
	}
	

}
