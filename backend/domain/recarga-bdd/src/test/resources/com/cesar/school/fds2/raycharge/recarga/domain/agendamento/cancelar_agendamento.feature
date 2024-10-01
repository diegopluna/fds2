Feature: Cancelar Agendamento

  Scenario: Cancelamento a Mais de 24h do Horário Agendado
    Given que o motorista possui um agendamento persistido no sistema com status ativo
    And o horário deste agendamento está a mais de 24h do momento atual
    When o motorista selecionar o agendamento para cancelamento
    Then o sistema deve mudar o status do agendamento para cancelado e o valor total para zero
    And criada e persistida uma notificação com a seguinte mensagem: "Cancelamento processado com sucesso. Por ter sido solicitado a mais de 24h do horário agendado, o preço mínimo será reembolsado".