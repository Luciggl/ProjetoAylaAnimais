package projeitoAdocaoAnimais;


import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class gravadorDeAnimais {
    private String arquivoAnimais;

    public gravadorDeAnimais(String nomeArquivo){
        this.arquivoAnimais = nomeArquivo;
    }
    public gravadorDeAnimais(){
        this("Animais.txt");
    }

    public void gravarAnimais(List<Animal> animais) throws Exception{
        BufferedWriter escritor = null;
        try {
            escritor= new BufferedWriter(new FileWriter(this.arquivoAnimais));
            for (Animal a: animais){
                String linhaDoAnimal = a.getNome()+"#"+a.getTipo()+"#"+a.getCor();
                escritor.write(linhaDoAnimal+"\n");
            }
        }finally {
            if (escritor!=null){
                escritor.close();
            }
        }
    }

    public List<Animal> lerAnimal() throws IOException {
        BufferedReader leitor = null;
        try {
            leitor = new BufferedReader(new FileReader(this.arquivoAnimais));
            List<Animal> lista = new LinkedList<>();
            String linhaLida = null;
            do {
                linhaLida = leitor.readLine();
                if (linhaLida!=null) {
                    String[] dados = linhaLida.split("#");
                    Animal a = new Animal(dados[0], dados[1],(dados[2]));
                    lista.add(a);
                }
            } while (linhaLida!=null);
            return lista;
        } finally {
            if (leitor!=null){
                leitor.close();
            }
        }



    }
}
