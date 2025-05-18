package com.challenge.validaSenha.core.usecases;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

// Implementação da estratégia para validar a ausência de caracteres repetidos
@Component
class ValidacaoCaracteresRepetidos implements ValidacaoStrategy {
    @Override
    public boolean validar(String senha) {
        if (senha != null) {
            Set<Character> caracteresUnicos = new HashSet<>();
            for (char c : senha.toCharArray()) {
                if (!caracteresUnicos.add(c)) {
                    return false;
                }
            }
        }
        return true;
    }
}
