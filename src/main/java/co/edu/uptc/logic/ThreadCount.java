package co.edu.uptc.logic;

import javax.swing.*;
import java.util.Random;

public class ThreadCount implements Runnable {

    private JTextField text;//Hay que cambiarlo para que acepte imagenes
    private boolean state;

    private boolean sw;

    public ThreadCount(JTextField text, boolean sw){
        this.text = text;
        this.sw = sw;
        state = true;
    }

    public void run(){
        if (sw){
            this.minToMax();
        }else{
            this.maxToMin();
        }
    }

    /*
     *Muestra los numeros de menor a mayor
     */
    private void minToMax(){
        for (var x = Integer.MIN_VALUE ; x <= Integer.MAX_VALUE && state ; x++){
            text.setText(""+x);//Va mostrando cada numero en pantalla
            try {
                Thread.sleep(new Random().nextInt(200));
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }

    /*
     *Muestra los numeros de mayor a menor
     */
    private void maxToMin(){
        for (var x = Integer.MAX_VALUE ; x >= Integer.MIN_VALUE && state; x--){
            text.setText(""+x);
            try {
                Thread.sleep(new Random().nextInt(200));
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }

    public void stopThread() {
        state = false;
    }
}
