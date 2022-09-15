# 🧑‍💼 SeuBarriga - Projeto de automação Web 🧑‍💼
Olá, seja bem-vindo ao meu Hub! Esse script foi desenvolvido para explicar de forma simples e eficaz o objetivo deste projeto em questão, no qual irei demonstrar meu nível de lógica e conhecimento sobre **testes automatizados**. Boa leitura!

## O que são testes automatizados? 🤔
Automação de testes é uma **importante** ferramenta para quem trabalha com o **desenvolvimento** de softwares. É o uso de frameworks para controlar a execução do teste, a comparação dos resultados esperados com os resultados reais e neles o sistema é otimizado com precisão e agilidade: é nessa hora que você **encontrará bugs, falhas de segurança e qualquer outro problema que prejudique o uso da aplicação.** 

O projeto em questão tem por objetivo testar e validar casos de uso para o site [**SeuBarriga**](https://seubarriga.wcaquino.me/login).

## Pré requisitos e Tecnologias utilizadas👷🚧
Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas ou dependências:

* [Git](https://git-scm.com)
* [Java](https://www.java.com/pt-BR/)
* [JDK](https://www.oracle.com/java/technologies/downloads/)

Além disto é bom ter uma IDE Java para trabalhar com o código como por exemplo o [IntelliJ IDEA](https://www.jetbrains.com/pt-br/idea/) ou [Eclipse](https://www.eclipse.org/downloads/) dentre outras. Este projeto conta com as seguintes tecnologias:

* [JUnit 5](https://junit.org/junit5/)
* [Maven](https://maven.apache.org/)
* [Selenium](https://www.selenium.dev)
* [WebDriverManager](https://github.com/bonigarcia/webdrivermanager)
* [ExtentReports](https://www.extentreports.com)
* [JavaFaker](https://github.com/DiUS/java-faker)

## Objetivos 🎯
Checklist básico para mostrar a progressão do projeto.

[✔️] Criar **Readme**

[✔️] Criar **Projeto** Maven

[✔️] Criar arquivo **.gitignore**

[✔️] Criar e Configurar Classe **TestBase**

[✔️] Criar e Configurar Classe de **Waits**

[✔️] Criar classes parar geração de **Reports**

[✔️] Criar Classe para gerar dados com **JavaFakers**

[✔️] Criar Classe e Mapear Elementos nas **PageObjects**

[✔️] Criar Classe e Desenvolver Métodos nas **Tasks**

[✔️] Criar Classe e Desenvolver Validações nas **Validations**

[✔️] Criar Classes de **TestsCases**

[] Criar **Suites** de Testes

## Padrão utilizado 📦
Como já escrito no titulo, neste tópico terá a padrão utilizado para estruturar o projeto junto de uma breve explicação do que tem em cada pacote.

**src/main/java/Framework/ -** Pacote responsável pela **TestBase** do projeto e por classes no qual controlam o **Browser**, geram o **Report** e classes **Utils**.

**src/test/java/PageObjects/ -** Classes com os elementos da página em questão mapeados por **selectors**.

**src/test/java/Tasks/ -** Tasks são onde lidamos e interagimos com os elementos da páginas.

**src/test/java/TestsCases/ -** Onde ficam as classes e métodos de testes.

**src/test/java/TestsSuites/ -** Pacote com objetivo de armazenar classes de **suites de execução** de testes (regressão) do projeto.

**src/test/java/Validations/ -** Onde criamos nossas classes e  métodos de validações.


## Execução dos Testes 📂
Este tópico tem como objetivo explicar de forma simples como rodar os testes desenvolvidos no projeto, siga o passo a passo abaixo.

* Abra o projeto
* Navegue até o pacote src/test/java/TestsCase/
* Na classe de teste de sua preferência clique com o botão direito
* Clique na opção "**Run** teste"

Também como opção tem a classe de **Regression** no pacote **src/test/java/TestsSuites/** no qual ira rodar todos os testes desenvolvidos no projeto!

## Geração de Relatório 📋✔️

Após executar os testes, os relatórios serão gerados automaticamente na pasta **Report** na raiz do projeto, basta clicar duas vezes no arquivo **.HTML** que ira abrir uma aba no navegador mostrando detalhadamente o teste.

