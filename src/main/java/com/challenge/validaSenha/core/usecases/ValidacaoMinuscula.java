package com.challenge.validaSenha.core.usecases;

import org.springframework.stereotype.Component;

// Implementação da estratégia para validar a presença de letra minúscula
@Component
class ValidacaoMinuscula implements ValidacaoStrategy {
    @Override
    public boolean validar(String senha, ResultadoValidacao resultado) {
        if (senha != null && !senha.chars().anyMatch(Character::isLowerCase)) {
            resultado.adicionarErro("A senha deve conter ao menos 1 letra minúscula.");
            return false;
        }
        return true;
    }
}
