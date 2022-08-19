/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa8portfolio;

import java.io.File;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.Container;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import PA6BabyNames.PA6fMainCalderonKaup;
import airplaneseats.PA2SeatsMainCalderon;
import PA7TicTacToe.PA7MainCalderon;

/**
 * File name:       PortfolioJFrameDelegateCalderonKaup.java
 * 
 * @author          Gabriela Calderon
 * @author          Spencer Kaup
 */
public class PortfolioJFrameDelegateCalderonKaup
{
    //--------------------CONSTANT FIELDS-------------------------
    
    private static final int width = 600;
    private static final int height = 300;
    private static final int lines = 10;
    private static final int charPerLine = 40;
    private static final String title = "\tMESSAGE CENTER\n\n";
    
    //---------------------INSTANCE FIELDS------------------------
    
    private JFrame frame;
    private JMenuBar menuBar;
    private JMenu menuTopFile;
    private JMenu menuSubPython;
    private JMenu menuSubJava;
    private JMenu menuTopView;
    private JMenu menuTopHelp;
    private JMenu menuSubLookAndFeel;
    private JMenu menuSubScroll;
    private JMenuItem menuItemFileSaveMessage;
    private JMenuItem menuItemFileGetMessage;
    private JMenuItem menuItemFileClear;
    private JMenuItem menuItemFileExit;
    private JMenuItem menuItemScrollNever;
    private JMenuItem menuItemScrollAlways;
    private JMenuItem menuIemScrollAsNeeded;
    private JMenuItem menuItemLookAndFeelMetal;
    private JMenuItem menuItemLookAndFeelMotif;
    private JMenuItem menuItemLookAndFeelWindows;
    private JMenuItem menuItemHelpIndex;
    private JMenuItem menuItemHelpAbout;
    private JPanel panelMessageCenter;
    private JTextArea textAreaMessageCenter;
    private JScrollPane scrollPaneMessageCenter ;
    private String message = "No saved messages";
    private JMenuItem menuItemBabyNames;
    private JMenuItem menuItemAirplaneSeats;
    private JMenuItem menuItemTicTacToe;
    private JMenuItem menuItemRiskGame;    
    
    //-----------------------CONSTRUCTORS-------------------------
    
    public PortfolioJFrameDelegateCalderonKaup()            
    {        
        runTheDemo();    
    }
    
    //--------------------------METHODS---------------------------
    
    public void runTheDemo()
    {
        //Step 1: we set up the JFrame
        frame = new JFrame();
        frame.setTitle("Menu Demo");
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null); //Center window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        //Step 2: we create the file menu and add choices
        menuTopFile = new JMenu("File");
        
        //Sub menus that divide programs between java and python
        menuSubPython = new JMenu("Python programs");        
        menuSubJava = new JMenu("Java programs");
        
        menuTopFile.add(menuSubPython);
        menuTopFile.add(menuSubJava);
        
        menuItemBabyNames = new JMenuItem("View baby name popularity");
        menuItemBabyNames.addActionListener(new AllWidgetsListener());
        menuSubJava.add(menuItemBabyNames);
        
        menuItemAirplaneSeats = new JMenuItem("Assign airplane seats");
        menuItemAirplaneSeats.addActionListener(new AllWidgetsListener());
        menuSubJava.add(menuItemAirplaneSeats);
        
        menuItemTicTacToe = new JMenuItem("Play tic tac toe");
        menuItemTicTacToe.addActionListener(new AllWidgetsListener());
        menuSubJava.add(menuItemTicTacToe);
        
        menuItemRiskGame = new JMenuItem("Run Python Risk simulator");
        menuItemRiskGame.addActionListener(new AllWidgetsListener());
        menuSubPython.add(menuItemRiskGame);                
        
        menuItemFileGetMessage = new JMenuItem("Get message");
        menuItemFileGetMessage.addActionListener(new AllWidgetsListener());
        menuTopFile.add(menuItemFileGetMessage);
        
        menuItemFileSaveMessage = new JMenuItem("Save message");
        menuItemFileSaveMessage.addActionListener(new AllWidgetsListener());
        menuTopFile.add(menuItemFileSaveMessage);
        
        menuItemFileClear = new JMenuItem("Clear message");
        menuItemFileClear.addActionListener(new AllWidgetsListener());
        menuTopFile.add(menuItemFileClear);
               
        menuItemFileExit = new JMenuItem("Exit");
        menuItemFileExit.addActionListener(new AllWidgetsListener());
        menuTopFile.add(menuItemFileExit);
        
        //Step 3: we create the view menu
        menuTopView = new JMenu("View");
        
        //Step 3.1: we create look and feel submenu
        menuSubLookAndFeel = new JMenu("Look and Feel");
        
