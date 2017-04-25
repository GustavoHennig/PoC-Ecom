## PoC - Serviço E-commerce

Gustavo Augusto Hennig - 04/2017


### Requisitos 

Desenvolver serviços para E-Commerce, que contemple: 
  * Cadastro de Produto
  * Busca de Produtos
  * Inclusão de Itens em Pedido
  * Fechamento do Pedido


### Tecnologias e Frameworks

Foi utilizado Spring Boot por ser largamente utilizado pelo comunidade, 
e se adequar ao que se propõe a PoC.

A arquitetura utiliza princípios DDD, mas com algumas simplificações.

O projeto utiliza Gradle, e foi utilizado IntelliJ.


### Outras considerações

Algumas chamadas rest foram disponibilizadas, poderiam ser feitas com RepositoryRestResource, 
mas o propósito desta camada (app) foi apenas demonstração/prova conceito.

Exemplos:
  * http://127.0.0.1:8080/produto?nome=a
  * http://127.0.0.1:8080/produto?nome=s


#### Aviso

A título de teste, a base de dados está configurada para resetar a cada execução,
dados de demonstração são inicializados a cada execução.
