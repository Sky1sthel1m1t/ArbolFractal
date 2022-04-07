package Vista;

import Modelo.Arbol;
import Modelo.Lista;

import javax.swing.*;
import java.awt.*;

public class FrameAddArbol extends JFrame {

    private JPanel panel = new JPanel();

    private JTextField txtComplejidad = new JTextField("");
    private JLabel lbComplejidad = new JLabel("");
    private JButton btnAceptar = new JButton("");

    private int x;
    private int y;

    private Lista lista;

    public FrameAddArbol(int posX, int posY, Lista lista){
        this.x = posX;
        this.y = posY;
        this.lista = lista;
        init1();
    }

    public void init1(){

        this.setLayout(null);
        this.setSize(300,300);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);

        panel.setSize(this.getWidth(), this.getHeight());
        panel.setVisible(true);
        panel.setLayout(null);

        int x = 15;
        int y = 50;
        lbComplejidad.setText("Introduzca la complejidad de su árbol:");
        lbComplejidad.setFont(new Font("Arial", Font.BOLD,13));
        lbComplejidad.setBounds(x,y, 250,50);
        y += 50;
        txtComplejidad.setBounds(x,y,250,30);
        x+=75;
        y+=50;
        btnAceptar.setText("Introducir");
        btnAceptar.setBounds(x,y,100,30);

        btnAceptar.addActionListener(e ->{
            int complejidad;
            String msgError = "Se necesita que introduzca un número";

            if (txtComplejidad.getText().equals("")){
                JOptionPane.showMessageDialog(null,msgError);
            } else {

                try {
                    complejidad = Integer.parseInt(txtComplejidad.getText());
                } catch (Exception error){
                    JOptionPane.showMessageDialog(null, msgError + " o un número más pequeño por "
                    + "seguridad de la maquina");
                    return;
                }

                if (complejidad > 10){
                    JOptionPane.showMessageDialog(null, "Por la seguridad de la maquina" +
                            " no se puede poner una complejidad más alta de 10");
                    return;
                } else if (complejidad <= 0){
                    JOptionPane.showMessageDialog(null, "La complejidad tiene que ser mayor a 0");
                    return;
                }
                else {
                    Arbol arbol = new Arbol(this.x,this.y,complejidad);
                    lista.addArbol(arbol);
                    dispose();
                }

            }
        });

        panel.add(lbComplejidad);
        panel.add(txtComplejidad);
        panel.add(btnAceptar);
        this.add(panel, BorderLayout.CENTER);
    }
}
