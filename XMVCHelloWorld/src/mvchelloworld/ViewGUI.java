/*
 * CPS 202
 * Spring 2021
 * Dr. Close
 * 
 * Copyright © 2021 Daryl Close 
 * This work is licensed under the Creative Commons 
 * Attribution-Noncommercial-No Derivative Works 3.0 United States License. 
 * To view a copy of this license, visit 
 * http://creativecommons.org/licenses/by-nc-nd/3.0/us/ 
 * or send a letter to Creative Commons, 171 Second Street, Suite 300, 
 * San Francisco, California, 94105, USA. * 
 */

package mvchelloworld;

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
 * In MVC, the View class handles output.  This View is GUI-based.
 * <p>
 * The View knows nothing about the Model or the Controller, 
 * i.e., the View contains no references to objects of either class. 
 * 
 * @author Daryl Close dclose@heidelberg.edu
 * @version 1.1, 21-Mar-2021
 */
public class ViewGUI
{
    //--------instance fields---------
   
    private JFrame frame;
    private JPanel namePanel;
    private JPanel buttonPanel;
    private JLabel promptLabel;
    private JTextField textField;
    private JButton continueButton;
     
    //-------constructor-------
    
    /**
     * No-arg constructor.
     */
    public ViewGUI()
    {   
        createAndShowGUI();
        
    }//End no-arg constructor
    
    //-------instance methods-------
    
    /**
     * Creates and displays a JFrame GUI.
     */
    public void createAndShowGUI()
    {
        //Create and set up the frame, location, and layout
        frame = new JFrame();
        frame.setLocationRelativeTo(null); 
        frame.setLayout(new GridLayout(2, 1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up name panel 
        namePanel = new JPanel();
        namePanel.setBackground(Color.LIGHT_GRAY);
        namePanel.setLayout(new BorderLayout());
        
        //Set up components for name panel
        promptLabel = new JLabel("");
        textField = new JTextField(20);
        
        //Add components to name panel
        namePanel.add(promptLabel, BorderLayout.CENTER);
        namePanel.add(textField, BorderLayout.SOUTH);               
       
        //Set up button panel
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        
        //Set up components and listeners for button panel
        continueButton = new JButton("Continue");
         
        //Add components to button panel
        buttonPanel.add(continueButton);  
         
        //Add panels to frame
        frame.add(namePanel);
        frame.add(buttonPanel);
        
        //Pack, center, and display frame
        frame.pack();
        frame.setSize(400, 200);  //Always place after pack
        frame.setVisible(true);
         
    }//End public void createAndShowGUI()
 
    /**
     * Displays the screen title.
     * 
     * @param title the screen title
     */
    public void displayTitle(String title)
    {
        frame.setTitle(title);
        
    }//End public void displayTitle(String)
    
    /**
     * Displays the user prompt.
     * 
     * @param prompt user prompt
     */
    public void displayPrompt(String prompt)
    {
        promptLabel.setText(prompt);
        
    }//End public void displayPrompt(String)
    
    /**
     * Displays the user message.
     * 
     * @param message the user message
     */
    public void displayMessage(String message)
    {
        textField.setText(message + "!");
        
    }//End public void displayMessage(String)
 
    /**
     * Gets the text entered by the user.
     * 
     * @return the user text
     */
    public String getInput()
    {
        return textField.getText();
        
    }//End public String getInput()
    
    /**
     * Register the widgets with a listener
     * 
     * @param listener ActionListener interface variable to store an object
     *                 of the class that implements the interface.
     */
    public void addListenersToWidgets(ActionListener listener)
    {
        continueButton.addActionListener(listener);
 
    }//End public void addListenersToWidgets(ActionListener)
    
}//End public class ViewGUI
