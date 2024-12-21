package org.example;

public class Usuario {
    private String login;
    private int senha;


    public String getLogin(){return login;}

    public void setLogin(String login){
        this.login = login;
    }

    public int getSenha(){return senha;}

    public void setSenha(int senha){
        this.senha = senha;
    }


    public Usuario(String login, int senha){
        this.login = login;
        this.senha = senha;
    }


    @Override
    public String toString(){
        return "Usuario{login:"+login+", senha: "+senha;
    }


}
