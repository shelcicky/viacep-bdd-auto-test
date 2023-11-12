## ViaCep Bdd Auto Test
**Descrição**: 
O objetivo deste projeto é dar um overview de como realizar uma validação de uma API rest. 
O recurso consumido está hospedado no site [ViaCep](https://viacep.com.br/).  

**Objetivos do teste**: 
Dado um determinado cep, será consumido a API de consulta de cep, desserializar o retorno e realizar a devida asserção.

---
### Pré-requisitos:
- JDK 17+
- Gradle 8.4+

Para validar se o JDK está instalado e devidamente configurado no ambiente, execute o seguinte comando:
```sh
java -version
```

O resultado deve ser algo semelhante ao output abaixo:
```sh
openjdk version "17.0.2" 2022-01-18
OpenJDK Runtime Environment (build 17.0.2+8-86)
OpenJDK 64-Bit Server VM (build 17.0.2+8-86, mixed mode, sharing)
```

Caso seja necessário, o download da biblioteca Java pode ser realizado clicando [aqui](https://www.oracle.com/br/java/technologies/downloads/).
Escolha a opção pertinente ao seu ambiente.
---
### Perfis da Aplicação:
- **local**: Atualmente o projeto é executado apenas de forma local, sem a necessidade de realizar parametrizações para este propósito.

### Executando o projeto:
Execute o comando abaixo no path do projeto, considerando o sistema operacional utilizado.

Em ambientes **Linux** ou **Mac**: 
```sh
./gradlew clean test
```

Em ambientes **Windows**:
```sh
.\gradlew clean test
```

---
### Relatório de execução:
Ao finalizar a execução dos testes, será gerado um report. 
O mesmo pode ser consultado ao abrir o arquivo **index.html**, presente no subdiretório **/target/site/serenity/**.

Exemplo:
```sh
{path do projeto}/target/site/serenity/index.html
```

---
##### Desenvolvido por:
- **Shelcicky Wilkerson**

**Contato**:

- **LinkedIn**: https://www.linkedin.com/in/shelcicky-alves-3b0102a6/
- **Instagram**: https://www.instagram.com/shell.wilkerson/