        //Step 3.1.1: we add coices to look and feel submenu
        menuItemLookAndFeelMetal = new JMenuItem("Metal (Java)");
        menuItemLookAndFeelMetal.addActionListener(new AllWidgetsListener());
        menuSubLookAndFeel.add(menuItemLookAndFeelMetal);
        
        menuItemLookAndFeelMotif = new JMenuItem("Motif (UNIX)");
        menuItemLookAndFeelMotif.addActionListener(new AllWidgetsListener());
        menuSubLookAndFeel.add(menuItemLookAndFeelMotif);
        
        menuItemLookAndFeelWindows = new JMenuItem("Windows");
        menuItemLookAndFeelWindows.addActionListener(new AllWidgetsListener());
        menuSubLookAndFeel.add(menuItemLookAndFeelWindows);
        
        //Step 3.2: we create scroll bars submenu
        menuSubScroll = new JMenu("Scroll Bars");
        
        //Step 3.2.1: we add choices to scroll bars submenu
        menuItemScrollNever = new JMenuItem("Never");
        menuItemScrollNever.addActionListener(new AllWidgetsListener());
        menuSubScroll.add(menuItemScrollNever);
        
        menuItemScrollAlways = new JMenuItem("Always");
        menuItemScrollAlways.addActionListener(new AllWidgetsListener());
        menuSubScroll.add(menuItemScrollAlways);
        
        menuIemScrollAsNeeded = new JMenuItem("As Needed");
        menuIemScrollAsNeeded.addActionListener(new AllWidgetsListener());
        menuSubScroll.add(menuIemScrollAsNeeded);
        
        //Step 3.2.2: Add submenus to View menu (Look and Feel, Scroll Bars)
        menuTopView.add(menuSubLookAndFeel);
        menuTopView.add(menuSubScroll);

        //Step 4: Create the Help menu and add choices
        menuTopHelp = new JMenu("Help");
        
        menuItemHelpIndex = new JMenuItem("Help Contents");
        menuItemHelpIndex.addActionListener(new AllWidgetsListener());
        menuTopHelp.add(menuItemHelpIndex);
        
        menuItemHelpAbout = new JMenuItem("About");
        menuItemHelpAbout.addActionListener(new AllWidgetsListener());
        menuTopHelp.add(menuItemHelpAbout);

        //Step 5: Set up the menu bar and add top level choices
        menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        menuBar.add(menuTopFile);
        menuBar.add(menuTopView);
        menuBar.add(menuTopHelp);
    
        //Step 6: Set up a JPanel to go in the JFrame
        panelMessageCenter = new JPanel();
        panelMessageCenter.setBackground(Color.darkGray);
        
        //Step 6.1: Set up a JTextArea to go in the JScrollPane
        textAreaMessageCenter = new JTextArea(lines, charPerLine);
        textAreaMessageCenter.setBackground(Color.gray);
        textAreaMessageCenter.setText(title);
        
        //Step 6.2: Set up the JScrollPane and add it to the JPanel
        scrollPaneMessageCenter = new JScrollPane(textAreaMessageCenter);
        panelMessageCenter.add(scrollPaneMessageCenter);
        
        //Step 6.3: Add the JPanel to the frame
        frame.add(panelMessageCenter, BorderLayout.CENTER);
        
