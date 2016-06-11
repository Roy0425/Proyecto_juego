/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Roy
 */
public class Monedas {
  
private int x,y;
private int ancho, alto;
private ImageIcon imagen;

    public Monedas(int x, int y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.imagen = new ImageIcon(getClass().getResource("/img/estrella.png"));
  
    }
    
    public Monedas() {
        this.x = 0;
        this.y = 0;
        this.ancho = 0; 
        this.alto = 0; 
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }
      
    
    public void dibujarMoneda(Graphics g)
    {
        this.imagen.paintIcon(null, g, getX(), getY());
    }
    
   
    
}
