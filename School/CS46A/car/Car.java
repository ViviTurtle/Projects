
   // A car can drive and consume fuel. 

public class Car 
{ 
   private double gasInTank;
   private double milesDriven;
   private double efficiency;
   private double gasConsumed;
   /** 
      Constructs a car with a given fuel efficiency. 
      @param anEfficiency the fuel efficiency of the car 
   */ 
   public Car(double anEfficiency) 
   {
      gasInTank = 0;
      milesDriven = 0;
      efficiency = anEfficiency;
   }

   /** Adds gas to the tank. 
       @param amount the amount of fuel to add 
   */ 

   public void addGas(double amount) 
   { 
      gasInTank = gasInTank + amount;
   } 
   /** 
       Drives a certain amount, consuming gas. 
       @param distance the distance driven 
   */ 
   public void drive(double distance) 
   { 
    
      milesDriven = milesDriven + distance;
      
   } 
    /** 
       Gets the amount of gas left in the tank. 
       @return the amount of gas 
   */ 
   public double getGasInTank() 
   { 
      double gasConsumed = milesDriven / efficiency;  
      return gasInTank-gasConsumed;  
   }  
   /** 
       Gets the total miles driven by this car. 
       @return the miles driven
   */ 
   public double getMilesDriven() 
   { 
      return milesDriven;
   }
}

