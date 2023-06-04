public abstract class Ship implements Shipable{
    private String name;
    private int year;
    private String imoNumber;
    
    public Ship(){
        
    }
    
    public Ship(String name, int year,String imoNumber ){
        this.name = name;
        this.year = year;
        this.imoNumber = imoNumber;
    }
    
    public String getName(){
        return name;
    }
    
    public int getYear(){
        return year;
    }
    
    public String getImoNumber(){
        return imoNumber;
    }
    
    public abstract String getAvailableSpace();
    
    public abstract boolean requireCheck();
    
}