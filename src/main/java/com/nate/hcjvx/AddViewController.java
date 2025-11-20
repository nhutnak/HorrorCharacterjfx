package com.nate.hcjvx;

import javafx.collections.FXCollections;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
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
    ProgressBar progressBar =  new ProgressBar();
    @FXML
    Label created = new Label();

    @FXML
    DatePicker datePicker = new DatePicker();
    @FXML
    ImageView imageView = new ImageView();

    private Task<Void> makeBar() //needs to be a method that returns a task so it can be used more than once
    {
        return new Task<Void>()
        {
            @Override
            protected Void call() throws Exception //protected because call() is not meant to be called outside of a Task. Needs to be AIC bc task isnt a func interface
            {

                for (int i = 0; i <= 100; i++)
                {
                    updateProgress(i, 100);
                    Thread.sleep(1);
                }
                return null;
            }
        }; //https://docs.oracle.com/javase/8/javafx/api/javafx/concurrent/Task.html
    }

    @FXML
    private void Make() throws InterruptedException
    {
        HorrorCharacter hc = null;
        try
        {
            String n = name.getText();
            int h = Integer.parseInt(health.getText());
            LocalDate d = datePicker.getValue();
            if(n.isEmpty() || h==0)
            {
                throw new Exception(); //ik its a little hack but i already need the exception catch anyways
            }


            //to scale just add an array of first letter priority then make the end value of substring to indexOf(type)+1
            if (comboBox.getValue().substring(0, 1).equals("V") || comboBox.getValue().substring(0, 1).equals("v"))
            {
                hc = new Vampire(n, h, d, transformed.isSelected());
            } else if (comboBox.getValue().charAt(0) == 'Z' || comboBox.getValue().charAt(0) == 'z')
            {
                hc = new Zombie(n, h,d);
            } else if (comboBox.getValue().charAt(0) == 'W' || comboBox.getValue().charAt(0) == 'w')
            {
                hc = new Werewolf(n, h, d, transformed.isSelected());
            }

            /* Didn't work because it uses the same thread as the gui stuff.
            but i really want this bs progress bar to work so we will be trying multithreading
            for (int i = 1; i <= 100 ; i++) {progressBar.setProgress(i);    Thread.sleep(100);}
            */
            progressBar.progressProperty().unbind();
            Task<Void> bar = makeBar();
            Thread animateBar = new Thread(bar);
            progressBar.progressProperty().bind(bar.progressProperty()); //Associates progress bar with task progress
            animateBar.start();
            bar.setOnSucceeded(e -> {System.out.println("Success");
                                                     created.setText("Success");});
        }
        catch(Exception e)
        {
            created.setText("Error");
        }

        if (hc != null)
        {
            AppState.characters.add(hc);
        }


    }

    @FXML
    public void populateList() throws IOException
    {
        AppState.characters.add(new Vampire("Drac",120,LocalDate.now(),false));
        AppState.characters.add(new Werewolf("Wolfman",400,LocalDate.of(2005,7,11),false));
        AppState.characters.add(new Zombie("Zombieman",50, LocalDate.of(2000,1,1)));
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        comboBox.setItems(FXCollections.observableArrayList("Vampire", "Werewolf", "Zombie"));
        Image image = new Image(getClass().getResource("glorp.png").toExternalForm());
        imageView.setImage(image);

    }
}
