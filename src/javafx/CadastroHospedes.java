package javafx;

import br.dell.modelos.Hospede;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.time.LocalDate;
import java.util.HashMap;


public class CadastroHospedes extends Application {
    static HashMap<Long, Hospede> hospedes = new HashMap<>();

    @Override
    public void start(Stage palco) throws Exception {
        VBox layoutRaiz = new VBox(10);
        layoutRaiz.setPadding(new Insets(10, 10, 10, 10));

        BorderPane layoutNome = new BorderPane();
        Label labelNome = new Label("Nome:");
        TextField textNome = new TextField();

        layoutNome.setTop(labelNome);
        layoutNome.setBottom(textNome);

        BorderPane layoutEndereco = new BorderPane();
        Label labelEndereco = new Label("Endereço:");
        TextField textEndereco = new TextField();

        layoutEndereco.setTop(labelEndereco);
        layoutEndereco.setBottom(textEndereco);

        BorderPane layoutCpf = new BorderPane();
        Label labelCpf = new Label("CPF:");
        TextField textCpf = new TextField();

        layoutCpf.setTop(labelCpf);
        layoutCpf.setBottom(textCpf);

        BorderPane layoutRg = new BorderPane();
        Label labelRg = new Label("RG:  ");
        TextField textRg = new TextField();

        layoutRg.setTop(labelRg);
        layoutRg.setBottom(textRg);

        BorderPane layoutIdade = new BorderPane();
        Label labelIdade = new Label("Idade:");
        TextField textIdade = new TextField();

        layoutIdade.setTop(labelIdade);
        layoutIdade.setBottom(textIdade);

        BorderPane layoutSexo = new BorderPane();
        Label labelSexo = new Label("Sexo:");
        layoutSexo.setTop(labelSexo);


        HBox layoutSexoBotoes = new HBox(20);
        RadioButton buttonSexoMasculino = new RadioButton("M");
        RadioButton buttonSexoFeminino = new RadioButton("F");

        buttonSexoMasculino.setPrefWidth(0);
        buttonSexoFeminino.setPrefWidth(0);

        layoutSexoBotoes.setAlignment(Pos.BOTTOM_LEFT);

        layoutSexoBotoes.setPadding(new Insets(10, 0, 0, 0));

        layoutSexoBotoes.getChildren().addAll(buttonSexoFeminino, buttonSexoMasculino);

        layoutSexo.setBottom(layoutSexoBotoes);

        BorderPane layoutQuartos = new BorderPane();
        Label labelQuartos = new Label("Quartos:");
        labelQuartos.setPadding(new Insets(0, 0, 10, 0));
        layoutQuartos.setTop(labelQuartos);

        ComboBox layoutQuartoCombo = new ComboBox();
        layoutQuartoCombo.getItems().add("Quarto 1");
        layoutQuartoCombo.getItems().add("Quarto 2");
        layoutQuartoCombo.getItems().add("Quarto 3");


        layoutQuartos.setBottom(layoutQuartoCombo);

        HBox layoutCheckinBotoes = new HBox(20);
        CheckBox checkin = new CheckBox("Check in");
        CheckBox checkout = new CheckBox("Check out");

        layoutCheckinBotoes.setAlignment(Pos.BOTTOM_LEFT);


        layoutCheckinBotoes.getChildren().addAll(checkin, checkout);

        HBox layoutBotoes = new HBox(20);
        Button buttonSalvar = new Button("Salvar");
        Button buttonBuscar = new Button("Buscar");
        Button buttonRemover = new Button("Remover");


        layoutBotoes.setAlignment(Pos.BOTTOM_LEFT);


        layoutBotoes.getChildren().addAll(buttonSalvar, buttonBuscar, buttonRemover);


        layoutRaiz.getChildren().addAll(layoutNome, layoutEndereco, layoutCpf, layoutRg, layoutIdade, layoutSexo, layoutQuartos, layoutCheckinBotoes, layoutBotoes);

        EventHandler<ActionEvent> eventoSalva = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent evento) {
                salvar(textNome, textEndereco, textCpf, textRg, textIdade, buttonSexoFeminino, buttonSexoMasculino, checkin, checkout);
            }
        };

        EventHandler<ActionEvent> eventoBuscar = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent evento) {
                buscar(textNome, textEndereco, textCpf, textRg, textIdade, buttonSexoFeminino, buttonSexoMasculino, checkin, checkout);
            }
        };
        EventHandler<ActionEvent> eventoRemover = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent evento) {
                remover(textCpf);
            }
        };
        buttonSalvar.setOnAction(eventoSalva);
        buttonBuscar.setOnAction(eventoBuscar);
        buttonRemover.setOnAction(eventoRemover);

        Scene cena = new Scene(layoutRaiz, 350, 450);
        palco.setScene(cena);

        palco.show();

    }

    public static void main(String[] args) {
        launch();
    }

    public static void salvar(TextField textNome, TextField textEndereco, TextField textCpf, TextField textRg, TextField textIdade, RadioButton buttonSexoFeminino, RadioButton buttonSexoMasculino, CheckBox checkin, CheckBox checkout) {

        Hospede hospede = new Hospede(Long.parseLong(textCpf.getText()), Long.parseLong(textRg.getText()), textNome.getText(), Integer.parseInt(textIdade.getText()), textEndereco.getText());

        if (buttonSexoFeminino.isSelected()) {
            hospede.setSexo("F");
        } else if (buttonSexoMasculino.isSelected()) {
            hospede.setSexo("M");
        }

        if (checkin.isSelected()) {
            hospede.setCheckin(LocalDate.now());
        } else if (checkout.isSelected()) {
            hospede.setCheckout(LocalDate.now());
        }

        hospedes.put(hospede.getCPF(), hospede);
        JOptionPane.showMessageDialog(null, "Hospede salvo com sucesso!");
    }

    public static void buscar(TextField textNome, TextField textEndereco, TextField textCpf, TextField textRg, TextField textIdade, RadioButton buttonSexoFeminino, RadioButton buttonSexoMasculino, CheckBox checkin, CheckBox checkout) {
        Hospede hospede = hospedes.get(Long.parseLong(textCpf.getText()));

        if (hospede == null) {
            JOptionPane.showMessageDialog(null, "Nao existe o hospede indicado!");
        } else {
            textNome.setText(hospede.getNome());
            textEndereco.setText(hospede.getEndereco());
            textCpf.setText(String.valueOf(hospede.getCPF()));
            textRg.setText(String.valueOf(hospede.getRG()));
            textIdade.setText(String.valueOf(hospede.getIdade()));

            if (hospede.getSexo().equals("F")) {
                buttonSexoFeminino.setSelected(true);
                buttonSexoMasculino.setSelected(false);
            } else {
                buttonSexoFeminino.setSelected(false);
                buttonSexoMasculino.setSelected(true);
            }

            if (hospede.getCheckin() != null) {
                checkin.setSelected(true);
                checkout.setSelected(false);
            } else if (hospede.getCheckin() != null && hospede.getCheckout() != null) {
                checkin.setSelected(true);
                checkout.setSelected(true);
            } else if (hospede.getCheckout() != null) {
                checkin.setSelected(false);
                checkout.setSelected(true);
            } else {
                checkin.setSelected(false);
                checkout.setSelected(false);
            }
        }
    }

    public static void remover(TextField cpf) {
        Hospede hospede = hospedes.get(Long.parseLong(cpf.getText()));
        if (hospede == null) {
            JOptionPane.showMessageDialog(null, "Nao existe o hospede indicado!");
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Deseja excluir o hospede " + hospede.getNome(), ButtonType.YES, ButtonType.NO);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                hospedes.remove(Long.parseLong(cpf.getText()));
                JOptionPane.showMessageDialog(null, "Hospede removido com sucesso!");
            }
        }

    }
}

