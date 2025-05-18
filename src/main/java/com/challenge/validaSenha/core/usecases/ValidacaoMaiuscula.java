package com.challenge.validaSenha.core.usecases;

import org.springframework.stereotype.Component;

// Implementação da estratégia para validar a presença de letra maiúscula
@Component
class ValidacaoMaiuscula implements ValidacaoStrategy {
    @Override
    public boolean validar(String senha) {
        if (senha != null && !senha.chars().anyMatch(Character::isUpperCase)) {
            return false;
        }
        return true;
    }
}
