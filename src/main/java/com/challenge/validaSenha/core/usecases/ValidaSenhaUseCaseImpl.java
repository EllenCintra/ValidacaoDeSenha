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
            if (Character.isWhitespace(c))
                return false;

            if (!caracteres.add(c)) //verifica carater repetido
                return false;

            if (Character.isDigit(c))
                possuiDigito = true;

            else if (Character.isLowerCase(c))
                possuiMinusculo = true;

            else if (Character.isUpperCase(c))
                possuiMaiusculo = true;

            else if (CARACTERES_ESPECIAIS.contains(String.valueOf(c)))
                possuiEspecial = true;
        }

        return possuiDigito && possuiMinusculo && possuiMaiusculo && possuiEspecial;
    }
}
