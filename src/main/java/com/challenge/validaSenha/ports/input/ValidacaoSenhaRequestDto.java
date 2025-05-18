package com.challenge.validaSenha.ports.input;

import jakarta.validation.constraints.NotBlank;

public class ValidacaoSenhaRequestDto {

    @NotBlank
    private String senha;

    public ValidacaoSenhaRequestDto(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }
}
