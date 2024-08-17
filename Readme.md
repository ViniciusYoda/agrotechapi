# AgTech
Um App voltado para os Pequenos Produtores conseguirem ter acesso a tecnologia e transformar a sua agricultura familiar voltada ao mercado, usando um App simples e de fácil acesso.

<h1>
    <img src="./img/logo 500 sf.png"/>
</h1>

<p>Video: https://youtu.be/1UTbyKBKFaM</p>

---

# Para iniciar o projeto acesse src/main/resources/config.properties e coloca sua chave da api da Openai:

# Endpoints

- [AgTech](#agtech)
- [Endpoints](#endpoints)
    - [Usuarios](#usuarios)
        - [Cadastrar um Usuário](#cadastrar-usuarios)
        - [Login de Usuário](#listar-usuario)
    - [Chats](#chats)
        - [Enviar uma Pergunta](#enviar-pergunta)
        - [Obter uma Resposta por ID](#obter-resposta)
    
---

## Usuarios

### Cadastrar um Usuário

Endpoint para cadastrar um novo usuário.

**URL**

`POST` /api/cadastrar

**Parâmetros de Entrada**

`usuario` (tipo: JSON) - Um objeto JSON contendo os detalhes do usuário a ser cadastrado.

**Campos da Requisição**

|   campo  | tipo  | obrigatório | descrição                            |
| -------- | ----- | :---------: | ------------------------------------ |
| cpf      | texto |     sim     | número de registro do usuário        |
| email    | texto |     sim     | E-mail do usuário                    |
| nome     | texto |     sim     | Nome completo do usuário             |
| senha    | texto |     sim     | o valor deve ter no minimo 8 digitos |

**Exemplo corpo requisição**

```js
{
 cpf:   "44877544550",
 email: "igor.cammargo@gmail.com",
 nome:  "Igor Camargo",
 senha: "123",
}
```

**Resposta de Sucesso**

`Código de Status:` 201 Created

`Corpo da Resposta:` Um objeto JSON representando o usuário cadastrado.

**Exemplo da Resposta**

```js
{
 id: 1,
 cpf:   "44877544550",
 email: "igor.cammargo@gmail.com",
 nome:  "Igor Camargo",
 senha: "123",
}
```

### Login de Usuário

Endpoint para autenticar um usuário e obter um token JWT.

`POST` /api/login

**Parâmetros de Entrada**

`credencial` (tipo: JSON) - Um objeto JSON contendo as credenciais do usuário para login.

**Campos da Requisição**

|   campo  | tipo  | obrigatório | descrição                            |
| -------- | ----- | :---------: | ------------------------------------ |
| email    | texto |     sim     | E-mail do usuário                    |
| senha    | texto |     sim     | o valor deve ter no minimo 8 digitos |

**Exemplo corpo requisição**

```js
{
 email: "igor.cammargo@gmail.com",
 senha: "123",
}
```

**Resposta de Sucesso**

`Código de Status:` 200 OK

`Corpo da Resposta:` Um token JWT para autenticação subsequente.

**Exemplo da Resposta**

```js
{
  token: "seu-token-jwt-aqui"
}
```

## Chat

### Enviar uma Pergunta

Este endpoint permite que os usuários enviem uma pergunta para ser respondida pelo modelo de linguagem GPT-3.5 Turbo.

**URL**

`POST` /ask

**Parâmetros de Entrada**

`requestData`(tipo: JSON) - Um objeto JSON contendo a pergunta a ser enviada.

**Campos da Requisição**

|   campo  | tipo  | obrigatório | descrição                            |
| -------- | ----- | :---------: | ------------------------------------ |
| answer   | texto |     sim     | Resposta para o  usuário             |
| question | texto |     sim     | Pergunta do usuário                  |

**Exemplo de Requisição**

```js
{
  question: "Como plantar milho?"
}
```

**Resposta de Sucesso**

`Código de Status:` 200 OK

`Corpo da Resposta:` A resposta gerada pelo modelo GPT-3.5 Turbo.

**Exemplo da Resposta**

```js
{
  response: "Tenha um terreno, abra um buraco e plante o grão."
}
```

### Obter uma Resposta por ID

Este endpoint permite que os usuários obtenham uma resposta anteriormente gerada pelo modelo GPT-3.5 Turbo com base no ID da resposta.

**URL**

`GET` /responses/{id}

**Parâmetros de Entrada**

`id `(tipo: Long) - O ID da resposta que você deseja obter.

**Campos da Requisição**

|   campo  | tipo  | obrigatório | descrição                            |
| -------- | ----- | :---------: | ------------------------------------ |
| answer   | texto |     sim     | Resposta para o  usuário             |
| question | texto |     sim     | Pergunta do usuário                  |

**Exemplo de Requisição**

`GET` /responses/123

**Resposta de Sucesso**

`Código de Status:` 200 OK

`Corpo da Resposta:` A resposta gerada pelo modelo GPT-3.5 Turbo com base no ID especificado.

**Exemplo da Resposta**

```js
{
  response: "Tenha um terreno, abra um buraco e plante o grão."
}
```









