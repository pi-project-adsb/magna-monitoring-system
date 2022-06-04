package com.magna.datacapture.repository;

public class ParametrizacaoRepository {

    private Integer id;
    private Integer usoRam;
    private Integer usoCpu;
    private Integer usoDisco;
    private Integer qtdProc;
    private Integer tempoRam;
    private Integer tempoCpu;
    private Integer tempoDisco;
    private String manutencaoPreventiva;
    private Integer fkTotem;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUsoRam() {
        return usoRam;
    }

    public void setUsoRam(Integer usoRam) {
        this.usoRam = usoRam;
    }

    public Integer getUsoCpu() {
        return usoCpu;
    }

    public void setUsoCpu(Integer usoCpu) {
        this.usoCpu = usoCpu;
    }

    public Integer getUsoDisco() {
        return usoDisco;
    }

    public void setUsoDisco(Integer usoDisco) {
        this.usoDisco = usoDisco;
    }

    public Integer getQtdProc() {
        return qtdProc;
    }

    public void setQtdProc(Integer qtdProc) {
        this.qtdProc = qtdProc;
    }

    public Integer getTempoRam() {
        return tempoRam;
    }

    public void setTempoRam(Integer tempoRam) {
        this.tempoRam = tempoRam;
    }

    public Integer getTempoCpu() {
        return tempoCpu;
    }

    public void setTempoCpu(Integer tempoCpu) {
        this.tempoCpu = tempoCpu;
    }

    public Integer getTempoDisco() {
        return tempoDisco;
    }

    public void setTempoDisco(Integer tempoDisco) {
        this.tempoDisco = tempoDisco;
    }

    public String getManutencaoPreventiva() {
        return manutencaoPreventiva;
    }

    public void setManutencaoPreventiva(String manutencaoPreventiva) {
        this.manutencaoPreventiva = manutencaoPreventiva;
    }

    public Integer getFkTotem() {
        return fkTotem;
    }

    public void setFkTotem(Integer fkTotem) {
        this.fkTotem = fkTotem;
    }

    @Override
    public String toString() {
        return "ParametrizacaoRepository{" +
                "id=" + id +
                ", usoRam=" + usoRam +
                ", usoCpu=" + usoCpu +
                ", usoDisco=" + usoDisco +
                ", qtdProc=" + qtdProc +
                ", tempoRam=" + tempoRam +
                ", tempoCpu=" + tempoCpu +
                ", tempoDisco=" + tempoDisco +
                ", manutencaoPreventiva='" + manutencaoPreventiva + '\'' +
                ", fkTotem=" + fkTotem +
                '}';
    }
}
