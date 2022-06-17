package br.dell.modelos;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Principal {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Hospede hospede = new Hospede();

        long cpfHospede = 0;
        long rgHospede = 0;
        int idadeHospede = 0;
        String enderecoHospede = "";
        String nomeHospede = "";
        int numeroDoQuarto = 0;

        boolean validaIdade = false;
        boolean validadoCpf = false;
        while (!validadoCpf) {
            try {
                System.out.println("Informe o CPF do hospede");
                cpfHospede = scanner.nextLong();
                validadoCpf = true;
            } catch (InputMismatchException exception) {
                System.err.println("Erro: Digite o numero de CPF");
            }
            scanner.nextLine();
        }
        System.out.println("Informe o RG do hospede");
        rgHospede = scanner.nextLong();
        while (!validaIdade) {
            try {
                System.out.println("Digite a idade do hospede");
                idadeHospede = scanner.nextInt();
                validaIdade = true;

            } catch (InputMismatchException exception) {
                System.err.println("Erro: digite um numero");
            }
            scanner.nextLine();

        }

        System.out.println("Digite o endereço do hospede");
        enderecoHospede = scanner.nextLine();

        HashMap<String, Integer> hospedeQuarto = new HashMap();
        System.out.println("Informe o nome do hospede");
        nomeHospede = scanner.nextLine();

        validacao(nomeHospede);

        System.out.println("Digite o numero do quarto");
        numeroDoQuarto = scanner.nextInt();
        scanner.nextLine();

        hospede.setNome(nomeHospede);
        hospede.setCPF(cpfHospede);
        hospede.setRG(rgHospede);
        hospede.setIdade(idadeHospede);
        hospede.setEndereço(enderecoHospede);

        Quarto quarto = new Quarto(numeroDoQuarto, hospede);

        hospedeQuarto.put(hospede.getNome(),quarto.getNumero());

        System.out.println("Hospede cadastrado com sucesso");

        System.out.println(" O numero do quarto é " + quarto.getNumero() + " " + quarto.getHospede().toString());

        System.out.println("Digite o nome para busca: ");
        String nomeBusca= scanner.nextLine();
        Object numeroQuartoBuscado = hospedeQuarto.get(nomeBusca);
        System.out.println( " O numero do quarto do cliente "+ nomeBusca +" é " + numeroQuartoBuscado);

    }

    public static boolean validacao(String nomeHospede) {
        boolean validar = nomeHospede.matches("[A-Z][a-z]*");
        System.out.println(" O nome de hospede (" +nomeHospede +") é válido? : " + validar);
        return validar;
    }

}
