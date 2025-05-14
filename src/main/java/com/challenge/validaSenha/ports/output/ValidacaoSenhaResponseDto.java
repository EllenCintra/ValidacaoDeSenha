package com.challenge.validaSenha.ports.output;

public class ValidacaoSenhaResponseDto {
    private boolean senhaValida;

    public ValidacaoSenhaResponseDto(boolean senha) {
        this.senhaValida = senha;
    }
}
