package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class Controller {
    @FXML
    private TextField name, memory, model, harddisk, predate, test1;
    private char character;
    private ArrayList<String> arr ;
    private String adder = "" ;

    //private String hell [];
    public Controller() {
        arr = new ArrayList<String>();
    }

    public void addData(ActionEvent actionEvent) { // Save Button !
        try {
            //file location
            FileWriter output = new FileWriter("D:\\Collage\\Summer2020\\DataBase\\test.txt", true);
            //BufferedWriter printWriter = new BufferedWriter(output);
            if (name.getText().isEmpty() || memory.getText().isEmpty() || model.getText().isEmpty() || harddisk.getText().isEmpty() || predate.getText().isEmpty() || test1.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all TextFields!!");
            } // all TextFields must not be empty !
            else {

                output.write(name.getText() + ",");
                output.write(model.getText() + ",");
                output.write(memory.getText() + ",");
                output.write(harddisk.getText() + ",");
                output.write(predate.getText() + ",");
                output.write(test1.getText());
                output.write("\n");

                name.clear(); // for clearing all fields!
                model.clear();
                memory.clear();
                harddisk.clear();
                predate.clear();
                test1.clear();
                output.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readFile() {
        try {
            File file = new File("test.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String s = scanner.next();
                String[] tokens = s.split(",");
                if (tokens[0].equalsIgnoreCase(name.getText())) {
                    model.setText(tokens[1]);
                    memory.setText(tokens[2]);
                    harddisk.setText(tokens[3]);
                    predate.setText(tokens[4]);
                    test1.setText(tokens[5]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void Search(ActionEvent actionEvent) {
        if (name.getText().isEmpty())
            JOptionPane.showMessageDialog(null, "Cannot update please put a name !");
        else {
            readFile();
        }
    }

    public void deleteData() {
        if (name.getText().isEmpty())
            JOptionPane.showMessageDialog(null, "Cannot update please put a name !");
        else{
            try {
                File file = new File("test.txt");
                Scanner scanner = new Scanner(file);

                while (scanner.hasNext()) {
                    String s = scanner.next();
                    String[] tokens = s.split(",");
                    if (tokens[0].equalsIgnoreCase(name.getText())) {
                        System.out.println("Name found");
                    }
                    else {
                        for (String token : tokens) {
                            adder = adder + token +",";
                        }
                        arr.add(adder);
                        adder = "" ;
                    }


                } // re-add after deleting everything
                FileWriter output = new FileWriter("D:\\Collage\\Summer2020\\DataBase\\test.txt");
                for (String c : arr){
                    output.write(c);
                    output.write("\n");
                }
                output.close();
                arr.clear();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void updateData(ActionEvent actionEvent) {
        if (name.getText().isEmpty())
            JOptionPane.showMessageDialog(null, "Cannot update please put a name !");
        else {

            try {

                File file = new File("test.txt");
                Scanner scanner = new Scanner(file);

                while (scanner.hasNext()) {
                    String s = scanner.next();
                    String[] tokens = s.split(",");
                    if (tokens[0].equalsIgnoreCase(name.getText())) {
                        System.out.println("Name found");
                    }
                    else {
                        for (String token : tokens) {
                            adder = adder + token +",";
                        }
                        arr.add(adder);
                        adder = "" ;
                    }
                }

                FileWriter output = new FileWriter("D:\\Collage\\Summer2020\\DataBase\\test.txt" );
                output.write(name.getText() + ",");
                output.write(model.getText() + ",");
                output.write(memory.getText() + ",");
                output.write(harddisk.getText() + ",");
                output.write(predate.getText() + ",");
                output.write(test1.getText());
                output.write("\n");


                for (String c : arr){
                    output.write(c);
                    output.write("\n");
                }

                arr.clear();
                output.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
// end of class controller !!

