package com.challenge.validaSenha.adapters.inbound;

import com.challenge.validaSenha.core.usecases.ValidaSenhaUseCase;
import com.challenge.validaSenha.ports.input.ValidacaoSenhaRequestDto;
import com.challenge.validaSenha.ports.output.Data;
import com.challenge.validaSenha.ports.output.ValidacaoSenhaResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SenhaController {

    private final ValidaSenhaUseCase validaSenhaUseCase;

    public SenhaController(ValidaSenhaUseCase validaSenhaUseCase) {
        this.validaSenhaUseCase = validaSenhaUseCase;
    }

    @PostMapping("/validacao-senha")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Data<ValidacaoSenhaResponseDto>> validaSenha(@RequestBody ValidacaoSenhaRequestDto senhaRequest) {
        ValidacaoSenhaResponseDto senhaValida = validaSenhaUseCase.validarSenha(senhaRequest);
        return ResponseEntity.status(HttpStatus.OK).body(new Data<>(senhaValida));
    }
}
