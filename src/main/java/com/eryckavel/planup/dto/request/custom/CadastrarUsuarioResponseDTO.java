package com.eryckavel.planup.dto.request.custom;

public class CadastrarUsuarioResponseDTO {

    private String nome;
    private String email;
    private String senha;

    public CadastrarUsuarioResponseDTO() {
    }

    public CadastrarUsuarioResponseDTO(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
