package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean login = ControleUsuario.LoginUsuario();
        if(login==true){
            LimparTela();
            MenuPrincipal();
        }

    }


    public static void MenuPrincipal() {
        Livraria livraria = new Livraria();
        ArrayList<String> livrosArray = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("============================");
        System.out.println("     SISTEMA LIVRARIA");
        System.out.println("============================");
        System.out.println("1 - Adicionar Livros");
        System.out.println("2 - Listar Livros");
        System.out.println("3 - Vender Livro");
        System.out.println("4 - Buscar Livro");
        System.out.println("5 - Atualizar Estoque");
        System.out.println("6 - Sair");
        System.out.print("\nEscolha uma opcao: ");
        int opcao = scanner.nextInt();
        if (opcao == 1) {
            LimparTela();
            livraria.AdicionarLivro();
        } else if (opcao == 2) {
            LimparTela();
            livraria.ListarLivros();
        } else if (opcao == 3) {
            LimparTela();
            livraria.VenderLivro();
        } else if (opcao == 4){
            LimparTela();
            livraria.BuscarLivrosMenu();
            System.out.println();
            livraria.Opcoes();

        } else if(opcao == 5){
            LimparTela();
            livraria.AtualizarEstoque();
            System.out.println();
        } else if (opcao == 6) {
            LimparTela();
            System.exit(0);
        } else {
            LimparTela();
            System.out.println("Opcao invalida!");
            MenuPrincipal();
        }
    }


    public static void LimparTela(){
        for(int i=0;i<50;i++){
            System.out.println();
        }
    }
}


