/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import modelo.InteraccionObjetos;
import modelo.Sapo;
import vista.PanelFondo;

/**
 *
 * @author Roy
 */
public class HiloJuego extends Thread  {
  
private PanelFondo panelFondo;
private InteraccionObjetos interaccion;
private Sapo sapo;

    public HiloJuego(PanelFondo panelFondo, InteraccionObjetos interaccion,Sapo sapo)
    {
        this.panelFondo = panelFondo;
        this.interaccion = interaccion;
        this.sapo = sapo;
    
    }
    
    
    public void run()
    {
        while(true)
        {     
            
            try {
                sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloJuego.class.getName()).log(Level.SEVERE, null, ex);
            }
            panelFondo.repaint();
            interaccion.bajar(sapo.isBrinco()); 
            try {
                interaccion.verificar();
            } catch (LineUnavailableException ex) {
                Logger.getLogger(HiloJuego.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(HiloJuego.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(HiloJuego.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
        }
    }
   

    
} // fin clase