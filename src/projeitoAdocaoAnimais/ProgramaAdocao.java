package projeitoAdocaoAnimais;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ProgramaAdocao {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        SistemaAnimal sistema = null;
        gravadorDeAnimais gravador = new gravadorDeAnimais();
        try {
            List<Animal> contatosRecuperados;
            contatosRecuperados = gravador.lerAnimal();
            System.out.println("Animal recuperados com sucesso");
            sistema = new SistemaAnimalLista(contatosRecuperados);
        } catch (IOException e) {
            sistema = new SistemaAnimalLista();
            System.out.println("Sistema iniciado sem dados");
            System.out.println("Não foi possível recuperar contatos. Detalhe do erro:" + e.getMessage());
            e.printStackTrace();
        }
        boolean continuar = true;
        while (continuar) {
            System.out.print("==============================  Bem vindo ao SPAP!!  ===================================");
            System.out.println("\nDigite uma opção:\n1.Cadastrar Animal\n2.Pesquisar Animal por Nome\n3.Salvar\n4.Sair");
            System.out.print("========================================================================================\n");
            String opcao = leitor.nextLine();
            if (opcao.equals("1")) {
                //Cadastrar
                System.out.println("Digite o nome do Animal");
                String nome = leitor.nextLine();
                System.out.println("Digite a tipo do Animal");
                String tipo = leitor.nextLine();
                System.out.println("Digite a cor do Animal");
                String cor = leitor.nextLine();
                System.out.println("Digite a idade do Animal");
                try {
                    int idade = Integer.parseInt(leitor.nextLine());
                    Animal a1 = new Animal(nome, tipo, cor);

                    try {
                        sistema.cadastrarAnimal(a1);
                    } catch (AnimalJaExisteException | AnimalNaoExisteException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Número inválido para idade. Tente novamente. Detalhes do erro:" + e.getMessage());
                    continue;
                }
                System.out.println("Amimal cadastrado com successo");


            } else if (opcao.equals("2")) {
                System.out.println("Qual o nome do Animal a pesquisar?");
                String nomePesq = leitor.nextLine();
                try {
                    Animal animalAchado = sistema.pesquisaAnimaloPeloNome(nomePesq);
                    System.out.println("O animal achado foi " + animalAchado.toString());
                } catch (AnimalNaoExisteException e) {
                    System.out.println(e.getMessage());
                }
            }else if (opcao.equals("3")){
                try {
                    gravador.gravarAnimais(sistema.obterAnimal());
                    System.out.println("Dado dos animais salvos com sucesso");
                } catch(Exception e){
                    System.out.println("Problema ao salvar os dados dos animais. Detalhe do erro:"+e.getMessage());
                }
            }else if (opcao.equals("4")){
                continuar = false;
            } else {
                System.out.println("Opção inválida. Tente novamente");
            }
        }
        System.out.println("Até mais");


        leitor.close();

    }
}
