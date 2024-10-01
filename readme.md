# RayCharge - Sistema de Gestão de Recarga de Veículos Elétricos

Este projeto foi desenvolvido como parte da disciplina de **Requisitos, Projeto de Software e Validação**, seguindo os princípios de **Domain-Driven Design (DDD)**, **Behavior-Driven Development (BDD)** e **Test-Driven Development (TDD)**, o que garante uma base sólida e alinhada com as necessidades de negócio. Além disso, a arquitetura do sistema foi construída com base nos conceitos de **Clean Architecture** e **Design Patterns**, garantindo uma organização clara e uma evolução sustentável.

## Equipe

<table>
  <tr>
    <td align="center">
      <a href="https://github.com/anabxalves">
        <img src="https://avatars.githubusercontent.com/u/108446826?v=4" width="200px;" alt="Foto Ana"/><br>
        <sub>
          <b>Ana Beatriz Alves</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/alwolmer">
        <img src="https://avatars.githubusercontent.com/u/108356950?v=4" width="200px;" alt="Foto Arthur"/><br>
        <sub>
          <b>Arthur Wolmer</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/Criismnaga">
        <img src="https://avatars.githubusercontent.com/u/104402971?v=4" width="200px;" alt="Foto Cristina"/><br>
        <sub>
          <b>Cristina Matsunaga</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/Caiobadv">
        <img src="https://avatars.githubusercontent.com/u/117755420?v=4" width="200px;" alt="Foto Caio"/><br>
        <sub>
          <b>Caio Barreto</b>
        </sub>
      </a>
    </td>
  </tr>
  <tr>
    <td align="center">
      <a href="https://github.com/diegopluna">
        <img src="https://avatars.githubusercontent.com/u/111078608?v=4" width="200px;" alt="Foto Diego"/><br>
        <sub>
          <b>Diego Peter</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/lainereis2002">
        <img src="https://avatars.githubusercontent.com/u/116602650?v=4" width="200px;" alt="Foto Gislaine"/><br>
        <sub>
          <b>Gislaine Reis</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/FernandaFBMarques">
        <img src="https://avatars.githubusercontent.com/u/101741395?v=4" width="200px;" alt="Foto Fernanda"/><br>
        <sub>
          <b>Fernanda Marques</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/virnaamaral">
        <img src="https://avatars.githubusercontent.com/u/116957619?v=4" width="200px;" alt="Foto Virna"/><br>
        <sub>
          <b>Virna Amaral</b>
        </sub>
      </a>
    </td>
  </tr>
</table>
<br>

## Descrição do Projeto

O RayCharge foi desenhado para oferecer uma solução completa de gestão de recarga de veículos elétricos, com funcionalidades robustas tanto para motoristas quanto para fornecedores. Utilizando os princípios do DDD, a divisão do domínio em subdomínios permite uma maior clareza e coesão na implementação do sistema, garantindo que as funcionalidades estejam organizadas de maneira lógica e eficiente. Além disso, a linguagem onipresente foi estabelecida para que todos os envolvidos no projeto — desenvolvedores, stakeholders e usuários — possam compartilhar um entendimento comum, minimizando ambiguidades e melhorando a comunicação durante o desenvolvimento do sistema.

### Funcionalidades Principais:
- **Consulta e agendamento de estações de recarga:** Os clientes podem localizar estações disponíveis próximas através de um mapa interativo.
- **Gestão de estações de recarga:** Os fornecedores podem cadastrar estações, monitorar o fluxo de uso e analisar o desempenho das suas unidades.
- **Cadastro e gerenciamento de veículos elétricos:** Os clientes podem registrar seus veículos no sistema, associando-os aos agendamentos de recarga.
- **Autenticação e autorização:** O sistema distingue entre os níveis de acesso de clientes e fornecedores, garantindo a segurança nas operações.

## Requisitos da 1ª entrega
## Descrição do domínio

