package com.eliwelton.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eliwelton.workshopmongo.domain.Post;
import com.eliwelton.workshopmongo.domain.User;
import com.eliwelton.workshopmongo.dto.UserDTO;
import com.eliwelton.workshopmongo.repository.PostRepository;
import com.eliwelton.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;// ja instanciado "injeção de dependencia automatica do spring"

	public Post findById(String id) {
	    Optional<Post> user = repo.findById(id);
	    return user.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado"));
	}

	// implmentando o FROMDTO aqui porque : caso seja necessario uma operação para
	// manuteção futura que ja tem acesso a dados
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
