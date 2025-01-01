package com.example.cacheredis.controller;


import com.example.cacheredis.dto.UsuarioRequestDto;
import com.example.cacheredis.entity.UsuarioEntity;
import com.example.cacheredis.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/redis/usuarios")
public class UsuarioRedisController {

    private final UsuarioService usuarioService;

    public UsuarioRedisController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioEntity> inserirUsuario(@RequestBody UsuarioRequestDto usuarioRequestDto){
        return ResponseEntity.ok(usuarioService.inserirUsuarioRedis(usuarioRequestDto));
    }

    @GetMapping("/idUsuario")
    public ResponseEntity<UsuarioEntity> redisUsuarios(@PathVariable(name = "idUsuario") Long idUsuario ){
        return ResponseEntity.ok(usuarioService.consultarUsuarioRedis(idUsuario));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioEntity>> listaRedisUsuarios(){
        return ResponseEntity.ok(usuarioService.listarUsuarioRedis());
    }
}
