import java.util.ArrayList;
/**
 * Write a description of class GameHelper here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GameHelper
{
    private static final String alphabet ="abcdefg";
    private int gridLength = 7;
    private int gridSize = 49;
    private int [] grid = new int[gridSize];
    private int shipCount = 0;
    
    ArrayList<String> placeShip(int shipSize){
        ArrayList<String> alphaCells = new ArrayList<String>();
        String[] alphacoords = new String[shipSize];
        String temp = null;
        int[] coords= new int[shipSize];
        int attempts = 0;
        boolean success = false;
        int location = 0;
        
        shipCount++;
        int incr= 1;
        if((shipCount % 2) ==1){
            incr = gridLength;
        }
        
        while(!success & attempts++ <200){
            location = (int) (Math.random()*gridSize);
            int x = 0;
            success = true;
            while(success && x < shipSize){
                if(grid[location] == 0){
                    coords[x++] = location;
                    location += incr;
                    if(location >= gridSize){
                        success= false;
                    }
                    if(x>0 && (location %gridLength == 0)){
                        success = false;
                    }
                }else{
                    success = false;
                }
            }
        }
        int x= 0;
        int row= 0;
        int column =0;
        while(x<shipSize){
            grid[coords[x]]=1;
            row = (int)(coords[x] / gridLength);
            column= coords[x] % gridLength;
            temp = String.valueOf(alphabet.charAt(column));
            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;
        }
        return alphaCells;
                }
                
            
}
