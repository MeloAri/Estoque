📦 Controle de Estoque - Spring Boot
Projeto simples de uma API REST para controle de estoque, desenvolvida com Java e Spring Boot.

🔧 Funcionalidades
✅ Cadastro de categorias

✅ Cadastro de produtos vinculados a categorias

✅ Registro de movimentações de entrada e saída de produtos

✅ Atualização automática do estoque atual com base nas movimentações

✅ Testes com o Postman

🛠️ Tecnologias utilizadas
Java 17

Spring Boot

Spring Data JPA

H2 Database (ou PostgreSQL)

Postman

Gradle

🗂️ Estrutura do Projeto
entities/ – Entidades do sistema (Produto, Categoria, Movimentação)

repositories/ – Interfaces JPA para persistência

services/ – Regras de negócio

controllers/ – Endpoints REST

exception/ – Classes para tratamento personalizado de erros

📬 Exemplos de Requisições (Postman)
Criar categoria:

json
Copiar
Editar
POST /categorias
{
  "nome": "Eletrônicos"
}
Criar produto:

json
Copiar
Editar
POST /produtos
{
  "nome": "Mouse",
  "quantidade": 10,
  "categoria": {
    "id": 1
  }
}
Registrar movimentação de entrada:

json
Copiar
Editar
POST /movimentacoes
{
  "tipo": "ENTRADA",
  "quantidade": 5,
  "produto": {
    "id": 1
  }
}
🧠 Aprendizados
Esse projeto me ajudou a reforçar conceitos fundamentais de construção de APIs REST com Spring Boot, organização em camadas, e a prática de testes com o Postman. Também explorei o uso de exceções personalizadas para melhorar a clareza dos retornos de erro.

