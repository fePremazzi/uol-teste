# Documentação ClientesAPI

### Como usar os serviços:

Ambiente de desenvolvimento:
http://localhost:8000/ 
(home)

http://localhost:8000/all 
(lista todos os clientes cadastrados)

http://localhost:8000/find/{id} 
(procura o cliente pelo id)

http://localhost:8000/add 
(adiciona um cliente com um Requestbody passando uma idade e um nome)

http://localhost:8000/delete/{id} 
(deleta um usuário pelo id)

http://localhost:8000/update/{id} 
(atualiza um cliente pelo id passando um body com o nome ou idade ou ambos que forem ser atualizados)

Ambiente de produção (funcionando):

https://cliente-rest-uol.herokuapp.com/ 
(home)

https://cliente-rest-uol.herokuapp.com/all 
(lista todos os clientes cadastrados)

https://cliente-rest-uol.herokuapp.com/find/{id} 
(procura o cliente pelo id)

https://cliente-rest-uol.herokuapp.com/add 
(adiciona um cliente com um Requestbody passando uma idade e um nome)

https://cliente-rest-uol.herokuapp.com/delete/{id} 
(deleta um usuário pelo id)

https://cliente-rest-uol.herokuapp.com/update/{id} 
(atualiza um cliente pelo id passando um body com o nome ou idade ou ambos que forem ser atualizados)

### Quais ferramentas foram utilizadas:
Foi utilizado o Spring Boot devido a sua fácil usabilidade e principalmente pelo fato de não termos que nos preocupar com configurações e sim apenas com as regras de negócio da aplicação. 
Spring JPA para facilitar a criação das entidades em um banco de dados através de anotações em classes.
MySQL para armazenamento de dados, sendo que ele é gratuito e é um dos BD's mais utilizados hoje em dia.
Instância MySQL na RDS da AWS para simulação de ambiente de produção.
Foi utilizado também, FasterXML/Jackson para poder manipular as respostas JSON transformando-as em objetos conhecidos pela aplicação. 
Além disso, foi utilizado o Maven como gerenciador de dependências do projeto.

### Infraestrutura adicional necessária para rodar, empacotar o projeto:
Necessário do Maven para instalação de depencias e empacotamento do projeto.
MySQL 5.6 para persistência dos dados. 
Java SDK 8
Postman para mandar o body dos POST’s requests

### Como executar, testar, empacotar e entregar o seu projeto

1º) Adicionar uma variável de ambiente chamada SPRING_PROFILES_ACTIVE e colocar seu value para “dev” caso seja ambiente de desenvolvimento e “prod” para ambiente de produção. Caso não colocar a variável de ambiente, ele irá inicializar por default o ambiente de dev.
2º) Case “dev” : Ir no arquivo application-dev.properties e configurar o banco de dados local de sua máquina.
Case “prod”: Ir no arquivo application-prod.properties e configurar o banco de dados que será usado em produção.

3º) Entrar dentro da pasta do projeto pelo cmd, e executar: 

```
mvn clean install
```

para criar o arquivo “.jar”. Ou se estiver usando Eclipse, usar o “maven install” diretamente pelo “pom.xml”.

4º) Entrar pela pasta target e executar o jar: 

```
java –jar cliente-rest-0.0.1-SNAPSHOT.jar
```

### Instruções para como montar o ambiente de produção onde seus serviços devem ser executados
O ambiente de produção para essa simulação está configurado para que conecte com uma instância do RDS na Amazon rodando o MySQL. As instruções para montar o ambiente tanto de dev quanto de prod estão no item anterior a este.
