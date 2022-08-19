/*
 * CPS 202
 * Will Bohlen
 * 4-May-2020
 */
package pa8portfoliobohlen;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import pa2feb5bohlen.PA2BohlenMain;
import pa5mar6bohlen.PA5BabyNamesBohlen;
import pa7tictactoebohlen.PA7MainBohlen;

/**
 * File name:     PA8PortfolioJFrameDelegateBohlen.java <p>
 * Description:   Programming Assignment 8 (JMenu Portfolio)
 *                <p>
 *                This program handles the JFrame I/O, and starts the other
 *                applications when they are selected.
 * 
 *                Adapted from code written by Daryl Close.
 * @author Will Bohlen wbohlen@heidelberg.edu
 * @author Daryl Close dclose@heidelberg.edu
 * @revision 6-May-2020
 */
public class PA8PortfolioJFrameDelegateBohlen {
    //-------private constants--------
    
    private static final int     WIDTH  = 600;
    private static final int     HEIGHT = 300;
    private static final int     LINES  = 10;
    private static final int     CHARS_PER_LINE = 40;
    private static final String  TITLE  = "\tMESSAGE CENTER\n\n";
    
    //-------private instance fields-------
    
    private JFrame      frame;    
    private JMenuBar    menuBar;
    private JMenu       menuTopFile;
    private JMenu       menuTopView;    
    private JMenu       menuTopHelp;    
    private JMenu       menuSubLookAndFeel;    
    private JMenu       menuSubScroll;      
    private JMenuItem   menuItemFileRunPython;    
    private JMenuItem   menuItemFileRunMemoryGame;    
    private JMenuItem   menuItemFileRunBabyNames;  
    private JMenuItem   menuItemFileRunTicTacToe;      
    private JMenuItem   menuItemFileExit;    
    private JMenuItem   menuItemScrollNever;    
    private JMenuItem   menuItemScrollAlways;
    private JMenuItem   menuIemScrollAsNeeded;    
    private JMenuItem   menuItemLookAndFeelMetal;    
    private JMenuItem   menuItemLookAndFeelMotif;    
    private JMenuItem   menuItemLookAndFeelWindows;    
    private JMenuItem   menuItemHelpIndex;    
    private JMenuItem   menuItemHelpAbout;    
    private JPanel      panelMessageCenter;    
    private JTextArea   textAreaMessageCenter;
    private JScrollPane scrollPaneMessageCenter ;    
    private String      message = "No saved messages";
    
    //-------constructor-------
    
    /**
     * No-arg constructor calls a private method to set up a nested JMenu
     */
    public PA8PortfolioJFrameDelegateBohlen()
    {
        runMenu();
    }//End no-arg constructor
    
    //-------private methods-------
    
    /**
     * Creates and displays the menu GUI.
     */
    private void runMenu()
    {        
        // 1.0 Set up JFrame
        frame = new JFrame();
        frame.setTitle("CPS 202 Portfolio");
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null); //Center window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
 
        // 2.0 Create the File menu and add choices.  The add order matters.
        menuTopFile = new JMenu("Portfolio");

        menuItemFileRunPython = new JMenuItem("Run Dice Roller (Python Script)");
        menuItemFileRunPython.addActionListener(new PA8PortfolioJFrameDelegateBohlen.AllWidgetsListener());
        menuTopFile.add(menuItemFileRunPython);
        
        menuItemFileRunMemoryGame = new JMenuItem("Play Memory Game");
        menuItemFileRunMemoryGame.addActionListener(new PA8PortfolioJFrameDelegateBohlen.AllWidgetsListener());
        menuTopFile.add(menuItemFileRunMemoryGame);
        
        menuItemFileRunBabyNames = new JMenuItem("Look Up a Baby Name");
        menuItemFileRunBabyNames.addActionListener(new PA8PortfolioJFrameDelegateBohlen.AllWidgetsListener());
        menuTopFile.add(menuItemFileRunBabyNames);
        
