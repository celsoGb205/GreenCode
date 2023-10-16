package com.Site.GreenCode.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="cad_pessoa")
public class M_Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private Long telefone;
    private String senha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public String getSenha(String senha) {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

