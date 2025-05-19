package com.challenge.validaSenha.adapters.inbound;

import com.challenge.validaSenha.ports.ValidaSenhaPort;
import com.challenge.validaSenha.core.dtos.ValidacaoSenhaRequestDto;
import com.challenge.validaSenha.core.dtos.ValidacaoSenhaResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class SenhaControllerTest {

    @Mock
    private ValidaSenhaPort validaSenhaPort;

    @InjectMocks
    private SenhaController senhaController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void validaSenha_deveRetornarStatusOk_senhaTrue_corpoComData() {
        ValidacaoSenhaRequestDto requestDto = new ValidacaoSenhaRequestDto("senhaValida");
        ValidacaoSenhaResponseDto responseDto = new ValidacaoSenhaResponseDto(true);
        when(validaSenhaPort.validarSenha(requestDto)).thenReturn(responseDto);

        ResponseEntity<Data<ValidacaoSenhaResponseDto>> responseEntity = senhaController.validaSenha(requestDto);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(responseDto, responseEntity.getBody().getData());
    }

    @Test
    public void validaSenha_deveRetornarStatusOk_senhaFalse_corpoComData() {
        ValidacaoSenhaRequestDto requestDto = new ValidacaoSenhaRequestDto("senhaValida");
        ValidacaoSenhaResponseDto responseDto = new ValidacaoSenhaResponseDto(false);
        when(validaSenhaPort.validarSenha(requestDto)).thenReturn(responseDto);

        ResponseEntity<Data<ValidacaoSenhaResponseDto>> responseEntity = senhaController.validaSenha(requestDto);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(responseDto, responseEntity.getBody().getData());
    }
}

