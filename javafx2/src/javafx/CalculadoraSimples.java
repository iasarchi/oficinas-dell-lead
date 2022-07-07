package javafx;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javax.swing.*;



public class CalculadoraSimples extends Application{
    @Override
    public void start(Stage palco) throws Exception{
        GridPane layoutJanela = new GridPane();
        layoutJanela.setAlignment(Pos.CENTER);

        layoutJanela.add(new Label("Primeiro valor:"),0,0);
        TextField campoPrimeiroValor = new TextField();
        layoutJanela.add(campoPrimeiroValor,1,0);

        layoutJanela.add(new Label("Segundo valor:"),0,1);
        TextField campoSegundoValor = new TextField();
        layoutJanela.add(campoSegundoValor,1,1);

        HBox layoutBotoes = new HBox(5);
        Button botaoSoma = new Button("+");
        Button botaoSubtracao = new Button("-");
        Button multiplicacao = new Button("*");
        Button divisao = new Button("/");
        layoutBotoes.getChildren().addAll(botaoSoma,botaoSubtracao,multiplicacao,divisao);
        layoutJanela.add(layoutBotoes,1,2);

        layoutJanela.add(new Label("Resultado:"),0,3);
        TextField campoResultado = new TextField();
        layoutJanela.add(campoResultado,1,3);
        campoResultado.setEditable(false);

        EventHandler<ActionEvent> eventoSoma = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent evento){
                calcular(campoPrimeiroValor,campoSegundoValor,campoResultado,'+');
            }
        };
        EventHandler<ActionEvent> eventoSubtracao = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent evento){
                calcular(campoPrimeiroValor,campoSegundoValor,campoResultado,'-');
            }
        };
        EventHandler<ActionEvent> eventoMultiplicacao = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent evento){
                calcular(campoPrimeiroValor,campoSegundoValor,campoResultado,'*');
            }
        };
        EventHandler<ActionEvent> eventoDivisao = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent evento){
                calcular(campoPrimeiroValor,campoSegundoValor,campoResultado,'/');
            }
        };

        botaoSoma.setOnAction(eventoSoma);
        botaoSubtracao.setOnAction(eventoSubtracao);
        multiplicacao.setOnAction(eventoMultiplicacao);
        divisao.setOnAction(eventoDivisao);
        Scene cena = new Scene(layoutJanela,300,150);

        palco.setTitle("Calculadora");
        palco.setScene(cena);
        palco.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void calcular(TextField primeiroValor, TextField segundoValor, TextField resultado, char operacao) {
        Double valor1 = 0.0;
        Double valor2 = 0.0;
        Double valorResultado = 0.0;

        try {
            valor1 = Double.valueOf(primeiroValor.getText());
            valor2 = Double.valueOf(segundoValor.getText());

        }catch (NumberFormatException exception){
            JOptionPane.showMessageDialog(null,"Erro na conversao de dados/ verifique se inseriu apenas numeros.","ERRO",JOptionPane.ERROR_MESSAGE);

        }
        switch (operacao){
            case '+':
                valorResultado = valor1 + valor2;
                break;
            case '-':
                valorResultado = valor1 - valor2;
                break;
            case '*':
                valorResultado = valor1 * valor2;
                break;
            case '/':
                valorResultado = valor1 / valor2;
                break;
        }
        resultado.setText(valorResultado.toString());
    }
}

