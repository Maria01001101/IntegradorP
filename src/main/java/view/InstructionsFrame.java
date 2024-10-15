/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author maria
 */

import controller.GameController;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InstructionsFrame extends JFrame {
    public InstructionsFrame(GameController controller) {
        setTitle("Instrucciones");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea instructionsText = new JTextArea("Aquí van las instrucciones...");
        instructionsText.setWrapStyleWord(true);
        instructionsText.setLineWrap(true);
        instructionsText.setEditable(false);
        add(new JScrollPane(instructionsText), "Center");

        JButton btnBack = new JButton("Volver al Menú");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.returnToMenu();
            }
        });
        add(btnBack, "South");
    }
}
