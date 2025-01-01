package com.example.cacheredis.repository;


import com.example.cacheredis.entity.UsuarioEntity;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UsuarioRedisRepository {

    private static final String HASH_KEY = "UsuarioEntity";

    private final RedisTemplate<String, Object> redisTemplate;

    public UsuarioRedisRepository(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public UsuarioEntity save(UsuarioEntity usuario) {
        redisTemplate.opsForHash().put(HASH_KEY, 1, usuario);
        return usuario;
    }

    public UsuarioEntity findById(Long id) {
        return (UsuarioEntity) redisTemplate.opsForHash().get(HASH_KEY, id);
    }

    public Map<Object, Object> findAll() {
        return redisTemplate.opsForHash().entries(HASH_KEY);
    }

    public void delete(Long id) {
        redisTemplate.opsForHash().delete(HASH_KEY, id);
    }

}
