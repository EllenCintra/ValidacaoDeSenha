package com.challenge.validaSenha.core.usecases;

import org.springframework.stereotype.Component;

// Implementação da estratégia para validar o tamanho mínimo
@Component
class ValidacaoTamanhoMinimo implements ValidacaoStrategy {
    private static final int TAMANHO_MINIMO = 9;

    @Override
    public boolean validar(String senha) {
        if (senha == null || senha.length() < TAMANHO_MINIMO) {
            return false;
        }
        return true;
    }
}
