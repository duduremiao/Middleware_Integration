# Sistema de Microserviços de Clientes e Pedidos

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.6-brightgreen)
![Java](https://img.shields.io/badge/Java-17-orange)
![Apache Camel](https://img.shields.io/badge/Apache%20Camel-4.8.1-red)
![Arquitetura](https://img.shields.io/badge/Arquitetura-Microservi%C3%A7os-blue)

> Sistema distribuído baseado em microserviços que integra o gerenciamento de clientes e pedidos através de uma arquitetura moderna e robusta.

## 📋 Visão Geral

Este projeto demonstra uma implementação prática de uma arquitetura de microserviços usando Spring Boot e Apache Camel. O sistema é composto por três serviços independentes que se comunicam através de APIs REST, com um middleware central responsável pela orquestração e integração dos dados.

### 🏗️ Arquitetura


O sistema é composto por:

- **Cliente Service**: Gerencia informações dos clientes
- **Pedido Service**: Gerencia os pedidos realizados 
- **Middleware**: Coordena a integração entre os serviços, processando e transformando dados

## 🚀 Funcionalidades

- Cadastro e consulta de clientes
- Registro e consulta de pedidos
- Integração automática de dados através do middleware
- Processamento e transformação de dados utilizando Apache Camel
- Interface REST para todas as operações
- Banco de dados independente para cada serviço (H2 Database)

## 💻 Tecnologias Utilizadas

- **Spring Boot**: Framework base para todos os microserviços
- **Spring Data JPA**: Persistência e acesso a dados
- **Apache Camel**: Implementação de Enterprise Integration Patterns
- **H2 Database**: Banco de dados em memória para cada serviço
- **Spring Actuator**: Métricas e monitoramento
- **Prometheus**: Exportação de métricas

## 🛠️ Estrutura do Projeto

```
.
├── clienteservice/          # Serviço de gerenciamento de clientes
├── pedidoservice/           # Serviço de gerenciamento de pedidos
└── middleware/              # Serviço de integração usando Apache Camel
```

## 📦 Componentes Principais

### Cliente Service (Porta 8081)
Responsável pelo gerenciamento de informações dos clientes.
- `Cliente`: Entidade que representa um cliente
- `ClienteController`: API REST para operações CRUD de clientes
- `ClienteRepository`: Interface de persistência de dados

### Pedido Service (Porta 8082)
Responsável pelo gerenciamento de pedidos.
- `Pedido`: Entidade que representa um pedido
- `PedidoController`: API REST para operações CRUD de pedidos
- `PedidoRepository`: Interface de persistência de dados

### Middleware (Porta 8083)
Responsável pela integração entre os serviços.
- `IntegrationRoutes`: Rotas Apache Camel para integração
- `IntegratedOrders`: Modelo de dados integrados
- `MiddlewareController`: API para iniciar processos de integração

## 🔄 Fluxo de Integração

1. Uma requisição é feita ao endpoint `/integrate` do Middleware
2. O Middleware busca todos os clientes do Cliente Service
3. Para cada cliente:
   - O Middleware busca os pedidos associados do Pedido Service
   - Processa e transforma os dados combinados
   - Salva os resultados como `IntegratedOrders`

## 🚦 Padrões de Projeto Implementados

- **Repository Pattern**: Abstração da camada de dados
- **Dependency Injection**: Injeção de dependências via construtor
- **MVC Pattern**: Separação clara entre Model, View e Controller
- **Enterprise Integration Patterns**: Implementados via Apache Camel
- **Facade Pattern**: Middleware como fachada para simplificar a integração

## 🧪 Tipos de Testes

- **Testes Unitários**: Validação isolada de componentes
- **Testes de Integração**: Verificação do fluxo completo entre os serviços

## 📝 Princípios de Design Aplicados

- **SOLID**: Princípios de design orientado a objetos
  - Single Responsibility: Cada classe tem responsabilidade única
  - Open/Closed: Extensível sem modificação
  - Liskov Substitution: Hierarquias de classes bem definidas
  - Interface Segregation: Interfaces específicas e coesas
  - Dependency Inversion: Dependências injetadas, não criadas internamente

- **Clean Code**: Código legível e manutenível
  - Nomes significativos
  - Métodos curtos com propósito único
  - Comentários explicativos onde necessário

## ⚙️ Como Executar

### Pré-requisitos
- Java 17 ou superior
- Maven 3.6 ou superior

### Passos para execução

#### 1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/microservices-integration.git
cd microservices-integration
```

#### 2. Execute o Cliente Service:
```bash
cd clienteservice
mvn spring-boot:run
```

#### 3. Execute o Pedido Service:
```bash
cd ../pedidoservice
mvn spring-boot:run
```

#### 4. Execute o Middleware:
```bash
cd ../middleware
mvn spring-boot:run
```

#### 5. Inicie o processo de integração:
```bash
curl http://localhost:8083/integrate
```

## 🔎 Acessando as Interfaces

- **Cliente Service API**: http://localhost:8081/clientes
- **Pedido Service API**: http://localhost:8082/pedidos
- **Middleware API**: http://localhost:8083/novosPedidos
- **H2 Console Cliente Service**: http://localhost:8081/h2-console
- **H2 Console Pedido Service**: http://localhost:8082/h2-console
- **H2 Console Middleware**: http://localhost:8083/h2-console
- **Actuator Endpoints**: http://localhost:8083/actuator

## 📊 Monitoramento

O Middleware está configurado com Spring Actuator e exportação de métricas Prometheus, permitindo o monitoramento detalhado das operações:

- Health Check: http://localhost:8083/actuator/health
- Métricas: http://localhost:8083/actuator/metrics
- Prometheus: http://localhost:8083/actuator/prometheus

## 📚 Documentação Adicional

- [Apache Camel Documentation](https://camel.apache.org/manual/)
- [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/)
- [Enterprise Integration Patterns](https://www.enterpriseintegrationpatterns.com/)

