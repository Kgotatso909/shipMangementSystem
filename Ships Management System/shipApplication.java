import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class shipApplication{
    private static Ship[] ships;
    
    public static void main(String[] args) {
        ships = readFile("ships.txt");

  
        System.out.println("List of Ships");
        String display = String.format("%-11s %-6s %-13s %-20s %s", "name", "year", "IMO number", "Max Load/Passengers", "Curreny load/passengers");
        System.out.println(display);
        for (Ship e : ships) {
            if (e != null) {
                System.out.println(e.toString());
            }
        
        }
    }

    
    private static Ship[]  readFile(String filename){
        ships = new Ship[25];
        int index = 0;
        
        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            while((line = br.readLine()) != null && index < 25){
                String[] values = line.split(",");
                
                String imoNumber = values[2];
                String firstDigit = imoNumber.substring(4,5);
                
                if(firstDigit.matches("[5-9]+")){
                    String name = values[0];
                    int year = Integer.parseInt(values[1]);
                    double maxCapacity = Double.parseDouble(values[3]);
                    double currentLoad = Double.parseDouble(values[4]);
                    CargoShip cargoShip = new CargoShip(name,year,imoNumber, maxCapacity,currentLoad);
                    ships[index] = cargoShip;
                    index++;
                }else if(firstDigit.matches("[0-4]+")){
                    String name = values[0];
                    int year = Integer.parseInt(values[1]);
                    int maxPassengers =  Integer.parseInt(values[3]);
                    int numberPassengers = Integer.parseInt(values[4]);
                    CruiseShip cruiseShip= new CruiseShip(name,year,imoNumber,maxPassengers, numberPassengers);
                    ships[index] = cruiseShip;
                    index++;
                }else {
                    System.out.print("Invalid IMO Number");
                }
            }
        }catch(FileNotFoundException e){
            System.out.println("File was not found"+ filename);
        }catch(IOException e){
            System.out.println("Access denied");
        }catch(Exception e){
            System.out.println("Something went wrong");
        }
        return ships;
    }
}
