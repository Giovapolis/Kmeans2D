package Interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ejes extends JPanel {

    public ArrayList<Point> puntos = new ArrayList<Point>();
    public ArrayList<Point> atractores = new ArrayList<Point>();
    public ArrayList<Point> centroides = new ArrayList<Point>();
    public ArrayList<Integer> clases = new ArrayList<Integer>();
    public ArrayList<Color> colores = new ArrayList<Color>();

    public int atractoresColocados = 0;

    public ejes() {
    }

    @Override
    public void paintComponent(Graphics g) {
        dibujaLineas(g);
    }

    public void paintI(Graphics g) {
        g.create();
    }

    public void dibujaLineas(Graphics g) {
        //Ejes
        g.setColor(Color.BLUE);
        g.drawLine(0, this.getHeight() / 2, this.getWidth(), this.getHeight() / 2);
        g.drawLine(this.getWidth() / 2, 0, this.getWidth() / 2, this.getHeight());

        int numdiv = 22;//Cuantas diviciones queremos
        int cadacuanto = 25;//Cada cuantos pixeles

        //Cuadricula
        g.setColor(Color.GRAY);
        for (int i = 0; i < numdiv; i++) {
            g.drawLine((i * cadacuanto), 0, (i * cadacuanto), (this.getHeight()));
            g.drawLine(0, (i * cadacuanto), this.getWidth(), (i * cadacuanto));
        }

        //Números
        g.setColor(Color.BLACK);
        Font fuente = new Font("Monospaced", Font.BOLD, 9);
        g.setFont(fuente);
        for (int i = 0; i < numdiv; i++) {
            g.drawString(Integer.toString((i - 10) * cadacuanto), (i * cadacuanto), (this.getWidth() / 2) - 3);
            g.drawString(Integer.toString((i - 10) * cadacuanto), (this.getHeight() / 2) - 3, (i * cadacuanto));
        }
    }

    public void dibujarPuntos(Graphics g) {
        g.clearRect(0, 0, 501, 501);
        dibujaLineas(g);
        g.setColor(Color.blue);
        for (int i = 0; i < puntos.size(); i++) {
            g.fillRect((int) puntos.get(i).getX(), (int) puntos.get(i).getY(), 5, 5);
        }
    }

    public void dibujarAtractores(Graphics g) {
        dibujaLineas(g);
        for (int i = 0; i < atractores.size(); i++) {
            g.setColor(colores.get(i));
            g.fillOval((int) atractores.get(i).getX(), (int) atractores.get(i).getY(), 10, 10);
        }
    }

    public void dibujarclasificados(Graphics g) {
        g.clearRect(0, 0, 501, 501);

        dibujaLineas(g);

        for (int i = 0; i < puntos.size(); i++) {
            g.setColor(colores.get(clases.get(i)));
            g.fillRect((int) puntos.get(i).getX(), (int) puntos.get(i).getY(), 5, 5);
        }
        
        for (int i = 0; i < atractores.size(); i++) {
            g.setColor(Color.BLACK);
            g.fillOval((int) atractores.get(i).getX(), (int) atractores.get(i).getY(), 10, 10);
        }
    }
}
