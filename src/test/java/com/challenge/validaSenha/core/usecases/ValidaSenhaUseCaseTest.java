package com.challenge.validaSenha.core.usecases;

import com.challenge.validaSenha.core.dtos.ValidacaoSenhaRequestDto;
import com.challenge.validaSenha.core.dtos.ValidacaoSenhaResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class ValidaSenhaUseCaseTest {

    @Mock
    private ValidacaoTamanhoMinimo validacaoTamanhoMinimo;
    @Mock
    private ValidacaoDigito validacaoDigito;
    @Mock
    private ValidacaoMinuscula validacaoMinuscula;
    @Mock
    private ValidacaoMaiuscula validacaoMaiuscula;
    @Mock
    private ValidacaoCaractereEspecial validacaoCaractereEspecial;
    @Mock
    private ValidacaoEspacoEmBranco validacaoEspacoEmBranco;
    @Mock
    private ValidacaoCaracteresRepetidos validacaoCaracteresRepetidos;

    @InjectMocks
    private ValidaSenhaUseCase validadorSenha;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        validadorSenha = new ValidaSenhaUseCase(Arrays.asList(
                validacaoTamanhoMinimo, validacaoDigito, validacaoMinuscula,
                validacaoMaiuscula, validacaoCaractereEspecial, validacaoEspacoEmBranco,
                validacaoCaracteresRepetidos
        ));
    }

    @Test
    void validarSenha_senhaValida() {
        ValidacaoSenhaRequestDto senhaRequestDto = new ValidacaoSenhaRequestDto("senhaRequest");
        String senha = senhaRequestDto.getSenha();

        when(validacaoTamanhoMinimo.validar(senha)).thenReturn(true);
        when(validacaoDigito.validar(senha)).thenReturn(true);
        when(validacaoMinuscula.validar(senha)).thenReturn(true);
        when(validacaoMaiuscula.validar(senha)).thenReturn(true);
        when(validacaoCaractereEspecial.validar(senha)).thenReturn(true);
        when(validacaoEspacoEmBranco.validar(senha)).thenReturn(true);
        when(validacaoCaracteresRepetidos.validar(senha)).thenReturn(true);

        ValidacaoSenhaResponseDto resultado = validadorSenha.validarSenha(senhaRequestDto);

        assertTrue(resultado.isSenhaValida());
    }


    @Test
    void validarSenha_senhaInvalida_erroCaracterEspecial() {
        ValidacaoSenhaRequestDto senhaRequestDto = new ValidacaoSenhaRequestDto("senhaRequest");
        String senha = senhaRequestDto.getSenha();

        when(validacaoCaractereEspecial.validar(senha)).thenReturn(false);

        ValidacaoSenhaResponseDto resultado = validadorSenha.validarSenha(senhaRequestDto);

        assertFalse(resultado.isSenhaValida());
    }

    @Test
    void validarSenha_senhaInvalida_erroCaracterRepetidos_CaseSensitive() {
        ValidacaoSenhaRequestDto senhaRequestDto = new ValidacaoSenhaRequestDto("senhaRequest");
        String senha = senhaRequestDto.getSenha();

        when(validacaoCaracteresRepetidos.validar(senha)).thenReturn(false);

        ValidacaoSenhaResponseDto resultado = validadorSenha.validarSenha(senhaRequestDto);

        assertFalse(resultado.isSenhaValida());
    }

    @Test
    void validarSenha_senhaInvalida_erroDeDigito() {
        ValidacaoSenhaRequestDto senhaRequestDto = new ValidacaoSenhaRequestDto("senhaRequest");
        String senha = senhaRequestDto.getSenha();

        when(validacaoDigito.validar(senha)).thenReturn(false);

        ValidacaoSenhaResponseDto resultado = validadorSenha.validarSenha(senhaRequestDto);

        assertFalse(resultado.isSenhaValida());
    }

    @Test
    void validarSenha_senhaInvalida_erroEspacoEmBranco() {
        ValidacaoSenhaRequestDto senhaRequestDto = new ValidacaoSenhaRequestDto("senhaRequest");
        String senha = senhaRequestDto.getSenha();

        when(validacaoEspacoEmBranco.validar(senha)).thenReturn(false);

        ValidacaoSenhaResponseDto resultado = validadorSenha.validarSenha(senhaRequestDto);

        assertFalse(resultado.isSenhaValida());
    }

    @Test
    void validarSenha_senhaInvalida_erroMaiuscula() {
        ValidacaoSenhaRequestDto senhaRequestDto = new ValidacaoSenhaRequestDto("senhaRequest");
        String senha = senhaRequestDto.getSenha();

        when(validacaoMaiuscula.validar(senha)).thenReturn(false);

        ValidacaoSenhaResponseDto resultado = validadorSenha.validarSenha(senhaRequestDto);

        assertFalse(resultado.isSenhaValida());
    }

    @Test
    void validarSenha_senhaInvalida_erroMinuscula() {
        ValidacaoSenhaRequestDto senhaRequestDto = new ValidacaoSenhaRequestDto("senhaRequest");
        String senha = senhaRequestDto.getSenha();

        when(validacaoMinuscula.validar(senha)).thenReturn(false);

        ValidacaoSenhaResponseDto resultado = validadorSenha.validarSenha(senhaRequestDto);

        assertFalse(resultado.isSenhaValida());
    }


    @Test
    void validarSenha_senhaInvalida_erroDeTamanho() {
        ValidacaoSenhaRequestDto senhaRequestDto = new ValidacaoSenhaRequestDto("senhaRequest");
        String senha = senhaRequestDto.getSenha();

        when(validacaoTamanhoMinimo.validar(senha)).thenReturn(false);

        ValidacaoSenhaResponseDto resultado = validadorSenha.validarSenha(senhaRequestDto);

        assertFalse(resultado.isSenhaValida());
    }

    @Test
    void validarSenha_senhaNula() {
        ValidacaoSenhaRequestDto senhaRequestDto = new ValidacaoSenhaRequestDto(null);

        ValidacaoSenhaResponseDto resultado = validadorSenha.validarSenha(senhaRequestDto);

        assertFalse(resultado.isSenhaValida());
    }

    @Test
    void validarSenha_senhaVazia() {
        ValidacaoSenhaRequestDto senhaRequestDto = new ValidacaoSenhaRequestDto("");

        ValidacaoSenhaResponseDto resultado = validadorSenha.validarSenha(senhaRequestDto);

        assertFalse(resultado.isSenhaValida());
    }
}
