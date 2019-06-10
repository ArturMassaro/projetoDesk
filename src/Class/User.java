/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author gustavocavalcante
 */
public class User {
    private String name;
    private String login;
    private String password;
    
    public User(String name, String login, String pass){
        this.name = name;
        this.login = login;
        this.password = pass;
    }
    
    public User(String lineString) {
        String data[] = lineString.split(";");
        
        this.name = data[0];
        this.login = data[1];
        this.password = data[2];
    }

    public User() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String toString() {
        return this.name + ";" + this.login + ";" + this.password;
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