O sistema em questão tem como domínio principal a gestão do recarregamento de **veículos** elétricos. Ele foi concebido para facilitar a interação entre **motoristas**, que são usuários de **veículos** elétricos, e **fornecedores**, que são os responsáveis pelas **estações de recarga**. **Estações de recarga** são estabelecimentos que oferecem recarga para **veículos** elétricos e possuem carregadores, que são os dispositivos físicos que fornecem energia elétrica para carregar um **veículo** por vez. A função central desse sistema é fornecer uma plataforma onde os **motoristas** possam encontrar **estações de recarga**, fazer **agendamentos** e garantir a realização das recargas agendadas, enquanto os **fornecedores** divulgam suas **estações de recarga**. O sistema também disponibilizará ao **fornecedor** ferramentas para atualização instantânea do status e relatórios de utilização e funcionamento das **estações de recarg**a. 

### Subdomínio de Realização de Recarga (principal)
O subdomínio de Realização de Recarga é a parte central do sistema, voltada para os **motoristas**. Aqui, o **motorista** pode consultar as **estações de recarga** que estejam mais próximas a ele e disponíveis por meio de um mapa interativo (similar a um catálogo visual) onde são exibidas informações sobre as **estações de recarga**, como localização, horários disponíveis, preços e avaliações atribuídas por outros **motoristas**. Após consultar a disponibilidade, o **motorista** pode realizar um **agendamento**, que garante o uso de um dos carregadores da estação de recarga em um determinado horário.

Esse subdomínio também inclui regras de negócio que garantem que não haja conflitos de **agendamento**, ou seja, que o número de **agendamento** para o mesmo horário não exceda o número de carregadores da **estação de recarga**. Outra regra de negócio importante é que um **motorista** não pode ter mais que um **agendamento** ativo ao mesmo tempo: antes que ele possa agendar novamente, todos os seus **agendamentos** anteriores já devem ter sido concluídos ou cancelados.

Esse subdomínio também garante a confiabilidade e segurança de agendamento através de um código de liberação para cada motorista conseguir usufruir do carregador. Por fim, esse domínio garante a aplicação da regra de negócio acerca do preço mínimo por **agendamento**: o **motorista** deverá debitar este valor ao realizar o **agendamento**, o qual será abatido do valor total da recarga, mas não será reembolsado no caso de não comparecimento ou cancelamento com menos de 24h de antecedência.

Esse subdomínio permitirá, ainda, que ao fim do carregamento o **motorista** avalie a estação de recarga numa escala de uma a cinco estrelas e, opcionalmente, descreva sua experiência.

### Subdomínio de Cadastro e Controle dos Fornecedores (genérico)

O subdomínio de Cadastro e Controle dos **Fornecedores** é voltado para os **fornecedores** se cadastrarem com uma conta de **fornecedor** no sistema e editarem suas informações bem como deletar a sua conta. Esse subdomínio permite que fornecedores controlem suas **estações de recarga**. O controle realizado pelo **fornecedor** refere-se a poder cadastrar e editar informações de **estações de recarga** e definir os horários de funcionamento de cada **estação de recarga**. O **fornecedor** também pode definir uma **estação de recarga** como ativa ou inativa (caso entre em manutenção ou falta de energia). Além disso, o **fornecedor** pode acessar o histórico de uso das **estações de recarga** para consulta.

### Subdomínio de Cadastro e Controle dos Motoristas (genérico)

O subdomínio de Cadastro e Gestão dos Motoristas é utilizado pelos **motoristas** para se cadastrar com uma conta de **motorista** no sistema, de editar suas informações bem como deletar a sua conta. Também permite que o **motorista** controle os seus **veículo**s elétricos. O controle de cada **motorista** refere-se a poder cadastrar ou editar as informações de **veículos** no sistema. Além disso, o **motorista** pode acessar o histórico de recargas para conferência.

### Subdomínio de Relatórios sobre as Estações de Recarga (suporte)

