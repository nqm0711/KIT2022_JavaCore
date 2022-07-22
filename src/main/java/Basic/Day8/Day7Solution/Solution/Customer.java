/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 

/**  
 *
 * @author Hung
 */
public class Customer { 
    private String name;
    private String address;
  public Customer (String n, String c){
      name=n;address=c;
  }  
    public String getName() {
        return name;
    } 
    public void setName(String name) {
        this.name = name;
    } 
    public String getCity() {
        return address;
    }
 
    public void setCity(String address) {
        this.address = address;
    }
    @Override
    public String toString(){
        return "Customer Name: " + name+" Address: "+ address;
    }
}
