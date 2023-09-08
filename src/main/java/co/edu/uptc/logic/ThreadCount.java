package co.edu.uptc.logic;

import co.edu.uptc.GUIwindows.GUIGameWindow;
import co.edu.uptc.GUIwindows.GUILastWindow;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class ThreadCount implements Runnable {

    private JLabel JLimagesSpace;
    private boolean State;

    private  String ImageName;
    private boolean stopRequested; //Indicar si se solicitó detener la visualización
    private int initialDelay; //Tiempo de espera inicial entre cambios de imagen
    private int delayIncrease; //Velocidad de incremento del tiempo de espera

    private GUIGameWindow currentWindow;




    public ThreadCount(JLabel imagesSpace, boolean state, GUIGameWindow currentWindow){
        this.JLimagesSpace = imagesSpace;
        this.State = state;
        this.initialDelay = 100;
        this.delayIncrease = 20;
        this.currentWindow = currentWindow;
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
        }
    }

    private void showImages() throws IOException {
        Random rdn = new Random();
        int delay = this.initialDelay;//Tiempo de espera inicial

        while (State && !stopRequested){
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
                Thread.sleep(delay);
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }

            //aumenta gradualmente el tiempo de cambio
            delay += delayIncrease;


            if (delay >= 800) {
                State = false;
                currentWindow.setVisible(false);
                GUILastWindow c = new GUILastWindow(null);
                c.lastWindow();
            }

        }
    }

    public void stopThread() {
        State = false;
        stopRequested = true; //Indicar que se solicitó detener la visualización
    }

    private Image chargeFirstImage() throws IOException {
        String route =  "src/main/java/co/edu/uptc/GUIwindows/imageResources/cerezas.png";
        File imagenArchivo = new File(route);
        this.setImageName(route);

        Image imagen = ImageIO.read(imagenArchivo);

        int width = JLimagesSpace.getWidth();
        int height = JLimagesSpace.getHeight();
        Image scaledImage = imagen.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        return scaledImage;
    }

    private Image chargeSecondImage() throws IOException {
        String route =  "src/main/java/co/edu/uptc/GUIwindows/imageResources/diamante.png";
        File imagenArchivo = new File(route);
        this.setImageName(route);

        Image imagen = ImageIO.read(imagenArchivo);

        int width = JLimagesSpace.getWidth();
        int height = JLimagesSpace.getHeight();
        Image scaledImage = imagen.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        return scaledImage;
    }

    private Image chargeThirdImage() throws IOException {
        String route =  "src/main/java/co/edu/uptc/GUIwindows/imageResources/limon.png";
        File imagenArchivo = new File(route);
        this.setImageName(route);
        Image imagen = ImageIO.read(imagenArchivo);

        int width = JLimagesSpace.getWidth();
        int height = JLimagesSpace.getHeight();
        Image scaledImage = imagen.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        return scaledImage;
    }

    private Image chargeFourthImage() throws IOException {
        String route =  "src/main/java/co/edu/uptc/GUIwindows/imageResources/sandia.png";
        File imagenArchivo = new File(route);
        this.setImageName(route);

        Image imagen = ImageIO.read(imagenArchivo);

        int width = JLimagesSpace.getWidth();
        int height = JLimagesSpace.getHeight();
        Image scaledImage = imagen.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        return scaledImage;
    }

    private Image chargeFifthImage() throws IOException {
        String route =  "src/main/java/co/edu/uptc/GUIwindows/imageResources/siete.png";
        File imagenArchivo = new File(route);
        this.setImageName(route);

        Image imagen = ImageIO.read(imagenArchivo);

        int width = JLimagesSpace.getWidth();
        int height = JLimagesSpace.getHeight();
        Image scaledImage = imagen.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        return scaledImage;
    }

    private Image chargeSixthImage() throws IOException {
        String route =  "src/main/java/co/edu/uptc/GUIwindows/imageResources/uva.png";
        File imagenArchivo = new File(route);
        this.setImageName(route);

        Image imagen = ImageIO.read(imagenArchivo);

        int width = JLimagesSpace.getWidth();
        int height = JLimagesSpace.getHeight();
        Image scaledImage = imagen.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        return scaledImage;
    }
}
