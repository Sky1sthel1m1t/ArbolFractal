package Vista;


import Modelo.Lista;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PanelPrincipal extends JPanel implements PropertyChangeListener {

    private int ancho;
    private int alto;
    private Lista lista;
    private int horizonte;

    private Logger logger = LogManager.getRootLogger();

    public PanelPrincipal(int ancho, int alto, Lista lista, int horizonte) {
        this.ancho = ancho;
        this.alto = alto;
        this.lista = lista;
        this.horizonte = horizonte;
    }

    public void dibujarFondo(Graphics g){
        g.setColor(Color.CYAN);
        g.fillRect(0,0,ancho, horizonte);
        g.setColor(Color.GREEN);
        g.fillRect(0,horizonte, ancho, alto);
        g.setColor(Color.YELLOW);
        g.fillOval(ancho - 100, -100,200,200);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        dibujarFondo(g);
        lista.dibujarArboles(g);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("NUEVO")){
            repaint();
            return;
        }
    }
}
