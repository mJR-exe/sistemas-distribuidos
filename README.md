# Trabalho de Sistemas Distribuidos - GCC129
Este é um sistema de cadastro de usuário, simulando o mesmo como se fosse um pacientes com um back-end Spring Boot. O sistema permite cadastrar um usuário, buscar, deletar e atualizar. O mesmo foi desenvolvido pelos alunos: **Gabriel Fernandes Silva Vieira, Gustavo Alvarenga Marzoque e Maurício Júnior Santos Freire**.

## Pré-requisitos

Antes de começar, verifique se você possui as seguintes ferramentas instaladas:

- Java Development Kit (JDK) 17: [Download](https://www.openlogic.com/openjdk-downloads)
- Maven: [Download](https://maven.apache.org/download.cgi)
- Git: [Download](https://git-scm.com/downloads)
- Postman: [Download](https://www.postman.com/downloads/)

## Criação do projeto
O Spring Initializr é uma ferramenta online que facilita a criação de projetos Spring Boot com configurações iniciais personalizadas. Para criar um projeto usando o Spring Initializr, siga estas etapas:

1. Acesse o Spring Initializr: Vá para o site https://start.spring.io/.
2. Configure o projeto: No lado esquerdo da página, você verá opções para configurar o seu projeto.
3. Gerar o projeto: Após configurar as opções conforme necessário, clique no botão "Generate" na parte inferior da página. Isso fará o download de um arquivo compactado (como um arquivo ZIP) contendo o esqueleto do seu projeto.
4. Descompacte o arquivo: Descompacte o arquivo ZIP baixado em um diretório de sua escolha.
5. Importe o projeto em sua IDE: Abra sua IDE e importe o projeto.
6. Execute o aplicativo: Agora que o projeto está importado na sua IDE, procure a classe principal que contém o método main e execute-o. Isso iniciará seu aplicativo Spring Boot.

![image](https://github.com/mJR-exe/sistemas-distribuidos/assets/55205777/69aa22c1-87f5-4c94-ae7b-9d2b6be8345a)

## Configuração

Siga as etapas abaixo para configurar o projeto localmente:
- Inicialmente você precisa instalar todas as dependências citadas acima.
- Após a instalação, pode clonar o projeto em sua máquina atráves do git clone com o comando `git clone https://github.com/mJR-exe/sistemas-distribuidos.git`
- Com o projeto em sua máquina, basta escolher um editor de sua preferência, no meu caso escolhi o Intelijj.
- Após este passo: execute o arquivo BackendApplication, e assim o projeto será configurado e executado na porta 8080 como padrão.
- É possível acessar os endpoints do projeto por linha de comando ou por qualquer outra plataforma de API, como o Postman, que foi utilizado em nosso trabalho.

## Endpoints
- **GET**: Buscar todos os pacientes - http://localhost:8080/paciente
- **GET**: Buscar um paciente por id - http://localhost:8080/paciente/{id}. Deve-se passar um id existente, como por exemplo http://localhost:8080/paciente/1
- **POST**: Criar um paciente - http://localhost:8080/paciente. Deve-se passar dados com os seguintes atributos para criar o paciente:
```json
{
  "nome": "Teste de criação",
  "dataNascimento": "17/03/2000",
  "sexo": "Masculino",
  "fuma": "false",
  "bebe": "true",
  "praticaExercicio": "true",
  "infartou": "false",
  "alimentacao": "true",
  "descricaoSintomas": "Nenhum sintoma"
}
```
- **DELETE**: Deletar um paciente por id - http://localhost:8080/paciente/{id}. Deve-se passar um id existente, como por exemplo http://localhost:8080/paciente/1
- **PUT**: Atualizar um paciente por id - http://localhost:8080/usuario/{id}. Deve-se passar um id existente e o campo a ser atualizado no body da requisição, como por exemplo http://localhost:8080/paciente/1
```json
{
  "nome": "Teste Sistemas Distribuídos",
}
```

## Imagem do Projeto sendo executado
![image](https://github.com/mJR-exe/sistemas-distribuidos/assets/55205777/e74777f6-de06-4311-8bed-1b42d024d53d)

## Exemplo de Criação de Usuário
![image](https://github.com/mJR-exe/sistemas-distribuidos/assets/55205777/60d4c0c5-24d5-47f6-8078-690745228969)

## Arquitetura da Aplicação
A aplicação foi construída com a arquitetura MVC (Model View Controler):

- **Model (Modelo)**:
Representa os dados e a lógica de negócios da aplicação. Ele é responsável por acessar e manipular os dados, bem como validar e aplicar as regras de negócios. O modelo notifica as mudanças aos observadores interessados (geralmente os controladores).

- **View (Visão)**: 
É responsável por apresentar os dados ao usuário e interpretar as interações do usuário. A visão exibe a informação proveniente do modelo e encaminha as ações do usuário para o controlador.

- **Controller (Controlador)**:
Atua como intermediário entre o modelo e a visão. Ele recebe as entradas do usuário da visão, processa essas entradas (geralmente alterando o estado do modelo) e atualiza a visão para refletir as mudanças no modelo. O controlador também pode receber notificações do modelo sobre alterações nos dados e atualizar a visão conforme necessário.

## Camadas
As camadas existentes nessa arquitetura são: 

- **Controller**:
Responsável por receber as solicitações do usuário (entrada), interpretá-las e chamar os serviços apropriados para lidar com essas solicitações.

- **Service**:
Contém a lógica de negócios da aplicação. Ele é responsável por processar as solicitações recebidas pelos controladores, interagir com os repositórios para acessar os dados e aplicar as regras de negócios.

- **Repository**:
Gerencia o acesso aos dados persistentes, como um banco de dados. Ele fornece uma abstração sobre o armazenamento de dados, permitindo que o serviço se concentre na lógica de negócios, sem se preocupar com os detalhes de armazenamento.

- **Entidade**:
Representa a estrutura de dados no banco de dados. É frequentemente mapeada para uma tabela no banco de dados relacional. A entidade é geralmente uma representação direta dos dados armazenados.

- **DTO** (Data Transfer Object):
É uma representação dos dados que será transferida entre as camadas. Os DTOs são usados para evitar que as entidades do banco de dados sejam expostas diretamente nas camadas superiores e para fornecer uma estrutura de dados específica para as necessidades da camada de apresentação.
