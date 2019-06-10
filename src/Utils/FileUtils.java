/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Class.Car;
import Class.Client;
import Class.User;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gustavocavalcante
 */
public abstract class FileUtils {
    public static String PATH_USERS = "users.txt";
    public static String PATH_CARS = "cars.txt";
    public static String PATH_CLIENT = "clients.txt";
    //Binarios
    public static String PATH_USERS_BIN = "users.obj";
    public static String PATH_CARS_BIN = "cars.obj";
    public static String PATH_CLIENT_BIN = "clients.obj";
    
    public static boolean writeText(String path, List<String> lines) {
        File file = new File(path);
        try {
            BufferedWriter buffer = new BufferedWriter(new FileWriter(file, false));
            for(String line : lines) {
                buffer.write(line);
                buffer.write("\n");
            }
            
            buffer.flush();
            buffer.close();
            
            return true;
        }
        catch(Exception e) {
            System.err.println("Erro de escrita");
            return false;
        }
    }
    
    public static List<String> readText(String path) {
        List<String> list = new ArrayList<>();
        File file = new File(path);
        
        try {
            FileReader leitor = new FileReader(file);
            BufferedReader leitorbuffer = new BufferedReader(leitor);
            while (leitorbuffer.ready()) {
                list.add(leitorbuffer.readLine());
            }
            leitorbuffer.close();
        }
        catch(Exception e) {
            
        }
        
        return list;
    }
    
    
     public static boolean writeBin(String path, List<String> lines) {
        File file = new File(path);
        
        
        try{            
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            // escreve todos os produtos do registro no arquivo
            oos.writeObject(lines);

            // fecha o arquivo
            oos.flush();
            oos.close();     
            fos.close();  
            return true;
        }
        catch(IOException e)
        {
            System.err.println("Erro de escrita");
            return false;
        }
            
        
     }
    
    public static List<String> readBin(String path) throws ClassNotFoundException {
        List<String> list = new ArrayList<>();
        File file = new File(path);

        
        try{            
            FileInputStream fos = new FileInputStream(file);
            ObjectInputStream oos = new ObjectInputStream(fos);
            // Le toda a lista do registro no arquivo
            list = (List<String>) oos.readObject();
            
            // fecha o arquivo
            oos.close();     
            fos.close();  
            return list;
        }
        catch(IOException e)
        {
            System.err.println("Erro de leitura ou arquivo vazio");
            return list;
        }
      
        
    }
    
    
    
}
