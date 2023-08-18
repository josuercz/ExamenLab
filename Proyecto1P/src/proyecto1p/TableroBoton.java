package proyecto1p;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

//ESTE ES COMO STRATEGO
public class TableroBoton extends javax.swing.JFrame {
    ArrayList<Loggs> ArrayLoggs;
   boolean turno=true;
   int contJugadas = 0, contTutorial = 0;
    
    Botones tableroBotones = new Botones();
    
    int[] Vencidos_Jugador1;
    int[][] Guia_botones;
    int[] Vencidos_Jugador2;
    int partidasJugadasJugador1 = 0, partidasJugadasJugador2 = 0;//partidasJugadasJugador1=partidasjugadasHeroes, partidasJugadasJugador2=partidasjugadasVillanos,
    ArrayList<Usuario> ArrayUsuarios;
    String nombreUsuario, RespTipopartida, RespUsuario, TipoInvitado;
    String[] TipoPartida = {"Jugador1", "Jugador2"};
    boolean mododejuego_Tutorial = true;
    private Botones tableroLogic;
    JPanel fondo = new JPanel();
    
    public TableroBoton(Botones tableroLogic,ArrayList<Usuario> AtributUsuarios, ArrayList<Loggs> AtributLoggs, String nombreUsuario, boolean mododejuego) {
        this.ArrayUsuarios = AtributUsuarios;
        this.nombreUsuario = nombreUsuario;
        this.ArrayLoggs = AtributLoggs;
        this.tableroLogic = tableroLogic;
        //Guia_botones = tableroBotones.getGuia_botones();
//        Vencidos_Jugador1 = tableroBotones.getVencidosJugador1();
//        Vencidos_Jugador2 = tableroBotones.getVencidosJugador2();
        mododejuego_Tutorial = mododejuego;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        setTitle("GHOSTS");

        
        fondo.setPreferredSize(new Dimension(700,700));
        fondo.setBackground(Color.gray);
        //fondo.setLocation(500,500);
        fondo.setLayout(new GridLayout(6, 6));
        
//        Dimension tamanoBotones = new Dimension(110, 110);
//        
//        tableroLogic.configurarTamanoBotones(tamanoBotones);
        JButton[][] botones = tableroLogic.getBotones();

        for (int fila = 0; fila < 6; fila++) {
            for (int columna = 0; columna < 6; columna++) {
                botones[fila][columna].setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto1p/imagenes/base_100x100.png")));
                fondo.add(botones[fila][columna]); 
            }
        }
        
        add(fondo,BorderLayout.CENTER);      
        pack();
        setExtendedState(6);
        initComponents();
        String[] nomusuarios = new String[ArrayUsuarios.size() - 1];
        
        int cont = 0;
        for (int i = 0; i < ArrayUsuarios.size(); i++) {

            System.out.println("" + ArrayUsuarios.get(i).getUsername());
            System.out.println("" + this.nombreUsuario);

            if (!ArrayUsuarios.get(i).getUsername().equals(this.nombreUsuario)) {
                nomusuarios[cont] = ArrayUsuarios.get(i).getUsername();
                cont++;
                }
            }
        if (nomusuarios.length > 1) {
            RespUsuario = (String) JOptionPane.showInputDialog(null, "Escoja el usuario", "", JOptionPane.QUESTION_MESSAGE, null, nomusuarios, nomusuarios[0]);
        } else {
            for (int i = 0; i < ArrayUsuarios.size(); i++) {
                if (!ArrayUsuarios.get(i).getUsername().equals(this.nombreUsuario)) {
                    RespUsuario = ArrayUsuarios.get(i).getUsername();
                }
            }
         }
        mostrarTablero();
        setLocationRelativeTo(null);
    }
    public void mostrarTablero(){
        if (this.turno == false) {
            
                name2.setText("Usuario: " + nombreUsuario);
            

                //name.setText("Usuario: " + RespUsuario);
        }else {
            //name2.setText("Usuario: " + nombreUsuario);
            

                name.setText("Usuario: " + RespUsuario);
    }
        
        fondo.removeAll();
        boolean ganoJugador1 = this.tableroBotones.getGanadorJugador1();
        boolean ganoJugador2 = this.tableroBotones.getGanadorJugador2();
        String jugador1 = "", jugador2 = "";
        //AQUII 
        if (RespUsuario == null) {

            for (int i = 0; i < this.ArrayUsuarios.size(); i++) {

                if (!ArrayUsuarios.get(i).getUsername().equals(this.nombreUsuario)) {

                    RespUsuario = ArrayUsuarios.get(i).getUsername();
                }
            }
        }
       
            jugador1 = nombreUsuario;

            jugador2 = RespUsuario;
        
        if (ganoJugador1 == true) {
            for (int i = 0; i < this.ArrayUsuarios.size(); i++) {
                if (ArrayUsuarios.get(i).getUsername().equals(jugador1)) {
                    ArrayUsuarios.get(i).setpuntos(ArrayUsuarios.get(i).getpuntos() + 3);
                }
            }

            DateTimeFormatter fechapartida = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime fecha = LocalDateTime.now();
            this.ArrayLoggs.add(new Loggs(jugador1 + "Usando heroes ha ganado y " + jugador2 + " usando villanos ha perdido " + fechapartida.format(fecha), "Heroes"));

            JOptionPane.showMessageDialog(null, "Gano " + jugador1 + " ante " + jugador2);
            MenuPrincipal mp3 = new MenuPrincipal(this.ArrayUsuarios, this.ArrayLoggs, nombreUsuario, mododejuego_Tutorial);
            mp3.setVisible(true);
            this.setVisible(false);
            partidasJugadasJugador1++;
        }
        if (ganoJugador2 == true) {
            for (int i = 0; i < this.ArrayUsuarios.size(); i++) {
                if (ArrayUsuarios.get(i).getUsername().equals(jugador2)) {
                    ArrayUsuarios.get(i).setpuntos(ArrayUsuarios.get(i).getpuntos() + 3);
                }
            }

            DateTimeFormatter fechapartida = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime fecha = LocalDateTime.now();
            this.ArrayLoggs.add(new Loggs(jugador2 + "Usando villanos ha ganado ya que " + jugador1 + " usando heroes " + fechapartida.format(fecha), "Villano"));

            JOptionPane.showMessageDialog(null, "Gano" + jugador2 + " ante " + jugador1);
            MenuPrincipal mp3 = new MenuPrincipal(this.ArrayUsuarios, this.ArrayLoggs, nombreUsuario, mododejuego_Tutorial);
            mp3.setVisible(true);
            this.setVisible(false);
            partidasJugadasJugador2++;
        }

    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BG = new javax.swing.JPanel();
        name2 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        name2.setText(" ");

        name.setText(" ");

        javax.swing.GroupLayout BGLayout = new javax.swing.GroupLayout(BG);
        BG.setLayout(BGLayout);
        BGLayout.setHorizontalGroup(
            BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BGLayout.createSequentialGroup()
                .addContainerGap(767, Short.MAX_VALUE)
                .addGroup(BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75))
        );
        BGLayout.setVerticalGroup(
            BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BGLayout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(name2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(467, Short.MAX_VALUE))
        );

        getContentPane().add(BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TableroBoton.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TableroBoton.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TableroBoton.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TableroBoton.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            Botones tableroLogic = new Botones();
            tableroLogic.configurarTamanoBotones(new Dimension(100, 100));
            TableroBoton tableroBoton = new TableroBoton(tableroLogic,null,null,null,true);
            tableroBoton.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BG;
    public javax.swing.JLabel name;
    private javax.swing.JLabel name2;
    // End of variables declaration//GEN-END:variables
}
