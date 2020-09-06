package com.raphaelgosteli.project.controller;

import com.raphaelgosteli.project.entity.User;
import com.raphaelgosteli.project.service.PersistenceService;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.Map;

public class SampleController extends BaseController {

    public Label name;

    @Override
    public void init(Map<String, Object> ctx) {
        super.init(ctx);
        User user = PersistenceService.get().createQuery("from User", User.class).getSingleResult();
        ((Stage) ctx.get(STAGE)).setTitle(user.getName());
        name.setText(user.getName());
    }

    public void doHelloWorld(ActionEvent actionEvent) {
        Map<String, Object> ctx = switchScene(getClass().getResource("helloworld.fxml"));
        ((Stage) ctx.get(STAGE)).setTitle("Hello World!");
    }
}
