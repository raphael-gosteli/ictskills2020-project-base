package com.raphaelgosteli.project.controller;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public abstract class BaseController implements Initializable {


    public static final String SCENE = "scene";
    public static final String STAGE = "stage";
    private Map<String, Object> context;

    public void init(Map<String, Object> ctx) {
        context = ctx;
    }

    public Map<String, Object> switchScene(URL location) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(location);

            Stage stage = (Stage) context.get(STAGE);
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);

            Map<String, Object> newContext = new HashMap<>();
            newContext.put(STAGE, stage);
            newContext.put(SCENE, scene);

            ((BaseController) fxmlLoader.getController()).init(newContext);

            return newContext;
        } catch (IOException e) {
            throw new RuntimeException("Error while loading scene");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
