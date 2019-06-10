/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import Interface.ModelDataBase;

/**
 *
 * @author gustavocavalcante
 */
public class Car implements ModelDataBase {
    private String Name;
    private String Color;
    private String Year;
    private String Model;
    
    public Car(String name, String color, String year, String model) {
        this.Name = name;
        this.Color = color;
        this.Year = year;
        this.Model = model;
    }
    
    public Car(String lineString) {
        String data[] = lineString.split(";");
        
        this.Name = data[0];
        this.Color = data[1];
        this.Year = data[2];
        this.Model = data[3];
    }

    @Override
    public String toString() {
        return this.Name + ";" + this.Color + ";" + this.Year + ";" + this.Model;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the Color
     */
    public String getColor() {
        return Color;
    }

    /**
     * @param Color the Color to set
     */
    public void setColor(String Color) {
        this.Color = Color;
    }

    /**
     * @return the Year
     */
    public String getYear() {
        return Year;
    }

    /**
     * @param Year the Year to set
     */
    public void setYear(String Year) {
        this.Year = Year;
    }

    /**
     * @return the Model
     */
    public String getModel() {
        return Model;
    }

    /**
     * @param Model the Model to set
     */
    public void setModel(String Model) {
        this.Model = Model;
    }
    
    
    public String getQuery(String exec){
        
        if(exec.equals("insert")){
            return "INSERT INTO Car";
        }
        return null;
    }

    @Override
    public String getUpdateQuery() {
        return "asd";
    }

    @Override
    public String getInsertQuery() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
