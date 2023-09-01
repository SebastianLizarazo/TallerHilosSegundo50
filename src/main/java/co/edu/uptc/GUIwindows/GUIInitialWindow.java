package co.edu.uptc.GUIwindows;

import co.edu.uptc.logic.Bet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GUIInitialWindow extends JFrame implements ActionListener {
    private JPanel JPFormArea;
    private JPanel JPInfoArea;
    private JLabel JLTitle;
    private JLabel JLAmountToBet;
    private JLabel JLProfitInstructions;
    private JTextField JTAmountToBet;

    private JButton JBStart;
    private JButton JBCancel;

    public GUIInitialWindow(){
        JPFormArea = new JPanel();
        JPInfoArea = new JPanel();

        JLTitle = new JLabel("Give us your money Casino", SwingConstants.CENTER);

        String profitInstructions = "<html>Ganarás 3 veces el valor apostado si aciertas las 3 imágenes<br>" +
                "Ganarás 2 veces el valor apostado si aciertas solo dos imágenes<br>" +
                "Perderás tu valor apostado si no aciertas ninguna </html>";

        JLProfitInstructions = new JLabel(profitInstructions);

        JLAmountToBet = new JLabel("Monto a apostar");
        JTAmountToBet = new JTextField();

        JBStart = new JButton("Iniciar");
        JBCancel = new JButton("Cancelar");

        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(600, 500);
        setLocationRelativeTo(null);
        setTitle("Formulario de inicio");

        setResizable(false);
    }

    public void makeMainForm(){
        JPFormArea.setBounds(0, 0, 575, 490);
        JPFormArea.setBackground(new Color(242, 242, 242));

        JPFormArea.setLayout(null);

        JLTitle.setBounds(100, 15, 400, 40);
        JLTitle.setFont(new Font("Arial", Font.BOLD, 30));
        JLTitle.setForeground(new Color(31, 90, 166));

        JPInfoArea.setBounds(20, 80, 500, 150);
        JPInfoArea.setBackground(Color.white);

        JPInfoArea.setLayout(null);

        JLProfitInstructions.setBounds(5,3,450,100);
        JLProfitInstructions.setFont(new Font("Fredoka One", Font.BOLD, 12));
        JLProfitInstructions.setForeground(Color.black);

        JLAmountToBet.setBounds(15, 280, 200, 20);
        JLAmountToBet.setFont(new Font("Fredoka One", Font.BOLD, 20));
        JLAmountToBet.setForeground(Color.black);
        JTAmountToBet.setBounds(15, 310, 245, 30);

        JBStart.setBounds(300, 390, 90, 40);
        JBStart.setForeground(Color.white);
        JBStart.setBackground(new Color(22, 85, 140));
        JBStart.addActionListener(this);

        JBCancel.setBounds(200, 390, 90, 40);
        JBCancel.setForeground(Color.white);
        JBCancel.setBackground(new Color(168, 191, 86));
        JBCancel.addActionListener(this);

        add(JPFormArea);
        JPFormArea.add(JLTitle);
        JPFormArea.add(JPInfoArea);
        JPInfoArea.add(JLProfitInstructions);
        JPFormArea.add(JLAmountToBet);
        JPFormArea.add(JTAmountToBet);
        JPFormArea.add(JBStart);
        JPFormArea.add(JBCancel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(JBStart)){
            if (JTAmountToBet.getText().length()!=0){
                double amountToBet= Double.parseDouble(JTAmountToBet.getText());
                new Bet(amountToBet);
                JOptionPane.showMessageDialog(null,"Monto establecido");
                //Mostrar en un messageDialog cuanto podria ganar dependiento de los haciertos
                this.setVisible(false);
                GUIGameWindow c = new GUIGameWindow();
                c.GameScreen();
            }else {
                JOptionPane.showMessageDialog(null, "Digite todo los datos");
            }
        }else if (o.equals(JBCancel)){
            JOptionPane.showMessageDialog(null, "Adios");
            System.exit(0);
        }
    }
}
