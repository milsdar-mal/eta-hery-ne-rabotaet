package com.example.demo;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;

public class HelloController {
    @FXML
    private TableView<stroka> tabletka;
    @FXML
    private TextField fileName;

    public static class stroka {
        public String a;
        public TextArea b = new TextArea();
        private stroka(String a, String b) {
            this.a = a;
            this.b.setText(b);
        }
        public String getA() {return this.a;}
        public TextArea getB() {return this.b;}
    }

    @FXML
    protected void Zapolnenie() {
        try {
            File file = new File(fileName.getText());
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            int i = 0;
            String j;
            while (line != null) {
                j = Integer.toString(i);
                tabletka.getItems().add(i, new stroka(j,line));
                line = reader.readLine();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void Ochishenie() {
        tabletka.getItems().clear();
    }
}