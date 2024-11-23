# Projeto de Desenvolvimento de Aplicações Corporativas 2024.2

## Objetivo

Este trabalho tem como objetivo o desenvolvimento de um jogo utilizando obrigatoriamente JSF, Primefaces e Hibernate, com persistência de dados em um banco de dados relacional (PostgreSQL). O projeto envolve a criação de um sistema de cadastro e listagem de jogos, onde os usuários podem salvar, editar, excluir e visualizar jogos com valores sorteados e cálculos de maior valor.

## Estrutura do Projeto

Este projeto foi desenvolvido utilizando as seguintes tecnologias:
- **Java**
- **JSF (JavaServer Faces)**
- **Primefaces**
- **Hibernate (JPA)**
- **PostgreSQL**

### Funcionalidades do Projeto

1. **Cadastro de Jogos**: Os usuários podem cadastrar um jogo com cinco valores (v1 até v5), com a data de cadastro e o número sorteado preenchidos automaticamente.
2. **Listagem de Jogos**: Exibe todos os jogos cadastrados, permitindo edição, exclusão e verificação de valores (maior número entre v1 a v5 e se o número sorteado está entre os valores).
3. **Operações de Edição e Exclusão**: Possui funcionalidades para editar e excluir jogos da lista.
4. **Validação de Campos**: A entrada de valores v1 a v5 é validada para garantir que os valores estejam entre 1 e 10.
5. **Consultas Avançadas**: Implementação de funcionalidades como mostrar o maior número sorteado e verificar se o número sorteado está entre os valores v1 a v5.

## Como Baixar e Configurar o Projeto

### Passos para Download e Configuração

1. **Baixar o Projeto**:
   - O projeto pode ser baixado diretamente do repositório ou da pasta compartilhada no Google Drive.
   - Caso o projeto esteja no Google Drive, basta acessar o link compartilhado e baixar o arquivo zipado contendo o código.

2. **Extrair os Arquivos**:
   - Após baixar o arquivo zipado, extraia os arquivos para um diretório de sua escolha no seu computador.

