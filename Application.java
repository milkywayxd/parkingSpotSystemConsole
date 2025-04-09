import java.util.*;
import java.io.*;


/**
 * Console interface including the main()method and handling all inputs and
 * outputs.
 * @author (Xiaodan Cao)
 * @version (1.0) 16/04/2021
 */
public class Application
{
     public static Scanner sc = new Scanner(System.in);
     public static CarPark cp = new CarPark();
     public static String slotId;
     public static ParkingSlot ps = new ParkingSlot(slotId, true, false, "null", "null", true);
     public static String reg;
     public static String owner;
     public static Car car = new Car(reg,"null",true);
     public static int option; 
     public static int indexS;
     public static int indexV;
     public static boolean newslotIfStaff;
    /**
     * Constructor for objects of class Application
     */
    public Application()
    {
        // initialise instance variables
        
    }

    /**
     * This is the main()method and handling all inputs and outputs.
     *
     * @param  null
     * @return null
     */
    
    public static void displayMenu()
    {
       System.out.println("1: List all car slots");
       System.out.println("2: Park a car");
       System.out.println("3: Find a car");
       System.out.println("4: Remove a car");
       System.out.println("5: Add a car slot");
       System.out.println("6: Delete a car slot");
       System.out.println("7: Exit");
       System.out.println("Please select an option (1-7)");
    
    }
    

    public static void main(String[] args)
    {
       System.out.println("Start to establish a car parking with slots for staff and visitors");
       System.out.println("Please enter the number of slots for staff:");
       indexS = sc.nextInt();
       System.out.println("Please enter the number of slots for visitors");
       indexV = sc.nextInt();
       System.out.println("The " + indexS + " slots for staff are created successfully");
       System.out.println("The " + indexV + " slots for vistors are created successfully");
       cp.initialCarPark(indexS,indexV);
    do {
           
       displayMenu();
       option = sc.nextInt();
       
       
       switch(option)
       {
           case 1: listSlots(indexS,indexV); break;
           case 2: parkCar(); break;
           case 3: findCar(); break;
           case 4: removeCar(); break;
           case 5: addSlot(); break;
           case 6: deleteSlot(); break;
           case 7: System.exit(0); break;
           default:
           System.out.println();
           System.out.println("Please enter a valid option 1 to 7.");
        }
       
    }
   
    while(option != 7);
      
    }
    
    public static void listSlots(int indexS ,int indexV)
    {
         cp.printSlot();
    }
    
    public static void parkCar()
    {
       Scanner a = new Scanner(System.in);
       System.out.println("Please enter slot ID");
       slotId = a.nextLine();
       System.out.println("Please enter car registration");
       reg = a.nextLine();
       System.out.println("Please enter owner's name");
       owner= a.nextLine().trim();
       System.out.println(slotId);
       System.out.println(reg);
       System.out.println(owner);
       System.out.println("Enter\"Y\" if the owner is staff, Enter\"N\" if the owner is not staff");
       String input = a.nextLine();
       boolean carIfStaff = car.staffCar(input);
       boolean slotIfStaff = ps.isStaff(slotId);
       ParkingSlot ps = new ParkingSlot(slotId, slotIfStaff, true, reg, owner,carIfStaff);
       if (ps.slotId.matches("[A-Z]\\d\\d\\d") && ps.reg.matches("[A-Z]\\d\\d\\d\\d\\d"))
       {
        int i;
        for(i=0; i<cp.slotList.size(); i++ )
        {
            String searchsid = cp.slotList.get(i).slotId; 
            if (searchsid.equals(slotId))
            {
                 break;
            }
        }
        
        System.out.println(i);
        cp.slotList.set(i,ps);                     
        System.out.println("SlotID: " + ps.slotId +", is occupied by " + ps.reg);
       }
       
       else { System.out.println("Please enter correct information");}
    }  
    
