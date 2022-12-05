package projeitoAdocaoAnimais.repository;

import projeitoAdocaoAnimais.entities.Animal;
import projeitoAdocaoAnimais.exception.AnimalJaExisteException;
import projeitoAdocaoAnimais.exception.AnimalListException;
import projeitoAdocaoAnimais.exception.AnimalNaoExisteException;

import java.util.List;

public interface RepositoryAnimal {

    Animal findByName(String nome) throws AnimalNaoExisteException;

    void create(String keyNome, Animal EntityAnimal) throws AnimalJaExisteException, AnimalNaoExisteException;

    void delete(String keyNome) throws AnimalNaoExisteException;


     default void saveAllDB(String path) throws AnimalListException {

    }

     default void recoverDB(String path) throws AnimalListException{

    }

}

