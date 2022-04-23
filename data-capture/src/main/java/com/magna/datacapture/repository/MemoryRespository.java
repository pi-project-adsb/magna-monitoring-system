package com.magna.datacapture.repository;

public class MemoryRespository {
    private Integer id;
    private String total;
    private String uso;
    private String disponivel;
    private String fkTotem;

    public MemoryRespository() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public String getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(String disponivel) {
        this.disponivel = disponivel;
    }

    public String getFkTotem() {
        return fkTotem;
    }

    public void setFkTotem(String fkTotem) {
        this.fkTotem = fkTotem;
    }

    @Override
    public String toString() {
        return String.format("\nID: %d\nTOTAL: %s\nUSO: %s\nDISPONIVEL: %s, \nFKTOTEM: %s",
                this.id, this.total, this.uso, this.disponivel, this.fkTotem);
    }
}
