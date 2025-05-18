package com.challenge.validaSenha.core.usecases;

// Interface para as estratégias de validação
interface ValidacaoStrategy {
    boolean validar(String senha);
}
