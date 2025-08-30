# Sistema de Gerenciamento de Ninjas e Missões 🥷

![Badge de Status](https://img.shields.io/badge/status-em%20desenvolvimento-yellow)
![Badge de Linguagem](https://img.shields.io/badge/linguagem-Java-blue?logo=java)
![Badge de Framework](https://img.shields.io/badge/framework-Spring%20Boot-green?logo=spring)
![Badge de Frontend](https://img.shields.io/badge/frontend-Thymeleaf-orange)

> Um sistema web completo para cadastrar, gerenciar e visualizar ninjas e suas respectivas missões, totalmente inspirado no universo de Naruto! 🍥

Este projeto foi desenvolvido como uma aplicação full-stack utilizando Java com Spring Boot no back-end e Thymeleaf para a renderização do front-end.

---

## ✨ Visão Geral do Projeto

O objetivo é criar um CRUD (Create, Read, Update, Delete) funcional para duas entidades principais: **Ninjas** e **Missões**. A interface foi cuidadosamente estilizada para proporcionar uma experiência imersiva e agradável, com temas que remetem à estética do anime.


### Tabela de missoes
<img width="1910" height="941" alt="image" src="https://github.com/user-attachments/assets/d35b4c98-31a7-46fa-b362-e8a19a7bb7ee" />

### Tabela de Ninjas
<img width="1358" height="632" alt="image" src="https://github.com/user-attachments/assets/852056ca-eb07-47f5-9bc0-20a4d49e21df" />




## 🚀 Funcionalidades Principais

-   **Gerenciamento de Ninjas:**
    -   [✔️] Listar todos os ninjas cadastrados.
    -   [✔️] Visualizar os detalhes de um ninja específico.
    -   [✔️] Adicionar um novo ninja ao sistema.
    -   [🚧] Alterar informações de um ninja existente.
    -   [✔️] Deletar um ninja.
-   **Gerenciamento de Missões:**
    -   [✔️] Listar todas as missões disponíveis.
    -   [✔️] Visualizar detalhes de uma missão.
    -   [✔️] Adicionar uma nova missão.
    -   [🚧] Alterar dados de uma missão.
    -   [✔️] Deletar uma missão.

*(Use [✔️] para funcionalidades concluídas e [🚧] para as que estão em progresso)*

---

## 💻 Tecnologias Utilizadas

Este projeto foi construído com as seguintes tecnologias:

-   **Back-end:**
    -   **Java 17:** Linguagem de programação principal.
    -   **Spring Boot:** Framework para criação da aplicação web.
    -   **Spring Data JPA:** Para persistência de dados.
    -   **Maven:** Gerenciador de dependências.
-   **Front-end:**
    -   **Thymeleaf:** Motor de templates para renderizar as páginas no servidor.
    -   **HTML5 & CSS3:** Estruturação e estilização das páginas.
-   **Banco de Dados:**
    -   **H2 Database:** Banco de dados em memória para ambiente de desenvolvimento. - Pretendo realizar a migração

## Iniciacilizando projeto 

### Passos

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/Hapolo11/CadastroDeNinjas.git
    ```

2.  **Navegue até o diretório do projeto:**
    ```bash
    cd CadastroDeNinjas
    ```

3.  **Execute a aplicação:**
    ```bash
    CadastroDeNinjasApplication.java
    ```

4.  **Acesse a aplicação:**
    -   Abra seu navegador e acesse `http://localhost:8080/ninjas/ui/listar`
    -   Você deverá ver a página principal da lista de ninjas.

---

### Rota para ir à lista de missões
http://localhost:8080/missoes/ui/listar 

### Rota para ir à lista de ninjas
http://localhost:8080/ninjas/ui/listar


ao iniciar o projeto podemos encontrar toda a documentação em: http://localhost:8080/swagger-ui/index.html#/




