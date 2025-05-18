package com.challenge.validaSenha.core.usecases;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

// Implementação da estratégia para validar a presença de caractere especial
@Component
class ValidacaoCaractereEspecial implements ValidacaoStrategy {
    private static final String CARACTERES_ESPECIAIS = "!@#$%^&*()-+";

    @Override
    public boolean validar(String senha) {
        if (senha != null && !senha.matches(".*[" + Pattern.quote(CARACTERES_ESPECIAIS) + "].*")) {
            return false;
        }
        return true;
    }
}
