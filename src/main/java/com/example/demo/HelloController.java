package com.example.demo;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.*;

public class HelloController {
    @FXML
    private TableView<stroka> tabletka;
    @FXML
    private TextField fileName;

    public static class stroka {
        private final SimpleStringProperty id;
        private final SimpleStringProperty value;

        private stroka(String fName, String lName) {
            this.id = new SimpleStringProperty(fName);
            this.value = new SimpleStringProperty(lName);
        }

        public stroka(SimpleStringProperty id, SimpleStringProperty value) {
            this.id = id;
            this.value = value;
        }
    }
    @FXML
    protected void Zapolnenie() {
        //ArrayList<String> arrayList = new ArrayList<>();
        try {
            File file = new File(fileName.getText());
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            int i = 0;
            String j = "0";
            while (line != null) {
                System.out.println(line);
                j = Integer.toString(i);
                tabletka.getItems().add(i, new stroka(j,line));
                ObservableList<stroka> data = tabletka.getItems(); // получаем данные
                data.add(new stroka(j, line)); // добавляем строку
                // считываем остальные строки в цикле
                line = reader.readLine();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}