# API Gestão de Pacientes

Este projeto é uma API para gestão de pacientes desenvolvida com Spring Boot e PostgreSQL.

## Pré-requisitos

Certifique-se de que você possui os seguintes softwares instalados e configurados em sua máquina:

1. **JDK 17 ou superior**  
   Para rodar a aplicação Spring Boot.
   
2. **PostgreSQL**  
   Certifique-se de que o PostgreSQL esteja instalado e rodando na porta padrão `5432`.
   - Crie o banco de dados `TrabalhoGestaoPacientes`.
   
3. **Maven**  
   Para gerenciar dependências e build do projeto.

4. **Git**  
   Para clonar o repositório (se necessário).

---

## Configurações do Banco de Dados

1. Crie um banco de dados no PostgreSQL:
   ```sql
   CREATE DATABASE TrabalhoGestaoPacientes;
   ```

2. Certifique-se de que o usuário `postgres` possui a senha `12345`. Caso contrário, ajuste as configurações no arquivo `application.properties` ou altere a senha do usuário no PostgreSQL.

---

## Rodando o Projeto Localmente

### 1. Clone o Repositório (se necessário)
```bash
git clone <URL_DO_REPOSITORIO>
cd <PASTA_DO_REPOSITORIO>
```

### 2. Configure o Banco de Dados
Certifique-se de que o banco de dados esteja criado e disponível na URL `jdbc:postgresql://localhost:5432/TrabalhoGestaoPacientes`.

### 3. Build do Projeto
Use o Maven para compilar o projeto:
```bash
mvn clean install
```

### 4. Rodando a Aplicação
Execute o comando abaixo para iniciar o servidor Spring Boot:
```bash
mvn spring-boot:run
```

---

## Endpoints da API

Após iniciar a aplicação, a API estará disponível em `http://localhost:8080`.

Consulte a documentação no swagger da API para ver os endpoints 'http://localhost:8080/swagger-ui/index.html#/consulta-controller/editarConsulta'.
