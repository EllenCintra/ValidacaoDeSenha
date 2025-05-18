package com.challenge.validaSenha.core.usecases;

import org.springframework.stereotype.Component;

@Component
public class ValidacaoDigito implements ValidacaoStrategy {

    @Override
    public boolean validar(String senha) {
        if (senha != null && senha.chars().anyMatch(Character::isDigit)) {
            return true;
        }
        return false;
    }
}
