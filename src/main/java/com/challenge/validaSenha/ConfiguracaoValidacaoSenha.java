package com.challenge.validaSenha;

import java.util.List;

@Configuration
class ConfiguracaoValidacaoSenha {

    // Bean para o validador de senha (adaptador que implementa a porta)
    @Bean
    public ValidadorSenhaPort validadorSenha(List<ValidacaoStrategy> validacoes) {
        return new ValidadorSenha(validacoes);
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