        menuItemFileRunTicTacToe = new JMenuItem("Play Tic-Tac-Toe");
        menuItemFileRunTicTacToe.addActionListener(new PA8PortfolioJFrameDelegateBohlen.AllWidgetsListener());
        menuTopFile.add(menuItemFileRunTicTacToe);

        menuItemFileExit = new JMenuItem("Exit");
        menuItemFileExit.addActionListener(new PA8PortfolioJFrameDelegateBohlen.AllWidgetsListener());
        menuTopFile.add(menuItemFileExit);

        // 3.0 Create the View menu
        menuTopView = new JMenu("View");
        
        // 3.1 Create Look and Feel submenu
        menuSubLookAndFeel = new JMenu("Look and Feel");
        
        // 3.1.1 Add choices to Look and Feel submenu 
        menuItemLookAndFeelMetal = new JMenuItem("Metal (Java)");
        menuItemLookAndFeelMetal.addActionListener(new PA8PortfolioJFrameDelegateBohlen.AllWidgetsListener());
        menuSubLookAndFeel.add(menuItemLookAndFeelMetal);
        
        menuItemLookAndFeelMotif = new JMenuItem("Motif (UNIX)");
        menuItemLookAndFeelMotif.addActionListener(new PA8PortfolioJFrameDelegateBohlen.AllWidgetsListener());
        menuSubLookAndFeel.add(menuItemLookAndFeelMotif);
        
        menuItemLookAndFeelWindows = new JMenuItem("Windows");
        menuItemLookAndFeelWindows.addActionListener(new PA8PortfolioJFrameDelegateBohlen.AllWidgetsListener());
        menuSubLookAndFeel.add(menuItemLookAndFeelWindows);
                
        // 3.2 Create Scroll Bars submenu
        menuSubScroll = new JMenu("Scroll Bars");
        
        // 3.2.1 Add choices to Scroll Bars submenu
        menuItemScrollAlways = new JMenuItem("Always");
        menuItemScrollAlways.addActionListener(new PA8PortfolioJFrameDelegateBohlen.AllWidgetsListener());
        menuSubScroll.add(menuItemScrollAlways);
        
        menuItemScrollNever = new JMenuItem("Never");
        menuItemScrollNever.addActionListener(new PA8PortfolioJFrameDelegateBohlen.AllWidgetsListener());
        menuSubScroll.add(menuItemScrollNever);
        
        menuIemScrollAsNeeded = new JMenuItem("As Needed");
        menuIemScrollAsNeeded.addActionListener(new PA8PortfolioJFrameDelegateBohlen.AllWidgetsListener());
        menuSubScroll.add(menuIemScrollAsNeeded);
        
        // 3.2.2 Add submenus to View menu (Look and Feel, Scroll Bars)
        menuTopView.add(menuSubLookAndFeel);
        menuTopView.add(menuSubScroll);

        // 4.0 Create the Help menu and add choices
        menuTopHelp = new JMenu("Help");
        
        menuItemHelpIndex = new JMenuItem("Help Contents");
        menuItemHelpIndex.addActionListener(new PA8PortfolioJFrameDelegateBohlen.AllWidgetsListener());
        menuTopHelp.add(menuItemHelpIndex);
        
        menuItemHelpAbout = new JMenuItem("About");
        menuItemHelpAbout.addActionListener(new PA8PortfolioJFrameDelegateBohlen.AllWidgetsListener());
        menuTopHelp.add(menuItemHelpAbout);

        // 5.0 Set up the menu bar and add top level choices
        menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        menuBar.add(menuTopFile);
        menuBar.add(menuTopView);
        menuBar.add(menuTopHelp);
    
        // 6.0 Set up a JPanel to go in the JFrame
        panelMessageCenter = new JPanel();
        panelMessageCenter.setBackground(Color.BLUE);
        
        // 6.1 Set up a JTextArea to go in the JScrollPane
        textAreaMessageCenter = new JTextArea(LINES, CHARS_PER_LINE);
        textAreaMessageCenter.setBackground(Color.WHITE);
        textAreaMessageCenter.setText(TITLE);
        
