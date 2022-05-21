package com.magna.datacapture.repository;

public class TotemRepository {
    private Integer id;
    private String hostname;
    private String localizacao;
    private String totemStatus;
    private String enderecoMac;
    private String sistemaOperacional;
    private Integer totalDisco;
    private String modeloCpu;
    private String frequenciaCpu;
    private Integer nucleosCpu;
    private Integer threadsCpu;
    private Integer totalRam;
    private Integer fkEmpresa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getEnderecoMac() {
        return enderecoMac;
    }

    public void setEnderecoMac(String enderecoMac) {
        this.enderecoMac = enderecoMac;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    public Integer getTotalDisco() {
        return totalDisco;
    }

    public void setTotalDisco(Integer totalDisco) {
        this.totalDisco = totalDisco;
    }

    public String getModeloCpu() {
        return modeloCpu;
    }

    public void setModeloCpu(String modeloCpu) {
        this.modeloCpu = modeloCpu;
    }

    public String getFrequenciaCpu() {
        return frequenciaCpu;
    }

    public void setFrequenciaCpu(String frequenciaCpu) {
        this.frequenciaCpu = frequenciaCpu;
    }

    public Integer getNucleosCpu() {
        return nucleosCpu;
    }

    public void setNucleosCpu(Integer nucleosCpu) {
        this.nucleosCpu = nucleosCpu;
    }

    public Integer getThreadsCpu() {
        return threadsCpu;
    }

    public void setThreadsCpu(Integer threadsCpu) {
        this.threadsCpu = threadsCpu;
    }

    public Integer getTotalRam() {
        return totalRam;
    }

    public void setTotalRam(Integer totalRam) {
        this.totalRam = totalRam;
    }

    public Integer getFkEmpresa() {
        return fkEmpresa;
    }

    public void setFkEmpresa(Integer fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
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
