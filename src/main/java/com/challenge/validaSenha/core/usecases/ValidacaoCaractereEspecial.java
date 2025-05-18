package com.challenge.validaSenha.core.usecases;

import org.springframework.stereotype.Component;

@Component
public class ValidacaoCaractereEspecial implements ValidacaoStrategy {
    private static final String CARACTERES_ESPECIAIS = "!@#$%^&*()-+";

    @Override
    public boolean validar(String senha) {
        if (senha != null) {
            for (char c : senha.toCharArray()) {
                if (CARACTERES_ESPECIAIS.contains(String.valueOf(c))) {
                    return true;
                }
            }
        }
        return false;
    }
}
