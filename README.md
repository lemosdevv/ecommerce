# API E-commerce Spring Boot 🛍️

## 📋 Descrição
API de E-commerce desenvolvida com Spring Boot, incluindo autenticação JWT, gerenciamento de produtos e controle de acesso por funções.

## 🛠️ Tecnologias Utilizadas
- **Java 17+**
- **Spring Boot 3.x**
- **Spring Security**
- **Autenticação JWT**
- **Banco de Dados MySQL**
- **Maven**

## ✨ Funcionalidades
- **Autenticação de Usuários** (Login/Registro)
- **Geração de Token JWT**
- **Gerenciamento de Produtos**
- **Controle de Acesso por Roles** (ADMIN/USER)

## 🚀 Instalação

### Pré-requisitos
- **Java 17+**
- **Maven**
- **MySQL**

### Configuração do Banco de Dados
1. Configure o banco de dados no arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/sua_base_de_dados
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=updat
```

### 🔗 Endpoints da API
**POST /auth/register - Registrar novo usuário**

**POST /auth/login - Login de usuário**

**Produtos**
**GET /products - Listar todos os produtos**

**POST /products - Criar produto (apenas ADMIN)**

**GET /products/{id} - Buscar produto por ID**

**PUT /products/{id} - Atualizar produto**

**DELETE /products/{id} - Deletar produto**

### 🔒 Segurança
**Autenticação baseada em JWT**

**Senhas criptografadas com BCrypt**

**Autorização baseada em papéis**

**Gerenciamento de sessão stateless**

### 👨‍💻 Desenvolvedor
**Mateus Lemos do Nascimento**

### 📄 Licença
**MIT License**

### 🤝 Contribuição
**Contribuições são bem-vindas! Sinta-se à vontade para abrir uma issue ou enviar um pull request.**
