![postech.png](src%2Fmain%2Fresources%2Fimages%2Fpostech.png)

# Objetivo
Há uma lanchonete de bairro que está expandindo devido seu grande sucesso. Porém, com a
expansão e sem um sistema de controle de pedidos, o atendimento aos clientes pode ser
caótico e confuso. Por exemplo, imagine que um cliente faça um pedido complexo, como um
hambúrguer personalizado com ingredientes específicos, acompanhado de batatas fritas e uma bebida.
O atendente pode anotar o pedido em um papel e entregá-lo à cozinha, mas não há garantia de que o pedido será
preparado corretamente. Sem um sistema de controle de pedidos, pode haver confusão entre os
atendentes e a cozinha, resultando em atrasos na preparação e entrega dos pedidos. Os pedidos
podem ser perdidos, mal interpretados ou esquecidos, levando à insatisfação dos clientes e a
perda de negócios.

Em resumo, um sistema de controle de pedidos é essencial para garantir que a lanchonete possa
atender os clientes de maneira eficiente, gerenciando seus pedidos e estoques de forma adequada.
Sem ele, expandir a lanchonete pode acabar não dando certo, resultando em cliente insatisfeitos e
impactando os negócios de forma negativa.

Dessa forma, o objetivo do projeto do curso é desenvolver um sistema de autoatendimento de fast food, que é composto por uma série de dispositivos e
interfaces que permitem aos clientes selecionar e fazer pedidos sem precisar interagir com um
atendente, com funcionalidades de pagamento, criação, acompanhamentode e entrega do pedido.

# Descrição
Projeto desenvolvido em Java 20 e Spring Framework, com banco de dados MySQL, Docker para
conteinerização, Maven para gerenciamento de dependências e utilização de JUnit nos testes.


# Entregáveis

<details>
  <summary> Primeiro trimestre</summary>

1. [Documentação do sistema (DDD) utilizando a linguagem ubíqua](https://miro.com/app/board/uXjVMJITQpk=/?share_link_id=811300643755), dos seguintes fluxos:
    1. Realização do pedido e pagamento
    2. Preparação e entrega do pedido
2. Uma aplicação para todo sistema de backend (monolito) que deverá ser desenvolvido seguindo os
   padrões apresentados nas aulas:
    1. Utilizando arquitetura hexagonal
    2. APIs:
        1. Cadastro do Cliente
        2. Identificação do Cliente via CPF
        3. Criar, editar e remover de produto
        4. Buscar produtos por categoria
        5. Fake checkout, apenas enviar os produtos escolhidos para a fila
        6. Listar os pedidos
    3. Aplicação deverá ser escalável para atender grandes volumes nos horários de pico
    4. Banco de dados a nossa escolha
3. A aplicação deve ser entregue com um [Dockerfile](https://github.com/matheus-mr94/postech-soat1/blob/8761acfb11dec777636908b59e961b798ee6916f/Dockerfile) configurado para
   executá-la corretamente. Para validação da POC, temos a seguinte limitação de infraestrutura:
    1. 1 instância para banco de dados
    2. 1 instância para executar aplicação

</details>

# Execução
1. Executar `git clone git@github.com:matheus-mr94/postech-soat1.git`
2. Rodar `docker-compose up --build` na raiz do projeto

# Funcionalidades
## Cadastro do Cliente
POST http://localhost:8080/clientes
```json
{
  "nome": "Ramin Paema",
  "email": "ramin@teste.com",
  "cpf": "95741879853"
}
```

## Identificação do Cliente via CPF
GET http://localhost:8080/clientes/{cpf}

## Criar, editar e remover produto
### Criação
POST http://localhost:8080/produtos
```json
{
  "nome": "Batata frita",
  "categoria": "ACOMPANHAMENTO",
  "preco": "5.50"
}
```

### Edição
PUT http://localhost:8080/produtos/{produtoId}/edita
```json
{
  "nome": "Batata frita",
  "categoria": "SOBREMESA",
  "preco": "10.00"
}
```

### Remoção
DELETE http://localhost:8080/produtos/{produtoId}/remove

## Buscar produtos por categoria
GET http://localhost:8080/produtos/categoria/{categoria}

## Criar e listar pedidos
### Criar
POST http://localhost:8080/pedidos
```json
{
    "produtosPedidos": 
    [
        {
            "produtoId": 1,
            "quantidade": 2
        },
        {
            "produtoId": 1,
            "quantidade": 1
        }
    ]
}
```

### Listar
GET http://localhost:8080/pedidos/todos

