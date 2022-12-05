package projeitoAdocaoAnimais;

import projeitoAdocaoAnimais.entities.Animal;
import projeitoAdocaoAnimais.exception.AnimalJaExisteException;
import projeitoAdocaoAnimais.exception.AnimalNaoExisteException;
import projeitoAdocaoAnimais.utils.SistemaAnimalLista;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ProgramaAdocao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SistemaAnimalLista crud = new SistemaAnimalLista();

        
        boolean continuar = true;
        while (continuar) {
            
            System.out.print("==============================  Bem vindo ao SPAP!!  ===================================");
            System.out.println("\nDigite uma opção:\n1.Cadastrar Animal\n2.Pesquisar Animal por Nome\n3.deletar\n4.Lista\n5.Sair");
            System.out.print("========================================================================================\n");
            String opcao = sc.nextLine();

            System.out.println();
            if (opcao.equals("1")) {
                //Cadastrar
                System.out.println("Digite o nome do Animal");
                String nome = sc.nextLine();
                System.out.println("Digite a tipo do Animal");
                String tipo = sc.nextLine();
                System.out.println("Digite a cor do Animal");
                String cor = sc.nextLine();
                System.out.println("Digite a idade do Animal");
                Integer idade = sc.nextInt();
                try {
                    Animal entityAnimal1 = new Animal(nome,idade,tipo,cor);

                    try {
                        String newNameKey = entityAnimal1.getNome();

                        crud.create(newNameKey,entityAnimal1);

                    } catch (AnimalJaExisteException | AnimalNaoExisteException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Número inválido para idade. Tente novamente. Detalhes do erro:" + e.getMessage());
                    continue;
                }
                System.out.println("Amimal cadastrado com successo");

                System.out.println();
            } else if (opcao.equals("2")) {
                System.out.println("Qual o nome do Animal a pesquisar?");
                String nomePesq = sc.nextLine();
                try {
                    Animal animalAchado = crud.findByName(nomePesq);
                    System.out.println("O animal achado foi " + animalAchado.toString());

                } catch (AnimalNaoExisteException e) {
                    System.out.println(e.getMessage());
                } catch (NullPointerException e) {
                    System.out.println("Animal não encontrado");
                }

                System.out.println();
            } else if (opcao.equals("3")) {
                try {
                    System.out.println("Nome do animal para deletar");
                    String nome = sc.nextLine();
                    crud.delete(nome);
                    System.out.println("Animal deletado com susseso");
                } catch (Exception e) {
                    System.out.println("Problema ao deletar os dados dos animais. Detalhe do erro:" + e.getMessage());
                }

                System.out.println();
            } else if (opcao.equals("4")) {

                System.out.println("Lista completa de animais");
                System.out.println(Arrays.asList(crud));
            } else if (opcao.equals("5")){
                continuar = false;
            } else {
                System.out.println("Opção inválida. Tente novamente");
            }
        }
        System.out.println("Até mais");


        sc.close();

    }
}
