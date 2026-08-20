package com.appOptimisation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        java.net.URL fxmlUrl = App.class.getResource("opti.fxml");
        
        if (fxmlUrl == null) {
            System.err.println("ERROR: No se encontró el archivo opti.fxml. Revisa la ruta de recursos.");
            return;
        }

        FXMLLoader fxmlLoader = new FXMLLoader(fxmlUrl);
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        stage.setTitle("Maintenance du PC");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}