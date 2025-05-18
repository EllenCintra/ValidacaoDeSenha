package com.challenge.validaSenha.core.usecases;

import org.springframework.stereotype.Component;

@Component
public class ValidacaoMaiuscula implements ValidacaoStrategy {
    @Override
    public boolean validar(String senha) {
        if (senha != null && senha.chars().anyMatch(Character::isUpperCase)) {
            return true;
        }
        return false;
    }
}
