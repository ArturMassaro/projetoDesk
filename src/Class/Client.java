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
public class Client {
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private String email;
    
    public Client(String fName, String lName, String address, String phone, String email) {
        this.firstName = fName;
        this.lastName = lName;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
    
    public Client(String lineString) {
        String data[] = lineString.split(";");
        
        this.firstName = data[0];
        this.lastName = data[1];
        this.address = data[2];
        this.phone = data[3];
        this.email = data[4];
    }

    @Override
    public String toString() {
        return this.firstName + ";" + this.lastName + ";" + this.address + ";" + this.phone + ";" + this.email;
    }
    

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
