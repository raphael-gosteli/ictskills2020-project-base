package com.raphaelgosteli.project;

import com.raphaelgosteli.project.controller.BaseController;
import com.raphaelgosteli.project.service.Service;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {


        Thread.setDefaultUncaughtExceptionHandler((thread, throwable) -> {
            Alert alert = new Alert(Alert.AlertType.ERROR, throwable.getMessage());
            alert.showAndWait();
        });


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("controller/sample.fxml"));
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("Hello World");
        Scene scene = new Scene(root);

        Map<String, Object> ctx = new HashMap<>();
        ctx.put(BaseController.SCENE, scene);
        ctx.put(BaseController.STAGE, primaryStage);

        ((BaseController) fxmlLoader.getController()).init(ctx);

        primaryStage.setScene(scene);
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
        Service.initialize();
    }
}
