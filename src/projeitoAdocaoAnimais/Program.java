package projeitoAdocaoAnimais;

import projeitoAdocaoAnimais.entities.Animal;
import projeitoAdocaoAnimais.exception.AnimalJaExisteException;
import projeitoAdocaoAnimais.exception.AnimalNaoExisteException;
import projeitoAdocaoAnimais.services.SistemaAnimalLista;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws AnimalNaoExisteException {
        Scanner sc = new Scanner(System.in);
        SistemaAnimalLista crud = new SistemaAnimalLista();


        boolean continuar = true;
        while (continuar) {

            System.out.print("==============================  Bem vindo ao SPAP!!  ===================================");
            System.out.println("\nDigite uma opção:\n1.Cadastrar Animal\n2.Pesquisar Animal por Nome\n3.deletar\n4.Salvar\n5.Atualizar\n6.Sair");
            System.out.print("========================================================================================\n");
            String opcao = sc.nextLine();

            System.out.println();
            if (opcao.equals("1")) {
                //Cadastrar
                System.out.println("Digite o nome do Animal");
                String nome = sc.nextLine();
                System.out.println("Digite a tipo do Animal");
                String tipo = sc.nextLine();
                System.out.println("Digite a idade do Animal");
                Integer idade = sc.nextInt();
                sc.nextLine();


                Animal entityAnimal1 = new Animal(nome, idade, tipo);


                try {
                    String newNameKey = entityAnimal1.getNome();

                    crud.create(newNameKey, entityAnimal1);
                    System.out.println("Animal cadastrado com successo");
                } catch (AnimalJaExisteException | AnimalNaoExisteException e) {
                    System.out.println(e.getMessage());
                    continue;
                }


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
                    System.out.println("Animal deletado com sucesso");
                } catch (Exception e) {
                    System.out.println("Problema ao deletar os dados dos animais. Detalhe do erro:" + e.getMessage());
                }

                System.out.println();
            } else if (opcao.equals("4")) {
                //salvar
                System.out.println("Lista completa de animais");
                System.out.println(List.of(crud));
                System.out.println();
                System.out.println("Dados salvos com salvo com sucesso");

            } else if (opcao.equals("5")) {
                //atualizar
                System.out.println("Digite o nome do animal que quer atualizar");
                String nome = sc.nextLine();

                Animal findedAnimal = crud.findByName(nome);



                System.out.println("\nDigite uma opção:\n1.idade \n2.tipo\n");
                String updateMenu = sc.nextLine();

                 if (updateMenu.equals("1")) {
                    System.out.println("Digite a IDADE quer alterar");
                    Integer novaIdade = sc.nextInt();

                    findedAnimal.setIdade(novaIdade);
                    System.out.println("Idade alterado com sucesso");
                } else if (updateMenu.equals("2")) {
                    System.out.println("Digite o TIPO quer alterar");
                    String novaTipo = sc.nextLine();
                    sc.nextLine();

                    findedAnimal.setTipo(novaTipo);
                    System.out.println("Tipo alterado com sucesso");
                } else {
                    System.out.println("opt invalida");
                }

                System.out.println("Operação feita com sucesso!");
            } else if (opcao.equals("6")){
               //Sair
                continuar = false;
            } else {
                System.out.println("Opção inválida. Tente novamente");
            }
        }
        System.out.println("Até mais");


        sc.close();

    }
}
