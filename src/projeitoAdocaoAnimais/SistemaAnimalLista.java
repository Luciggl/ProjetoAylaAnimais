package projeitoAdocaoAnimais;

import java.util.ArrayList;
import java.util.List;
public class SistemaAnimalLista implements SistemaAnimal {
    private final List<Animal> animais;
     public SistemaAnimalLista(){
         this.animais = new ArrayList<>();
     }
    public SistemaAnimalLista(List<Animal> listaInicialDeAnimais){
         this.animais = listaInicialDeAnimais;
    }
    public List<Animal> obterAnimais(){
         return this.animais;
    }
    public void cadastrarAnimal(Animal animal) throws AnimalJaExisteException, AnimalNaoExisteException {
        if (this.animais.contains(animal)){
            throw new AnimalNaoExisteException("Já existe um animal no sistema com o nome "+ animal.getNome());
        } else {
            this.animais.add(animal);
        }
    }

    @Override
    public Animal pesquisaAnimaloPeloNome(String nome) throws AnimalNaoExisteException {
        return null;
    }

    @Override
    public List<Animal> obterAnimal() {
        return this.animais;
    }

    public Animal pesquisarAnimalPorNome(String nome) throws AnimalNaoExisteException{
        for (Animal a: this.animais){
            if (a.getNome().equals(nome)){
                return a;
            }
        }
        throw new AnimalNaoExisteException("não existe animal com o nome "+nome);
    }
}
