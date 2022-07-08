package br.dell.modelos;
/*Oficina Aula 1
Esta oficina é de extrema relevância, pois servirá como base para as próximas atividades a serem feitas nas aulas que estão por vir. Vamos começar lendo com atenção a situação a seguir:
-Lázaro deseja desenvolver um sistema para sua rede de hotéis no qual ele possa cadastrar seus clientes, realizando,
 assim, todo o gerenciamento de seu estabelecimento. Como primeira versão, Lázaro solicita que o sistema cadastre
 seus hóspedes, ou seja, que ele esteja possibilitado a receber dados pessoais dos visitantes.

Para que isso seja feito, é essencial que os seguintes passos sejam executados sequencialmente:

Etapa 1
Primeiramente devemos abrir nossa IDE e criar um projeto do tipo Java, para que assim possamos codificar corretamente.
Então vamos lá:

Primeiramente, abra o Eclipse IDE para criar um projeto do tipo Java, para que você possa codificar corretamente;
Crie um projeto Java (Java project) chamado Hotel;
Crie, no projeto, um pacote chamado br.dell.modelos.
Com o projeto criado, podemos definir as classes do nosso programa. Vamos para o próximo passo.

Etapa 2
Crie a classe modelo responsável por armazenar os dados dos visitantes;
Crie a classe modelo Hospede com os seguintes atributos:
private long CPF;
private long RG;
private String nome;
private int idade;
private String endereço.
Crie os métodos getters e setters dos atributos;
Crie um método construtor sem parâmetros;
Crie um método construtor que receba todos os atributos como parâmetros.
Ao finalizar a Etapa 2, você terá modelado a classe que representará os hóspedes. Agora, vamos para o próximo passo.

Etapa 3
Crie a classe Quarto com os atributos:
private int numero;
private Hospede hospede.
Gere os métodos getters e setters dos atributos;
Crie um método construtor que receba todos os atributos como parâmetros.
Feito isso, você terá criado a classe que representará os quartos do hotel.

Etapa 4
Crie uma classe chamada Principal, com o método main(). Esta será a classe que será executada para testarmos o programa.
Ela também conterá a lógica do programa que será: receber do usuário os dados do hóspede (instanciar um objeto da classe Hospede),
atribuir um quarto ao hóspede (instanciar um objeto da classe Quarto com um objeto da classe Hospede) e exibir todas as informações ao usuário;
Instancie no bloco do método main() um objeto do tipo Hóspede, adicionando suas respectivas informações. Dica: use o método showInputDialog() para receber as informações;
Ao criar um novo hóspede (instanciar um objeto do tipo Hospede), o sistema deve informar que o visitante foi cadastrado com sucesso. Use o método showMessageDialog() da classe JOptionPane;
Instancie um objeto da classe Quarto, recebendo os dados por meio do método showInputDialog(). Dica: como a classe Quarto possui um atributo da classe Hospede,
 passe como parâmetro em seu construtor os dados necessários, recebidos do usuário, e o objeto da classe Hospede.
Feito isso, você terá desenvolvido um programa para receber as informações do usuário. Agora, precisamos exibi-las. Faremos isso na próxima etapa.

Etapa 5
Exiba, através do método showMessageDialog(), os dados do hóspede e o número do seu quarto.
Ao fim de todas as cinco etapas, você terá criado um programa que recebe como entrada as informações de um hóspede e
 o quarto em que ele ficará hospedado, exibindo essas informações para o usuário ao fim da execução.*/

import java.time.LocalDate;

/**
 * @author Iasmim Cardoso
 * @version 1
 */
public class Hospede {
    private long CPF;
    private long RG;
    private String nome;
    private int idade;
    private String endereco;
    private String sexo;
    private LocalDate checkin;
    private LocalDate checkout;

    public Hospede() {
    }

    public Hospede(long CPF, long RG, String nome, int idade, String endereco) {
        this.CPF = CPF;
        this.RG = RG;
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;

    }

    public long getCPF() {
        return CPF;
    }

    public void setCPF(long CPF) {
        this.CPF = CPF;
    }

    public long getRG() {
        return RG;
    }

    public void setRG(long RG) {
        this.RG = RG;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public void setCheckin(LocalDate checkin) {
        this.checkin = checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    public void setCheckout(LocalDate checkout) {
        this.checkout = checkout;
    }

    public String toString() {
        return "Hospede{" +
                "CPF=" + CPF +
                ", RG=" + RG +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", endereço='" + endereco + '\'' +
                '}';
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;

    }
}
