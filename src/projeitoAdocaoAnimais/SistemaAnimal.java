package projeitoAdocaoAnimais;

import projeitoAdocaoAnimais.entities.Animal;
import projeitoAdocaoAnimais.exception.AnimalJaExisteException;
import projeitoAdocaoAnimais.exception.AnimalNaoExisteException;

import java.util.List;

public interface SistemaAnimal {

    Animal findByName(String nome) throws AnimalNaoExisteException;

    void create(String keyNome, Animal EntityAnimal) throws AnimalJaExisteException, AnimalNaoExisteException;

    void delete(String keyNome) throws AnimalNaoExisteException;

}

