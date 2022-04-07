package Modelo;

import Vista.PanelPrincipal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class Lista {

    private ArrayList<Arbol> arboles = new ArrayList<>();
    private PropertyChangeSupport cambio;

    private Logger logger = LogManager.getRootLogger();

    public Lista(){
        cambio = new PropertyChangeSupport(this);
    }

    public void addObserver(PanelPrincipal observer){
        cambio.addPropertyChangeListener(observer);
    }

    public void addArbol(Arbol arbol){
        arboles.add(arbol);
        cambio.firePropertyChange("NUEVO", this, arbol);
    }

    public void dibujarArboles(Graphics g){
        for (int i = 0; i < arboles.size(); i++) {
            Arbol aux = arboles.get(i);
            aux.dibujar(g);
        }
    }

    public ArrayList<Arbol> getArboles() {
        return arboles;
    }

    public void setArboles(ArrayList<Arbol> arboles) {
        this.arboles = arboles;
    }
}
