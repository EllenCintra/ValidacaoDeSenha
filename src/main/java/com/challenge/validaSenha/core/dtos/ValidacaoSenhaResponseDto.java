package com.challenge.validaSenha.core.dtos;

public class ValidacaoSenhaResponseDto {
    private boolean senhaValida;

    public ValidacaoSenhaResponseDto(boolean senha) {
        this.senhaValida = senha;
    }

    public boolean isSenhaValida() {
        return senhaValida;
    }

    public void setSenhaValida(boolean senhaValida) {
        this.senhaValida = senhaValida;
    }
}
