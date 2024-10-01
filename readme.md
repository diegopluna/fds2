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

O domínio engloba subdomínios principais, genéricos e de suporte, além das regras de negócio e entidades essenciais que definem e estruturam o funcionamento do sistema da Raycharge.

- [Documento com descrição do domínio](https://docs.google.com/document/d/1bUvD6dpPbb2WyeItl-1PSUMetRk0zRbo3yT8mG8kcmQ/edit?usp=drive_link)

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

Foi realizado o protótipo de baixa fidelidade das 4 histórias mencionadas e pode ser acessado no link abaixo:

- [Protótipo de baixa PDF](https://drive.google.com/file/d/1h5JuYP3Lzcu-ww4hzgAeoYkpY_6lE3k4/view?usp=drive_link)

## Cenários BBD

A descrição dos comportamentos esperados do sistema para as histórias a serem implementadas pode ser encontrado no documento baixo: 

- [Documento com cenários de teste](https://drive.google.com/file/d/1h5JuYP3Lzcu-ww4hzgAeoYkpY_6lE3k4/view?usp=drive_link)

## Automação dos cenários BDD

Implementação de testes automatizados baseados nos cenários definidos em BDD para garantir que o sistema se comporta conforme o esperado. 

- referenciar as pastas

## Adotar os níveis preliminar do DDD

A definição de entidades, agregados, acoplamento das relações, value objects serviços e eventos no domínio foi realizado na fase de criação do Context Map.
Neste projeto, nossa equipe adotou os níveis preliminares de DDD com o objetivo de alinhar a arquitetura do sistema ao domínio do problema focou na identificação clara dos Bounded Contexts e na definição de Entidades e Value Objects em cada contexto. Dessa forma, a abordagem incluiu:

- **Definição de Bounded Contexts**: Cada contexto delimitado foi mapeado de forma a garantir a separação de responsabilidades, tornando o sistema mais modular e fácil de evoluir.
- **Identificação de Entidades e Value Objects**: As principais Entidades e Value Objects foram claramente definidas em cada contexto, representando os conceitos fundamentais do domínio.
- **Separação de Subdomínios**: Organizamos o domínio em subdomínios lógicos, o que nos permitiu concentrar a modelagem no núcleo do negócio, deixando espaço para evolução contínua à medida que novas funcionalidades são adicionadas.

Essa abordagem inicial permitiu que o sistema evoluísse de forma mais estruturada, garantindo consistência entre os modelos de domínio e os requisitos do negócio. Confira na prática observando a definição de entidades, agregados, acoplamento das relações, value objects serviços e eventos no **Context Map**, e ressaltado ao longo de todo o desenvolvimento do **Backend**.

## Arquiquetura limpa

Implementamos a Arquitetura Limpa com o objetivo de garantir flexibilidade e manutenção ao longo do ciclo de vida do projeto, com o sistema sendo organizado em camadas, onde cada uma tem uma responsabilidade clara e as dependências sempre apontam para o núcleo do negócio. As camadas definidas foram: 
- Dominio (*domain*)
- Infraestrurura (*infra*)
- Aplicação (*application*)
- Apresentação (*presentation*)

Vejamos que foi utilizado um padrão de arquitetura que promove a independência dos frameworks e facilita testes, ao dividir o sistema em camadas com responsabilidades bem definidas.

## Camada de persistência e memória

A camada de persistência foi implementada de forma a manter a lógica de acesso aos dados separada do núcleo do sistema, seguindo os princípios de Arquitetura Limpa, permitindo que o sistema utilize diferentes estratégias de persistência (em memória ou em banco de dados real) sem afetar as regras de negócios. Dessa forma, estando desacoplada das regras de negócios e de outros aspectos do sistema, proporcionou uma flexibilidade que facilitará a troca ou substituição posterior da tecnologia de armazenamento (em memória para JPA, na 2ª entrega) sem necessidade de grandes alterações no código base.