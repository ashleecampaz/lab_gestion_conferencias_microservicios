package com.conference.gui.presentation;

//import co.unicauca.edu.articulo_microservicio.presentation.GUIcreateArticle;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author Ashlee Campaz
 */
public class pnlAutor extends javax.swing.JPanel {

    /**
     * Creates new form pnlAutor
     */
    public pnlAutor(int num) {
        initComponents();
        lbAutor.setText("Autor " + num);
    }
public pnlAutor() {
        initComponents();
    }
    public JLabel getLbAutor() {
        return lbAutor;
    }

    public void setLbAutor(JLabel lbAutor) {
        this.lbAutor = lbAutor;
    }

    public JTextField getTxtfApellido() {
        return txtfApellido;
    }

    public void setTxtfApellido(JTextField txtfApellido) {
        this.txtfApellido = txtfApellido;
    }

    public JTextField getTxtfCorreo() {
        return txtfCorreo;
    }

    public void setTxtfCorreo(JTextField txtfCorreo) {
        this.txtfCorreo = txtfCorreo;
    }

    public JTextField getTxtfNombre() {
        return txtfNombre;
    }

    public void setTxtfNombre(JTextField txtfNombre) {
        this.txtfNombre = txtfNombre;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtfNombre = new javax.swing.JTextField();
        txtfApellido = new javax.swing.JTextField();
        txtfCorreo = new javax.swing.JTextField();
        lbAutor = new javax.swing.JLabel();
        lbEliminar = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMaximumSize(new java.awt.Dimension(342, 161));
        setPreferredSize(new java.awt.Dimension(342, 161));

        txtfNombre.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        txtfNombre.setBorder(javax.swing.BorderFactory.createTitledBorder("*Nombre"));

        txtfApellido.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        txtfApellido.setBorder(javax.swing.BorderFactory.createTitledBorder("*Apellido"));

        txtfCorreo.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        txtfCorreo.setBorder(javax.swing.BorderFactory.createTitledBorder("*Correo electronico"));

        lbAutor.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        lbAutor.setForeground(new java.awt.Color(102, 102, 102));
        lbAutor.setText("Autor");

        lbEliminar.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        lbEliminar.setText("X");
        lbEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbEliminarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbEliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbEliminarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtfCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtfApellido)))
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbAutor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbEliminar)
                        .addGap(14, 14, 14))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEliminar)
                    .addComponent(lbAutor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtfCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lbEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbEliminarMouseClicked
        GUIcreateArticle internalFrameContenedor =  (GUIcreateArticle) SwingUtilities.getAncestorOfClass(JInternalFrame.class, this);
        internalFrameContenedor.getListadoAutores().remove(this);
        internalFrameContenedor.getPnlAutores().remove(this);
        internalFrameContenedor.actualizarListadoAutores();
        internalFrameContenedor.repaint();
    }//GEN-LAST:event_lbEliminarMouseClicked

    private void lbEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbEliminarMouseEntered
        lbEliminar.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
    }//GEN-LAST:event_lbEliminarMouseEntered

    private void lbEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbEliminarMouseExited
        lbEliminar.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
    }//GEN-LAST:event_lbEliminarMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbAutor;
    private javax.swing.JLabel lbEliminar;
    private javax.swing.JTextField txtfApellido;
    private javax.swing.JTextField txtfCorreo;
    private javax.swing.JTextField txtfNombre;
    // End of variables declaration//GEN-END:variables
}
