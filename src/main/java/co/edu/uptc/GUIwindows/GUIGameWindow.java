package co.edu.uptc.GUIwindows;

import co.edu.uptc.logic.ThreadCount;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;

public class GUIGameWindow extends JFrame {

    private JPanel JPMainArea;
    private JLabel JLImagesOne;//Deben ser cambiados por los espacios para imagenes
    private JLabel JLImagesTwo;//Deben ser cambiados por los espacios para imagenes
    private JLabel JLImagesThree;//Deben ser cambiados por los espacios para imagenes

    private JButton JBtnOne;
    private JButton JBtnTwo;
    private JButton JBtnThree;

    public GUIGameWindow(){
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

        ThreadCount runOne = new ThreadCount(JLImagesOne,true);
        ThreadCount runTwo = new ThreadCount(JLImagesTwo,false);
        ThreadCount runThree = new ThreadCount(JLImagesThree,true);

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
