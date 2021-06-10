import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Write a description of class Game here.
 *
 * @Coombs
 * @version 2
 */
public class Game implements ActionListener
{
    
        private ArrayList<Ship> listOfShips = new ArrayList<Ship>();
        private int numOfGuesses = 0;
        private Scanner keyboard = new Scanner(System.in);
        private GameHelper helper = new GameHelper();
        JFrame frame= new JFrame();
        JPanel title_panel=new JPanel();
        JPanel button_panel=new JPanel();
        JButton[][] buttons=new JButton[7][7];
        JLabel title_text=new JLabel();
      Game(){
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800,800);
            frame.getContentPane().setBackground(new Color(50,50,50));
            frame.setLayout(new BorderLayout());
            frame.setVisible(true);
            
            title_text.setBackground(new Color(25,25,25));
            title_text.setForeground(new Color(25,255,0));
            title_text.setFont(new Font("Ink Free",Font.BOLD,75));
            title_text.setHorizontalAlignment(JLabel.CENTER);
            title_text.setText("BattleShip");
            title_text.setOpaque(true);
            
            title_panel.setLayout(new BorderLayout());
            title_panel.setBounds(0,0,800,100);
            
            button_panel.setLayout(new GridLayout(7,7));
            button_panel.setBackground(new Color(150,150,150));
            
             for (int i = 0; i < 7; i++) {
                 for (int j = 0; j < 7; j++) {
                    buttons[i][j] = new JButton();
                    button_panel.add(buttons[i][j], 7 * i + j);
                    buttons[i][j].setFont(new Font("MV Boli",Font.BOLD,50));
                    buttons[i][j].setFocusable(false);
                    buttons[i][j].addActionListener(this);
                }
    
             } 
            title_panel.add(title_text);
            frame.add(title_panel,BorderLayout.NORTH);
            frame.add(button_panel);
        
        }
        
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
       @Override
	public void actionPerformed(ActionEvent e) {
	   
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
    