    public static void findCar()
    {
       Scanner b = new Scanner(System.in);
       System.out.println("Please enter car registration number");
       String reg1= b.nextLine().trim();
       if (reg1.matches("[A-Z]\\d\\d\\d\\d\\d") )
       {
           
            int j;
            for(j=0; j<cp.slotList.size(); j++ )
                {
                    String searchreg = cp.slotList.get(j).reg; 
                    if (searchreg.equals(reg1))
                    {
                     break;
                    }
                }
            String carslotid = cp.slotList.get(j).slotId;
            String carowner =  cp.slotList.get(j).owner;        
            System.out.println("Car found. SlotID: " + carslotid + " Car Owner: " + carowner);
                
           }
        else
           {
              System.out.println("Car not found. ");
            }
       }       
      
       public static void removeCar()
       {   
           Scanner d = new Scanner(System.in);
           System.out.println("Please enter car registration number");
           String reg2 = d.nextLine().trim();
           if (reg2.matches("[A-Z]\\d\\d\\d\\d\\d"))
           {
                int k;
                for(k=0; k<cp.slotList.size(); k++ )
                {
                    String searchreg = cp.slotList.get(k).reg; 
                    if (searchreg.equals(reg2))
                    {
                     break;
                    }
                }
                
                String removecarslotid = cp.slotList.get(k).slotId;
                boolean removecarisStaff = cp.slotList.get(k).isStaff;
                boolean removecarstaffCar = cp.slotList.get(k).staffCar;
                               
                ParkingSlot removecar = new ParkingSlot(removecarslotid, removecarisStaff, false, "null", "null",removecarstaffCar);
                
                cp.slotList.set(k,removecar);
                
                System.out.println("Car found Removed. SlotID: " + removecarslotid + " Car Reg: " + reg2);
                
           }
        else
           {
              System.out.println("Please enter a valid car reg number. ");
            }
        }
       
        
        public static void addSlot()
        {
           Scanner d = new Scanner(System.in);
           System.out.println("Please enter slot ID");
           String newslotId = d.nextLine();
           System.out.println("Please enter S for staff or V for vistor");
           String slotowner = d.nextLine();
           
           if (slotowner == "S")
           {
                newslotIfStaff = true;
           }
            else
           {
                newslotIfStaff = false;
           } 
           
           ParkingSlot newps = new ParkingSlot(newslotId, newslotIfStaff, false, "null", "null",true);
           if (newps.slotId.matches("[A-Z]\\d\\d\\d"))
            {
            cp.slotList.add(newps);                     
            System.out.println("SlotID: " + newslotId +", is added");
            }
       
           else { System.out.println("Please enter correct information");}
        } 
        
        
        public static void deleteSlot()
        {
            Scanner e = new Scanner(System.in);
            System.out.println("Please enter slot ID:");
            String deleteslotid= e.nextLine().trim();
            if (deleteslotid.matches("[A-Z]\\d\\d\\d") )
               {
                    int z;
                    for(z=0; z<cp.slotList.size()-1; z++ )
                        {
                            String searchdeleteslotid = cp.slotList.get(z).reg; 
                            if (searchdeleteslotid.equals(deleteslotid))
                            {
                                 break;
                            }
                        }
                    boolean deleteslotOccupied = cp.slotList.get(z).isOccupied;
                    boolean deleteisStaff = cp.slotList.get(z).isStaff; 
                    boolean deletestaffCar = cp.slotList.get(z).staffCar;
                    String deletereg = cp.slotList.get(z).reg;
                    String deleteowner = cp.slotList.get(z).owner; 
                    ParkingSlot deleteps = new ParkingSlot(deleteslotid, deleteisStaff, deleteslotOccupied, deletereg, deleteowner,deletestaffCar);
                    
                    
                    if (deleteslotOccupied)
                    {
                        System.out.println("SlotID: " + deleteslotid + " is occupied and can not be removed." );
                    }
                    else
                    {
                        cp.slotList.remove(z);
                        System.out.println("SlotID: " + deleteslotid + " has been removed." );
               }
            }
       
           else { System.out.println("Please enter correct information");}
        } 
}

