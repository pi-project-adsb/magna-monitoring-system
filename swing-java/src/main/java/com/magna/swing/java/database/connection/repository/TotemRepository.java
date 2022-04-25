/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.magna.swing.java.database.connection.repository;

public class TotemRepository {
    private String hostname;
    private String localizacao;
    private String totemStatus;
    private String sistemaOperacional;
    private Integer fkEmpresa;
    private String enderecoMac;

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getTotemStatus() {
        return totemStatus;
    }

    public void setTotemStatus(String totemStatus) {
        this.totemStatus = totemStatus;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    public Integer getFkEmpresa() {
        return fkEmpresa;
    }

    public void setFkEmpresa(Integer fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
    }

    public String getEnderecoMac() {
        return enderecoMac;
    }

    public void setEnderecoMac(String enderecoMac) {
        this.enderecoMac = enderecoMac;
    }

    @Override
    public String toString() {
        return
                "\nhostname: " + this.hostname +
                "\nlocalizacao: " + this.localizacao +
                "\ntotemStatus: " + this.totemStatus +
                "\nsistemaOperacional: " + this.sistemaOperacional +
                "\nfkEmpresa: " + this.fkEmpresa +
                "\nenderecoMac: " + this.enderecoMac;
    }
}
