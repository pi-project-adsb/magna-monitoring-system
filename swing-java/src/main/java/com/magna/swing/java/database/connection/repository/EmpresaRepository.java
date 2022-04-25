/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.magna.swing.java.database.connection.repository;

/**
 *
 * @author Gustavo
 */
public class EmpresaRepository {
    private Integer id;
    private String email;
    private String nome;
    private String cnpj;
    private String senha;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "EmpresaRepository{" + "id=" + this.id + ", email=" + this.email + ", nome=" + this.nome + ", cnpj=" + this.cnpj + ", senha=" + this.senha + '}';
    }

    
}
