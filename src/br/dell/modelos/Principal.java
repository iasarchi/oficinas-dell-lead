package br.dell.modelos;

import javax.swing.*;

import java.util.InputMismatchException;
import java.util.Scanner;

import static javax.swing.JOptionPane.showInputDialog;

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

        try {
            System.out.println("Informe o CPF do hospede");
            cpfHospede = scanner.nextLong();

        } catch (InputMismatchException exception) {
            System.err.println("Erro: Digite o numero de CPF");
        }
        System.out.println("Informe o RG do hospede");
        rgHospede = scanner.nextLong();



        try {
            System.out.println("Digite a idade do hospede");
         idadeHospede = scanner.nextInt();

        } catch (InputMismatchException exception) {
            System.err.println("Erro: digite um numero");
        }
        scanner.nextLine();
        System.out.println("Digite o endereço do hospede");
        enderecoHospede = scanner.nextLine();

        System.out.println("Informe o nome do hospede");
        nomeHospede = scanner.nextLine();

        System.out.println("Digite o numero do quarto");
        numeroDoQuarto = scanner.nextInt();

        Quarto quarto = new Quarto(numeroDoQuarto, hospede);

        hospede.setNome(nomeHospede);
        hospede.setCPF(cpfHospede);
        hospede.setRG(rgHospede);

        hospede.setIdade(idadeHospede);

        hospede.setEndereço(enderecoHospede);


        System.out.println("Hospede cadastrado com sucesso");

        System.out.println("O numero do quarto é " + quarto.getNumero() + " " + quarto.getHospede().toString());

    }
}
