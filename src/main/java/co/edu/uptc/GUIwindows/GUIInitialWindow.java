package co.edu.uptc.GUIwindows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIInitialWindow extends JFrame implements ActionListener {
    private JPanel JPFormArea;
    private JLabel JLTitle;
    private JLabel JLAmountToBet;
    private JTextField JTAmountToBet;

    private JButton JBStart;
    private JButton JBCancel;

    public GUIInitialWindow(){
        JPFormArea = new JPanel();
        JLTitle = new JLabel("Give us your money Casino", SwingConstants.CENTER);

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

        JLAmountToBet.setBounds(15, 220, 200, 20);
        JLAmountToBet.setFont(new Font("Fredoka One", Font.BOLD, 20));
        JLAmountToBet.setForeground(Color.black);
        JTAmountToBet.setBounds(15, 250, 245, 30);

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
            this.setVisible(false);
            if (JTAmountToBet.getText().length()!=0){
                double amountToBet= Double.parseDouble(JTAmountToBet.getText());
                //Crear el objeto apuesta y ingresar el monto a apostar
                //Añadir la GUI de la pantalla de juego
            }else {
                JOptionPane.showMessageDialog(null, "Digite todo los datos");
            }
        }else if (o.equals(JBCancel)){
            JOptionPane.showMessageDialog(null, "Adios");
            System.exit(0);
        }
    }
}
