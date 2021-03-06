/*
 * DialogoComercio.java
 *
 * Created on April 14, 2008, 10:48 AM
 */

package eps.catan.gui;

import eps.cartas.Carta;
import eps.cartas.Mazo;
import eps.cartas.gui.InterfazMazo;
import eps.catan.BarajaRecursos;
import eps.catan.BarajaRecursos.Recurso;
import eps.catan.TableroCatan;
import eps.catan.accion.AccionComercio;
import eps.multij.Accion;
import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author  mfreire
 */
public class DialogoComercio extends javax.swing.JDialog {
        
    private InterfazMazo im;
    private boolean cancelada;
    private HashMap<Recurso, JComboBox> solicito = new HashMap<Recurso, JComboBox>();
    
    /** Creates new form DialogoComercio */
    public DialogoComercio(java.awt.Dialog parent, Mazo mazoOrigen) {
        super(parent, true);
        initComponents();
        im = new InterfazMazo();
        im.setMazo(mazoOrigen);
        im.setSeparacion(InterfazMazo.MUY_SEPARADAS);
        im.setModoSel(InterfazMazo.SEL_MUCHAS);
        jpOfrezco.add(im, BorderLayout.CENTER);
        solicito.put(Recurso.Madera, jcbMadera);
        solicito.put(Recurso.Trigo, jcbTrigo);
        solicito.put(Recurso.Roca, jcbRoca);
        solicito.put(Recurso.Ladrillo, jcbLadrillo);
        solicito.put(Recurso.Oveja, jcbOvejas);
        String[] opts = new String[]{"0","1","2","3","4","5","6","7","8"};
        for (JComboBox jcb : solicito.values()) {
            jcb.setModel(new DefaultComboBoxModel(opts));
        }
    }
    
    public Accion getAccion(int origen, int destino, TableroCatan tc) {
        
        if (cancelada) {
            return null;
        }
        
        Mazo mo = im.getSeleccionadas();
        Mazo md = new Mazo(mo.getBaraja());
        for (Map.Entry<Recurso, JComboBox> e : solicito.entrySet()) {
            int i = e.getValue().getSelectedIndex();
            Carta c = BarajaRecursos.cartaParaTipo(e.getKey());
            for (int j=0; j<i; j++) md.add(c);
        }
        AccionComercio a = new AccionComercio(mo, origen, md, destino, tc);
        return a;
    }    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jbCancelar = new javax.swing.JButton();
        jbEnviar = new javax.swing.JButton();
        jpOfrezco = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jcbMadera = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jcbOvejas = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jcbRoca = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jcbTrigo = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jcbLadrillo = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jbCancelar.setText("Cancelar Comercio");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(jbCancelar);

        jbEnviar.setText("Enviar Oferta");
        jbEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEnviarActionPerformed(evt);
            }
        });
        jPanel1.add(jbEnviar);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        jpOfrezco.setBorder(javax.swing.BorderFactory.createTitledBorder("Ofrezco"));
        jpOfrezco.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jpOfrezco, java.awt.BorderLayout.CENTER);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Solicito"));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Madera");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel3.add(jLabel1, gridBagConstraints);

        jcbMadera.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel3.add(jcbMadera, gridBagConstraints);

        jLabel2.setText("Ovejas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel3.add(jLabel2, gridBagConstraints);

        jcbOvejas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel3.add(jcbOvejas, gridBagConstraints);

        jLabel3.setText("Roca");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel3.add(jLabel3, gridBagConstraints);

        jcbRoca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel3.add(jcbRoca, gridBagConstraints);

        jLabel4.setText("Trigo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel3.add(jLabel4, gridBagConstraints);

        jcbTrigo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel3.add(jcbTrigo, gridBagConstraints);

        jLabel5.setText("Ladrillo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel3.add(jLabel5, gridBagConstraints);

        jcbLadrillo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel3.add(jcbLadrillo, gridBagConstraints);

        getContentPane().add(jPanel3, java.awt.BorderLayout.EAST);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEnviarActionPerformed
        cancelada = false;
        this.dispose();
    }//GEN-LAST:event_jbEnviarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        cancelada = true;
        this.dispose();
    }//GEN-LAST:event_jbCancelarActionPerformed
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbEnviar;
    private javax.swing.JComboBox jcbLadrillo;
    private javax.swing.JComboBox jcbMadera;
    private javax.swing.JComboBox jcbOvejas;
    private javax.swing.JComboBox jcbRoca;
    private javax.swing.JComboBox jcbTrigo;
    private javax.swing.JPanel jpOfrezco;
    // End of variables declaration//GEN-END:variables
    
}
