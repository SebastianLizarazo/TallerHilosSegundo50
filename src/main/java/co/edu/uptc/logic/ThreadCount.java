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
    private boolean State;

    private  String ImageName;



    public ThreadCount(JLabel imagesSpace, boolean state){
        this.JLimagesSpace = imagesSpace;
        this.State = state;
    }

    public JLabel getJLimagesSpace() {
        return JLimagesSpace;
    }

    public void setJLimagesSpace(JLabel JLimagesSpace) {
        this.JLimagesSpace = JLimagesSpace;
    }

    public boolean isState() {
        return State;
    }

    public void setState(boolean state) {
        this.State = state;
    }

    public String getImageName() {
        return ImageName;
    }

    public void setImageName(String imageName) {
        ImageName = imageName;
    }

    public void run(){
        if (State){
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
        while (State){
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

    public void stopThread() {
        State = false;
    }

    private Image chargeFirstImage() throws IOException {
        String route =  "C:/Users/sebli/IdeaProjects/TallerHilosSegundo50/src/imageResources/cerezas.png";
        File imagenArchivo = new File(route);
        this.setImageName(route);

        Image imagen = ImageIO.read(imagenArchivo);

        int width = JLimagesSpace.getWidth();
        int height = JLimagesSpace.getHeight();
        Image scaledImage = imagen.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        return scaledImage;
    }

    private Image chargeSecondImage() throws IOException {
        String route =  "C:/Users/sebli/IdeaProjects/TallerHilosSegundo50/src/imageResources/diamante.png";
        File imagenArchivo = new File(route);
        this.setImageName(route);

        Image imagen = ImageIO.read(imagenArchivo);

        int width = JLimagesSpace.getWidth();
        int height = JLimagesSpace.getHeight();
        Image scaledImage = imagen.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        return scaledImage;
    }

    private Image chargeThirdImage() throws IOException {
        String route =  "C:/Users/sebli/IdeaProjects/TallerHilosSegundo50/src/imageResources/limon.png";
        File imagenArchivo = new File(route);
        this.setImageName(route);
        Image imagen = ImageIO.read(imagenArchivo);

        int width = JLimagesSpace.getWidth();
        int height = JLimagesSpace.getHeight();
        Image scaledImage = imagen.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        return scaledImage;
    }

    private Image chargeFourthImage() throws IOException {
        String route =  "C:/Users/sebli/IdeaProjects/TallerHilosSegundo50/src/imageResources/sandia.png";
        File imagenArchivo = new File(route);
        this.setImageName(route);

        Image imagen = ImageIO.read(imagenArchivo);

        int width = JLimagesSpace.getWidth();
        int height = JLimagesSpace.getHeight();
        Image scaledImage = imagen.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        return scaledImage;
    }

    private Image chargeFifthImage() throws IOException {
        String route =  "C:/Users/sebli/IdeaProjects/TallerHilosSegundo50/src/imageResources/siete.png";
        File imagenArchivo = new File(route);
        this.setImageName(route);

        Image imagen = ImageIO.read(imagenArchivo);

        int width = JLimagesSpace.getWidth();
        int height = JLimagesSpace.getHeight();
        Image scaledImage = imagen.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        return scaledImage;
    }

    private Image chargeSixthImage() throws IOException {
        String route =  "C:/Users/sebli/IdeaProjects/TallerHilosSegundo50/src/imageResources/uva.png";
        File imagenArchivo = new File(route);
        this.setImageName(route);

        Image imagen = ImageIO.read(imagenArchivo);

        int width = JLimagesSpace.getWidth();
        int height = JLimagesSpace.getHeight();
        Image scaledImage = imagen.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        return scaledImage;
    }
}
