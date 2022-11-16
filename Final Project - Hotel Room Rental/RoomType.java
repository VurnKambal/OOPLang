 

public class RoomType
{
    private String label;
    private String[] services;
    private double price;
    
    public RoomType(String label, String[] services)
    {
        this.label = label;
        this.services = services;
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
    
    
    public String[] getServices()
    {
        return this.services;
    }
    
    public void setServices(String[] services)
    {
        this.services = services;
    }
    
}
