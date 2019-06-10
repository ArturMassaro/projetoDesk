/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Class.Car;
import Utils.FileUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gustavocavalcante
 */
public class CarController {
    private List<Car> mList;
    
    public CarController() {
        mList = loadCars();
    }
    
    public void reloadUsers() {
        mList = loadCars();
    }
    
    private List<Car> loadCars() {
        List<Car> datas = new ArrayList<>();
        List<String> lines;
        try {
            lines = FileUtils.readBin(FileUtils.PATH_CARS_BIN);
            for(String line : lines) {
            Car data = new Car(line);
            datas.add(data);
        }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CarController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return datas;
    } 
    
    private boolean saveCars() {
        List<String> lines = new ArrayList<>();
        for(Car data : mList) {
            lines.add(data.toString());
        }
        
        return FileUtils.writeBin(FileUtils.PATH_CARS_BIN, lines);
    }
    
    public List<Car> getCars() {
        return mList;
    }
    
    public boolean newCar(Car data) {
        mList.add(data);
        return this.saveCars();
    }
    
    public boolean editCar(Car data, int position) {
        mList.remove(position);
        mList.add(position, data);
        
        return this.saveCars();
    }
    
    public boolean removeCar( int position) {
        mList.remove(position);
        
        return this.saveCars();
    }
    
    public Car getCar(int position) {
        if(mList.size() > position) {
            return mList.get(position);
        }
        
        return null;
    }
}
