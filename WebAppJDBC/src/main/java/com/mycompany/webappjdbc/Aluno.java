/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.webappjdbc;

import java.util.Date;

/**
 *
 * @author willian
 */
public class Aluno {
    private String nome;
    private Integer matricula;
    private String email;
    private String telefone;
    private Integer idade;
    private Date dtNascimento;
    
    public Aluno(){
    }
    
    public Aluno(int matricula){
    this.matricula = matricula;
    
    }

    public Aluno(String nome, Integer matricula, String email, String telefone, Integer idade, Date dtNascimento) {
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        this.telefone = telefone;
        this.idade = idade;
        this.dtNascimento = dtNascimento;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }
    
    
    
}
