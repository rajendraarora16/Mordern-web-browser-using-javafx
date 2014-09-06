package com.RajendraArora.WebBrowser;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Main extends Application {

    @Override
    public void start (Stage primaryStage){
        primaryStage.setTitle("Modern web browser using Javafx made by Rajendra arora.");
        WebView wv = new WebView();
        wv.setLayoutX(0.0);
        wv.setLayoutY(40.0);
        wv.setPrefHeight(Double.MAX_EXPONENT);
        wv.setPrefWidth(Double.MAX_EXPONENT);
        final WebEngine we = wv.getEngine();
        we.load("http://www.google.com/");

        final TextField tf = new TextField("http://www.google.com/");
        tf.setLayoutX(1.0);
        tf.setPrefWidth(960.0);
        tf.setPrefHeight(25.0);

        Button btn=new Button("Go Now!");
        btn.setLayoutX(1.0);
        btn.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent e){
                we.load(tf.getText().startsWith("http://") ? tf.getText() : "http://"+tf.getText());
                we.locationProperty().addListener(new ChangeListener<String>(){

                    @Override
                    public void changed(ObservableValue<?extends String> observable, String oldValue, String newValue){
                        tf.setText(newValue);
                    }
                });
            }
        });

        HBox hb=new HBox();
        hb.getChildren().add(tf);
        hb.getChildren().add(btn);

        Pane sp = new Pane();
        sp.getChildren().add(hb);
        sp.getChildren().add(wv);

        Scene scene = new Scene(sp, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}