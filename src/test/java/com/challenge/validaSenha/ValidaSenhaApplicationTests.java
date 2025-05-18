package com.challenge.validaSenha;

import com.challenge.validaSenha.core.usecases.ConfiguracaoValidacaoSenha;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import({ConfiguracaoValidacaoSenha.class})
class ValidaSenhaApplicationTests {

	@Test
	void contextLoads() {
	}

}
