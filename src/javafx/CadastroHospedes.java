package javafx;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class CadastroHospedes extends Application {
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
        Label labelRg = new Label("RG:");
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

        layoutSexoBotoes.setPadding(new Insets(10,0,0,0));

        layoutSexoBotoes.getChildren().addAll(buttonSexoFeminino,buttonSexoMasculino);

        layoutSexo.setBottom(layoutSexoBotoes);

        BorderPane layoutQuartos = new BorderPane();
        Label labelQuartos = new Label("Quartos:");
        labelQuartos.setPadding(new Insets(0,0,10,0));
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


        layoutCheckinBotoes.getChildren().addAll(checkin,checkout);

        HBox layoutBotoes = new HBox(20);
        Button buttonSalvar = new Button("Salvar");
        Button buttonBuscar = new Button("Buscar");
        Button buttonRemover = new Button("Remover");


        layoutBotoes.setAlignment(Pos.BOTTOM_LEFT);


        layoutBotoes.getChildren().addAll(buttonSalvar,buttonBuscar,buttonRemover);


        layoutRaiz.getChildren().addAll(layoutNome, layoutEndereco, layoutCpf,layoutRg,layoutIdade,layoutSexo,layoutQuartos,layoutCheckinBotoes,layoutBotoes);

        Scene cena = new Scene(layoutRaiz, 350, 450);
        palco.setScene(cena);

        palco.show();


    }

    public static void main(String[] args) {
        launch();
    }
}
