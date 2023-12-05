# Sistema de Atendimento a Pacientes

Este é um sistema de cadastro de usuário, simulando o mesmo como se fosse um pacientes com um back-end Spring Boot. O sistema permite cadastrar um usuário, buscar por todos usuários, deletar e atualizar o mesmo.

## Pré-requisitos

Antes de começar, verifique se você possui as seguintes ferramentas instaladas:

- Java Development Kit (JDK) 17: [Download]([https://adoptopenjdk.net/](https://www.openlogic.com/openjdk-downloads))
- Maven: [Download](https://maven.apache.org/download.cgi)
- Git: [Download](https://git-scm.com/downloads)
- Postman: [Download](https://www.postman.com/downloads/)

## Configuração

Siga as etapas abaixo para configurar o projeto localmente:
- Inicialmente você precisa instalar todas as dependências citadas acima.
- Após a instalação, pode clonar o projeto em sua máquina atráves do git clone.
- git clone https://github.com/mJR-exe/sistemas-distribuidos.git
- Com o projeto em sua máquina, basta escolher um editor de sua preferência, no meu caso escolhi o Intelijj.
- Após este passo: execute o arquivo BackendApplication, e assim o projeto será configurado e executado na porta 8080 como padrão.
- Para acessar os endpoints existentes no projeto, é só utilizar os seguintes endereços:
- Importante para acessar os endpoints do nosso projeto, você pode acessar por linha de comando ou pelo POSTMAN, que no caso foi o utilizado em nosso trabalho.
- O Postman é muito utilizado pelos desenvolvedores para criar solicitações HTTP personalizadas, testar diferentes métodos (como GET, POST, PUT, DELETE), e verificar as respostas das APIs. Ele também permite a automação de testes e colaboração em equipe.
- Buscar todos os usuários: GET - http://localhost:8080/usuario
- Buscar um usuário por id: GET - http://localhost:8080/usuario/{id}, no caso você deverá passar um id existente, como por exemplo http://localhost:8080/usuario/1
- Criar um usuário: POST - http://localhost:8080/usuario, você precisará passar os seguintes dados para criar o usuário:
{
  "nome": "Teste de criação",
  "dataNascimento": "17/03/2000",
  "sexo": "Masculino",
  "fuma": "false",
  "bebe": "true",
  "praticaExercicio": "true",
  "infartou": "false",
  "alimentacao": "true",
  "descricaoSintomas": "Possuo nenhum sintomas"
}
- Deletar um usuário por id: DELETE - http://localhost:8080/usuario/{id}, no caso você deverá passar um id existente, como por exemplo http://localhost:8080/usuario/1
- Atualizar um usuário por id: PUT - http://localhost:8080/usuario/{id}, no caso você deverá passar um id existente, como por exemplo http://localhost:8080/usuario/1

## Imagem do Projeto sendo executado
![image](https://github.com/mJR-exe/sistemas-distribuidos/assets/55205777/6c4d6d11-d642-42a5-81d9-e69a89e4ab91)

## Exemplo de Criação de Usuário
![image](https://github.com/mJR-exe/sistemas-distribuidos/assets/55205777/60d4c0c5-24d5-47f6-8078-690745228969)

## Arquitetura da Aplicação.
A aplicação foi construída com a arquitetura MVC(Model View Controler).

### Model(Modelo):
Representa os dados e a lógica de negócios da aplicação. Ele é responsável por acessar e manipular os dados, bem como validar e aplicar as regras de negócios. O modelo notifica as mudanças aos observadores interessados (geralmente os controladores).

### View (Visão): 
É responsável por apresentar os dados ao usuário e interpretar as interações do usuário. A visão exibe a informação proveniente do modelo e encaminha as ações do usuário para o controlador.

### Controller (controlador)
Atua como intermediário entre o modelo e a visão. Ele recebe as entradas do usuário da visão, processa essas entradas (geralmente alterando o estado do modelo) e atualiza a visão para refletir as mudanças no modelo. O controlador também pode receber notificações do modelo sobre alterações nos dados e atualizar a visão conforme necessário.

### Camadas
As camadas existentes nessa arquitetura são: 

#### Controller
Responsável por receber as solicitações do usuário (entrada), interpretá-las e chamar os serviços apropriados para lidar com essas solicitações.

#### Service
Contém a lógica de negócios da aplicação. Ele é responsável por processar as solicitações recebidas pelos controladores, interagir com os repositórios para acessar os dados e aplicar as regras de negócios.

#### Repository
Gerencia o acesso aos dados persistentes, como um banco de dados. Ele fornece uma abstração sobre o armazenamento de dados, permitindo que o serviço se concentre na lógica de negócios, sem se preocupar com os detalhes de armazenamento.

#### Entidade
Representa a estrutura de dados no banco de dados. É frequentemente mapeada para uma tabela no banco de dados relacional. A entidade é geralmente uma representação direta dos dados armazenados.

#### DTO (Data Transfer Object)
É uma representação dos dados que será transferida entre as camadas. Os DTOs são usados para evitar que as entidades do banco de dados sejam expostas diretamente nas camadas superiores e para fornecer uma estrutura de dados específica para as necessidades da camada de apresentação.
