package kmeans;

import java.awt.Point;
import java.util.ArrayList;

public class algoritmo {

    ArrayList<Point> puntos = new ArrayList<Point>();
    ArrayList<Point> atractores = new ArrayList<Point>();
    ArrayList<Integer> clases = new ArrayList<Integer>();
    ArrayList<Point> centroides = new ArrayList<Point>();
    int cuantosCentros;

    public algoritmo(ArrayList<Point> puntos, ArrayList<Point> atractores, ArrayList<Integer> clases) {
        this.puntos = puntos;
        this.atractores = atractores;
        this.clases = clases;
        cuantosCentros = atractores.size();
    }

    public void clasificar() {
        double distancia;
        clases.clear();
        for (int i = 0; i < puntos.size(); i++) {
            distancia=obtenerDistancia(puntos.get(i), atractores.get(0));
            clases.add(0);
            for (int j = 1; j < atractores.size(); j++) {
                if (distancia >= obtenerDistancia(puntos.get(i), atractores.get(j))) {
                    clases.set(i,j);
                }
            }
        }
    }

    public void calculacentroides() {
        int it = 0;
        double x = 0, y = 0;
        centroides.clear();
        for (int i = 0; i < cuantosCentros; i++) {
            for (int j = 0; j < puntos.size(); j++) {
                if (clases.get(j) == i) {
                    x += puntos.get(j).x;
                    y += puntos.get(j).y;
                    it++;
                }
            }
            centroides.add(new Point((int) x / it, (int) y / it));
            it = 0;
            x = 0;
            y = 0;
        }
    }

    private double obtenerDistancia(Point p1, Point p2) {
        int nX = p1.x - p2.x;
        int nY = p1.y - p2.y;

        return Math.sqrt(Math.pow(nX, 2) + Math.pow(nY, 2));
//        return Math.abs(nX) + Math.abs(nY);
//        return Math.max(Math.abs(nX), Math.abs(nY));
//        return Math.pow(((Math.pow(Math.abs(nX), 3)) + (Math.pow(Math.abs(nY), 3))), (1f / 3f));
    }

}
