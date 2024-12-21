package org.example;

public class Livro {
    private String titulo;
    private String autor;
    private double preco;
    private int estoque;
    private Livraria livraria;

    public String getTitulo(){
        return titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getAutor(){
        return autor;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

    public Double getPreco(){
        return preco;
    }

    public void setPreco(Double preco){
        this.preco = preco;
    }

    public int getEstoque(){ return estoque; }

    public void setEstoque(int estoque){
        this.estoque = estoque;
    }

    public Livro(String titulo, String autor, Double preco, int estoque){
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
        this.estoque = estoque;
    }

    @Override
    public String toString(){
        return "Livro{titulo='"+titulo+"', autor='"+autor+"', preco="+preco+"estoque="+estoque+"}";
    }
}
