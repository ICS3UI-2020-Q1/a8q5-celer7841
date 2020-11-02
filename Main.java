import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;

  JLabel instructions;
  JLabel result;

  JTextField input;

  JButton submitButton;
  JButton newButton;

  Random rand = new Random();

  int randInt = rand.nextInt (100) + 1;
  


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);

    
    mainPanel = new JPanel();
    
    mainPanel.setLayout(null);

    instructions = new JLabel("Guess the number between 0 and 100");
    instructions.setBounds(20, 20, 300, 20);
    result = new JLabel();
    result.setBounds(20, 110, 300, 20);

    input = new JTextField();
    input.setBounds(20, 50, 280, 20);

    submitButton = new JButton("Submit");
    submitButton.setBounds(20, 90, 100, 20);
    newButton = new JButton("New Number");
    newButton.setBounds(150, 90, 150, 20);

    submitButton.addActionListener(this);
    newButton.addActionListener(this);

    submitButton.setActionCommand("submit");
    newButton.setActionCommand("new");

    mainPanel.add(submitButton);
    mainPanel.add(newButton);

    mainPanel.add(input);

    mainPanel.add(instructions);
    mainPanel.add(result);

    frame.add(mainPanel);

 
    

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    if(command.equals("submit")){
      String inputText = input.getText();
      int inputInt = Integer.parseInt(inputText);

      if(inputInt == randInt){
        result.setText("You are correct! Great job!");
      }else if (inputInt < randInt){
        result.setText("Your guess of" + inputInt + "is too low!");
      }else if (inputInt > randInt){
        result.setText("Your guess of " + inputInt + "is too high!");
      }
    }else if (command.equals("new")){
      input.setText("");
      randInt = rand.nextInt(100) + 1;
    }

  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
