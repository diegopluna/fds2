Feature: Criar Conta de Usuário

  Scenario: Criar uma nova conta de usuário com sucesso
    Given que não existe um usuário com o login "novousuario@example.com"
    When eu criar uma nova conta com os seguintes detalhes:
      | login                   | senha    | tipoUsuario |
      | novousuario@example.com | senha123 | MOTORISTA   |
    Then a conta deve ser criada com sucesso
    And o id do usuário deve ser retornado

  Scenario: Tentar criar uma conta com um login já existente
    Given que existe um usuário com o login "existente@example.com"
    When eu criar uma nova conta com os seguintes detalhes:
      | login                  | senha    | tipoUsuario |
      | existente@example.com  | senha456 | FORNECEDOR  |
    Then a criação da conta deve falhar
    And uma mensagem de erro indicando que o usuário já existe deve ser retornada

  Scenario: Criar contas com diferentes tipos de usuário
    When eu criar uma nova conta com os seguintes detalhes:
      | login                | senha    | tipoUsuario |
      | motorista@example.com | senha789 | MOTORISTA   |
    Then a conta deve ser criada com sucesso
    When eu criar uma nova conta com os seguintes detalhes:
      | login                 | senha    | tipoUsuario |
      | fornecedor@example.com | senha101 | FORNECEDOR  |
    Then a conta deve ser criada com sucesso