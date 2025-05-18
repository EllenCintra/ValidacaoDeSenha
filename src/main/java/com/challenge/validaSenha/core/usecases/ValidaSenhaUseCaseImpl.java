package com.challenge.validaSenha.core.usecases;

import com.challenge.validaSenha.ports.input.ValidacaoSenhaRequestDto;
import com.challenge.validaSenha.ports.output.ValidacaoSenhaResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ValidaSenhaUseCaseImpl implements ValidaSenhaUseCase{

    private final List<ValidacaoStrategy> validacoes;

    // Injeção de dependência das estratégias de validação
    public ValidaSenhaUseCaseImpl(List<ValidacaoStrategy> validacoes) {
        this.validacoes = validacoes;
    }

    @Override
    public ValidacaoSenhaResponseDto validarSenha(ValidacaoSenhaRequestDto senhaRequest) {
        String senha = senhaRequest.getSenha();
        return new ValidacaoSenhaResponseDto(senhaValida(senha));
    }

    public boolean senhaValida(String senha) {
        for (ValidacaoStrategy validacao : validacoes) {
            if (!validacao.validar(senha)) {
                return false; // Retorna no primeiro erro
            }
        }
        return true;
    }

}
