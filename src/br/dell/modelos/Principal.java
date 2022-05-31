package br.dell.modelos;

import javax.swing.*;

import static javax.swing.JOptionPane.showInputDialog;

public class Principal {
    public static void main(String[] args) {
        Hospede hospede = new Hospede();


        String cpfHospede = showInputDialog("Informe o CPF do hospede");
        String rgHospede = showInputDialog("Informe o RG do hospede");
        String nomeHospede = showInputDialog("Informe o nome do hospede");
        String idadeHospede = showInputDialog("Informe a idade do hospede");
        String enderecoHospede = showInputDialog("Informe o endereço do hospede");

        String numeroDoQuarto = showInputDialog("Informe o numero do quarto");
        Quarto quarto = new Quarto(Integer.parseInt(numeroDoQuarto),hospede);


        hospede.setNome(nomeHospede);
        hospede.setCPF(Long.parseLong(cpfHospede));
        hospede.setRG(Long.parseLong(rgHospede));
        hospede.setIdade(Integer.parseInt(idadeHospede));
        hospede.setEndereço(enderecoHospede);


        JOptionPane.showMessageDialog(null, "Hospede cadastrado com sucesso");

        JOptionPane.showMessageDialog(null, "O numero do quarto é " + quarto.getNumero() + quarto.getHospede().toString() );

    }
}
