package com.challenge.validaSenha.core.usecases;

import com.challenge.validaSenha.ports.input.ValidacaoSenhaRequestDto;
import com.challenge.validaSenha.ports.output.ValidacaoSenhaResponseDto;

public interface ValidaSenhaUseCase {
    ValidacaoSenhaResponseDto validarSenha(ValidacaoSenhaRequestDto senhaRequest);
}
