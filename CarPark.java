import java.util.*;
/**
 * Class CarPark is designed for maintaining a list of available parking slots.
 *
 * @author (Xiaodan Cao 2790866)
 * @version (1.0 16/04/2021)
 */
public class CarPark
{
    public ArrayList<ParkingSlot> slotList;
    public String slotId;
    ParkingSlot ps;
    public int index1;
    public int index2;
    public String people;
    public String status;
    public String slid;
    /**
     * Constructor for objects of class CarPark
     */
    public CarPark()
    {
        slotList = new ArrayList<ParkingSlot>();
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void addSlot(ParkingSlot ps)
    {
        slotList.add(ps);
        
    }
  
    public void initialCarPark(int indexA, int indexB)
    {
        String s = "S";
        String v = "V";
        int a = 0;
        for (int i= 0; i<indexA; i++)
        {
            String zeroa = String.format("%03d", a);
            String SslotId = s + zeroa;
            ps = new ParkingSlot(SslotId, true, false, "null", "null", true);
            slotList.add(ps);   
            a = a + 1;
        }
        int b = 0;
        for (int j= 0; j<indexB; j++)
        {
            String zerob = String.format("%03d", b);
            String VslotId = v + zerob;
            ps = new ParkingSlot(VslotId, false, false, "null", "null", false);
            slotList.add(ps);   
            b = b + 1;
        }
        
    
    }
    
    public ArrayList<ParkingSlot> getSlotList()
    {
         return slotList;
    }
    
    public void printSlot()
    {
        for (ParkingSlot x : slotList) 
        {
          slid=x.slotId;
          
          if (x.isStaff)
            {
               people = "staff";
            }
          else
            {
                people = "visitor";
            }
            
          if (x.isOccupied)
            {
               status = "Occupied";
            }
          else
            {
                status = "not Occupied";
            }
          
          System.out.println("SlotID: " + slid + ", is for " + people + ", and is " + status);
        }
    }

    
    public void deleteSlot(int slotIndex, boolean isOccupied)
    
    { if(isOccupied = false)
        {
          slotList.remove(slotIndex);
          System.out.println("Parking slot deleted");
        }
        
      else
      {
        System.out.println("Parking slot is occupied, can not delete.");
        }
    
    
    }
    
    //public void printList(int intS, int intV)
    //{
    //    index1 = intS;
    //    index2 = intV;
     //   String s = "S";
    //    int idIndex = 000;
     //   slotId = s + idIndex;
     //   for(int i1=0; i1< index1; i1++)
    //    {
      //      idIndex = idIndex + 1;
     //       System.out.println(slotList.get(i1));
     //   }
      //  String v = "V";
     //   slotId = v + idIndex;
       // for(int i2=0; i2< index2; i2++)
//        {    
      //      idIndex = idIndex + 1;
      //      System.out.println(slotList.get(i2));
       // }
    //}
}
