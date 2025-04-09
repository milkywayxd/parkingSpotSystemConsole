 import java.util.*;
/**
 * class ParkingSlot with method is designed to manage parking slots.
 *
 * @author (Xiaodan Cao 2790866)
 * @version (1.0 16/04/2021)
 */
public class ParkingSlot
{
    public String slotId;
    public String slotForS;
    public String slotForV;
    public boolean isStaff;
    public Car car;
    public boolean isOccupied;
    public String reg;
    public boolean staffCar;
    public String owner;

    /**
     * Constructor for objects of class ParkingSlot
     */
    public ParkingSlot(String newSlotId, boolean newisStaff, boolean newisOccupied, String newReg, String newOwner, boolean newstaffCar)
    {
       slotId = newSlotId;
       isStaff = newisStaff;
       isOccupied = newisOccupied;  
       reg = newReg;
       owner = newOwner;
       staffCar = newstaffCar;

    }

    /**
     * 
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getSlotId()
    {
        return slotId; 
    }
    
    public void setSlotId(String slotId)
    {
        this.slotId =slotId;
    }
    
    public Car getCar()
    {
        return car; 
    }
    
    public void setCar(Car car)
    {
        this.car = car;
    }
    
    public boolean isStaff(String slotId)
    {
        if (slotId.charAt(0) == 'S')
        {
            return true;    
        }
        else 
        { 
            return false;
        }

    }
    
    public boolean isOccupied(String slot)
    {
        if (slotId.matches(slot))
        
        {    
             return true;
        }
        else
        {
            return false;
        }

    }
    
    
    public void removeCar(Car car, String slotId)
    {
       System.out.println(car +" has been removed from Parking Slot "+ slotId);
    }
    
    public void Occupied(String newId)
    {
        System.out.println("Parking slot"+ newId +" is occupied.");
    }
    
    
    public String toString()
    {
        if (isStaff = true && isOccupied == false)
        {
           return "Slot ID is: " + slotId +", is for staff, and is not occupied"; 
        }
        
        else if (isStaff = true && isOccupied == true)
        {
           return "Slot ID is: " + slotId +", is for staff, and is occupied"; 
        }
        else if (isStaff = false && isOccupied == false)
        {
           return "Slot ID is: " + slotId +", is for vistor, and is not occupied"; 
        }
        else isStaff = false && isOccupied == true;
        {
           return "Slot ID is: " + slotId +", is for vistor, and is occupied"; 
        }
    
    }

}   

