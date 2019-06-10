/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Class.Client;
import Utils.FileUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gustavocavalcante
 */
public class ClientController {
    private List<Client> mList;
    
    public ClientController() {
        mList = loadClients();
    }
    
    public void reloadUsers() {
        mList = loadClients();
    }
    
    private List<Client> loadClients() {
        List<Client> datas = new ArrayList<>();
        List<String> lines;
        try {
            lines = FileUtils.readBin(FileUtils.PATH_CLIENT_BIN);
            for(String line : lines) {
            Client data = new Client(line);
            datas.add(data);
        }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return datas;
    } 
    
    private boolean saveClients() {
        List<String> lines = new ArrayList<>();
        for(Client data : mList) {
            lines.add(data.toString());
        }
        
        return FileUtils.writeBin(FileUtils.PATH_CLIENT_BIN, lines);
    }
    
    public List<Client> getClients() {
        return mList;
    }
    
    public boolean newClient(Client data) {
        mList.add(data);
        return this.saveClients();
    }
    
    public boolean editClient(Client data, int position) {
        mList.remove(position);
        mList.add(position, data);
        
        return this.saveClients();
    }
    
    public boolean RemoveClient(int position) {
        mList.remove(position);
        
        return this.saveClients();
    }
    
    public Client getClient(int position) {
        if(mList.size() > position) {
            return mList.get(position);
        }
        
        return null;
    }
}
