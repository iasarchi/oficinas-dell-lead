package Produto;
//instancia dois objetos do tipo Cliente; instancia seis objetos do tipo Produto; instancia dois objetos do tipo RegistroDePagamento (um para cada cliente);//

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Principal {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente();
        Cliente cliente2 = new Cliente();
        Produto produto1 = new Produto("panama-its not over",13.49,"/c:/musicas/its not over.mp3");
        Produto produto2 = new Produto("phill veras- sorriso ao sono",15.19,"/c:/musicas/sorriso ao sono.mp3");
        Produto produto3 = new Produto("marisa monte-vilarejo",10.40,"/c:/musicas/vilarejo.mp3");
        Produto produto4 = new Produto("pearl jam-black",20.69,"/c:/musicas/black.mp3");
        Produto produto5 = new Produto("manerva-pisando descalço",10.49,"/c:/musicas/pisando descalco.mp3");
        Produto produto6 = new Produto("charlotte cardin - main girl ",10.49,"/c:/musicas/main girl.mp3");
        RegistroDePagamento registroDePagamento1 = new RegistroDePagamento(Arrays.asList(produto1,produto2,produto3),LocalDate.of(2022,07,14),cliente1);
        RegistroDePagamento registroDePagamento2 = new RegistroDePagamento(Arrays.asList(produto4,produto5,produto6),LocalDate.of(2022,07,15),cliente2);
    }
}
