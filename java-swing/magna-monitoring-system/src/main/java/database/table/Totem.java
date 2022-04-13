package database.table;

public class Totem {
    private Integer id;
    private String localizacao;
    private String status;
    private String sistema;
    private String macAddress;
    private String localhost;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getLocalhost() {
        return localhost;
    }

    public void setLocalhost(String localhost) {
        this.localhost = localhost;
    }

    @Override
    public String toString() {
        return "Totem{" +
                "id=" + id +
                ", localizacao='" + localizacao + '\'' +
                ", status='" + status + '\'' +
                ", sistema='" + sistema + '\'' +
                ", macAddress='" + macAddress + '\'' +
                ", localhost='" + localhost + '\'' +
                '}';
    }
}
