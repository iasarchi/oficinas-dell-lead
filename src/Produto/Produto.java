package Produto;

public class Produto {
    private String nome;
    private double preco;
    private String path;

    public Produto(String nome, double preco, String path) {
        this.nome = nome;
        this.preco = preco;
        this.path = path;
    }
    public Produto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", path='" + path + '\'' +
                '}';
    }
}
