package co.edu.uptc.GUIwindows;

import co.edu.uptc.logic.Bet;
import co.edu.uptc.logic.GameController;
import co.edu.uptc.logic.ThreadCount;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.util.Random;

public class GUIGameWindow extends JFrame {

    private GameController gameController;
    private JPanel JPMainArea;
    private JLabel JLImagesOne;//Deben ser cambiados por los espacios para imagenes
    private JLabel JLImagesTwo;//Deben ser cambiados por los espacios para imagenes
    private JLabel JLImagesThree;//Deben ser cambiados por los espacios para imagenes

    private JButton JBtnOne;
    private JButton JBtnTwo;
    private JButton JBtnThree;

    private Bet currentBet;

    public GUIGameWindow(Bet betRecived){
        gameController = new GameController();

        currentBet = betRecived;

        JPMainArea = new JPanel();

        JLImagesOne = new JLabel();
        JLImagesTwo = new JLabel();
        JLImagesThree = new JLabel();

        JBtnOne = new JButton("Stop");
        JBtnTwo = new JButton("Stop");
        JBtnThree = new JButton("Stop");

        setTitle("Pantalla de juego");
        setSize(800,700);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }

    public void GameScreen(){//Es el equivalente del metodo begin del ejemplo de hilos
        JPanel JPCenter = new JPanel();

        JPMainArea.setBounds(0, 0, 800, 700);
        JPMainArea.setBackground(new Color(242, 242, 242));

        JPMainArea.setLayout(null);

        JPCenter.setLayout(new GridLayout(2,3));//Organiza los componentes en una cuadricula
        JPCenter.setBounds(200,200,400,300);

        JLImagesOne.setBounds(10,10,10,10);
        JLImagesTwo.setBounds(10,10,10,10);
        JLImagesThree.setBounds(10,10,10,10);

        add(JPMainArea);
        JPCenter.add(JLImagesOne);
        JPCenter.add(JLImagesTwo);
        JPCenter.add(JLImagesThree);
        JPCenter.add(JBtnOne);
        JPCenter.add(JBtnTwo);
        JPCenter.add(JBtnThree);
        JPMainArea.add(JPCenter,BorderLayout.CENTER);

        setVisible(true);

        addComponents();
    }


    private void addComponents() {//El metodo controlador

        ThreadCount runOne = new ThreadCount(JLImagesOne,true,this);
        ThreadCount runTwo = new ThreadCount(JLImagesTwo,true,this);
        ThreadCount runThree = new ThreadCount(JLImagesThree,true,this);

        Thread thOne = new Thread(runOne);
        Thread thTwo = new Thread(runTwo);
        Thread thThree = new Thread(runThree);

        thOne.start();
        thTwo.start();
        thThree.start();

        //Los action listener de cada boton para detener el contador
        JBtnOne.addActionListener((e)->{
            runOne.stopThread();
            if (gameController.isTheGameOver(runOne,runTwo,runThree)){
                Double amountWined = GameController.calculateVictory(runOne,runTwo,runThree,currentBet); //Implementar metodo para calcular la victoria del jugador con el objeto bet entrante
                currentBet.setAmountWinned(amountWined);
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException m){
                    throw new RuntimeException(m);
                }
                this.setVisible(false);
                GUILastWindow c = new GUILastWindow(currentBet);
                c.lastWindow();
            }
        });
        JBtnTwo.addActionListener((e)->{
            runTwo.stopThread();
            if (gameController.isTheGameOver(runOne,runTwo,runThree)){
                Double amountWined = GameController.calculateVictory(runOne,runTwo,runThree,currentBet); //Implementar metodo para calcular la victoria del jugador con el objeto bet entrante
                currentBet.setAmountWinned(amountWined);
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException k){
                    throw new RuntimeException(k);
                }
                this.setVisible(false);
                GUILastWindow c = new GUILastWindow(currentBet);
                c.lastWindow();
            }
        });
        JBtnThree.addActionListener((e)->{
            runThree.stopThread();
            if (gameController.isTheGameOver(runOne,runTwo,runThree)){
                Double amountWined = GameController.calculateVictory(runOne,runTwo,runThree,currentBet); //Implementar metodo para calcular la victoria del jugador con el objeto bet entrante
                currentBet.setAmountWinned(amountWined);
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException j){
                    throw new RuntimeException(j);
                }
                this.setVisible(false);
                GUILastWindow c = new GUILastWindow(currentBet);
                c.lastWindow();
            }
        });
    }


    private void timeThread(JLabel hour){
        new Thread(()->{
            while(true){
                LocalTime time = LocalTime.now();
                //System.out.println(time.getHour() + ":" + time.getMinute() + ":" + time.getSecond());
                hour.setText(time.getHour() + ":" + time.getMinute() + ":" + time.getSecond());
                try{
                    Thread.sleep(1000);//Espera un segundo antes de hacer la siguiente ejecucion
                }catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}
