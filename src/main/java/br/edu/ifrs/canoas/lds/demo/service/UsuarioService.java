package br.edu.ifrs.canoas.lds.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.demo.domain.Usuario;
import br.edu.ifrs.canoas.lds.demo.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public List<Usuario> findAll(){
		return usuarioRepository.findAll();
	}

	public void delete(Long id) {
		usuarioRepository.deleteById(id);
	}

	public void salva(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	public Usuario busca(Long id) {
		return usuarioRepository.getOne(id);
	}
	
}
