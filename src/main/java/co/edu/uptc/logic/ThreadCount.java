package co.edu.uptc.logic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class ThreadCount implements Runnable {

    private JLabel imagesSpace;//Hay que cambiarlo para que acepte imagenes
    private boolean state;

    private boolean sw;

    public ThreadCount(JLabel imagesSpace, boolean sw){
        this.imagesSpace = imagesSpace;
        this.sw = sw;
        state = true;
    }

    public void run(){
        if (sw){
            try {
                showImages();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            //this.minToMax();
        }else{
            //this.maxToMin();
        }
    }

    private void showImages() throws IOException {
        imagesSpace.setIcon(new ImageIcon(this.chargeFirstImage()));
    }

    /*
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
     */
    public void stopThread() {
        state = false;
    }

    private BufferedImage chargeFirstImage() throws IOException {
        File imagenArchivo = new File("/TallerHilosSegundo50/src/imageResources/campan.jpg");
        if (imagenArchivo.exists()) {
            System.out.println("La ruta es válida y el archivo existe.");
        } else {
            System.out.println("La ruta no es válida o el archivo no existe.");
        }
        BufferedImage imagen = ImageIO.read(imagenArchivo);
        return imagen;
    }

    private Image chargeSecondImage() throws IOException {
        File imagenArchivo = new File("/TallerHilosSegundo50/src/imageResources/cerezas.png");
        Image imagen = ImageIO.read(imagenArchivo);
        return imagen;
    }

    private BufferedImage chargeThirdImage() throws IOException {
        File imagenArchivo = new File("imageResources/diamante.png");
        BufferedImage imagen = ImageIO.read(imagenArchivo);
        return imagen;
    }
}
