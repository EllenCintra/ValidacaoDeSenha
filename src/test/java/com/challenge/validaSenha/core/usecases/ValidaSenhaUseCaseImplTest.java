package com.challenge.validaSenha.core.usecases;

import com.challenge.validaSenha.ports.input.ValidacaoSenhaRequestDto;
import com.challenge.validaSenha.ports.output.ValidacaoSenhaResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

public class ValidaSenhaUseCaseImplTest {

    private ValidaSenhaUseCaseImpl validaSenhaUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        validaSenhaUseCase = new ValidaSenhaUseCaseImpl();
    }

    @Test
    void validarSenha_senhaValida_tamanhoInvalido_retornaTrue() {
        ValidacaoSenhaRequestDto requestDto = new ValidacaoSenhaRequestDto("AbCdEfg1!");
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
    void validarSenha_semDigito_retornaFalse() {
        ValidacaoSenhaRequestDto requestDto = new ValidacaoSenhaRequestDto("Abcdefghi!");
        ValidacaoSenhaResponseDto responseDto = validaSenhaUseCase.validarSenha(requestDto);
        assertFalse(responseDto.isSenhaValida());
    }

    @Test
    void validarSenha_semMinuscula_retornaFalse() {
        ValidacaoSenhaRequestDto requestDto = new ValidacaoSenhaRequestDto("ABCDEFGHI9!");
        ValidacaoSenhaResponseDto responseDto = validaSenhaUseCase.validarSenha(requestDto);
        assertFalse(responseDto.isSenhaValida());
    }

    @Test
    void validarSenha_semMaiuscula_retornaFalse() {
        ValidacaoSenhaRequestDto requestDto = new ValidacaoSenhaRequestDto("abcdefghi9!");
        ValidacaoSenhaResponseDto responseDto = validaSenhaUseCase.validarSenha(requestDto);
        assertFalse(responseDto.isSenhaValida());
    }

    @Test
    void validarSenha_semCaractereEspecial_retornaFalse() {
        ValidacaoSenhaRequestDto requestDto = new ValidacaoSenhaRequestDto("aBcDeFgHi9");
        ValidacaoSenhaResponseDto responseDto = validaSenhaUseCase.validarSenha(requestDto);
        assertFalse(responseDto.isSenhaValida());
    }

    @Test
    void validarSenha_caractereEspecialInvalido_retornaFalse() {
        ValidacaoSenhaRequestDto requestDto = new ValidacaoSenhaRequestDto("aBcDeFgHi9~");
        ValidacaoSenhaResponseDto responseDto = validaSenhaUseCase.validarSenha(requestDto);
        assertFalse(responseDto.isSenhaValida());
    }

    @Test
    void validarSenha_caracteresRepetidos_caseSensitive_retornaFalse() {
        ValidacaoSenhaRequestDto requestDto = new ValidacaoSenhaRequestDto("aabBcCdDe9!");
        ValidacaoSenhaResponseDto responseDto = validaSenhaUseCase.validarSenha(requestDto);
        assertFalse(responseDto.isSenhaValida());
    }

    @Test
    void validarSenha_espacoEmBranco_retornaFalse() {
        ValidacaoSenhaRequestDto requestDto = new ValidacaoSenhaRequestDto("aB1! fghi9");
        ValidacaoSenhaResponseDto responseDto = validaSenhaUseCase.validarSenha(requestDto);
        assertFalse(responseDto.isSenhaValida());
    }

    @Test
    void validarSenha_retornaTrue() {
        ValidacaoSenhaRequestDto requestDto = new ValidacaoSenhaRequestDto("aB1!fghi9");
        ValidacaoSenhaResponseDto responseDto = validaSenhaUseCase.validarSenha(requestDto);
        assertTrue(responseDto.isSenhaValida());
    }
}
