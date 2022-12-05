package projeitoAdocaoAnimais.entities;

import java.util.Objects;

public class Animal {

    private String nome;
    private Integer idade;
    private String tipo;
    private String cor;

    public Animal() {
    }

    public Animal(String nome, int idade, String tipo, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.tipo = tipo;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", tipo='" + tipo + '\'' +
                ", cor='" + cor + '\'' +
                '}';
    }
}
