package com.challenge.validaSenha.core.usecases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidacaoStrategiesTest {

    @Test
    void validacaoTamanhoMinimo_senhaValida_retornaVerdadeiro() {
        ValidacaoTamanhoMinimo validacao = new ValidacaoTamanhoMinimo();
        assertTrue(validacao.validar("123456789"));
    }

    @Test
    void validacaoTamanhoMinimo_senhaInvalida_retornaFalso() {
        ValidacaoTamanhoMinimo validacao = new ValidacaoTamanhoMinimo();
        assertFalse(validacao.validar("12345678"));
    }

    @Test
    void validacaoTamanhoMinimo_senhaNula_retornaFalso() {
        ValidacaoTamanhoMinimo validacao = new ValidacaoTamanhoMinimo();
        assertFalse(validacao.validar(null));
    }

    @Test
    void validacaoDigito_senhaValida_retornaVerdadeiro() {
        ValidacaoDigito validacao = new ValidacaoDigito();
        assertTrue(validacao.validar("9"));
    }

    @Test
    void validacaoDigito_senhaInvalida_retornaFalso() {
        ValidacaoDigito validacao = new ValidacaoDigito();
        assertFalse(validacao.validar("a"));
    }

    @Test
    void validacaoDigito_senhaNula_retornaFalso() {
        ValidacaoDigito validacao = new ValidacaoDigito();
        assertFalse(validacao.validar(null));
    }

    @Test
    void validacaoMinuscula_senhaValida_retornaVerdadeiro() {
        ValidacaoMinuscula validacao = new ValidacaoMinuscula();
        assertTrue(validacao.validar("a"));
    }

    @Test
    void validacaoMinuscula_senhaInvalida_retornaFalso() {
        ValidacaoMinuscula validacao = new ValidacaoMinuscula();
        assertFalse(validacao.validar("A"));
    }

    @Test
    void validacaoMinuscula_senhaNula_retornaFalso() {
        ValidacaoMinuscula validacao = new ValidacaoMinuscula();
        assertFalse(validacao.validar(null));
    }

    @Test
    void validacaoMaiuscula_senhaValida_retornaVerdadeiro() {
        ValidacaoMaiuscula validacao = new ValidacaoMaiuscula();
        assertTrue(validacao.validar("A"));
    }

    @Test
    void validacaoMaiuscula_senhaInvalida_retornaFalso() {
        ValidacaoMaiuscula validacao = new ValidacaoMaiuscula();
        assertFalse(validacao.validar("a"));
    }

    @Test
    void validacaoMaiuscula_senhaNula_retornaFalso() {
        ValidacaoMaiuscula validacao = new ValidacaoMaiuscula();
        assertFalse(validacao.validar(null));
    }

    @Test
    void validacaoCaractereEspecial_senhaValida_retornaVerdadeiro() {
        ValidacaoCaractereEspecial validacao = new ValidacaoCaractereEspecial();
        assertTrue(validacao.validar("*"));
    }

    @Test
    void validacaoCaractereEspecial_senhaInvalida_retornaFalso() {
        ValidacaoCaractereEspecial validacao = new ValidacaoCaractereEspecial();
        assertFalse(validacao.validar("a9"));
    }

    @Test
    void validacaoCaractereEspecial_senhaNula_retornaFalso() {
        ValidacaoCaractereEspecial validacao = new ValidacaoCaractereEspecial();
        assertFalse(validacao.validar(null));
    }

    @Test
    void validacaoEspacoEmBranco_senhaValida_retornaVerdadeiro() {
        ValidacaoEspacoEmBranco validacao = new ValidacaoEspacoEmBranco();
        assertTrue(validacao.validar("a"));
    }

    @Test
    void validacaoEspacoEmBranco_senhaInvalida_retornaFalso() {
        ValidacaoEspacoEmBranco validacao = new ValidacaoEspacoEmBranco();
        assertFalse(validacao.validar("a "));
    }

    @Test
    void validacaoEspacoEmBranco_senhaNula_retornaFalso() {
        ValidacaoEspacoEmBranco validacao = new ValidacaoEspacoEmBranco();
        assertFalse(validacao.validar(null));
    }

    @Test
    void validacaoCaracteresRepetidos_senhaValida_retornaVerdadeiro() {
        ValidacaoCaracteresRepetidos validacao = new ValidacaoCaracteresRepetidos();
        assertTrue(validacao.validar("ab"));
    }

    @Test
    void validacaoCaracteresRepetidos_senhaInvalida_retornaFalso() {
        ValidacaoCaracteresRepetidos validacao = new ValidacaoCaracteresRepetidos();
        assertFalse(validacao.validar("aa"));
    }

    @Test
    void validacaoCaracteresRepetidos_senhaNula_retornaFalso() {
        ValidacaoCaracteresRepetidos validacao = new ValidacaoCaracteresRepetidos();
        assertFalse(validacao.validar(null));
    }
}
