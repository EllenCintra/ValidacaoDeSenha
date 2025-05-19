package com.challenge.validaSenha.core.usecases;

import com.challenge.validaSenha.core.dtos.ValidacaoSenhaRequestDto;
import com.challenge.validaSenha.core.dtos.ValidacaoSenhaResponseDto;
import com.challenge.validaSenha.ports.ValidaSenhaPort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ValidaSenhaUseCase implements ValidaSenhaPort {

    private final List<ValidacaoStrategy> validacoes;

    public ValidaSenhaUseCase(List<ValidacaoStrategy> validacoes) {
        this.validacoes = validacoes;
    }

    @Override
    public ValidacaoSenhaResponseDto validarSenha(ValidacaoSenhaRequestDto senhaRequest) {
        String senha = senhaRequest.getSenha();
        return new ValidacaoSenhaResponseDto(senhaValida(senha));
    }

    public boolean senhaValida(String senha) {
        if (senha == null || senha.isEmpty())
            return false;

        for (ValidacaoStrategy validacao : validacoes) {
            if (!validacao.validar(senha)) {
                return false;
            }
        }
        return true;
    }

}
