package Modelo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;

public class Arbol {

    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int largo;
    private int ancho;
    private int complejidad;
    private Color color;


    private Logger logger = LogManager.getRootLogger();

    public Arbol(int x1, int y1, int complejidad) {
        this.x1 = x1;
        this.y1 = y1;
        this.complejidad = complejidad;
        this.largo = 50 * (y1 / 200);
        this.ancho = 5 * (y1 / 100);
        this.x2 = x1;
        this.y2 = y1 - largo;
        this.color = new Color(132, 64, 36, 225);
    }


    public void dibujar(Graphics g) {
        System.out.println("--------------------------------------------");
        dibujarArbol(g, x1, y1, x2, y2, largo, ancho, complejidad);
        System.out.println("--------------------------------------------");
    }

    private void dibujarArbol(Graphics g, int x, int y, int x2, int y2, int largo, int ancho, int complejidad) {
        Graphics2D graphics2D = (Graphics2D) g;

        if (complejidad == 1) {
            BasicStroke basicStroke = new BasicStroke(ancho, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
            Line2D linea = new Line2D.Double(x, y, x2, y2);
            graphics2D.setColor(color);
            graphics2D.setStroke(basicStroke);
            graphics2D.draw(linea);
            logger.debug("Se dibujo una rama en el punto (" + linea.getX1() + ";" + linea.getY1() + ") hacia el punto (" +
                    linea.getX2() + ";" + linea.getY2() + ")" );
            return;
        }

        int newComplejidad = complejidad - 1;

        dibujarArbol(g, x, y, x2, y2, largo, ancho, newComplejidad);

        int newLargo = (int) (largo * 0.75);
        int newAncho = (int) (ancho * 0.60);
        int newX = x2;
        int newY = y2;
        int newX2 = newX - newLargo;
        int newY2 = newY - newLargo;

        dibujarArbol(g, newX, newY, newX2, newY2, newLargo, newAncho, newComplejidad);

        newX2 = newX + newLargo;

        dibujarArbol(g, newX, newY, newX2, newY2, newLargo, newAncho, newComplejidad);
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getComplejidad() {
        return complejidad;
    }

    public void setComplejidad(int complejidad) {
        this.complejidad = complejidad;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
