Feature: Realizar Agendamento de Recarga

  Scenario: Selecionar horário e confirmar o agendamento de recarga
    Given que existe uma estação com horários disponíveis e um motorista que não possui agendamentos com status ativo
    When o motorista selecionar para agendamento esta estação e um horário específico entre os disponíveis desta mesma estação
    Then o agendamento deve ser instanciado e persistido no sistema
    And deve ser criada e persistida uma notificação de confirmação: "Agendamento realizado com sucesso para a estação [nome da estação] no dia e horário [dia e horário]."

  Scenario: Agendamento em Horário Indisponível
    Given que existe uma estação com horários disponíveis e um motorista que não possui agendamentos com status ativo
    When o motorista selecionar para agendamento esta estação e um horário que não estiver entre os disponíveis desta mesma estação
    Then o agendamento não deve ser criado ou persistido no sistema
    And deve ser criada e persistida uma notificação de erro: "Não foi possível agendar para a estação [nome da estação] no horário [horário], por favor selecione um horário disponível"

  Scenario: Tentativa de agendar com agendamento ativo
    Given que exista uma estação com horários disponíveis e um motorista que possui um agendamento com status ativo
    When o motorista selecionar para agendamento a estação e um horário específico entre os disponíveis desta mesma estação
    Then o agendamento não deve ser criado ou persistido no sistema
    And deve ser criada e persistida uma notificação de erro: "Você já possui um agendamento ativo. Para criar um novo agendamento, finalize o atual ou cancele-o."