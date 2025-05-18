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
    void ehValida_senhaValida_retornaVerdadeiro() {
        // Arrange
        String senha = "aB1!fghi9";
        when(validacaoTamanhoMinimo.validar(senha, new ResultadoValidacao())).thenReturn(true);
        when(validacaoDigito.validar(senha, new ResultadoValidacao())).thenReturn(true);
        when(validacaoMinuscula.validar(senha, new ResultadoValidacao())).thenReturn(true);
        when(validacaoMaiuscula.validar(senha, new ResultadoValidacao())).thenReturn(true);
        when(validacaoCaractereEspecial.validar(senha, new ResultadoValidacao())).thenReturn(true);
        when(validacaoEspacoEmBranco.validar(senha, new ResultadoValidacao())).thenReturn(true);
        when(validacaoCaracteresRepetidos.validar(senha, new ResultadoValidacao())).thenReturn(true);

        // Act
        boolean resultado = validadorSenha.ehValida(senha);

        // Assert
        assertTrue(resultado);
    }

    @Test
    void ehValida_senhaInvalida_retornaFalso() {
        // Arrange
        String senha = "abc";
        when(validacaoTamanhoMinimo.validar(senha, new ResultadoValidacao())).thenReturn(false);

        // Act
        boolean resultado = validadorSenha.ehValida(senha);

        // Assert
        assertFalse(resultado);
    }

    @Test
    void verificarValidade_senhaValida_retornaSemErros() {
        // Arrange
        String senha = "aB1!fghi9";
        when(validacaoTamanhoMinimo.validar(senha, new ResultadoValidacao())).thenReturn(true);
        when(validacaoDigito.validar(senha, new ResultadoValidacao())).thenReturn(true);
        when(validacaoMinuscula.validar(senha, new ResultadoValidacao())).thenReturn(true);
        when(validacaoMaiuscula.validar(senha, new ResultadoValidacao())).thenReturn(true);
        when(validacaoCaractereEspecial.validar(senha, new ResultadoValidacao())).thenReturn(true);
        when(validacaoEspacoEmBranco.validar(senha, new ResultadoValidacao())).thenReturn(true);
        when(validacaoCaracteresRepetidos.validar(senha, new ResultadoValidacao())).thenReturn(true);

        // Act
        ResultadoValidacao resultado = validadorSenha.verificarValidade(senha);

        // Assert
        assertTrue(resultado.ehValido());
        assertTrue(resultado.getErros().isEmpty());
    }

    @Test
    void verificarValidade_senhaInvalida_retornaErroDeTamanho() {
        // Arrange
        String senha = "abc";
        ResultadoValidacao resultadoEsperado = new ResultadoValidacao();
        resultadoEsperado.adicionarErro("A senha deve ter no mínimo 9 caracteres.");
        when(validacaoTamanhoMinimo.validar(senha, new ResultadoValidacao())).thenReturn(false);
        when(validacaoTamanhoMinimo.validar(senha, new ResultadoValidacao())).thenReturn(false);


        // Act
        ResultadoValidacao resultado = validadorSenha.verificarValidade(senha);

        // Assert
        assertFalse(resultado.ehValido());
        assertEquals(1, resultado.getErros().size());
        assertEquals("A senha deve ter no mínimo 9 caracteres.", resultado.getErros().get(0));
    }

    @Test
    void verificarValidade_senhaInvalida_retornaErroDeDigito() {
        // Arrange
        String senha = "abcdefghi!";
        ResultadoValidacao resultadoEsperado = new ResultadoValidacao();
        resultadoEsperado.adicionarErro("A senha deve conter ao menos 1 dígito.");
        when(validacaoTamanhoMinimo.validar(senha, new ResultadoValidacao())).thenReturn(true);
        when(validacaoDigito.validar(senha, new ResultadoValidacao())).thenReturn(false);

        // Act
        ResultadoValidacao resultado = validadorSenha.verificarValidade(senha);

        // Assert
        assertFalse(resultado.ehValido());
        assertEquals(1, resultado.getErros().size());
        assertEquals("A senha deve conter ao menos 1 dígito.", resultado.getErros().get(0));
    }
}
