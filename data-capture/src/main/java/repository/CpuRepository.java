package repository;

public class CpuRepository {

    private Integer id;
    private String nome;
    private String frequencia;
    private String nucleos;
    private String threads;
    private String uso;
    private String fkTotem;


    public CpuRepository() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }

    public String getNucleos() {
        return nucleos;
    }

    public void setNucleos(String nucleos) {
        this.nucleos = nucleos;
    }

    public String getThreads() {
        return threads;
    }

    public void setThreads(String threads) {
        this.threads = threads;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public String getFkTotem() {
        return fkTotem;
    }

    public void setFkTotem(String fkTotem) {
        this.fkTotem = fkTotem;
    }

    @Override
    public String toString() {
        return String.format("\nID: %d\nNOME: %s\nFREQUENCIA: %s\nNUCLEOS: %s\nTHREADS: %s\nUSO: %s\nFKTOTEM: %s",
                this.id, this.nome, this.frequencia, this.nucleos, this.threads, this.uso,this.fkTotem);
    }
}
