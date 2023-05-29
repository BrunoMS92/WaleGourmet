package br.com.wale.walegourmet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wale.walegourmet.model.Usuario;
import br.com.wale.walegourmet.repository.UsuarioRepository;

import java.util.List;

@Service
@Transactional
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario criarUsuario(Usuario usuario) {
        
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarUsuarioPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario != null) {
            String senha = usuario.getSenha();
            if (senha.contains("%adm%123")) {
                System.out.println("ADM registrado");
            } else {
                System.out.println("Usuário registrado");
            }
        }
        return usuario;
    }

    public List<Usuario> buscarTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    public void atualizarUsuario(Usuario usuario) {
        if (usuario != null) {
            String senha = usuario.getSenha();
            if (senha.contains("%adm%123")) {
                System.out.println("ADM atualizado com sucesso!!!");
            } else {
                System.out.println("Usuário atualizado com sucesso!!!");
            }
            usuarioRepository.save(usuario);
        }
    }

    public void excluirUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
