import java.util.Date;

public class CargoShip extends Ship{
    private double maxCapacity;
    private double currentLoad;
    
    public CargoShip(){
        
    }
    
    public CargoShip(String name, int year,String imoNumber, double maxCapacity, double currentLoad){
        super(name,year,imoNumber);
        this.maxCapacity = maxCapacity;
        this.currentLoad = currentLoad;
    }
    
    public double getMaxCapacity(){
        return maxCapacity;
    }
    
    public double getCurrentLoad(){
        return currentLoad;
    }
    
    @Override
    public boolean requireCheck(){
        Date today = new Date();
        int currentYear = today.getYear();
        int shipAge = currentYear - getYear();
        int avalibleSpace = (int) Math.floor((maxCapacity/currentLoad)*100);
        
        if(shipAge < 20 && avalibleSpace < 75){
            return false;
        } 
        return true;
    }
    
    @Override
    public String getAvailableSpace(){
        double space = Math.round((maxCapacity - currentLoad)*100.0)/100.0;
        
        return String.format("%s: %f  gt",getName(), space);
    }
    
    @Override
    public String toString(){
        return String.format("%-11s %-6d %-13s %10.0f %25.0f",getName(), getYear(), getImoNumber(), maxCapacity, currentLoad);
    }
}