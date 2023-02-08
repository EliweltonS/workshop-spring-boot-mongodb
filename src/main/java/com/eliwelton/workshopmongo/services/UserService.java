package com.eliwelton.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eliwelton.workshopmongo.domain.User;
import com.eliwelton.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;//ja instanciado "injeção de dependencia automatica do spring"
	
	public List<User> findAll(){
		return repo.findAll();
	}
}
