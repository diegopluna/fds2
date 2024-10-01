Feature: Cancelar Agendamento

  Scenario: Cancelamento com mais de 24h de antecedência
    Given que o motorista possui um agendamento ativo no sistema
    And o horário deste agendamento está a mais de 24h do momento atual
    When o motorista seleciona o agendamento para cancelamento
    Then o sistema deve alterar o status do agendamento para cancelado
    And o sistema deve definir o valor total do agendamento para zero
    And uma notificação deve ser criada com a mensagem: "Cancelamento processado com sucesso. Por ter sido solicitado com mais de 24h de antecedência, o valor será totalmente reembolsado."

  Scenario: Cancelamento com menos de 24h de antecedência
    Given que o motorista possui um agendamento ativo no sistema
    And o horário do agendamento está a menos de 24h do momento atual
    When o motorista seleciona o agendamento para cancelamento
    Then o sistema deve alterar o status do agendamento para cancelado
    And o sistema deve definir o valor total do agendamento para o valor mínimo da estação
    And uma notificação deve ser criada com a mensagem: "Cancelamento processado com sucesso. Por ter sido solicitado com menos de 24h de antecedência, será cobrado o valor mínimo da estação."

  Scenario: Tentativa de cancelamento de agendamento inexistente
    Given que o motorista não possui nenhum agendamento ativo no sistema
    When o motorista tenta cancelar um agendamento
    Then o sistema deve exibir uma mensagem de erro: "Não foi possível cancelar o agendamento. Nenhum agendamento ativo encontrado."