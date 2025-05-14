package com.challenge.validaSenha.core.usecases;

import com.challenge.validaSenha.ports.input.ValidacaoSenhaRequestDto;
import com.challenge.validaSenha.ports.output.ValidacaoSenhaResponseDto;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ValidaSenhaUseCaseImpl implements ValidaSenhaUseCase{

    private static final int TAMANHO_MINIMO = 9;
    private static final String CARACTERES_ESPECIAIS = "!@#$%^&*()-+";

    @Override
    public ValidacaoSenhaResponseDto validarSenha(ValidacaoSenhaRequestDto senhaRequest) {
        boolean senhaValida = senhaValida(senhaRequest.getSenha());
        return new ValidacaoSenhaResponseDto(senhaValida);
    }

    private boolean senhaValida(String senha) {
        if (senha == null || senha.length() < TAMANHO_MINIMO) {
            return false;
        }

        boolean possuiDigito = false;
        boolean possuiMinusculo = false;
        boolean possuiMaiusculo = false;
        boolean possuiEspecial = false;
        Set<Character> caracteres = new HashSet<>();


        for (char c : senha.toCharArray()) {
            if (Character.isWhitespace(c)) {
                return false; // Espaços em branco não são permitidos
            }

            if (!caracteres.add(c)) {
                return false; // Caracteres repetidos não são permitidos
            }
        }

        return possuiDigito && possuiMinusculo && possuiMaiusculo && possuiEspecial;
    }
}
