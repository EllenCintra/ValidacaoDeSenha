package com.challenge.validaSenha.core.usecases;

import org.springframework.stereotype.Component;

@Component
public class ValidacaoEspacoEmBranco implements ValidacaoStrategy {

    @Override
    public boolean validar(String senha) {
        if (senha == null)
            return false;

        return !senha.chars().anyMatch(Character::isWhitespace);
    }
}
