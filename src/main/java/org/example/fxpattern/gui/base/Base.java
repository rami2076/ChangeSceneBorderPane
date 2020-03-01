package org.example.fxpattern.gui.base;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.Root;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class Base implements Initializable {

    @FXML
    private BorderPane borderPane;

    @FXML
    private void ui1(ActionEvent event) {
        loadUi("ui1");
    }

    @FXML
    private void ui2(ActionEvent event) {
        loadUi("ui2");

    }

    @FXML
    private void ui3(ActionEvent event) {
        loadUi("ui3");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private Map<String, Parent> map = new HashMap<>();

    private void loadUi(String str) {

        if (map.containsKey(str)) {
            borderPane.setCenter(map.get(str));
            return;
        }


        Parent root = null;
        String pathString = format(str);
        URL location = getClass().getResource(pathString);


        try {
            root = FXMLLoader.load(location);
        } catch (IOException e) {
            e.printStackTrace();
        }
        map.put(str, root);
        borderPane.setCenter(root);

    }

    private String format(String str) {
        return String.format("%s/%s.fxml", str, StringUtils.capitalize(str));
    }


}
