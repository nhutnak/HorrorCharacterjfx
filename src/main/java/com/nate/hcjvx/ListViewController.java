package com.nate.hcjvx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ListViewController implements Initializable
{
    @FXML
    private void switchView() throws IOException
    {
        App.setRoot("addView");
    }
    @FXML
    ListView<HorrorCharacter> listView =  new ListView<>(FXCollections.observableArrayList(AppState.characters));
    @FXML
    Button delete;

    @FXML
    public void deleteItem()
    {
        HorrorCharacter subject = listView.getSelectionModel().getSelectedItem();
        AppState.characters.remove(subject);
        listView.getItems().remove(subject);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        //ObservableList<HorrorCharacter> list = FXCollections.observableArrayList(AppState.characters);
        //listView.setItems(list);
        for(HorrorCharacter hc : AppState.characters)
        {
            listView.getItems().add(hc);
        }
    }
}
