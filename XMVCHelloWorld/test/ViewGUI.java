/*
 * CPS 202
 * Fall 2016
 * Dr. Close
 * 
 * Copyright © 2016 Daryl Close 
 * This work is licensed under the Creative Commons 
 * Attribution-Noncommercial-No Derivative Works 3.0 United States License. 
 * To view a copy of this license, visit 
 * http://creativecommons.org/licenses/by-nc-nd/3.0/us/ 
 * or send a letter to Creative Commons, 171 Second Street, Suite 300, 
 * San Francisco, California, 94105, USA. * 
 */

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Illustrates simple layout managers for JFrame and JPanel.  
 * Note:  getContentPane() is called internally as of Java 5, so a Container 
 * object is no longer needed to call add and setLayout.
 *  
 * @author Daryl Close dclose@heidelberg.edu
 * @version 20-Nov-2016
 */
public class ViewGUI
{
    //------- private instance fields -------
   
    private String prompt;
    private String greeting;
    private JFrame centerFrame;
    private JPanel namePanel;
    private JPanel buttonPanel;
    private JLabel promptLabel;
    private JTextField inputOutputTextField;
    private JButton continueButton;
     
    //-------constructors-------
    
    public ViewGUI()
    {   
        createAndShowGUI();
        
    }//End no-arg constructor
    
    //-------instance methods-------
    
    public void createAndShowGUI()
    {
        //Create and set up frame, background, and layout
        centerFrame = new JFrame();
        centerFrame.setTitle("Welcome Center");
        centerFrame.setLocationRelativeTo(null); 
        centerFrame.setLayout(new GridLayout(2, 1));

        //Set up name panel 
        namePanel = new JPanel();
        namePanel.setBackground(Color.LIGHT_GRAY);
        namePanel.setLayout(new BorderLayout());
        
        //Set up components for name panel
        promptLabel = new JLabel(prompt);
        inputOutputTextField = new JTextField(20);
        
        //Add components to name panel
        namePanel.add(promptLabel, BorderLayout.CENTER);
        namePanel.add(inputOutputTextField, BorderLayout.SOUTH);               
       
        //Set up button panel
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        
        //Set up components and listeners for button panel
        continueButton = new JButton("Continue");
         
        //Add components to button panel
        buttonPanel.add(continueButton);  
         
        //Add panels to frame
        centerFrame.add(namePanel);
        centerFrame.add(buttonPanel);
        
        //Pack, center, and display frame
        centerFrame.pack();
        centerFrame.setSize(400, 200);  //Always place after pack
        centerFrame.setVisible(true);
        centerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }//End method void createAndShowGUI()
    
    public void displayPrompt()
    {
        System.out.print(prompt);
    }
    
    public void displayGreeting()
    {
        System.out.println(greeting);
    } 
  
    public void displayGUIPrompt()
    {
        promptLabel.setText(prompt);
    }
    
    public void displayGUIGreeting()
    {
        inputOutputTextField.setText(greeting);
    }
    
    public void setPrompt(String tempPrompt)
    {
        prompt = tempPrompt;
    }
    
    public void setGUIPrompt(String tempPrompt)
    {
        promptLabel.setText(prompt);
    }
    
    public void setGreeting(String tempGreeting)
    {
        greeting = tempGreeting;
    }
     
    public void setInputOutputTextField(String tempText)
    {
        inputOutputTextField.setText(tempText);
    }
    
    public String getInputOutputTextField()
    {
        return inputOutputTextField.getText();
    }
    
    /**
     * Register the widgets with a listener
     * 
     * @param listener An object of the inner class in the client that 
     *                 implements the ActionListener interface
     */
    public void addListenersToWidgets(ActionListener listener)
    {
        continueButton.addActionListener(listener);
        inputOutputTextField.addActionListener(listener);

    }//End method void addListenersToWidgets(ActionListener)
    
}//End public class ViewGUI
