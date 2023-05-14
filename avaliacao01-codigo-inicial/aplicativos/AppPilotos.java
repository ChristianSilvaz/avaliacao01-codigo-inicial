package aplicativos;
import classes.*;
import java.io.IOException;
import java.util.Scanner;

public class AppPilotos {
    public static void main(String[] args) throws InterruptedException, IOException {
        final int MAX_ELEMENTOS = 10;
        int opcao, qtdCadastrados = 0;
        Pessoa[] pilotos = new Pessoa[MAX_ELEMENTOS];
        Scanner sc = new Scanner(System.in);
        
        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Cadastrar piloto");
            System.out.println("2 - Listar pilotos cadastrados");
            System.out.println("3 - Localizar piloto pelo CPF");
            System.out.println("4 - Cadastrar aeronave");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = sc.nextInt();
            sc.nextLine(); // Tira o ENTER que ficou na entrada na instrução anterior

            if (opcao == 1) {
                // Se não tem mais espaço no vetor, saio do cadastro
             
                if (qtdCadastrados == MAX_ELEMENTOS) {
                    System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                    voltarMenu(sc);
                    continue;
                }
             
                Piloto piloto1 = new Piloto();
                System.out.println("informe o nome do piloto : ");
                piloto1.setNome(sc.next());
                System.out.println("informe o CPF do piloto: ");
                piloto1.setCpf(sc.next());
                System.out.println("Infome um resumo do piloto:");
                piloto1.setBreve(sc.next());
                //Cadastre seu piloto aqui
                pilotos[qtdCadastrados] = piloto1;
                qtdCadastrados++;
                

                System.out.println("\nPiloto cadastrado com sucesso.");
                voltarMenu(sc);
                }
             else if (opcao == 2) {
                // Se não tem ninguém cadastrado no vetor, caio fora
                if (qtdCadastrados == 0) {
                    System.out.println("\nNão há pilotos cadastrados para exibir.");
                    voltarMenu(sc);
                    continue;
                }
                for (int i = 0; i < qtdCadastrados; i++) {
                    Piloto pilotoAtual = (Piloto) pilotos[i];
                    System.out.println("Nome: " + pilotoAtual.getNome());
                    System.out.println("CPF: " + pilotoAtual.getCpf());
                    System.out.println("Breve: " + pilotoAtual.getBreve()+"\n");
                    }
                    voltarMenu(sc);
                // Exiba os pilotos aqui

                
            } else if (opcao == 3) {
              System.out.print("\nInforme o CPF do piloto: ");
            String cpfBusca = sc.next();
            boolean encontrado = false;

            for (int i = 0; i < qtdCadastrados; i++) {
                Piloto pilotoAtual = (Piloto) pilotos[i];
                if (cpfBusca.equals(pilotoAtual.getCpf())) {
                    System.out.println("\nPiloto encontrado:");
                    System.out.println("Nome: " + pilotoAtual.getNome());
                    System.out.println("CPF: " + pilotoAtual.getCpf());
                    System.out.println("Breve: " + pilotoAtual.getBreve());
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("\nPiloto não encontrado.");
            }

            
            
            } else if (opcao == 4) {
                 // Se não tem ninguém cadastrado no vetor, caio fora
                 if (qtdCadastrados == 0) {
                    System.out.println("\nSem pilotos, não há como cadastrar uma aeronave");
                    voltarMenu(sc);
                    continue;
                }
                System.out.println("\nInforme o CPF do piloto para cadastrar a aeronave:");
                String cpfPiloto = sc.next();
                boolean pilotoEncontrado = false;
                for (int i = 0; i < qtdCadastrados; i++) {
                    if (pilotos[i].getCpf().equals(cpfPiloto)) {
                        pilotoEncontrado = true;
                        System.out.println("\nInforme o modelo da aeronave:");
                        String modeloAeronave = sc.next();
                        System.out.println("Informe a matrícula da aeronave:");
                        String matriculaAeronave = sc.next();
                        Aeronave aeronave = new Aeronave(modeloAeronave, matriculaAeronave);
                        // Associe a aeronave ao piloto aqui
                        pilotos[i].setAeronave(aeronave);
                        System.out.println("\nAeronave cadastrada com sucesso para o piloto " + pilotos[i].getNome() + ".");
                        break;
                    }
                }
                if (!pilotoEncontrado) {
                    System.out.println("\nPiloto não encontrado.");
                }
                
             else {
                System.out.println("\nOpção inválida. Tente novamente.");
                voltarMenu(sc);
            }
              
                System.out.println("\nAeronave cadastrada com sucesso.");
               //Solicite ao usuário o piloto
               //Crie a aeronave vinculando-a ao piloto
               //Exiba os dados da aeronave

                voltarMenu(sc);
            
    } else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");

        sc.close();
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
    }
}