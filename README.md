<h1>ApiRest de gerenciamento de rebeldes da guerra interestelar com SpringBoot </h1>
<p>Neste projeto foi desenvolvidas uma ApiRest de gerenciamento de um jogo de batalha nas estrelas com persistência realizada em banco de dados
de teste H2. Apresenta as seguintes funionalidades:</p>
<ul>
    <li>Cadastrar rebelde</li>
    <li>Listar todos os rebeldes</li>
    <li>Atualizar coordenadas</li>
    <li>Reportar rebelde como traidor</li>
    <li>Trocar item entre rebeldes</li>
    <li>Relatório com a porcentagem de rebeldes e traidores</li>
    <li>Relatório com a média de cada item por rebelde</li>
    <li>Relatório de pontos de itens perdidos devido a traidores</li>
</ul>

<p>Para executar o projeto no terminal, digite o seguinte comando:</p><br>

```
mvn spring-boot:run
```
<p>Após executar o comando acima, basta apenas abrir o seguinte endereço e visualizar a execução do projeto:</p><br>

```
http://localhost:8080/starwarsresistence
```

<h1>Teste dos métodos com Postman</h1>
<p><b>Save</b><p>


```
Tipo de requisição: POST
{ 
    "name": "Jão", 
    "age": "37", 
    "genre": "Masc", 
    "bag":  
        { 
        "weapons": 10, 
        "ammunition": 10, 
        "water": 10, 
        "food": 10 
    } 
    , 
    "coordinates":  
        { 
        "latitude": "58", 
        "longitude": "89", 
        "galaxyName": "Via Lactea" 
    }     
}

```

<p><b>ListAll</b></p>

```
Tipo de requisição: GET

URL: localhost:8080/starwarsresistence
```


<p><b>Update Coordinates</b></p>

Tipo de requisição: `PUT`

URL: `localhost:8080/starwarsresistence`

Body:

```
{ 
    "id": 1, 
    "latitude": "500", 
    "longitude": "500", 
    "galaxyName": "Andromeda"
}
```

<p><b>Report Rebel</b></p>

```
Tipo de requisição: PUT

URL: localhost:8080/starwarsresistence/1
```

<p><b>Trade Items</b></p>

Tipo de requisição: `PUT`

URL: `localhost:8080/starwarsresistence/trade`

Body:

```
{ 
    "rebelTradeData1": 
        { 
        "rebelId": 1,  
        "rebelTradeBag":  
        [
            { 
            "item": "WEAPON",
            "amount":1 
        }
        ]
    } 
    , 
    "rebelTradeData2": 
        { 
        "rebelId": 2,  
        "rebelTradeBag":  
        [
            { 
            "item": "AMMUNITION",
            "amount":1 
            },
            { 
            "item": "FOOD",
            "amount":1 
            }
        ]
    }     
}
```

<p><b>Percentage Report</b></p>

```
Tipo de requisição: GET

URL: localhost:8080/starwarsresistence/reports/traitorpercentagereport
```

<p><b>Items Average Report</b></p>

```
Tipo de requisição: GET

URL: localhost:8080/starwarsresistence/reports/itemsaveragereport
```

<p><b>Lost Points Report</b></p>

```
Tipo de requisição: GET

URL: localhost:8080/starwarsresistence/reports/lostpointsreport
```

<h1>
<a href="https://www.linkedin.com/in/samuelfavero/">Linkedin</a>
</h1>