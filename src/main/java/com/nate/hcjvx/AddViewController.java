package com.nate.hcjvx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;

public class AddViewController implements Initializable
{
    @FXML
    private void switchToAddView() throws IOException
    {
        App.setRoot("listView");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }
}
