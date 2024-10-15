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
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuFrame extends JFrame {
    public MainMenuFrame(GameController controller) {
        setTitle("Main Menu");
        setSize(1920, 1080);  // Tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel izquierdo para los botones de menú (con tamaño reducido)
        JPanel leftPanel = new JPanel(new GridBagLayout());  // Usamos GridBagLayout para centrar verticalmente
        leftPanel.setPreferredSize(new Dimension(300, 600));  // Ajustar el tamaño del panel izquierdo
        leftPanel.setBorder(BorderFactory.createEmptyBorder(50, 20, 50, 20));  // Márgenes alrededor

        // GridBagConstraints para centrar verticalmente los botones
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.insets = new Insets(20, 0, 20, 0);  // Espaciado entre los botones

        // Crear ImageIcons para los botones y escalarlas al tamaño del botón
        ImageIcon historyIcon = new ImageIcon(new ImageIcon("ruta/de/tu/imagen_historia.png").getImage().getScaledInstance(150, 50, Image.SCALE_SMOOTH));
        ImageIcon instructionsIcon = new ImageIcon(new ImageIcon("ruta/de/tu/imagen_instrucciones.png").getImage().getScaledInstance(150, 50, Image.SCALE_SMOOTH));
        ImageIcon exitIcon = new ImageIcon(new ImageIcon("ruta/de/tu/imagen_salir.png").getImage().getScaledInstance(150, 50, Image.SCALE_SMOOTH));
        ImageIcon playIcon = new ImageIcon(new ImageIcon("assets/BotonInicio.png").getImage().getScaledInstance(300, 100, Image.SCALE_SMOOTH));

        // Botones del menú con tamaño específico e imágenes escaladas
        JButton btnHistory = new JButton("Historia", historyIcon);
        JButton btnInstructions = new JButton("Instrucciones", instructionsIcon);

        // Definir tamaño preferido para los botones
        Dimension buttonSize = new Dimension(150, 50);
        btnHistory.setPreferredSize(buttonSize);
        btnInstructions.setPreferredSize(buttonSize);

        // Añadir acciones a los botones
        btnHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.showHistory();
            }
        });

        btnInstructions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.showInstructions();
            }
        });

        // Botón "Salir" al final del panel izquierdo con imagen escalada
        JButton btnExit = new JButton("Salir", exitIcon);
        btnExit.setPreferredSize(buttonSize);
        btnExit.setBackground(new Color(0, 0, 0, 0));  // Fondo transparente
        btnExit.setOpaque(false);  // Elimina la opacidad del botón
        btnExit.setContentAreaFilled(false);  // Asegura que el área del contenido sea transparente
        btnExit.setBorderPainted(false);  // Elimina el borde del botón para que no interfiera con la transparencia
        btnExit.setFont(new Font("Arial", Font.BOLD, 18));

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.exitGame();
            }
        });

        // Agregar botones al panel izquierdo (centrado verticalmente)
        leftPanel.add(btnHistory, gbc);
        leftPanel.add(btnInstructions, gbc);

        // Agregar espacio vacío antes del botón "Salir"
        gbc.weighty = 1.0;  // Agregar peso para empujar el botón "Salir" hacia abajo
        gbc.anchor = GridBagConstraints.PAGE_END;  // Poner el botón "Salir" al final
        leftPanel.add(btnExit, gbc);  // Botón "Salir" en la parte inferior

        // Panel derecho para la imagen de entrada y el botón "Jugar" con imagen escalada
        JPanel rightPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon background = new ImageIcon("assets/BackgroundInicio.jpg");
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        rightPanel.setLayout(null);  // Usar layout null para posicionar los botones manualmente

        // Botón "Jugar" sobre la imagen de fondo con la imagen escalada
        JButton btnPlay = new JButton("Jugar", playIcon);
        btnPlay.setBounds(800, 500, 300, 100);  // Posicionar el botón en el centro del panel derecho
        btnPlay.setBackground(new Color(0, 0, 0, 0));  // Fondo transparente
        btnPlay.setOpaque(false);  // Elimina la opacidad del botón
        btnPlay.setContentAreaFilled(false);  // Asegura que el área del contenido sea transparente
        btnPlay.setBorderPainted(false);  // Elimina el borde del botón
        btnPlay.setFont(new Font("Arial", Font.BOLD, 24));

        btnPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.startGame();
            }
        });

        // Agregar el botón "Jugar" al panel derecho
        rightPanel.add(btnPlay);

        // Agregar los paneles al frame principal
        add(leftPanel, BorderLayout.WEST);  // Panel izquierdo con botones centrados
        add(rightPanel, BorderLayout.CENTER);  // Panel derecho (imagen y botón "Jugar")
    }
}
