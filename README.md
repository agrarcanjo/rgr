
<h1 align="center">
    Prova RGR
</h1>

<p align="center">
  <a href="#-tecnologias">Tecnologias</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-projeto">Projeto</a>
</p>

<p align="center">
 <img src="https://img.shields.io/static/v1?label=PRs&message=welcome&color=15C3D6&labelColor=000000" alt="PRs welcome!" />

  <img alt="License" src="https://img.shields.io/static/v1?label=license&message=MIT&color=15C3D6&labelColor=000000">
</p>

<br>

## 💻  Tecnologias

Para executar esse projeto, será necessário as tecnologias: 

- [Java](https://www.java.com/pt-BR/download/ie_manual.jsp?locale=pt_BR)
- [Maven](https://maven.apache.org/download.cgi)
- [Postman](https://www.postman.com/downloads/)
- [MySql](https://www.mysql.com/downloads/)

## 💻 Projeto

Configurar o MySql com o usuário root e senha vazia como o padrão

ou

Ir no arquivo de [application](src/main/resources/application.properties) e colocar o seu acesso MySql lá.


Para gerar o executável da aplicação, após instalar e configurar o java e o maven, junto com suas
variáveis ambiente, executar o comando no diretório da aplicação:



```bash
> mvn clean install
```

Navegue para o diretório target e execute:

```bash
> java -jar rgr-0.0.1-SNAPSHOT.jar
```

Execute, para inserir valores iniciais e conferir as consultas realizadas, 
segue conforme: [initial_script.sql](src/main/java/com/example/rgr/database/initial_state.sql)

O serviço assim estará disponível na máquina local:

http://localhost:8080/

Para realizar as requisições segue o arquivo postman: [Requisições](src/main/java/com/example/rgr/database/RGR.postman_collection.json)


Para conferir as imagens do projeto com as respostas:  [Imagens](src/main/java/com/example/rgr/images)

 ## Licença

Esse projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE.md) para mais detalhes.

---

by agrarcanjo 