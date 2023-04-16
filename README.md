# Lava-rapido

[![NPM](https://img.shields.io/npm/l/react)](https://github.com/Muriloabreu/Lava-rapido/blob/main/LICENCE) 

# Sobre o projeto


Lava-rapido é uma API REST.

API - Java utilizando Spring boot com o proposito de realizar CRUD de Serviço de um Lava Rápido, onde realiza CRUD para Clientes, Veículos, Tipo de Serviço, Consumos e Serviço de Lava Rápido



# Tecnologias utilizadas
## Back end
- Java
- Maven
- Spring Boot



## Implantação em produção

- Banco de dados: Postgres 9.5

## Back end
- Pré-requisitos: Java 17

# Como executar o projeto

Necessário ter um servidor Tomcat para poder rodar o projeto Java

##  Utilize uma plataforma de consultas de API's e faça a requisição de acordo os modelos disponíveis na sessão abaixo.
</code></pre>
 - Modelos de requisição JSON
</p>

</P>
<h5>Consumos</h5>

```json
{
        "id": 3,
        "nome": "Cerveja",
        "quantidade": 10,
        "valorTotal": 90.0
    }
```
</p>
<h5>Clientes</h5>

```json
{
        "id": 1,
        "nome": "Murilo",
        "sobreNome": "Abreu",
        "cpf": "21673948123",
        "telefone": "999945012"
    }
```
</p>
<h5>TipoServico</h5>

```json
{
        "id": 2,
        "nome": "Lavagem Basic - Polimento",
        "valor": 75.0
    },
    {
        "id": 3,
        "nome": "Lavagem Basic ",
        "valor": 35.0
    }
```
</p>
</p>

<h5>Veiculo</h5>

```json
{
    "id": 1,
    "placa": "ABC1010",
    "fabricante": "volkswagen",
    "modelo": "golf sportline",
    "cor": "PRATA",
    "registrationDate": "2023-04-15T19:26:12.801122",
    "cliente": {
        "id": 1,
        "nome": "Murilo",
        "sobreNome": "Abreu",
        "cpf": "21673948123",
        "telefone": "999945012"
    }
}
```
</p>
</p>

<h5>Servico</h5>

```json
{
    "id": 2,
    "tipoServico": {
        "id": 3,
        "nome": "Lavagem Basic ",
        "valor": 35.0
    },
    "veiculo": {
        "id": 1,
        "placa": "ABC1010",
        "fabricante": "volkswagen",
        "modelo": "golf sportline",
        "cor": "PRATA",
        "registrationDate": "2023-04-15T19:26:12.801122",
        "cliente": {
            "id": 1,
            "nome": "Murilo",
            "sobreNome": "Abreu",
            "cpf": "21673948123",
            "telefone": "999945012"
        }
    },
    "consumos": [
        {
            "id": 1,
            "nome": "Cerveja A",
            "quantidade": 5,
            "valorTotal": 50.0
        },
        {
            "id": 2,
            "nome": "Cerveja B",
            "quantidade": 10,
            "valorTotal": 70.0
        }
    ],
    "valorTotal": 300.0
}
```
</p>
</p>


- Baixar o projeto

```bash
# clonar repositório
git clone git@github.com:Muriloabreu/Lava-rapido.git

```

# Autor

Murilo Abreu do Nascimento

https://www.linkedin.com/in/murilo-abreu/
