package com.challenge.validaSenha.ports;

import com.challenge.validaSenha.core.dtos.ValidacaoSenhaRequestDto;
import com.challenge.validaSenha.core.dtos.ValidacaoSenhaResponseDto;

public interface ValidaSenhaPort {
    ValidacaoSenhaResponseDto validarSenha(ValidacaoSenhaRequestDto senhaRequest);
}
