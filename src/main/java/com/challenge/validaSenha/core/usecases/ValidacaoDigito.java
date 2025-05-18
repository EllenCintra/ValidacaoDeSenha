package com.challenge.validaSenha.core.usecases;

import org.springframework.stereotype.Component;

// Implementação da estratégia para validar a presença de dígito
@Component
class ValidacaoDigito implements ValidacaoStrategy {
    @Override
    public boolean validar(String senha, ResultadoValidacao resultado) {
        if (senha != null && !senha.chars().anyMatch(Character::isDigit)) {
            resultado.adicionarErro("A senha deve conter ao menos 1 dígito.");
            return false;
        }
        return true;
    }
}
