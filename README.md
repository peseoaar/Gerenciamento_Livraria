# Gerenciamento de Livraria

Este é um projeto simples de **gerenciamento de usuários para uma livraria**. O sistema permite que os usuários façam login e cadastro. Ele armazena as informações dos usuários em um arquivo de texto e oferece uma interface simples para interação.

## Funcionalidades

- **Cadastro de usuários**: Permite que novos usuários se registrem no sistema.
- **Login de usuários**: Permite que usuários existentes façam login com seu nome de usuário e senha.
- **Validação de login**: Verifica se o usuário e a senha estão corretos.
- **Opções de recuperação**: Se o login falhar, o sistema oferece a opção de tentar novamente ou cadastrar um novo usuário.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação utilizada para o desenvolvimento do sistema.
- **Arquivos de texto**: Utilizados para armazenar os dados dos usuários de maneira simples.

## Como Rodar o Projeto

### Pré-requisitos

Antes de rodar o projeto, você precisa ter o Java instalado no seu computador:

- [Java 8 ou superior](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html)

### Passos para Rodar

1. Clone o repositório para o seu computador:

   ```bash
   git clone https://github.com/peseoaar/Gerenciamento_Livraria.git
   ```

2. Abra o projeto em sua IDE favorita (exemplo: IntelliJ IDEA, Eclipse, ou NetBeans).

3. Compile e execute o arquivo principal do projeto (`ControleUsuario.java`).

4. O sistema pedirá para você inserir seu **nome de usuário** e **senha** para login. Se o usuário não existir, será possível cadastrá-lo.

## Como Contribuir

Se você quiser contribuir para este projeto, siga as etapas abaixo:

1. Faça um **fork** deste repositório.
2. Crie uma nova **branch** para suas alterações:

   ```bash
   git checkout -b feature/nova-funcionalidade
   ```

3. Faça commit das suas alterações:

   ```bash
   git commit -am 'Adicionando nova funcionalidade'
   ```

4. Envie suas alterações para o repositório remoto:

   ```bash
   git push origin feature/nova-funcionalidade
   ```

5. Abra um **pull request** no GitHub para revisar e integrar suas alterações.

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).
```
