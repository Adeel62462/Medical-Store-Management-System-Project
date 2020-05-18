
import DBHandling.DBHandler;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;


public class DataFiller {
    public static DefaultComboBoxModel<String> insertNamesIntoComboBox(){
        DBHandler db = new DBHandler();
        ArrayList<String> data = db.getMedicinesName();
        int size = data.size();
        String[] names = new String[size];
        for(int i=0;i<size;i++)
            names[i] = data.get(i);
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel <>(names);
        return model;
    }
}
