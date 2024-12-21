package org.example;
import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.util.Arrays;

public class Livraria {
    private static Livro livro;
    private Cliente cliente;
    private static Main main;


    public ArrayList<String> ListarLivros(){
        ArrayList<String> dadosLivro = new ArrayList<String>();
        int count=0;
        try{
            FileReader arquivo = new FileReader("C://Users/pedro/IdeaProjects/Gerenciamento_Livraria/src/main/resources/data/livros.txt");
            BufferedReader reader = new BufferedReader(arquivo);

            String linha;
            System.out.println("Lista de Livros");
            System.out.println("----------------");
            while((linha = reader.readLine()) != null){
                if(!linha.trim().isEmpty()) { // se mesmo sem os espacos a linha esta vazia
                    String[] dados = linha.split(", ");// dando split depois da virgula
                    if (dados.length == 4) {
                        String linhaFormatada = String.format("Titulo: %-30s | Autor: %-20s | Preço R$ %-10s | Estoque: %-10s", dados[0], dados[1], dados[2], dados[3]);
                        System.out.println(linhaFormatada);
                        dadosLivro.add(linhaFormatada);
                        count++;

                    } else{
                        System.out.println("Erro na formatação da linha: " + linha);
                    }
                }
            }

        }catch(IOException e){
            e.printStackTrace();
        }
        Opcoes();
        return dadosLivro;
    }


