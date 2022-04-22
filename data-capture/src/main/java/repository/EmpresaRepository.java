package repository;

public class EmpresaRepository {
    private String email;
    private String nome;
    private String cnpj;
    private String senha;

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
        return "EmpresaRepository{" +
                "email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
