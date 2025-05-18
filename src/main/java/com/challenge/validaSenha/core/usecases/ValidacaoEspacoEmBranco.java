package com.challenge.validaSenha.core.usecases;

import org.springframework.stereotype.Component;

// Implementação da estratégia para validar a ausência de espaços em branco
@Component
class ValidacaoEspacoEmBranco implements ValidacaoStrategy {
    @Override
    public boolean validar(String senha) {
        if (senha != null && senha.chars().anyMatch(Character::isWhitespace)) {
            return false;
        }
        return true;
    }
}
