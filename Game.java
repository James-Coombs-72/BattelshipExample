import java.util.Scanner;
import java.util.ArrayList;
/**
 * Write a description of class Game here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Game{
    
    private ArrayList<Ship> listOfShips = new ArrayList<Ship>();
    private int numOfGuesses = 0;
    private Scanner keyboard = new Scanner(System.in);
    private GameHelper helper = new GameHelper();
    
    private void setUpGame(){
        Ship shipOne = new Ship();
        shipOne.setName("SS Botany Bay");
        Ship shipTwo = new Ship();
        shipTwo.setName("SS Millenium");
        Ship shipThree = new Ship();
        shipThree.setName("SS Firefly");
        
        
        listOfShips.add(shipOne);
        listOfShips.add(shipTwo);
        listOfShips.add(shipThree);
        
        System.out.println("Your goal is to sink three ships.");
        System.out.println("Try to sink them in the fewest guesses.");
        
        for(Ship ship : listOfShips){
            ArrayList<String> location = helper.placeShip(3);//We could Randomly genrate the size
            ship.setLocationCells(location);
        }
    }
    
    private void startPlaying(){
        while (!listOfShips.isEmpty()){
         String userGuess = getUserInput();
         checkUserGuess(userGuess);
        }
        finishGame();
    }
    
    private void checkUserGuess(String userGuess){
        numOfGuesses++;
        String result="miss";
        for (Ship ship : listOfShips){
            result = ship.checkYourself(userGuess);
            if(result.equalsIgnoreCase("hit")){
                break;
            }
            if(result.equalsIgnoreCase("kill")){
                listOfShips.remove(ship);
                break;
            }
        }
        System.out.println(result);
    }
    
    private void finishGame(){
     System.out.println("All Ships have been sunk!");
     if (numOfGuesses <= 18){
         System.out.println("It only took you " + numOfGuesses + " guesses.");
         System.out.println("Wow!  Thats impressive Admiral.");
        }else{
            System.out.println("With a score like "+ numOfGuesses + " guesses.");
            System.out.println("I wouldn't get my hope up for professional career.");
        }
    }
    
    private String getUserInput(){
            String guess = keyboard.nextLine();
            return guess;
        }
    
    public static void main(String[] args){
      Game game = new Game();
      game.setUpGame();
      game.startPlaying();
      
    }
}
    