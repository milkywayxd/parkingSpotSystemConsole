import java.util.*;
/**
 * Java class Car with methods to manage Car objects
 *
 * @author (Xiaodan Cao 2790866)
 * @version (1.0 17/04/2021)
 */
public class Car
{
    public String reg;
    public boolean staffCar;
    public String owner;
    public String ifStaff;

    /**
     * Constructor for objects of class Car
     */
    public Car(String newReg, String newOwner, boolean staffCar)
    {
     reg = newReg;
     owner = newOwner;
     staffCar = true;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getReg()
    {
        return reg;
    }
    
    public void setReg(String reg)
    {
        this.reg = reg;
    }
    
    public String getOwner()
    {
        return owner;
    }
    public void setOwner(String owner)
    {
       this.owner = owner;
    }
    
    public String getIfStaff()
    {
        return ifStaff;
    }
    
    public boolean staffCar(String ifStaff)
    {  
       //String str = ifStaff;
       //if (str.matches("Y")) 
       if (ifStaff == "Y")
       {
           return true;  
       }
       else 
       {           
           return false;
       }
    }
    public String toString()
    {
        if (staffCar = true)
        {
            return "Car registration "+ reg + "Owner is" + owner + "Staff";
    
        }
        else
        
        {
            return "Car registration "+ reg + "Owner is" + owner; 
        }
    
     }

}
