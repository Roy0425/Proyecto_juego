/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import modelo.InteraccionObjetos;
import modelo.Sapo;
import vista.GUIJuego;
import vista.PanelFondo;

/**
 *
 * @author Roy
 */
public class ControlJuego implements KeyListener {

private PanelFondo panelFondo; 
private GUIJuego guiJuego;
private InteraccionObjetos interaccion;
private HiloJuego hilo;
    
    public ControlJuego (PanelFondo panelFondo, GUIJuego guiJuego, InteraccionObjetos interaccion)
    {
        this.panelFondo = panelFondo;
        this.guiJuego = guiJuego;
        this.interaccion = interaccion;
        this.hilo = new HiloJuego(panelFondo,interaccion,interaccion.getSapo());
        hilo.start();
        
        panelFondo.setSapo(interaccion.getSapo());
        
    }
    
     
    
    @Override
    public void keyPressed(KeyEvent kEvento) 
    {
    interaccion.getSapo().setBrinco(true);  
    try {
        if(interaccion.verificar()==10)
        {
            hilo.stop();
            interaccion.sonidoCompletaNivel();
            guiJuego.mensaje("Felicitaciones, completo el nivel");     
            guiJuego.dispose();
        }
        else
        {
                  
            if(kEvento.getKeyCode()==38)
                interaccion.mover(38);  
            interaccion.sonidoBrinco();
                         
                       
            if(kEvento.getKeyCode()== 37)
                interaccion.mover(37);
           interaccion.sonidoBrinco();
            
            
            if(kEvento.getKeyCode()==39)
                interaccion.mover(39);
           interaccion.sonidoBrinco();
           
        }
        
    } catch (LineUnavailableException ex) {
        Logger.getLogger(ControlJuego.class.getName()).log(Level.SEVERE, null, ex);
    } catch (UnsupportedAudioFileException ex) {
        Logger.getLogger(ControlJuego.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(ControlJuego.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    } // fin key event
    

    @Override
    public void keyReleased(KeyEvent e) {
       
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    
} // fin clase
