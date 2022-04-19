package repository;

public class Memory {
    private Integer id;
    private String total;
    private String uso;
    private String disponivel;
    private String fkTotem;

    public Memory(Integer id, String total, String uso, String disponivel, String fkTotem) {
        this.id = id;
        this.total = total;
        this.uso = uso;
        this.disponivel = disponivel;
        this.fkTotem = fkTotem;
    }

    public Memory() {
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
        return "Memory{" +
                "id=" + id +
                ", total='" + total + '\'' +
                ", uso='" + uso + '\'' +
                ", disponivel='" + disponivel + '\'' +
                ", fkTotem='" + fkTotem + '\'' +
                '}';
    }
}
