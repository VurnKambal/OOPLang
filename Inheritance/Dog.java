public class Dog extends Animal
{
    String dogName;
    
    public Dog(String color, int numOfLegs)
    {    
        super(color, numOfLegs);
        this.dogName = "PomPom";
    }
    
    public String getName()
    {
        return dogName;
    }
    
    public void setName(String name)
    {
        dogName = name;
    }
    
    public void showInfo()
    {
        System.out.println("Name: " + getName());
        super.showInfo();
    }
}