/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Class.User;
import Utils.FileUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gustavocavalcante
 */
public class UserController {
    private List<User> mList;
    
    public UserController() {
        mList = loadUsers();
    }
    
    public void reloadUsers() {
        mList = loadUsers();
    }
    
    private List<User> loadUsers() {
        List<User> users = new ArrayList<>();
        List<String> usersLines;
        try {
            usersLines = FileUtils.readBin(FileUtils.PATH_USERS_BIN);
            for(String line : usersLines) {
            User user = new User(line);
            users.add(user);
        }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return users;
    } 
    
    private boolean saveUsers() {
        List<String> usersLines = new ArrayList<>();
        for(User user : mList) {
            usersLines.add(user.toString());
        }
        
        return FileUtils.writeBin(FileUtils.PATH_USERS_BIN, usersLines);
    }
    
    public List<User> getUsers() {
        return mList;
    }
    
    public boolean newUser(User user) {
        mList.add(user);
        return this.saveUsers();
    }
    
    public boolean editUser(User user, int position) {
        mList.remove(position);
        mList.add(position, user);
        
        return this.saveUsers();
    }
    
    public boolean removeUser( int position) {
        mList.remove(position);
        
        return this.saveUsers();
    }
    
    public User getUser(int position) {
        if(mList.size() > position) {
            return mList.get(position);
        }
        
        return null;
    }
}