O subdomínio de Relatórios sobre as Estações de Recarga é focado em informar ao **fornecedor** sobre o desempenho das suas **estações de recarga** através do uso de gráficos e visualizações estatísticas em dados sobre o fluxo e taxa de desistência de **motoristas** por dia/horário, marcas e modelos dos **veículos** e rendimento da **estação de recarga**. Esse subdomínio ajuda o **fornecedor** a entender picos de utilização e identificar oportunidades para melhorar a eficiência, garantindo uma gestão mais estratégica da operação. Esse subdomínio pode ser aliado a outras ferramentas tecnológicas para realizar previsões de uso e receita em relação a uma época do ano. 

### Subdomínio de Autenticação e Autorização (suporte)

O subdomínio de Autenticação e Autorização garante a segurança no acesso ao sistema, diferenciando o nível de permissão entre **motoristas** e **fornecedores**. Nele, os **motoristas** e **fornecedores** criam contas e realizam o login ao acessar o sistema. Esse subdomínio garante que o **motorista** tenha a autorização para realizar a consulta de **estações de carregamento** e **agendamento** de recargas, para acessar as informações de histórico e cadastros dos seus **veículos** e suas informações cadastrais. 

Também garante que apenas o **fornecedor** tenha autorização para acessar as funcionalidades de cadastro, controle e análise de desempenho das **estações  de recarga**, bem como ter acesso às informações de histórico de uso. Somente o **fornecedor** tem autorização para editar o cadastro de suas **estações de recarga** e suas informações cadastrais. Esse subdomínio assegura que cada **motorista** e **fornecedor** tenha a autorização apenas às funcionalidades relevantes ao seu papel. 

### Subdomínio de Notificações (suporte)
O subdomínio de Notificações é responsável por enviar alertas e atualizações aos **motoristas** e **fornecedores** em resposta a eventos específicos que ocorrem no sistema. Este subdomínio garante que os **motoristas** sejam notificados em casos de cancelamento de um **agendamento** pelo fornecedor em situações de manutenção, falta de energia ou algum outro imprevisto. 

Já os fornecedores são notificados em casos de cancelamento de reserva por parte dos clientes e os **motoristas** recebem a notificação de cancelamento realizado com sucesso. 

## Mapa de contexto

O mapa de contexto foi realizando utilizando o Context Mapper e pode ser acessado nos links abaixo: 

- Arquivo model.cml
- Diagramas UML 

## Mapa histórias dos usuários

É a representação visual das interações do usuário com o sistema e foi desenvolvido no Avion e pode ser visualido abaixo: 

- [Mapa de histórias diretamente do Avion](https://cesar.avion.io/share/FxPRxTzF4gkdtsQ2E)
- [Mapa de histórias em pdf](https://drive.google.com/file/d/1y9WiLlNyOw82ORwd2GbFGCED5i-B37oi/view?usp=drive_link)

## Histórias a serem implementadas

A partir do mapa de histórias, foram selecionadas 4 histórias não triviais que contém regras de negócio.  

1. Como motorista, desejo visualizar as estações de recargas mais próximas da minha localização

2. Como motorista, desejo realizar um agendamento de recarga

3. Como motorista, desejo cancelar um agendamento

4. Como motorista, desejo ser notificado caso algum imprevisto cancele meu agendamento

## Protótipo de baixa fidelidade

Foi realizado o protótipo de baixa fidelidade das 4 histórias mencionadas 

- Protótipo de baixa PDF

## Cenários BBD

A descrição dos comportamentos esperados do sistema para as histórias a serem implementadas pode ser encontrado no documento baixo: 

- Documento com cenários de teste

## Automação dos cenários BDD

Implementação de testes automatizados baseados nos cenários definidos em BDD para garantir que o sistema se comporta conforme o esperado. 

- referenciar as pastas

## Adotar os níveis preliminar do DDD

A definição de entidades, agregados, acoplamento das relações, value objects serviços e eventos no domínio foi realizado na fase de criação do Context Map

## Arquiquetura limpa

Padrão de arquitetura que promove a independência dos frameworks e facilita testes, ao dividir o sistema em camadas com responsabilidades bem definidas.

## Camada de persistência e memória

Componente responsável por gerenciar o armazenamento e recuperação de dados do sistema, separando a lógica de negócios do acesso a dados.

