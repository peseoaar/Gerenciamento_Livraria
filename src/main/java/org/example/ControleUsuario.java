package org.example;
import java.io.*;
import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;

public class ControleUsuario {
    private Usuario usuario;


    public static ArrayList<String> CarregarUsuario() {
        ArrayList<String> DadosUsuario = new ArrayList<String>();
        String arquivo = "C://Users/pedro/IdeaProjects/Gerenciamento_Livraria/src/main/resources/data/usuarios.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;

            while ((linha = reader.readLine()) != null) {
                if (!linha.trim().isEmpty()) {
                    DadosUsuario.add(linha);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return DadosUsuario;
    }


    public static boolean LoginUsuario() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> usuarios = CarregarUsuario();
        boolean resultado = false;

        System.out.println("===============");
        System.out.println("LIVRARIA LOGIN");
        System.out.println("===============");
        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();


        for (int i = 0; i < usuarios.size(); i++) {
            String linha = usuarios.get(i); // pegando linha atual em forma de String
            String[] dadosUsuario = linha.split(", ");

            if (dadosUsuario[0].contains(usuario) && dadosUsuario[1].contains(senha)){
                return true;
            } else{
                    System.out.println("Usuario ou senha invalido(s)!");
                    System.out.println("1- Tentar Novamente");
                    System.out.println("2- Cadastrar novo usuario!");
                    System.out.println();
                    System.out.print("Escolha uma opcao: ");
                    int opcaoMenuLogin = scanner.nextInt();
                    scanner.nextLine();

                    if(opcaoMenuLogin==1){
                        return LoginUsuario();
                    } else if(opcaoMenuLogin==2){
                        CadastroUsuario();
                    } else{
                        System.out.println("Opcao Invalida!");
                        return LoginUsuario();
                    }
                return false;
            }
        }
        scanner.nextLine();
        return resultado = false;
        }







    public static void CadastroUsuario(){
        String arquivo = "C://Users/pedro/IdeaProjects/Gerenciamento_Livraria/src/main/resources/data/usuarios.txt";
        Scanner scannerCadastro = new Scanner(System.in);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true))) {

            System.out.println("================");
            System.out.println("CADASTRO USUARIO");
            System.out.println("================");
            System.out.print("Usuario: ");
            String nomeUsuario = scannerCadastro.nextLine();
            System.out.print("Senha: ");
            String senhaUsuario = scannerCadastro.nextLine();

            writer.write(nomeUsuario + ", " + senhaUsuario);
            writer.newLine();
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}