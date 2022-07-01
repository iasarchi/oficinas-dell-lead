package javafx;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;


public class AlunoCadastro extends Application {
    @Override
    public void start(Stage palco) throws Exception {
        VBox layoutRaiz = new VBox(10);
        layoutRaiz.setPadding(new Insets(10, 10, 10, 10));

        BorderPane layoutNome = new BorderPane();
        Label labelNome = new Label("Nome:");
        TextField textNome = new TextField();
        layoutNome.setLeft(labelNome);
        layoutNome.setRight(textNome);

        BorderPane layoutMatricula = new BorderPane();
        Label labelMatricula = new Label("Matricula:");
        TextField textMatricula = new TextField();

        layoutMatricula.setLeft(labelMatricula);
        layoutMatricula.setRight(textMatricula);

        BorderPane layoutDatadeNascimento = new BorderPane();
        Label labelDatadeNascimento = new Label("Data de nascimento: ");
        TextField textDatadeNascimento = new TextField();
        layoutDatadeNascimento.setLeft(labelDatadeNascimento);
        layoutDatadeNascimento.setRight(textDatadeNascimento);

        HBox layoutBotoes = new HBox(20);
        Button buttonSalvar = new Button("Salvar");
        Button buttonCancelar = new Button("Cancelar");

        buttonSalvar.setPrefWidth(100);
        buttonCancelar.setPrefWidth(100);

        layoutBotoes.setAlignment(Pos.CENTER);

        layoutBotoes.setPadding(new Insets(30,0,0,0));

        layoutBotoes.getChildren().addAll(buttonSalvar,buttonCancelar);


        layoutRaiz.getChildren().addAll(layoutNome, layoutMatricula, layoutDatadeNascimento,layoutBotoes);

        Scene cena = new Scene(layoutRaiz, 350, 200);
        palco.setScene(cena);

        palco.setTitle("Cadastro de Aluno");
        palco.show();


    }

    public static void main(String[] args) {
        launch();
    }
}
