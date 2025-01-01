package com.example.cacheredis.dto;


import java.util.Objects;

public class UsuarioRequestDto {
    private String nome;
    private String email;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public UsuarioRequestDto(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioRequestDto that = (UsuarioRequestDto) o;
        return Objects.equals(nome, that.nome) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, email);
    }
}
