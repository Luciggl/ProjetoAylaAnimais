package projeitoAdocaoAnimais.services;

import projeitoAdocaoAnimais.entities.Animal;
import projeitoAdocaoAnimais.exception.AnimalJaExisteException;
import projeitoAdocaoAnimais.exception.AnimalNaoExisteException;
import projeitoAdocaoAnimais.repository.RepositoryAnimal;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnimalServices implements RepositoryAnimal {

    public static HashMap<String, Animal> listGlobalCotroller = new HashMap<>();

    public static List<Animal> animalList = new ArrayList<>();

    @Override
    public Animal findByName(String keyNome) throws AnimalNaoExisteException {
        return listGlobalCotroller.get(keyNome);
    }

    @Override
    public void create(String keyNome, Animal EntityAnimal) throws AnimalJaExisteException, AnimalNaoExisteException {
        listGlobalCotroller.put(keyNome, EntityAnimal);

        //sava na lista de animais
        animalList.add(EntityAnimal);
    }

    @Override
    public void delete(String keyNome) throws AnimalNaoExisteException {
        listGlobalCotroller.remove(keyNome);
        Animal animalFind = findByName(keyNome);
        animalList.remove(animalFind);
    }

    //Recovers for date
    @Override
    public void saveAllDB(String path) {


        String Injectpath = path;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Injectpath))) {

            for (Animal line : animalList) {
                bw.write(line.getNome()+" ");
                bw.write(String.valueOf(line.getIdade())+" ");
                bw.write(line.getTipo()+" ");
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void recoverDB(String path) {

        List<Animal> newReadList = new ArrayList<>();

        String Injectpath = path;
        try (BufferedReader br = new BufferedReader(new FileReader(Injectpath))) {
            String line = br.readLine();
            while (line != null) {
                String[] animalSplit = line.split(" ");


                String nome = animalSplit[0];
                String idade = animalSplit[1];
                String tipo = animalSplit[2];

                Animal buildAnimal = new Animal(nome,idade,tipo);

                newReadList.add(buildAnimal);
                animalList.add(buildAnimal);
                listGlobalCotroller.put(nome,buildAnimal);

                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        for (Animal readAll : newReadList) {
            System.out.println(readAll);
        }
    }

    public HashMap<String, Animal> getHashMap() {
        return listGlobalCotroller;
    }

    @Override
    public String toString() {
        return "SistemaAnimalLista{" +
                "hashMap=" + listGlobalCotroller +
                '}'+"\n";
    }


}
