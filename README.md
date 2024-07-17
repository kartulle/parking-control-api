<h1>Parking Control API</h1>
Este projeto é uma API de controle de vagas de estacionamento construída em Java 22 com Spring Boot 3. <br/>
Abaixo estão descritos os padrões de projeto utilizados na implementação do código.

## Principais Tecnologias
 - **Java 22**: Utilizei a versão mais recente do Java para tirar vantagem das últimas inovações que essa linguagem robusta e amplamente utilizada oferece;
 - **Spring Boot 3**: Trabalhei com a mais nova versão do Spring Boot, que maximiza a produtividade do desenvolvedor por meio de sua poderosa premissa de autoconfiguração;
 - **Spring Data JPA**: Explorei como essa ferramenta pode simplificar nossa camada de acesso aos dados, facilitando a integração com bancos de dados SQL;
 - **OpenAPI (Swagger)**: Criei uma documentação de API eficaz e fácil de entender usando a OpenAPI (Swagger), perfeitamente alinhada com a alta produtividade que o Spring Boot oferece;

<br/>

# Padrões de Projeto Utilizados
Padrões de projeto ajudam a manter o código organizado, modular e fácil de manter e testar. Eles promovem boas práticas de desenvolvimento de software.

## 1. Injeção de Dependência (Dependency Injection)
A injeção de dependência é um padrão de projeto que permite que uma classe receba suas dependências de fontes externas, em vez de criá-las internamente. Isso promove um baixo acoplamento entre as classes e facilita o teste e a manutenção do código.
### Uso no Código: 
No controlador ParkingSpotController, as dependências ParkingSpotService e ParkingSpotValidator são injetadas através da anotação @Autowired. Da mesma forma, o ParkingSpotService tem o repositório ParkingSpotRepository injetado.

## 2. Serviço (Service Pattern)
O padrão de serviço encapsula a lógica de negócios em uma camada de serviço. Isso promove a separação de responsabilidades, onde os controladores lidam com a lógica de controle e os serviços lidam com a lógica de negócios.
### Uso no Código: 
A classe ParkingSpotService contém métodos que encapsulam a lógica de negócios relacionada às operações de ParkingSpot, como salvar, deletar e verificar existência.

## 3. Repositório. (Repository Pattern)
O padrão de repositório abstrai a lógica de acesso a dados, fornecendo uma interface comum para manipulação dos dados. Ele atua como um mediador entre a camada de domínio e a camada de mapeamento de dados.
### Uso no Código: 
A interface ParkingSpotRepository estende JpaRepository, proporcionando uma abstração sobre o acesso a dados e fornecendo métodos para verificar a existência de registros e realizar operações CRUD.

## 4. DTO (Data Transfer Object)
O padrão DTO é usado para transferir dados entre diferentes camadas da aplicação. Ele encapsula os dados que precisam ser transferidos e pode incluir validações e lógica de transformação de dados.
### Uso no Código: 
A classe ParkingSpotDto é um exemplo de DTO usado para encapsular os dados transferidos na API, garantindo que apenas os dados necessários sejam enviados entre o cliente e o servidor.

## 5. Conversão (Mapper Pattern)
O padrão de conversão é utilizado para mapear dados de um objeto para outro, especialmente entre entidades e DTOs. Isso promove a separação das preocupações e facilita a transformação de dados.
### Uso no Código:
O método BeanUtils.copyProperties é usado para mapear os dados do DTO ParkingSpotDto para a entidade ParkingSpotModel.

## 6. Tratamento de Exceções (Exception Handling)
Embora não seja um padrão de projeto formal, o tratamento de exceções é uma prática importante para garantir a robustez do código. Ele permite que o sistema lide com erros de forma graciosa e mantenha a integridade dos dados.
### Uso no Código: 
A anotação @Transactional nos métodos do ParkingSpotService garante que, se algo der errado durante uma operação de banco de dados, a transação será revertida, garantindo a consistência dos dados.
