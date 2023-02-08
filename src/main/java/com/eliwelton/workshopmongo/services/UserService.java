package com.eliwelton.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eliwelton.workshopmongo.domain.User;
import com.eliwelton.workshopmongo.dto.UserDTO;
import com.eliwelton.workshopmongo.repository.UserRepository;
import com.eliwelton.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;// ja instanciado "injeção de dependencia automatica do spring"

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	
//implmentando o FROMDTO aqui porque : caso seja necessario uma operação para manuteção futura que ja tem acesso a dados
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
