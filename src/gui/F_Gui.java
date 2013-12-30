package gui;

import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import llegircvs.Intermediari;
import llegircvs.LlegirCvs;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class F_Gui extends javax.swing.JFrame {

    DefaultListModel llista = new DefaultListModel();

    public F_Gui() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelRutaFitxer = new javax.swing.JLabel();
        labelListatMateries = new javax.swing.JLabel();
        botoExaminar = new javax.swing.JButton();
        botoGenerar = new javax.swing.JButton();
        rutaFitxer = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        listatMateries = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Generador de llistats");

        labelRutaFitxer.setText("Indica el fitxer que cont� les dades a tractar:");

        labelListatMateries.setText("Selecciona les mat�ries de les quals vols generar llistes:");

        botoExaminar.setText("Examinar...");
        botoExaminar.setName("ButtonExaminar"); // NOI18N
        botoExaminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoExaminarActionPerformed(evt);
            }
        });

        botoGenerar.setText("Generar Llistes");
        botoGenerar.setName("ButtonGenerarLl"); // NOI18N

        rutaFitxer.setEditable(false);
        rutaFitxer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rutaFitxerActionPerformed(evt);
            }
        });

        listatMateries.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listatMateriesValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listatMateries);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rutaFitxer, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botoExaminar, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelListatMateries)
                            .addComponent(labelRutaFitxer))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(380, Short.MAX_VALUE)
                    .addComponent(botoGenerar)
                    .addGap(18, 18, 18)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelRutaFitxer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botoExaminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rutaFitxer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(labelListatMateries)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(133, Short.MAX_VALUE)
                    .addComponent(botoGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(71, 71, 71)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botoExaminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoExaminarActionPerformed
        if (evt.getSource() == botoExaminar) {
            File file;

            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Fitxers Cvs", "csv");
            chooser.setFileFilter(filter);

            int returnVal = chooser.showOpenDialog(this);

            if (returnVal == JFileChooser.APPROVE_OPTION) { //si ha escollit ok,si,etc.
                file = chooser.getSelectedFile();

                if (!filter.accept(file)) {      //si no s'aplica el filtre, mostre una finestra de error(amb la x).
                    JOptionPane.showMessageDialog(rootPane, "Fitxer incorrecte", "Error", returnVal);//showMessageDialog(new JFrame(), "No es un fitxer Csv");
                } else {

                    LlegirCvs cvs = new LlegirCvs(chooser.getSelectedFile().getAbsolutePath().toString());
                    String[] tMateries = cvs.mostrarMateries();
                    // inter.setRutaFitxer(chooser.getSelectedFile().getAbsolutePath().toString());
                    for (int i = 0; i < tMateries.length;i++){
                        llista.addElement(tMateries[i]);
                    }
                    listatMateries.setModel(llista);

                    rutaFitxer.setText(chooser.getSelectedFile().getAbsolutePath().toString()); //mostro el nom del arxiu.
                }
            }
        }
    }//GEN-LAST:event_botoExaminarActionPerformed

    private void rutaFitxerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rutaFitxerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rutaFitxerActionPerformed

    private void listatMateriesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listatMateriesValueChanged
        String[] materiesSeleccionades = null;
        
        if (!listatMateries.isSelectionEmpty()){
            materiesSeleccionades = (String[])listatMateries.getSelectedValuesList().toArray(); 
        }
        
        
        
    }//GEN-LAST:event_listatMateriesValueChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(F_Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(F_Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(F_Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(F_Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new F_Gui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botoExaminar;
    private javax.swing.JButton botoGenerar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelListatMateries;
    private javax.swing.JLabel labelRutaFitxer;
    private javax.swing.JList listatMateries;
    private javax.swing.JTextField rutaFitxer;
    // End of variables declaration//GEN-END:variables
}
