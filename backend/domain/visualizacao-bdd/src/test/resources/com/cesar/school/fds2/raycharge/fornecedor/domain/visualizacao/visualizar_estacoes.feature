Feature: Visualizar Estações de Recarga

  Scenario: Exibição das Estações com Dados e Ordenação por Proximidade
    Given que existam três estações de recarga cadastradas
    When o motorista realizar a busca
    Then as estações cadastradas retornadas com nome, endereço, distância do motorista até a estação, preço mínimo e preço por kWh
    And os cards devem estar ordenados em ordem crescente de distância entre a estação e a localização do motorista

  Scenario: Filtragem por Horário Disponível
    Given que há uma estação de recarga cadastrada no sistema sem horários disponíveis
    When o motorista realizar a busca
    Then a estação sem horário disponível não deve ser retornada

  Scenario: Filtragem por Status
    Given que há uma estação de recarga cadastrada no sistema com status inativo
    When o motorista realizar a busca
    Then a estação com status inativo não deve ser retornada