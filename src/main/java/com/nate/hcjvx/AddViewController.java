package com.nate.hcjvx;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddViewController implements Initializable
{
    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private void switchToAddView() throws IOException
    {
        App.setRoot("listView");
    }

    @FXML
    private TextField name;
    @FXML
    private TextField health;
    @FXML
    private CheckBox transformed;
    @FXML
    private Label success = new Label();
    @FXML
    private Button create;

    @FXML
    private void Make() throws IOException
    {
        String n = name.getText();
        int h = Integer.parseInt(health.getText());
        HorrorCharacter hc = null;

        //to scale just add an array of first letter priority then make the end value of substring to indexOf(type)+1
        if(comboBox.getValue().substring(0, 1).equals("V") || comboBox.getValue().substring(0, 1).equals("v"))
        {
            hc=new Vampire(n,h,transformed.isSelected());
        }
        else if(comboBox.getValue().charAt(0) == 'Z' ||comboBox.getValue().charAt(0) == 'z')
        {
            hc=new Zombie(n,h);
        }
        else if(comboBox.getValue().charAt(0) == 'W' ||comboBox.getValue().charAt(0) == 'w')
        {
            hc=new Werewolf(n,h,transformed.isSelected());
        }

        if(hc!=null) {System.out.println("Success");;
            AppState.characters.add(hc);}
        else {System.out.println("Error");}


    }

    @FXML
    public void populateList() throws IOException
    {
        AppState.characters.add(new Vampire("Drac",120,false));
        AppState.characters.add(new Werewolf("Wolfman",400,false));
        AppState.characters.add(new Zombie("Zombieman",50));
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        comboBox.setItems(FXCollections.observableArrayList("Vampire", "Werewolf", "Zombie"));

    }
}
