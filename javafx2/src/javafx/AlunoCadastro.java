package javafx;

import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.awt.*;

public class AlunoCadastro extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox layoutRaiz = new VBox(10);
        layoutRaiz.setPadding(new Insets(10,10,10,10));

        BorderPane layoutNome = new BorderPane();
        Label labelNome = new Label("Nome: ");
        TextField textNome = new TextField();
        layoutNome.setLeft(labelNome);
        layoutNome.setRight(textNome);

        layoutRaiz.getChildren().addAll(layoutNome);

        Scene cena = new Scene(layoutRaiz, 350, 200);
        JFXPanel palco = null;
        palco.setScene(cena);


    }

    public static void main(String[] args) {
        launch();
    }
}
