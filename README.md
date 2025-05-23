# Validacao de Senha API

## Como executar o projeto?

Pré-requisitos:
- Java 17
- Maven 3.8.4 ou superior

Clonar o Repositório:
git clone https://github.com/EllenCintra/ValidacaoDeSenha.git

Compilar o Projeto:
mvn clean install

Executar o Projeto:
mvn spring-boot:run

## Como usar a api Validação de Senha?
__Requisição:__

Método: POST

URL: http://localhost:8080/validacao-senha

Header: Content-Type: application/json

Body: Um objeto JSON com o campo "senha":
```c#
{
    "senha": "suaSenhaAqui"
}
```
__Resposta:__

A API sempre retorna o código de status HTTP 200 OK. O corpo da resposta é um objeto JSON com o seguinte formato:
```c#
{
    "data": {
        "senhaValida": true
    }
}
```
senhaValida: Um valor booleano que indica se a senha é válida (true) ou inválida (false).

## Detalhes sobre a solução:

- Arquitetura Hexagonal: Isola a lógica de negócios da comunicação com sistemas externos.

    - Domínio (Core): Contém as classes e interfaces que representam a lógica de negócios da aplicação (ex: ValidacaoStrategy e ValidacaoSenhaUseCase).

    - Portas: Interfaces que definem os pontos de entrada e saída do domínio (ex: ValidaSenhaPort).

    - Adaptadores: Classes que adaptam o mundo externo ao domínio (ex: SenhaController).

- Padrão Strategy: As diferentes regras de validação de senha (tamanho mínimo, presença de dígito, etc.) são implementadas como estratégias separadas (ValidacaoStrategy). Isso permite adicionar ou remover regras de validação facilmente, sem modificar o código principal do validador.

- Injeção de Dependência: O Spring Framework é utilizado para gerenciar a criação e injeção de dependências entre os componentes da aplicação. Isso promove um código mais desacoplado e testável.

- Inversão de Dependência: Módulos de alto nível, que definem a lógica principal da aplicação, não devem "conhecer" ou depender diretamente dos módulos de baixo nível, que fornecem a implementação concreta. Ambos devem depender de uma abstração comum, permitindo uma maior flexibilidade na substituição de implementações sem afetar a lógica principal.

- Testes Automatizados: A aplicação inclui testes unitários e de integração para garantir a qualidade e o correto funcionamento da lógica de validação e da API.


## Premissas Assumidas

- Validação de Caracteres Repetidos:

    - Premissa: A validação de caracteres repetidos é case-sensitive. Por exemplo, "Aa" não é considerado caracteres repetidos.

- Tratamento de Erros:

    - Premissa: A API retorna sempre o status 200 OK, mesmo em caso de falha na validação. A informação sobre o sucesso ou falha da validação é retornada no corpo da resposta.

- Validação de Nulo:

    - Premissa: As classes de validação tratam senhas nulas como inválidas para evitar NullPointerExceptions e verificações desnecessárias.
