package projeitoAdocaoAnimais.entities;

public class Animal {

    private String nome;
    private String idade;
    private String tipo;

    public Animal() {
    }

    public Animal(String nome, String idade, String tipo) {
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

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
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