        //Step 7: Pack and display the frame
        frame.pack();
        frame.setVisible(true);
        
    }//End private void runTheDemo()

    
    private class AllWidgetsListener implements ActionListener
    { 
        public AllWidgetsListener()
        {
            //Deliberately empty
			
        }//End no-arg constructor
                
        @Override
        public void actionPerformed(ActionEvent e)    
        {
            String execArgumentString;           
            Process p;
            
            String actionCommand = e.getActionCommand();

            if (actionCommand.equals("View baby name popularity"))
            {                
                textAreaMessageCenter.setText("Launching Baby Names program...");
                PA6fMainCalderonKaup.main(null);
            }
            else if (actionCommand.equals("Assign airplane seats"))
            {
                frame.setState(JFrame.ICONIFIED);                
                textAreaMessageCenter.setText("Launching Airplane Seats "
                                                + "program...");
                PA2SeatsMainCalderon.main(null);
                frame.setState(JFrame.NORMAL);
            }
            else if (actionCommand.equals("Play tic tac toe"))
            {
                //frame.setState(JFrame.ICONIFIED);
                textAreaMessageCenter.setText("Launching tic tac toe "
                                                + "program...");
                PA7MainCalderon.main(null);
                frame.setState(JFrame.NORMAL);
            }
            else if (actionCommand.equals("Run Python Risk simulator"))
            {
                frame.setState(JFrame.ICONIFIED);
                                
                execArgumentString = "cmd /c start cmd.exe /k \"python "
                        + "C:\\Python\\Risk_Game_Simulator.py\"";                
                
                try
                {                    
                    p = Runtime.getRuntime().exec(execArgumentString);
                    System.out.println(p.info());
                }
                catch (IOException ex)
                {
                    Logger.getLogger(PortfolioJFrameDelegateCalderonKaup.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
                
                textAreaMessageCenter.setText("Launching python risk game"
                                                + " simulator");
                frame.setState(JFrame.NORMAL);
                
            }            
            else if (actionCommand.equals("Save message"))
                message = textAreaMessageCenter.getText();                   
            else if (actionCommand.equals("Get message"))
                textAreaMessageCenter.setText(message);
            else if (actionCommand.equals("Clear message"))
                textAreaMessageCenter.setText(title);
            else if (actionCommand.equals("Run another program"))
            {                
                //Here we will insert call back to an external program
                
                //Place source code files in the NetBeans project subdirectory.
                //Example:
                //frame.setState(JFrame.ICONIFIED);
                //PA7TicTacToeMain.main(new String[4]);
                //frame.setState(JFrame.NORMAL);          
                textAreaMessageCenter.setText(title 
                                      + "\n\nThis is a stub for an external "
                                      + "program.  It would be running in "
                                      + "another window.");
            }    
            /*else if (actionCommand.equals("Run Microsoft Word"))
            {
                //Call Microsoft Word. Note that escaped double-quotes are
                //required for the command line argument.
                frame.setState(JFrame.ICONIFIED);
                
                String execArgumentString = "cmd /c " + "\"c:\\program files "
                        + "(x86)\\"
                        + "Microsoft Office\\Office16\\winword.exe\"";  
                try 
                {                    
                    Process p = Runtime.getRuntime().exec(execArgumentString);
                    
                } catch (IOException ex) 
                {
                    Logger.getLogger(PortfolioJFrameDelegateCalderonKaup.class.
                                    getName()).log(Level.SEVERE, null, ex);
                }
                textAreaMessageCenter.setText(title + "Microsoft Word 2016");
                frame.setState (JFrame.NORMAL);                
            }*/
            else if (actionCommand.equals("Metal (Java)"))
            {
                textAreaMessageCenter.setText(title 
                                      + "This is the Metal Java look.");
                try
                {
                    UIManager.setLookAndFeel(
                        "javax.swing.plaf.metal.MetalLookAndFeel");
                    SwingUtilities.updateComponentTreeUI(frame);
                }
                catch (Exception e2)
                {
                    System.out.println("Look and feel problem.");
                }
            }
            else if(actionCommand.equals("Motif (UNIX)"))
            {
                textAreaMessageCenter.setText("This is the UNIX Motif look.");
                try
                {
                    UIManager.setLookAndFeel(
                        "com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                    SwingUtilities.updateComponentTreeUI(frame);
                }
                catch (Exception e2)
                {
                    System.out.println("Look and feel problem.");
                }
            }
            else if (actionCommand.equals("Windows"))
            {
                textAreaMessageCenter.setText(title 
                                      + "This is the Windows look.");
                try
                {
                    UIManager.setLookAndFeel(
                        "com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    SwingUtilities.updateComponentTreeUI(frame);
                }
                catch(Exception e2)
                {
                    System.out.println("Look and feel problem.");
                }
            }
            else if (actionCommand.equals("Never"))
            {
                scrollPaneMessageCenter.setHorizontalScrollBarPolicy(
                                    JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                scrollPaneMessageCenter.setVerticalScrollBarPolicy(
                                     JScrollPane.VERTICAL_SCROLLBAR_NEVER);
                SwingUtilities.updateComponentTreeUI(frame);
            }
            else if (actionCommand.equals("Always"))
            {
                scrollPaneMessageCenter.setHorizontalScrollBarPolicy(
                                   JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                scrollPaneMessageCenter.setVerticalScrollBarPolicy(
                                   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                SwingUtilities.updateComponentTreeUI(frame);
            }
            else if (actionCommand.equals("As Needed"))
            {
                scrollPaneMessageCenter.setHorizontalScrollBarPolicy(
                                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                scrollPaneMessageCenter.setVerticalScrollBarPolicy(
                                  JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                SwingUtilities.updateComponentTreeUI(frame);
            }
            else if (actionCommand.equals("Help Contents"))
                textAreaMessageCenter.setText(title
                                      + PA8PortfolioFileDelegateCalderonKaup.
                                              readTextFile());
                                              
            else if (actionCommand.equals("About"))
                textAreaMessageCenter.setText(title
                                      + "\n\nCopyright 2021 Gabriela Calderon"
                                              + " & Spencer Kaup");
            else if (actionCommand.equals("Exit"))
                System.exit(0); 
            else
                textAreaMessageCenter.setText("Error in JMenu interface");

        }//End public void actionPerformed(ActionEvent)
        
    }//End private class AllWidgetsListener 
    
}//End public class NestedJMenuDemo