package projeitoAdocaoAnimais;

import java.util.List;

public interface SistemaAnimal {
    void cadastrarAnimal(Animal animal) throws AnimalJaExisteException, AnimalNaoExisteException;
    Animal pesquisaAnimaloPeloNome(String nome) throws AnimalNaoExisteException;

    List<Animal> obterAnimal();
}

