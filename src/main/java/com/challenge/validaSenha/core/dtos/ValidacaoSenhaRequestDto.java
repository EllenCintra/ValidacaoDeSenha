package com.challenge.validaSenha.core.dtos;

public class ValidacaoSenhaRequestDto {

    private String senha;

    public ValidacaoSenhaRequestDto(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }
}