        // 6.2 Set up the JScrollPane and add it to the JPanel
        scrollPaneMessageCenter = new JScrollPane(textAreaMessageCenter);
        panelMessageCenter.add(scrollPaneMessageCenter);
        
        // 6.3 Add the JPanel to the frame
        frame.add(panelMessageCenter, BorderLayout.CENTER);
        
        // 7.0 Pack and display the frame
        //frame.pack();
        frame.setVisible(true);
        
    }//End private void runMenu()
    
    /**
     * This private class implements the ActionListener interface by overriding
     * the actionPerformed method in the interface (the only method in the
     * interface). 
     */
    private class AllWidgetsListener implements ActionListener
    { 
        /**
         * Deliberately empty no-arg constructor.  Explicitly coded here as 
         * documentation.  The constructor is called by the addActionListener 
         * method in the JMenu class.  The empty constructor is often absent 
         * in the source code because Java will add one automatically. 
         */
        public AllWidgetsListener()
        {
            //Deliberately empty
			
        }//End no-arg constructor
        
        /**
         * This method implements the abstract method from the ActionListener 
         * interface.
         * <p>
         * When a button/widget is clicked, the actionPerformed method will be 
         * invoked automatically.  All widget callback actions are specified 
         * here.  Note that
	 * <p>
         * (1) this method is never explicitly invoked in the source code; and
 	 * <p>
         * (2) there is no looping in the method's source code, yet loop 
         *     behavior occurs.
         * <p>
         * @param e the listener object from java.awt.event.ActionEvent.
         */
        @Override
        public void actionPerformed(ActionEvent e)    
        {
            String actionCommand = e.getActionCommand();

            if (actionCommand.equals("Look Up a Baby Name"))
            {
                textAreaMessageCenter.setText("Launching Baby Names program...");
                PA5BabyNamesBohlen.main(null);
            }
            else if (actionCommand.equals("Play Memory Game"))
            {
                textAreaMessageCenter.setText("Launching Memory Game...");
                PA2BohlenMain.main(null);
            }
            else if (actionCommand.equals("Play Tic-Tac-Toe"))
            {
                textAreaMessageCenter.setText("Launching Tic-Tac-Toe...");
                PA7MainBohlen.main(null);
            } 
            else if (actionCommand.equals("Run Dice Roller (Python Script)"))
            {
                //Call the Python script. I encountered issues with the /c
                //argument, and my solution was to use it to start a second
                //command prompt with /k. Just using /k first didn't work.
                frame.setState(JFrame.ICONIFIED);
                
                String execArgumentString = "cmd /c start "
                        + "cmd /c python diceRoll.py";  
                try 
                {                    
                    Process p = Runtime.getRuntime().exec(execArgumentString);
                    System.out.println(p.info());
                } catch (IOException ex) 
                {
                    Logger.getLogger(PA8PortfolioJFrameDelegateBohlen.class.getName())
                                     .log(Level.SEVERE, null, ex);
                }
                textAreaMessageCenter.setText(TITLE + "Microsoft Word 2016");
                frame.setState (JFrame.NORMAL);                
            }            
            else if (actionCommand.equals("Metal (Java)"))
            {
                textAreaMessageCenter.setText(TITLE 
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
                textAreaMessageCenter.setText(TITLE 
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
                textAreaMessageCenter.setText(TITLE +
                        PA8PortfolioFileDelegateBohlen.readTextFile());
            else if (actionCommand.equals("About"))
                textAreaMessageCenter.setText(TITLE
                                      + "\nWritten by Will Bohlen"
                                              + "\nAdapted from code by Daryl Close");
            else if (actionCommand.equals("Exit"))
                System.exit(0); 
            else
                textAreaMessageCenter.setText("Error in JMenu interface");

        }//End public void actionPerformed(ActionEvent)
        
    }//End private class AllWidgetsListener
}
