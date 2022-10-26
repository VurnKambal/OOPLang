public class Animal
{
    String color;
    int numOfLegs;

    
    public Animal(String color, int numOfLegs)
    {
        setColor(color);
        setNumOfLegs(numOfLegs);
    }
    
    public Animal()
    {
        this("Black", 4);
    }
    
    /*
    public Animal(String color)
    {
        this(color, 4);
    }
    
    public Animal(int numOfLegs)
    {
        this("Black", numOfLegs)
    }
    */
    
    // Get Color
    public String getColor()
    {
        return color;
    }
    
    // Set Color
    public void setColor(String color)
    {
        this.color = color;
    }
    
    
    // Get Number of Legs
    public int getNumOfLegs()
    {
        return numOfLegs;
    }
    
    // Set Number of Legs
    public void setNumOfLegs(int numOfLegs)
    {
        this.numOfLegs = numOfLegs;
    }
    
    
    public void showInfo()
    {
        System.out.println("Color: " + getColor());
        System.out.println("Number of Legs: " + getNumOfLegs());
    }
}

