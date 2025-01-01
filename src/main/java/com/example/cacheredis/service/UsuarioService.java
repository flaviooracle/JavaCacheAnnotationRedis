package com.example.cacheredis.service;

import com.example.cacheredis.dto.UsuarioRequestDto;
import com.example.cacheredis.entity.UsuarioEntity;
import com.example.cacheredis.repository.UsuarioRedisRepository;
import com.example.cacheredis.repository.UsuarioRepository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final UsuarioRedisRepository usuarioRedisRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioRedisRepository usuarioRedisRepository) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioRedisRepository = usuarioRedisRepository;
    }

    @Cacheable("UsuarioEntity")
    public List<UsuarioEntity> listarUsuarios()
    {
        return (List<UsuarioEntity>) usuarioRepository.findAll();
    }

    public UsuarioEntity inserirUsuarioRedis(UsuarioRequestDto usuarioRequestDto){
        UsuarioEntity entity = new UsuarioEntity(usuarioRequestDto.getNome(),usuarioRequestDto.getEmail());
        return usuarioRedisRepository.save(entity);
    }

    public UsuarioEntity consultarUsuarioRedis(Long idUsuario){
        return usuarioRedisRepository.findById(idUsuario);
    }

    public List<UsuarioEntity> listarUsuarioRedis(){
        return (List<UsuarioEntity>) usuarioRedisRepository.findAll();
    }

    public void deletarUsuarioRedis(Long idUsuario){
        usuarioRedisRepository.delete(idUsuario);
    }


}
