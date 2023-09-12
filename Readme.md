# AgTech
Um App voltado para os Pequenos Produtores conseguirem ter acesso a tecnologia e transformar a sua agricultura familiar voltada ao mercado, usando um App simples e de fácil acesso.

<h1>
    <img src="./img/logo 500 sf.png"/>
</h1>

---

# Endpoints

- [AgTech](#agtech)
- [Endpoints](#endpoints)
    - [Usuarios](#usuarios)
        - [Cadastrar usuarios](#cadastrar-usuarios)
        - [Logar usuario](#listar-usuario)
    - [Chats](#chats)
        - [Listar chats](#listar-chats)
    
---

## Usuarios

### Cadastrar usuários

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

Código de Status: 201 Created

Corpo da Resposta: Um objeto JSON representando o usuário cadastrado.

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

### Logar usuário

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

Código de Status: 200 OK

Corpo da Resposta: Um token JWT para autenticação subsequente.

**Exemplo da Resposta**

```js
{
  token: "seu-token-jwt-aqui"
}
```

