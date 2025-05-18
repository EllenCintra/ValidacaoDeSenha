package com.challenge.validaSenha.core.usecases;

import com.challenge.validaSenha.ports.input.ValidacaoSenhaRequestDto;
import com.challenge.validaSenha.ports.output.ValidacaoSenhaResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class ValidaSenhaUseCaseImplTest {

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
    private ValidaSenhaUseCaseImpl validadorSenha;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        validadorSenha = new ValidaSenhaUseCaseImpl(Arrays.asList(
                validacaoTamanhoMinimo, validacaoDigito, validacaoMinuscula,
                validacaoMaiuscula, validacaoCaractereEspecial, validacaoEspacoEmBranco,
                validacaoCaracteresRepetidos
        ));
    }

    @Test
    void validarSenha_senhaValida() {
        ValidacaoSenhaRequestDto senhaRequestDto = new ValidacaoSenhaRequestDto("Abcdefgh!9");
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
        ValidacaoSenhaRequestDto senhaRequestDto = new ValidacaoSenhaRequestDto("Abcdefghi9");
        String senha = senhaRequestDto.getSenha();

        when(validacaoCaractereEspecial.validar(senha)).thenReturn(false);

        ValidacaoSenhaResponseDto resultado = validadorSenha.validarSenha(senhaRequestDto);

        assertFalse(resultado.isSenhaValida());
    }

    @Test
    void validarSenha_senhaInvalida_erroCaracterRepetidos_CaseSensitive() {
        ValidacaoSenhaRequestDto senhaRequestDto = new ValidacaoSenhaRequestDto("AAbcdefghi!9");
        String senha = senhaRequestDto.getSenha();

        when(validacaoCaracteresRepetidos.validar(senha)).thenReturn(false);

        ValidacaoSenhaResponseDto resultado = validadorSenha.validarSenha(senhaRequestDto);

        assertFalse(resultado.isSenhaValida());
    }

    @Test
    void validarSenha_senhaInvalida_erroDeDigito() {
        ValidacaoSenhaRequestDto senhaRequestDto = new ValidacaoSenhaRequestDto("Abcdefghi!");
        String senha = senhaRequestDto.getSenha();

        when(validacaoDigito.validar(senha)).thenReturn(false);

        ValidacaoSenhaResponseDto resultado = validadorSenha.validarSenha(senhaRequestDto);

        assertFalse(resultado.isSenhaValida());
    }

    @Test
    void validarSenha_senhaInvalida_erroEspacoEmBranco() {
        ValidacaoSenhaRequestDto senhaRequestDto = new ValidacaoSenhaRequestDto("Aabcdefg !9");
        String senha = senhaRequestDto.getSenha();

        when(validacaoEspacoEmBranco.validar(senha)).thenReturn(false);

        ValidacaoSenhaResponseDto resultado = validadorSenha.validarSenha(senhaRequestDto);

        assertFalse(resultado.isSenhaValida());
    }

    @Test
    void validarSenha_senhaInvalida_erroMaiuscula() {
        ValidacaoSenhaRequestDto senhaRequestDto = new ValidacaoSenhaRequestDto("abcdefg!9");
        String senha = senhaRequestDto.getSenha();

        when(validacaoMaiuscula.validar(senha)).thenReturn(false);

        ValidacaoSenhaResponseDto resultado = validadorSenha.validarSenha(senhaRequestDto);

        assertFalse(resultado.isSenhaValida());
    }

    @Test
    void validarSenha_senhaInvalida_erroMinuscula() {
        ValidacaoSenhaRequestDto senhaRequestDto = new ValidacaoSenhaRequestDto("A1234567!9");
        String senha = senhaRequestDto.getSenha();

        when(validacaoMinuscula.validar(senha)).thenReturn(false);

        ValidacaoSenhaResponseDto resultado = validadorSenha.validarSenha(senhaRequestDto);

        assertFalse(resultado.isSenhaValida());
    }


    @Test
    void validarSenha_senhaInvalida_erroDeTamanho() {
        ValidacaoSenhaRequestDto senhaRequestDto = new ValidacaoSenhaRequestDto("Abcdefgh!");
        String senha = senhaRequestDto.getSenha();

        when(validacaoTamanhoMinimo.validar(senha)).thenReturn(false);

        ValidacaoSenhaResponseDto resultado = validadorSenha.validarSenha(senhaRequestDto);

        assertFalse(resultado.isSenhaValida());
    }
}
