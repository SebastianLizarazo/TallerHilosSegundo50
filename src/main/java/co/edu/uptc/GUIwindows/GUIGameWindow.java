package co.edu.uptc.GUIwindows;

import co.edu.uptc.logic.ThreadCount;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;

public class GUIGameWindow extends JFrame {

    private JPanel JPMainArea;
    private JTextField JTTxtOne;//Deben ser cambiados por los espacios para imagenes
    private JTextField JTTxtTwo;//Deben ser cambiados por los espacios para imagenes
    private JTextField JTTxtThree;//Deben ser cambiados por los espacios para imagenes

    private JButton JBtnOne;
    private JButton JBtnTwo;
    private JButton JBtnThree;

    public GUIGameWindow(){
        JPMainArea = new JPanel();

        JTTxtOne = new JTextField();
        JTTxtTwo = new JTextField();
        JTTxtThree = new JTextField();

        JBtnOne = new JButton("Stop");
        JBtnTwo = new JButton("Stop");
        JBtnThree = new JButton("Stop");

        setTitle("Pantalla de juego");
        setSize(600,300);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }

    public void GameScreen(){//Es el equivalente del metodo begin del ejemplo de hilos

        JPMainArea.setLayout(new GridLayout(2,3));//Organiza los componentes en una cuadricula


        JPMainArea.add(JTTxtOne);
        JPMainArea.add(JTTxtTwo);
        JPMainArea.add(JTTxtThree);
        JPMainArea.add(JBtnOne);
        JPMainArea.add(JBtnTwo);
        JPMainArea.add(JBtnThree);
        this.add(JPMainArea,BorderLayout.CENTER);

        setVisible(true);

        addComponents();
    }


    private void addComponents() {//El metodo controlador

        ThreadCount runOne = new ThreadCount(JTTxtOne,true);
        ThreadCount runTwo = new ThreadCount(JTTxtTwo,false);
        ThreadCount runThree = new ThreadCount(JTTxtThree,true);

        Thread thOne = new Thread(runOne);
        Thread thTwo = new Thread(runTwo);
        Thread thThree = new Thread(runThree);

        thOne.start();
        thTwo.start();
        thThree.start();

        //Los action listener de cada boton para detener el contador
        JBtnOne.addActionListener((e)->{
            runOne.stopThread();
        });
        JBtnTwo.addActionListener((e)->{
            runTwo.stopThread();
        });
        JBtnThree.addActionListener((e)->{
            runThree.stopThread();
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
