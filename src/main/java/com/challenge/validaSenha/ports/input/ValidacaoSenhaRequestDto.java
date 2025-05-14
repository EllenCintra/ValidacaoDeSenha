package com.challenge.validaSenha.ports.input;

public class ValidacaoSenhaRequestDto {
    private String senha;

    public ValidacaoSenhaRequestDto(String senha) {
        this.senha = senha;
    }

    public ValidacaoSenhaRequestDto() {
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
