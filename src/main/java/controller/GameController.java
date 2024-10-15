/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author maria
 */


import view.GameFrame;
import view.HistoryFrame;
import view.InstructionsFrame;
import view.MainMenuFrame;

public class GameController {
    private MainMenuFrame mainMenu;
    private HistoryFrame historyFrame;
    private InstructionsFrame instructionsFrame;
    private GameFrame gameFrame;
    
    

    public GameController() {
        mainMenu = new MainMenuFrame(this);
        historyFrame = new HistoryFrame(this);
        instructionsFrame = new InstructionsFrame(this);
        gameFrame = new GameFrame(this);
        
       // Colocar las ventanas al centro de la pantalla
        mainMenu.setLocationRelativeTo(null);
        historyFrame.setLocationRelativeTo(null);
        instructionsFrame.setLocationRelativeTo(null);
        gameFrame.setLocationRelativeTo(null);
    }

    public void showMainMenu() {
        mainMenu.setVisible(true);
    }

    public void showHistory() {
        mainMenu.setVisible(false);
        historyFrame.setVisible(true);
    }

    public void showInstructions() {
        mainMenu.setVisible(false);
        instructionsFrame.setVisible(true);
    }

    public void startGame() {
        mainMenu.setVisible(false);
        gameFrame.setVisible(true);
    }

    public void exitGame() {
        System.exit(0);
    }

    public void returnToMenu() {
        historyFrame.setVisible(false);
        instructionsFrame.setVisible(false);
        gameFrame.setVisible(false);
        mainMenu.setVisible(true);
    }
}

