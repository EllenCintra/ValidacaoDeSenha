package com.challenge.validaSenha.core.usecases;

import com.challenge.validaSenha.core.dtos.ValidacaoSenhaRequestDto;
import com.challenge.validaSenha.core.dtos.ValidacaoSenhaResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ContextConfiguration(classes = {
        ValidaSenhaUseCase.class,
        ValidacaoTamanhoMinimo.class,
        ValidacaoDigito.class,
        ValidacaoMinuscula.class,
        ValidacaoMaiuscula.class,
        ValidacaoCaractereEspecial.class,
        ValidacaoEspacoEmBranco.class,
        ValidacaoCaracteresRepetidos.class
})
public class ValidaSenhaUseCaseImplIntegrationTest {

    @Autowired
    private ValidaSenhaUseCase validaSenhaUseCase;

    @BeforeEach
    void setUp() {
    }

    @Test
    void validarSenha_senhaValida_retornaTrue() {
        ValidacaoSenhaRequestDto requestDto = new ValidacaoSenhaRequestDto("AbcdefF*9");

        ValidacaoSenhaResponseDto responseDto = validaSenhaUseCase.validarSenha(requestDto);

        assertTrue(responseDto.isSenhaValida());
    }

    @Test
    void validarSenha_senhaVazia_retornaFalse() {
        ValidacaoSenhaRequestDto requestDto = new ValidacaoSenhaRequestDto("");

        ValidacaoSenhaResponseDto responseDto = validaSenhaUseCase.validarSenha(requestDto);

        assertFalse(responseDto.isSenhaValida());
    }

    @Test
    void validarSenha_senhaNula_retornaFalse() {
        ValidacaoSenhaRequestDto requestDto = new ValidacaoSenhaRequestDto(null);

        ValidacaoSenhaResponseDto responseDto = validaSenhaUseCase.validarSenha(requestDto);

        assertFalse(responseDto.isSenhaValida());
    }

    @Test
    void validarSenha_senhaSemCaracterEspecialValido_retornaFalse() {
        ValidacaoSenhaRequestDto requestDto = new ValidacaoSenhaRequestDto("Abcdefg~9");

        ValidacaoSenhaResponseDto responseDto = validaSenhaUseCase.validarSenha(requestDto);

        assertFalse(responseDto.isSenhaValida());
    }

    @Test
    void validarSenha_senhaCaracteresRepetidosCaseSensitive_retornaFalse() {
        ValidacaoSenhaRequestDto requestDto = new ValidacaoSenhaRequestDto("AAcdefg*9");

        ValidacaoSenhaResponseDto responseDto = validaSenhaUseCase.validarSenha(requestDto);

        assertFalse(responseDto.isSenhaValida());
    }

    @Test
    void validarSenha_senhaSemDigito_retornaFalse() {
        ValidacaoSenhaRequestDto requestDto = new ValidacaoSenhaRequestDto("AbcdefgG*");

        ValidacaoSenhaResponseDto responseDto = validaSenhaUseCase.validarSenha(requestDto);

        assertFalse(responseDto.isSenhaValida());
    }

    @Test
    void validarSenha_senhaEspacoEmBranco_retornaFalse() {
        ValidacaoSenhaRequestDto requestDto = new ValidacaoSenhaRequestDto("Abcdefg*9 ");

        ValidacaoSenhaResponseDto responseDto = validaSenhaUseCase.validarSenha(requestDto);

        assertFalse(responseDto.isSenhaValida());
    }

    @Test
    void validarSenha_senhaSemMaiuscula_retornaFalse() {
        ValidacaoSenhaRequestDto requestDto = new ValidacaoSenhaRequestDto("abcdefg*9");

        ValidacaoSenhaResponseDto responseDto = validaSenhaUseCase.validarSenha(requestDto);

        assertFalse(responseDto.isSenhaValida());
    }

    @Test
    void validarSenha_senhaSemMinuscula_retornaFalse() {
        ValidacaoSenhaRequestDto requestDto = new ValidacaoSenhaRequestDto("ABCDEFG*9");

        ValidacaoSenhaResponseDto responseDto = validaSenhaUseCase.validarSenha(requestDto);

        assertFalse(responseDto.isSenhaValida());
    }

    @Test
    void validarSenha_tamanhoInvalido_retornaFalse() {
        ValidacaoSenhaRequestDto requestDto = new ValidacaoSenhaRequestDto("Abcdef*8");

        ValidacaoSenhaResponseDto responseDto = validaSenhaUseCase.validarSenha(requestDto);

        assertFalse(responseDto.isSenhaValida());
    }
}