    public static void AdicionarLivro(){
        String arquivo = "C://Users/pedro/IdeaProjects/Gerenciamento_Livraria/src/main/resources/data/livros.txt";
        Livro livro = PerguntarDadosLivro(); // puxando dados do livro dentro de um novo objeto livro

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true))){
            String tituloLivro = livro.getTitulo();
            String autorLivro = livro.getAutor();
            String precoLivro = Double.toString(livro.getPreco());
            String estoqueLivro = Integer.toString(livro.getEstoque());

            writer.write(tituloLivro + ", " + autorLivro + ", " + precoLivro + ", "+estoqueLivro);
            writer.newLine();
            writer.flush();

        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("Livro Cadastrado com Sucesso!");
        Opcoes();
    }


    public static Livro PerguntarDadosLivro() {
        String tituloLivro = null;
        String autorLivro = null;
        Double precoLivro = null;
        int estoqueLivro = 0;

        System.out.println("===============");
        System.out.println("Adicionar Livro");
        System.out.println("===============");
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Titulo: ");
            tituloLivro = scanner.nextLine();
            System.out.print("Autor: ");
            autorLivro = scanner.nextLine();
            System.out.print("Preco: ");
            precoLivro = scanner.nextDouble();
            System.out.print("Estoque: ");
            estoqueLivro = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Valor Invalido!");
            Opcoes();
        } finally {
            return new Livro(tituloLivro, autorLivro, precoLivro, estoqueLivro);
        }
    }

    public void VenderLivro(){
        ArrayList<String> livros = CarregarLivros();
        Scanner scanner = new Scanner(System.in);


        System.out.println("============");
        System.out.println("Vender Livro");
        System.out.println("============");
        System.out.print("Nome do livro: ");
        String nomeLivro = scanner.nextLine();

        for(int i = 0; i < livros.size(); i++){
            String linha = livros.get(i); // pegando linha atual em forma de String

            if(linha.toLowerCase().contains(nomeLivro.toLowerCase())){
                String[] dadosLivro = linha.split(", "); // separando dados da linha encontrada atraves da virgula
                int estoque = Integer.parseInt(dadosLivro[3]); // passando o estoque do livro para int
                if(estoque > 0) {
                    estoque--;  // reduzindo estoque
                    String estoqueAtualizado = Integer.toString(estoque);
                    dadosLivro[3] = estoqueAtualizado;  // atualizado dado de estoque com string
                    String novaLinha = String.join(", ", dadosLivro); // reconstruindo linha
                    livros.set(i, novaLinha); // atualizando arraylist com a nova linha
                } else{
                    System.out.println("Sem estoque para este Livro!");
                    Opcoes();
                }
            } else{
                System.out.println();
                System.out.println("Livro Indisponivel!");
                Opcoes();
            }
        }
        // reescrevendo arquivo com dados atualizados
        String arquivo = "C://Users/pedro/IdeaProjects/Gerenciamento_Livraria/src/main/resources/data/livros.txt";

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))){

            for(String i : livros){
                writer.write(i); // escrevendo cada linha
                writer.newLine();
            }
            writer.flush();
        }catch(IOException e){
            e.printStackTrace();
        } finally{
            System.out.println("Estoque de Livros Atualizado com Sucesso!");
            Opcoes();
        }


    }

    public static ArrayList<String> CarregarLivros(){
        ArrayList<String> livros = new ArrayList<>();
        String arquivo = "C://Users/pedro/IdeaProjects/Gerenciamento_Livraria/src/main/resources/data/livros.txt";

        try(BufferedReader reader = new BufferedReader(new FileReader(arquivo))){
            String linha;

            while((linha = reader.readLine()) != null){
                if(!linha.trim().isEmpty()){ // se mesmo sem os espacos a linha esta vazia
                    livros.add(linha);
                }
            }
        }catch(IOException e){
            System.out.println("Erro ao carregar os Livros!");
            e.printStackTrace();
        }
        return livros;
    }

    public static String BuscarLivros(ArrayList<String> livros, String tituloBusca){
        for(String linha : livros){
            if(linha.toLowerCase().contains(tituloBusca.toLowerCase())){
                String[] dadosLivro = linha.split(", ");

                return String.format("Livro Encontrado! - Preco: %-10s", dadosLivro[2]);
            }
        }
        return "Livro nao encontrado!";
    }

    public static void BuscarLivrosMenu(){
        Scanner scannerLivro = new Scanner(System.in);
        ArrayList<String> livros = CarregarLivros(); // iterando o array com os livros de 'livros.txt' antes de buscar

        System.out.println("============");
        System.out.println("Buscar Livro");
        System.out.println("============");
        System.out.print("Nome do Livro: ");
        String tituloBusca = scannerLivro.nextLine();
        String resultadoBusca = BuscarLivros(livros, tituloBusca);

        System.out.println();
        System.out.println(resultadoBusca);
    }


    public static void AtualizarEstoque(){
        ArrayList<String> livros = CarregarLivros();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=================");
        System.out.println("Atualizar Estoque");
        System.out.println("=================");
        System.out.print("Nome do livro: ");
        String nomeLivro = scanner.nextLine();

        for(int i = 0; i < livros.size(); i++){
            String linha = livros.get(i); // pegando linha atual em forma de String
            Scanner scanner2 = new Scanner(System.in);

            if(linha.toLowerCase().contains(nomeLivro.toLowerCase())){
                String[] dadosLivro = linha.split(", "); // separando dados da linha encontrada atraves da virgula
                int estoque = Integer.parseInt(dadosLivro[3]); // passando o estoque do livro para int

                System.out.println("Estoque atual de '" + nomeLivro + "': "+estoque);
                System.out.print("\nDigite o novo estoque para este livro: ");
                int novoEstoque = scanner2.nextInt();
                String estoqueAtualizado = Integer.toString(novoEstoque);
                dadosLivro[3] = estoqueAtualizado;
                String novaLinha = String.join(", ", dadosLivro); // reconstruindo linha
                livros.set(i, novaLinha); // setando linha atual(i), para novaLinha
            } else{
                System.out.println("Livro nao encontrado!");
                Opcoes();
            }
        }


        // reescrevendo arquivo com dados atualizados
        String arquivo = "C://Users/pedro/IdeaProjects/Gerenciamento_Livraria/src/main/resources/data/livros.txt";

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))){

            for(String i : livros){
                writer.write(i); // escrevendo cada linha
                writer.newLine();
            }
            writer.flush();
            }catch(IOException e){
                e.printStackTrace();
            } finally{
                System.out.println("Estoque de Livros Atualizado com Sucesso!");
                Opcoes();
            }

    }

    public static void Opcoes(){
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println();
        System.out.println("1 - Adicionar Livro");
        System.out.println("2 - Voltar ao Menu");
        System.out.println("3 - Sair");

        System.out.print("Escolha uma opcao: ");
        int opcao = scanner.nextInt();
        if (opcao == 1){
            AdicionarLivro();
        } else if(opcao == 2){
            main.LimparTela();
            main.MenuPrincipal(); ///////// como fazer isso ?????
        } else if(opcao == 3){
            System.exit(0);
        } else {
            System.out.println("Opcao invalida!");
            Opcoes();
        }
    }
}
