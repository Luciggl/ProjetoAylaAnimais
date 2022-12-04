package projeitoAdocaoAnimais;

import java.util.Objects;

public class Animal {
    private static String nome;
    private int idade;
    private String tipo;
    private String cor;
    private double tamanho;


    public Animal(String dado, String s, String dado1){
        this.nome = nome;
        this.idade = this.idade;
        this.tipo = tipo;
        this.cor = cor;
        this.tamanho = tamanho;

    }

    public Animal(String dado, String dado1, String dado2, String dado3) {
    }

    @Override
    public String toString() {
        return "Animal{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", tipo='" + tipo + '\'' +
                ", cor='" + cor + '\'' +
                ", tamanho=" + tamanho +
                '}';
    }
    public static void Pet(Animal animal) {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal animal)) return false;
        Animal animais = (Animal) o;
        return Objects.equals(nome, Animal.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, tipo, cor);
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

    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }


}
