package com.challenge.validaSenha.core.usecases;

import java.util.ArrayList;
import java.util.List;

// Classe para representar o resultado da validação
class ResultadoValidacao {
    private boolean ehValido;
    private List<String> erros;

    public ResultadoValidacao() {
        this.ehValido = true;
        this.erros = new ArrayList<>();
    }

    public boolean ehValido() {
        return ehValido;
    }

    public List<String> getErros() {
        return erros;
    }

    public void adicionarErro(String erro) {
        this.ehValido = false;
        this.erros.add(erro);
    }
}
