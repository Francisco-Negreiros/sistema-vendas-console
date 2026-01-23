# 🛒 Sistema de Vendas em Java (Console)

Projeto desenvolvido em Java com foco em **boas práticas de programação**, 
**arquitetura limpa** e **simulação de um sistema real de vendas em console**.

O objetivo do projeto é demonstrar domínio de:
- Orientação a Objetos
- Separação de responsabilidades
- Persistência de dados
- Organização de código como em projetos profissionais

## 🚀 Funcionalidades

- Cadastro de produtos
- Listagem de produtos
- Busca de produto por código
- Edição de produto
- Remoção de produto
- Persistência de dados em arquivo (`.txt`)
- Tratamento de regras de negócio com exceções

## 🏗️ Arquitetura do Projeto

O projeto foi organizado seguindo princípios de **arquitetura limpa**, com separação clara de responsabilidades:

- `application`  
  Camada responsável pela interação com o usuário (Console UI).

- `domain`  
  Contém as regras de negócio e entidades do sistema.

- `domain.repository`  
  Define contratos de persistência e implementações (em memória e em arquivo).

- `domain.exception`  
  Exceções de negócio para garantir integridade do sistema.

  ## 🧪 Tecnologias Utilizadas

- Java 21
- Programação Orientada a Objetos
- Git e GitHub
- Persistência em arquivo
- Eclipse / VS Code
  
  ## ▶️ Como Executar o Projeto

1. Clone o repositório: git clone https://github.com/Francisco-Negreiros/sistema-vendas-console.git
2. Abra o projeto em uma IDE Java (Eclipse, IntelliJ, etc)
3. Execute a classe: application.Program
4. O sistema será iniciado no console.
