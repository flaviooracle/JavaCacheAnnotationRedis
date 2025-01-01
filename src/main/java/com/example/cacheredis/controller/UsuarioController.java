package com.example.cacheredis.controller;

import com.example.cacheredis.entity.UsuarioEntity;
import com.example.cacheredis.service.UsuarioService;
import jakarta.persistence.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @GetMapping
    public ResponseEntity<List<UsuarioEntity>>  listaUsuarios(){
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

}
