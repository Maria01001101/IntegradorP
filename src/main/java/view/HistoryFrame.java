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

public class HistoryFrame extends JFrame {
    public HistoryFrame(GameController controller) {
        setTitle("Historia del Juego");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea historyText = new JTextArea("Aquí va la historia del juego...");
        historyText.setWrapStyleWord(true);
        historyText.setLineWrap(true);
        historyText.setEditable(false);
        add(new JScrollPane(historyText), "Center");

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
