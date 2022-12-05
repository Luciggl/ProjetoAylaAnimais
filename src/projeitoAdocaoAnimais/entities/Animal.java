package projeitoAdocaoAnimais.entities;

public class Animal {

    private String nome;
    private Integer idade;
    private String tipo;

    public Animal() {
    }

    public Animal(String nome, int idade, String tipo) {
        this.nome = nome;
        this.idade = idade;
        this.tipo = tipo;
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


    @Override
    public String toString() {
        return "Animal " +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", tipo='" + tipo + '\'' +
                ' ';
    }
}
