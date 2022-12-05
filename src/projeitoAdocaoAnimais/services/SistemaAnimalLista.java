package projeitoAdocaoAnimais.services;

import projeitoAdocaoAnimais.SistemaAnimal;
import projeitoAdocaoAnimais.entities.Animal;
import projeitoAdocaoAnimais.exception.AnimalJaExisteException;
import projeitoAdocaoAnimais.exception.AnimalNaoExisteException;

import java.util.HashMap;

public class SistemaAnimalLista implements SistemaAnimal {

    private final HashMap<String, Animal> hashMap = new HashMap<>();

    @Override
    public Animal findByName(String keyNome) throws AnimalNaoExisteException {
        return hashMap.get(keyNome);
    }

    @Override
    public void create(String keyNome, Animal EntityAnimal) throws AnimalJaExisteException, AnimalNaoExisteException {
        hashMap.put(keyNome, EntityAnimal);
    }

    @Override
    public void delete(String keyNome) throws AnimalNaoExisteException {
        hashMap.remove(keyNome);
    }

    public HashMap<String, Animal> getHashMap() {
        return hashMap;
    }

    @Override
    public String toString() {
        return "SistemaAnimalLista{" +
                "hashMap=" + hashMap +
                '}'+"\n";
    }
}
