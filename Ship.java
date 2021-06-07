import java.util.ArrayList;

/**
 * Write a description of class Ship here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ship
{
   private ArrayList<String> locationCells;
   private String name;
   
   public String checkYourself(String stringGuess){
       String result = "miss";
       int index = locationCells.indexOf(stringGuess);
       if(index >= 0){
           locationCells.remove(index);
           if(locationCells.isEmpty()){
               result = "kill";
            }else{
               result = "hit";
            }
        } 
        return result;
    }
    public void setLocationCells(ArrayList<String> locations){ //setter for location cells
        this.locationCells = locations;
    }
    void setName (String name){
        this.name = name;
    }
}
       