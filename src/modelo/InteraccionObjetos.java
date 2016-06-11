/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.IOException;
import java.util.ArrayList;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import vista.PanelFondo;


/**
 *
 * @author Roy
 */
public class InteraccionObjetos {
 
private Sapo sapo;
private Monedas moneda1, moneda2, moneda3, moneda4, moneda5, moneda6, moneda7, moneda8,moneda9,moneda10;
private ArrayList<Monedas> listaMonedas;
private PanelFondo panelFondo;
private int contador;


    public InteraccionObjetos(PanelFondo panelFondo)
    {
        this.listaMonedas = new ArrayList<>();
        this.panelFondo = panelFondo;
        this.contador = 0;
        
        this.sapo = new Sapo(20,440,25,25);
        this.moneda1 = new Monedas(30,10,25,25);
        this.moneda2 = new Monedas(120,70,25,25);
        this.moneda3 = new Monedas(240,120,25,25);
        this.moneda4 = new Monedas(360,40,25,25);
        this.moneda5 = new Monedas(490,10,25,25);
        this.moneda6 = new Monedas (580,70,25,25);
        this.moneda7 = new Monedas (670,220,25,25);
        this.moneda8 = new Monedas(780,70,25,25);
        this.moneda9 = new Monedas(900,130,25,25);
        this.moneda10 = new Monedas (970,20,25,25);
        listaMonedas.add(moneda1);
        listaMonedas.add(moneda2);
        listaMonedas.add(moneda3);
        listaMonedas.add(moneda4);
        listaMonedas.add(moneda5);
        listaMonedas.add(moneda6);
        listaMonedas.add(moneda7);
        listaMonedas.add(moneda8);
        listaMonedas.add(moneda9);
        listaMonedas.add(moneda10);        
    }

    public Sapo getSapo() {
        return sapo;
    }
    
    public ArrayList<Monedas> getListaMonedas()
    {
        return this.listaMonedas;
    }
 ///////////////////////////////////////////////////////////

    public void mover(int codigoTecla)
    {   
        if(codigoTecla ==  38)
        {   
            if(this.sapo.getY()-30 > 0)
            {
                this.sapo.setY(this.sapo.getY()-30); 
                this.sapo.setBrinco(false);
            }
                
        }
        
        if(codigoTecla == 37)
        {
            if(this.sapo.getX() - 10 > 0)
                this.sapo.setX(this.sapo.getX() - 10);
                          
        }
        
        if(codigoTecla == 39)
        {
            if(this.sapo.getX() + 10 < panelFondo.getWidth()-50)
                this.sapo.setX(this.sapo.getX() + 10);
               
        }
        
     
    }
           
    
    
    public void bajar(boolean condicion)
    {
        if(condicion)
        {
            if(sapo.getY()!=440)
                sapo.setY(sapo.getY()+5);
            
        }
         
    }
    
    public boolean insercion(Sapo sapo, Monedas moneda)
    {
        if (sapo.getX() + sapo.getAncho() < moneda.getX()) {
            return false;
        }
        if (sapo.getY() + sapo.getAlto() < moneda.getY()) {
            return false;
        }
        if (sapo.getX() > moneda.getX() + moneda.getAncho()) {
            return false;
        }
        if (sapo.getY() > moneda.getY() + moneda.getAlto()) {
            return false;
        }
        return true;
}
    
    public int verificar() throws LineUnavailableException, UnsupportedAudioFileException, IOException
    {
        for(int i = 0; i < listaMonedas.size(); i++)
        {
             if(insercion(this.sapo, listaMonedas.get(i)))
            {
                listaMonedas.remove(i);
                panelFondo.setMonedas(listaMonedas);
                sonidoMoneda();
                contador++;
                
            }
            
        }
    return contador;
    }
    
    
    public void sonidoMoneda() throws LineUnavailableException, UnsupportedAudioFileException, IOException
    {
        Clip sonido = AudioSystem.getClip();
        sonido.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/sonidos/moneda.wav")));
        sonido.start();
        
    }   
    
    public void sonidoCompletaNivel() throws LineUnavailableException, UnsupportedAudioFileException, IOException
    {
        Clip sonido = AudioSystem.getClip();
        sonido.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/sonidos/completa nivel.wav")));
        sonido.start();
        
    }
    
     public void sonidoBrinco() throws LineUnavailableException, UnsupportedAudioFileException, IOException
    {
        Clip sonido = AudioSystem.getClip();
        sonido.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/sonidos/brinco.wav")));
        sonido.start();
        
    }
    
    
    
    
 
}// fin clase
