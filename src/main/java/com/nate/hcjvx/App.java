package com.nate.hcjvx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;

import java.io.IOException;


public class App extends Application
{
    private static Scene scene;
    public static void main(String[] args)
    {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        scene = new Scene(loadFXML("addView"),640,480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException
    {
        scene.setRoot(loadFXML(fxml));
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
}
