/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 

public class Extra {
    
    private String label;
    private double price;
 
    public Extra(String label, double price)
    {
        this.label = label;
        this.price = price;
    }
       
    public String getLabel()
    {
        return this.label;
    }
    
    public void setLabel(String label)
    {
        this.label = label;
    }
    
    public double getPrice()
    {
        return this.price;
    }
    
    public void setPrice(double price)
    {
        this.price = price;
    }
    
}
