package co.edu.uptc.GUIwindows;

import co.edu.uptc.logic.Bet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUILastWindow extends JFrame implements ActionListener {

    private JPanel JPFormArea;
    private JPanel JPInfoArea;
    private JLabel JLTitle;
    private JLabel JLProfitInstructions;

    private JButton JBStart;
    private JButton JBCancel;

    private Bet currentBet;

    public GUILastWindow(Bet betRecived){
        currentBet = betRecived;

        JPFormArea = new JPanel();
        JPInfoArea = new JPanel();

        JLTitle = new JLabel("Give us your money Casino", SwingConstants.CENTER);

        String profitInstructions = announceProfit();

        JLProfitInstructions = new JLabel(profitInstructions,SwingConstants.CENTER);


        JBStart = new JButton("Reintentar");
        JBCancel = new JButton("Terminar");

        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(600, 500);
        setLocationRelativeTo(null);
        setTitle("Formulario de inicio");

        setResizable(false);
    }

    private String announceProfit() {
        String announce = "";
        if (currentBet.getAmountWinned()>0){
            announce = "<html><center>Felicidades has ganado $"+currentBet.getAmountWinned()+"</center></html>";
        }else {
            announce = "<html><center>Acabas de perder, muchas gracias por regalarnos tu dinero ;) </center></html>";
        }
        return announce;
    }

    public void lastWindow(){
        JPFormArea.setBounds(0, 0, 575, 490);
        JPFormArea.setBackground(new Color(242, 242, 242));

        JPFormArea.setLayout(null);

        JLTitle.setBounds(100, 15, 400, 40);
        JLTitle.setFont(new Font("Arial", Font.BOLD, 30));
        JLTitle.setForeground(new Color(31, 90, 166));

        JPInfoArea.setBounds(40, 80, 500, 150);
        JPInfoArea.setBackground(Color.white);

        JPInfoArea.setLayout(null);

        JLProfitInstructions.setBounds(5,3,450,100);
        JLProfitInstructions.setFont(new Font("Fredoka One", Font.BOLD, 15));
        JLProfitInstructions.setForeground(Color.black);


        JBStart.setBounds(300, 390, 110, 40);
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
        JPFormArea.add(JBStart);
        JPFormArea.add(JBCancel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(JBStart)){
            this.setVisible(false);
            GUIInitialWindow c = new GUIInitialWindow();
            c.makeMainForm();
        }else if (o.equals(JBCancel)){
            JOptionPane.showMessageDialog(null, "Adios");
            System.exit(0);
        }
    }
}
