package com.challenge.validaSenha.adapters.inbound;

import com.challenge.validaSenha.core.dtos.ValidacaoSenhaRequestDto;
import com.challenge.validaSenha.core.dtos.ValidacaoSenhaResponseDto;
import com.challenge.validaSenha.ports.ValidaSenhaPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SenhaController {

    private final ValidaSenhaPort validaSenhaPort;

    public SenhaController(ValidaSenhaPort validaSenhaUseCase) {
        this.validaSenhaPort = validaSenhaUseCase;
    }

    @PostMapping("/validacao-senha")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Data<ValidacaoSenhaResponseDto>> validaSenha(@RequestBody ValidacaoSenhaRequestDto senhaRequest) {
        ValidacaoSenhaResponseDto senhaValida = validaSenhaPort.validarSenha(senhaRequest);
        return ResponseEntity.status(HttpStatus.OK).body(new Data<>(senhaValida));
    }
}
