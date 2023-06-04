public class CruiseShip extends Ship{
    private int maxPassengers;
    private int numberPassengers; // Number of passengers currently on board
    
    public CruiseShip(){
        
    }
    
    public CruiseShip(String name, int year,String imoNumber,int maxPassengers, int numberPassengers){
        super(name,year,imoNumber);
        this.maxPassengers = maxPassengers;
        this.numberPassengers = numberPassengers;
    }
    
    public int getMaxPassengers(){
        return maxPassengers;
    }
    
    public int getNumberPassengers(){
        return numberPassengers;
    }
    
    @Override
    public boolean requireCheck(){
       return false;
    }
    
    @Override
    public String getAvailableSpace(){
        int space = (maxPassengers - numberPassengers);
        return String.format("%s: %d passengers",getName(),space);
    }
    
    @Override
    public String toString(){
        return String.format("%-11s %-6d %-13s %10d %25d",getName(), getYear(), getImoNumber(), maxPassengers, numberPassengers);
    }
}