3. **Configurar o Banco de Dados PostgreSQL**:
   - Certifique-se de que o PostgreSQL esteja instalado em sua máquina. Se não tiver o PostgreSQL instalado, você pode seguir as instruções de instalação no [site oficial do PostgreSQL](https://www.postgresql.org/download/).
   - Crie um banco de dados chamado `jogos_db` no PostgreSQL.
     ```sql
     CREATE DATABASE jogos_db;
     ```
   - No arquivo `src/META-INF/persistence.xml`, configure as credenciais de conexão com o banco de dados. Atualize o URL, usuário e senha conforme necessário:
     ```xml
     <persistence-unit name="jogosPU">
         <jta-data-source>jdbc/PostgresDS</jta-data-source>
         <properties>
             <property name="hibernate.dialect" value="org.hibernate.dialect.PostgreSQLDialect" />
             <property name="hibernate.hbm2ddl.auto" value="update" />
             <property name="hibernate.show_sql" value="true" />
             <property name="hibernate.format_sql" value="true" />
             <property name="hibernate.jdbc.lob.non_contextual_creation" value="true" />
         </properties>
     </persistence-unit>
     ```

4. **Importar o Projeto no Eclipse**:
   - Abra o Eclipse e clique em **File > Import > Existing Projects into Workspace**.
   - Selecione o diretório onde você extraiu os arquivos do projeto e clique em **Finish**.

5. **Configuração do Tomcat**:
   - Caso você ainda não tenha o Tomcat configurado, baixe e instale a versão do Tomcat em [Apache Tomcat](http://tomcat.apache.org/download-90.cgi).
   - No Eclipse, vá até **Window > Preferences > Server > Runtime Environments** e adicione o Tomcat.
   - Selecione o Tomcat configurado como servidor para o seu projeto.

6. **Rodando o Projeto**:
   - Após importar o projeto e configurar o Tomcat, clique com o botão direito sobre o projeto no Eclipse e selecione **Run on Server** para rodar a aplicação.
   - O Tomcat irá iniciar e o navegador será aberto automaticamente. Caso não aconteça, acesse `http://localhost:8080` para visualizar o projeto.

7. **Testando a Aplicação**:
   - Acesse a página de cadastro do jogo em `http://localhost:8080/index.xhtml`.
   - Após cadastrar um jogo, acesse a página de listagem de jogos em `http://localhost:8080/listagem.xhtml`.
   - Teste as funcionalidades de visualização, exclusão, maior número, e verificação do número sorteado.

## Descrição das Funcionalidades

### a) Classe `Jogo`
A classe `Jogo` deve conter as variáveis:
- `id` (Integer)
- `dataCadastro` (Date)
- `numeroSorteado` (Integer)
- `v1` a `v5` (Integer)

A classe deve ser anotada com as anotações `@Entity`, `@Column`, `@Temporal`, `@Id`, e `@GeneratedValue`.

### b) Classe `JogoDAO`
A classe `JogoDAO` deve ser responsável pelas operações de salvar, editar, excluir e listar objetos da classe `Jogo` utilizando o `EntityManager`. Métodos adicionais devem ser criados conforme necessário.

### c) Arquivo `persistence.xml` e Classe `JPAUtil`
O arquivo `persistence.xml` deve ser configurado com as credenciais do banco de dados, e a classe `JPAUtil` deve fornecer um método para criar objetos do tipo `EntityManager`.

### d) Página de Cadastro (index.xhtml)
A página de cadastro deve permitir que o usuário informe os valores de `v1` a `v5`, com validação para garantir que os valores estejam entre 1 e 10. O campo `dataCadastro` deve ser preenchido automaticamente com a data e hora atual e o campo `numeroSorteado` deve ser preenchido com um número aleatório entre 1 e 10.

### e) Página de Listagem (listagem.xhtml)
A página de listagem deve exibir os jogos cadastrados em uma `p:dataTable`. Ela deve permitir a edição, exclusão e outras funcionalidades, como verificar o maior número entre `v1` a `v5` e se o número sorteado está presente entre esses valores.

### f) Funcionalidades Avançadas
- **Maior Número**: Ao clicar em um botão, a aplicação deve exibir o maior valor entre `v1` a `v5` da linha selecionada.
- **Verificação do Número Sorteado**: Ao clicar no botão "result", deve exibir se o número sorteado está entre os valores de `v1` a `v5`.
- **Maior Número Sorteado**: Exibir o maior número sorteado de todos os jogos cadastrados.

### g) Classe `JogoBean`
A classe `JogoBean` deve permitir a comunicação entre as páginas de cadastro e listagem, viabilizando o salvamento, edição, exclusão e exibição das funcionalidades descritas.

## Problemas Comuns e Soluções

- **Erro de Conexão com o Banco de Dados**:
  - Verifique se o PostgreSQL está rodando e se as credenciais de conexão no `persistence.xml` estão corretas.

- **Tomcat não inicializa**:
  - Verifique se o Tomcat está configurado corretamente no Eclipse. Caso o servidor não inicie, tente reiniciar o Eclipse ou reconfigurar o Tomcat.

- **Erros ao Salvar ou Editar Jogo**:
  - Verifique se os valores de `v1` a `v5` estão dentro do intervalo permitido (1 a 10).
  - Consulte os logs de erro do servidor para identificar problemas na persistência dos dados.

## Contribuições

Este projeto foi desenvolvido por [**Kauan Carolino**](https://github.com/KauanCarolino) e [**Murilo Pontes**](https://github.com/mfpontes). Para mais informações, consulte os arquivos de código e as instruções descritas acima. Ou entre em contato pelo meu Linkedin

## Licença

Este projeto é licenciado sob a [Licença MIT](https://opensource.org/licenses/MIT). Consulte o arquivo `LICENSE` para mais detalhes.

