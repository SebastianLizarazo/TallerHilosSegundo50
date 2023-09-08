package co.edu.uptc.logic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class ThreadCount implements Runnable {

    private JLabel JLimagesSpace;//Hay que cambiarlo para que acepte imagenes
    private boolean state;

    private boolean sw;

    public ThreadCount(JLabel imagesSpace, boolean sw){
        this.JLimagesSpace = imagesSpace;
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
        Random rdn = new Random();
        while (state){
            int num = rdn.nextInt(60);
            if (num>=1 && num<=10){
                JLimagesSpace.setIcon(new ImageIcon(this.chargeFirstImage()));
            }else if (num>=11 && num<=20){
                JLimagesSpace.setIcon(new ImageIcon(this.chargeSecondImage()));
            }else if (num>=21 && num<=30){
                JLimagesSpace.setIcon(new ImageIcon(this.chargeThirdImage()));
            }else if (num>=31 && num<=40){
                JLimagesSpace.setIcon(new ImageIcon(this.chargeFourthImage()));
            }else if (num>=41 && num<=50){
                JLimagesSpace.setIcon(new ImageIcon(this.chargeFifthImage()));
            }else if (num>=51 && num<=60){
                JLimagesSpace.setIcon(new ImageIcon(this.chargeSixthImage()));
            }
            try {
                Thread.sleep(new Random().nextInt(200));
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }

        }
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

    private Image chargeFirstImage() throws IOException {
        File imagenArchivo = new File("C:/Users/sebli/IdeaProjects/TallerHilosSegundo50/src/imageResources/cerezas.png");
        Image imagen = ImageIO.read(imagenArchivo);

        int width = JLimagesSpace.getWidth();
        int height = JLimagesSpace.getHeight();
        Image scaledImage = imagen.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        return scaledImage;
    }

    private Image chargeSecondImage() throws IOException {
        File imagenArchivo = new File("C:/Users/sebli/IdeaProjects/TallerHilosSegundo50/src/imageResources/diamante.png");
        Image imagen = ImageIO.read(imagenArchivo);

        int width = JLimagesSpace.getWidth();
        int height = JLimagesSpace.getHeight();
        Image scaledImage = imagen.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        return scaledImage;
    }

    private Image chargeThirdImage() throws IOException {
        File imagenArchivo = new File("C:/Users/sebli/IdeaProjects/TallerHilosSegundo50/src/imageResources/limon.png");
        Image imagen = ImageIO.read(imagenArchivo);

        int width = JLimagesSpace.getWidth();
        int height = JLimagesSpace.getHeight();
        Image scaledImage = imagen.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        return scaledImage;
    }

    private Image chargeFourthImage() throws IOException {
        File imagenArchivo = new File("C:/Users/sebli/IdeaProjects/TallerHilosSegundo50/src/imageResources/sandia.png");
        Image imagen = ImageIO.read(imagenArchivo);

        int width = JLimagesSpace.getWidth();
        int height = JLimagesSpace.getHeight();
        Image scaledImage = imagen.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        return scaledImage;
    }

    private Image chargeFifthImage() throws IOException {
        File imagenArchivo = new File("C:/Users/sebli/IdeaProjects/TallerHilosSegundo50/src/imageResources/siete.png");
        Image imagen = ImageIO.read(imagenArchivo);

        int width = JLimagesSpace.getWidth();
        int height = JLimagesSpace.getHeight();
        Image scaledImage = imagen.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        return scaledImage;
    }

    private Image chargeSixthImage() throws IOException {
        File imagenArchivo = new File("C:/Users/sebli/IdeaProjects/TallerHilosSegundo50/src/imageResources/uva.png");
        Image imagen = ImageIO.read(imagenArchivo);

        int width = JLimagesSpace.getWidth();
        int height = JLimagesSpace.getHeight();
        Image scaledImage = imagen.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        return scaledImage;
    }
}
