package com.challenge.validaSenha.core.configs;

import com.challenge.validaSenha.core.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
class ConfiguracaoValidacaoSenha {

    @Bean
    public ValidaSenhaUseCaseImpl validadorSenha(List<ValidacaoStrategy> validacoes) {
        return new ValidaSenhaUseCaseImpl(validacoes);
    }

    @Bean
    public ValidacaoTamanhoMinimo validacaoTamanhoMinimo() {
        return new ValidacaoTamanhoMinimo();
    }

    @Bean
    public ValidacaoDigito validacaoDigito() {
        return new ValidacaoDigito();
    }

    @Bean
    public ValidacaoMinuscula validacaoMinuscula() {
        return new ValidacaoMinuscula();
    }

    @Bean
    public ValidacaoMaiuscula validacaoMaiuscula() {
        return new ValidacaoMaiuscula();
    }

    @Bean
    public ValidacaoCaractereEspecial validacaoCaractereEspecial() {
        return new ValidacaoCaractereEspecial();
    }

    @Bean
    public ValidacaoEspacoEmBranco validacaoEspacoEmBranco() {
        return new ValidacaoEspacoEmBranco();
    }

    @Bean
    public ValidacaoCaracteresRepetidos validacaoCaracteresRepetidos() {
        return new ValidacaoCaracteresRepetidos();
    }

}
