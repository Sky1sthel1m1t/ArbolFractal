package Vista;

import Modelo.Arbol;
import Modelo.Lista;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FramePrincipal extends JFrame implements MouseListener {

    private PanelPrincipal panelPrincipal;
    private Logger logger = LogManager.getRootLogger();
    private Lista lista;
    private int horizonte;

    public FramePrincipal(Lista lista){
        this.lista = lista;
        init1();
        lista.addObserver(panelPrincipal);
    }

    public void init1(){
        // Iniciando el Frame
        this.setSize(1400,900);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

        //Iniciando el panel
        this.horizonte = (25 * this.getHeight()) /100;
        System.out.println(horizonte);
        panelPrincipal = new PanelPrincipal(this.getWidth(),this.getHeight(), lista, horizonte);
        panelPrincipal.addMouseListener(this);
        this.add(panelPrincipal);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getY() < horizonte){
            JOptionPane.showMessageDialog(null, "No se puede poner un arbol en el cielo");
        } else {
            logger.info("Se hizo click en la posicion (" + e.getX() + " , " + e.getY() + ")");
            new FrameAddArbol(e.getX(), e.getY(), lista);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
