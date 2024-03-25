# Gerenciador-Society

## #️⃣SOBRE
Este é um projeto com uma iniciativa minha, onde percebi, por meio de experiências pessoais, a necessidade de automatizar e facilitar tanto a utilização de societys quanto o seu gerenciamento pelos proprietários. Dessa forma, decidi desenvolver esta solução. O projeto consiste em um site que simplifica o agendamento de campos de society, bem como a organização das pessoas para o evento. O site também tem o objetivo de facilitar o gerenciamento dos proprietários em relação a horários disponíveis, campos, valores, etc.

## ⚒️FERRAMENTAS
As tecnologias empregadas neste projeto incluem a linguagem Java, em conjunto com o framework Spring Boot. Para o gerenciamento do banco de dados, foi utilizado o MySQL, integrado ao Spring Data. Além disso, o Spring Web foi empregado para disponibilizar APIs REST, tornando o sistema mais eficiente e acessível.

- Java 21
- Spring Boot 3.1.2
- MySql 8
- Lombok
- Maven
- Junit 5

## 🔵COMO UTILIZAR:

```bash
 #Clonar o repositório na sua máquina
 #Abra seu CMD e digite o sequinte código:
 $ git clone https://github.com/vitorvieirah/gerenciador-society.git
`````

##

```bash
Agora basta abrir o projeto em sua IDE de preferência, vale ressaltar que é nescessário ter a SGBD MySQL instalada em sua máquina, caso não tenha basta seguir este link:

- WINDOWS: https://dicasdeprogramacao.com.br/como-instalar-o-mysql-no-windows/

- LINUX: https://www.linkedin.com/pulse/instalação-e-configuração-do-mysql-linux-mint-20-ubuntu-yenny-delgado/?originalSubdomain=pt

- MAC: https://blog.cod3r.com.br/configuracao-de-ambiente-do-mysql-para-mac/
````

##

```bash
##Configurando o banco de dados
Para que o projeto consiga se conectar com o banco de dados é nescessário apenas configurar seu usuário e senha, basta entrar no arquivo "application.properties", nesse seguinte caminho: "\gerenciador-society\src\main\resources\application.properties": 
````
![print application](https://github.com/vitorvieirah/produto-vendas/assets/108897429/f3f05f8a-998a-41a9-a7c0-03fffc4c30e7)

```bash
Depois de entrar no arquivo basta mudar o valor dos comandos "spring.datasource.username" e "spring.datasource.password", basta colocar o seu usuário e senha, para o programa se conectar ao banco automáticamente.
````

![print config](https://github.com/vitorvieirah/produto-vendas/assets/108897429/a19a2849-5fd9-4051-a2d7-4fa9fe3e1d81)

##

```bash
##Mandando requisições
Para mandar as requisições para as APIs recomendo a utilização de um software, o "Postman" ou "Insomnia", mas claro, fique livre para utilizar o de sua preferência.
Link para dowload:
 - POSTMAN: https://www.postman.com/downloads/
 - INSOMNIA: https://insomnia.rest/download
````

## ⚠️LEMBRETE
```bash
Lembrando que é nescessário estar conectado a internet para utilizar o projeto, para assim o Maven conseguir baixar as dependências corretamente.
````
