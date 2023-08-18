package proyecto1p;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import javax.accessibility.AccessibleContext;

//ESTE ES COMO TABLEROPRINCIPAL
public class Botones extends JFrame{
  private JButton[][] boton;
    int fantasmas1;
    int fantasmas2;
//    int[][]Guia_botones;//Guia_botones=Guia_botones
//    int[] VencidosJugador1;//VencidosVillanos=vencidosJugador1
//    int[] VencidosJugador2;//VencidosHeroes=vencidosJugador2
    boolean turno = true, ganadorJugador1 = false, ganadorJugador2 = false; //ganadorJugador1=ganadorheroes  ganadorJugador2=ganadorvillanos
    Dimension CoordSeleccionada = null;
    Random aleatorio = new Random(); //r=aleatorio

    public Botones() {
        boton = new JButton[6][6];
        for (int fila = 0; fila < 6; fila++) {
            for (int columna = 0; columna < 6; columna++) {
                boton[fila][columna] = new JButton();
            }
        }    
    }
    
    public void configurarTamanoBotones(Dimension tamano) {
        for (int fila = 0; fila < 6; fila++) {
            for (int columna = 0; columna < 6; columna++) {
                boton[fila][columna].setPreferredSize(tamano);
            }
        }
    }
    
    public JButton[][] getBotones() {
        return boton;
    }
public boolean getTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;

    }
//    public int[] getVencidosJugador1() {
//        return VencidosJugador1;
//    }
//
//    public int[] getVencidosJugador2() {
//        return VencidosJugador1;
//    }
//
//    public void setVencidosJugador1(int[] VencidosJugador1) {
//        this.VencidosJugador1 = VencidosJugador1;
//    }
//
//    public void setVencidosJugador2(int[] VencidosJugador2) {
//        this.VencidosJugador2 = VencidosJugador2;
//    }

    public void setGanadorJugador1(boolean ganadorJugador1) {
        this.ganadorJugador1 = ganadorJugador1;
    }

    public boolean getGanadorJugador1() {
        return ganadorJugador1;
    }

    public void setGanadorJugador2(boolean ganadorJugador2) {
        this.ganadorJugador2 = ganadorJugador2;
    }

    public boolean getGanadorJugador2() {
        return ganadorJugador2;
    }
  
}
