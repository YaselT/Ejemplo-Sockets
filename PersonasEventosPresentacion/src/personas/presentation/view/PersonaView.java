/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personas.presentation.view;

import java.awt.Color;
import java.awt.Point;
import javax.swing.JOptionPane;
import personas.Application;
import personas.entities.Persona;
import personas.presentation.model.PersonaModel;
/**
 *
 * @author jsanchez
 */
public class PersonaView extends javax.swing.JDialog implements java.util.Observer {

    /**
     * Creates new form PersonaView
     */
    public PersonaView(java.awt.Frame parent, boolean modal) {
        super(parent,modal);
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

        sexoFld = new javax.swing.ButtonGroup();
        idLbl = new javax.swing.JLabel();
        nombreLbl = new javax.swing.JLabel();
        sexoLbl = new javax.swing.JLabel();
        estadoLbl = new javax.swing.JLabel();
        pasatiemposLbl = new javax.swing.JLabel();
        guardarFld = new javax.swing.JButton();
        cancelarFld = new javax.swing.JButton();
        idFld = new javax.swing.JTextField();
        nombreFld = new javax.swing.JTextField();
        sexoFldMasc = new javax.swing.JRadioButton();
        sexoFldFem = new javax.swing.JRadioButton();
        estadoFld = new javax.swing.JComboBox();
        pasatiempoFldMusica = new javax.swing.JCheckBox();
        pasatiempoFldCine = new javax.swing.JCheckBox();
        pasatiempoFldDeporte = new javax.swing.JCheckBox();
        pasatiempoFldVideoJuegos = new javax.swing.JCheckBox();
        pasatiempoFldCocina = new javax.swing.JCheckBox();
        pasatiempoFldOtro = new javax.swing.JCheckBox();
        pasatiempoFldOtroDescripcion = new javax.swing.JTextField();

        setTitle("PERSONA");
        setPreferredSize(new java.awt.Dimension(450, 300));

        idLbl.setText("Id");

        nombreLbl.setText("Nombre");

        sexoLbl.setText("Sexo");

        estadoLbl.setText("Estado Civil");

        pasatiemposLbl.setText("Pasatiempos");

        guardarFld.setIcon(new javax.swing.ImageIcon(getClass().getResource("/personas/presentation/view/save.png"))); // NOI18N
        guardarFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarFldActionPerformed(evt);
            }
        });

        cancelarFld.setIcon(new javax.swing.ImageIcon(getClass().getResource("/personas/presentation/view/cancel.png"))); // NOI18N
        cancelarFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarFldActionPerformed(evt);
            }
        });

        sexoFld.add(sexoFldMasc);
        sexoFldMasc.setText("Masculino");

        sexoFld.add(sexoFldFem);
        sexoFldFem.setText("Femenino");

        estadoFld.setRequestFocusEnabled(false);

        pasatiempoFldMusica.setText("Musica");

        pasatiempoFldCine.setText("Cine");

        pasatiempoFldDeporte.setText("Deporte");

        pasatiempoFldVideoJuegos.setText("Video Juegos");

        pasatiempoFldCocina.setText("Cocina");

        pasatiempoFldOtro.setText("Otro");
        pasatiempoFldOtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasatiempoFldOtroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pasatiemposLbl)
                    .addComponent(sexoLbl)
                    .addComponent(nombreLbl)
                    .addComponent(idLbl)
                    .addComponent(estadoLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(estadoFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pasatiempoFldMusica)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pasatiempoFldCine)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pasatiempoFldDeporte))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(guardarFld, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(cancelarFld, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pasatiempoFldVideoJuegos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pasatiempoFldCocina)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pasatiempoFldOtro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pasatiempoFldOtroDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idFld, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombreFld, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(sexoFldMasc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sexoFldFem)))))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLbl)
                    .addComponent(idFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreLbl)
                    .addComponent(nombreFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sexoLbl)
                    .addComponent(sexoFldMasc)
                    .addComponent(sexoFldFem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(estadoLbl)
                    .addComponent(estadoFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pasatiemposLbl)
                    .addComponent(pasatiempoFldMusica)
                    .addComponent(pasatiempoFldCine)
                    .addComponent(pasatiempoFldDeporte))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pasatiempoFldVideoJuegos)
                    .addComponent(pasatiempoFldCocina)
                    .addComponent(pasatiempoFldOtro)
                    .addComponent(pasatiempoFldOtroDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardarFld)
                    .addComponent(cancelarFld, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarFldActionPerformed
        this.controller.guardar();
    }//GEN-LAST:event_guardarFldActionPerformed

    private void pasatiempoFldOtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasatiempoFldOtroActionPerformed
        this.pasatiempoFldOtroDescripcion.setVisible(this.pasatiempoFldOtro.isSelected());
         this.validate();
    }//GEN-LAST:event_pasatiempoFldOtroActionPerformed

    private void cancelarFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarFldActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_cancelarFldActionPerformed

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
            java.util.logging.Logger.getLogger(PersonaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PersonaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PersonaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PersonaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton cancelarFld;
    public javax.swing.JComboBox estadoFld;
    public javax.swing.JLabel estadoLbl;
    public javax.swing.JButton guardarFld;
    public javax.swing.JTextField idFld;
    public javax.swing.JLabel idLbl;
    public javax.swing.JTextField nombreFld;
    public javax.swing.JLabel nombreLbl;
    public javax.swing.JCheckBox pasatiempoFldCine;
    public javax.swing.JCheckBox pasatiempoFldCocina;
    public javax.swing.JCheckBox pasatiempoFldDeporte;
    public javax.swing.JCheckBox pasatiempoFldMusica;
    public javax.swing.JCheckBox pasatiempoFldOtro;
    public javax.swing.JTextField pasatiempoFldOtroDescripcion;
    public javax.swing.JCheckBox pasatiempoFldVideoJuegos;
    public javax.swing.JLabel pasatiemposLbl;
    private javax.swing.ButtonGroup sexoFld;
    public javax.swing.JRadioButton sexoFldFem;
    public javax.swing.JRadioButton sexoFldMasc;
    public javax.swing.JLabel sexoLbl;
    // End of variables declaration//GEN-END:variables
    personas.presentation.controller.PersonaController controller;
    personas.presentation.model.PersonaModel model;
    
    public void setController(personas.presentation.controller.PersonaController controller){
        this.controller=controller;
    }
    public void setModel(personas.presentation.model.PersonaModel model){
        this.model=model;
         model.addObserver(this);
    }
    
   public void update(java.util.Observable updatedModel,Object parametros){
       if (parametros != PersonaModel.PERSONA_CURRENT) return;
       
       Persona personaCurrent = model.getPersonaCurrent();
        
       this.idFld.setEnabled(model.getModo()==Application.MODO_AGREGAR);
       
       idFld.setText(personaCurrent.getId());
       if (model.getErrores().get("id")!=null){
            idLbl.setBorder(Application.BORDER_ERROR);
            idLbl.setToolTipText(model.getErrores().get("id"));
        }
        else{
            idLbl.setBorder(null);
            idLbl.setToolTipText("");
        }

        nombreFld.setText(personaCurrent.getNombre());
        if (model.getErrores().get("nombre")!=null){
            nombreLbl.setBorder(Application.BORDER_ERROR);
            nombreLbl.setToolTipText(model.getErrores().get("nombre"));
        }
        else{
           nombreLbl.setBorder(null);
           nombreLbl.setToolTipText("");
        }

        if (personaCurrent.getSexo()=='F'){
            sexoFldFem.setSelected(true);
        }
        else if(personaCurrent.getSexo()=='M'){
            sexoFldMasc.setSelected(true);  
        }
        else{
            this.sexoFld.clearSelection();
        }
        if (model.getErrores().get("sexo")!=null){
            sexoLbl.setBorder(Application.BORDER_ERROR);
            sexoLbl.setToolTipText(model.getErrores().get("sexo"));
        }
        else{
           sexoLbl.setBorder(null);
           sexoLbl.setToolTipText("");
         }
        estadoFld.setModel(model.getEstadosCiviles());
        estadoFld.setSelectedItem(personaCurrent.getEstadoCivil());
        pasatiempoFldMusica.setSelected(personaCurrent.isPasatiempoMusica());
        pasatiempoFldCine.setSelected(personaCurrent.isPasatiempoCine());
        pasatiempoFldDeporte.setSelected(personaCurrent.isPasatiempoDeporte());
        pasatiempoFldVideoJuegos.setSelected(personaCurrent.isPasatiempoVideoJuegos());
        pasatiempoFldCocina.setSelected(personaCurrent.isPasatiempoCocina());
        pasatiempoFldOtro.setSelected(personaCurrent.isPasatiempoOtro());
        if (personaCurrent.isPasatiempoOtro()){
            pasatiempoFldOtroDescripcion.setVisible(true);
            pasatiempoFldOtroDescripcion.setText(model.getPersonaCurrent().getPasatiempoOtroTexto());
            if (model.getErrores().get("pasatiempoOtroDescripcion")!=null){
                pasatiempoFldOtro.setBorder(Application.BORDER_ERROR);
                pasatiempoFldOtro.setBorderPainted(true); 
                pasatiempoFldOtro.setToolTipText(model.getErrores().get("pasatiempoOtroDescripcion"));
            }
            else{
                pasatiempoFldOtro.setBorder(null);
                pasatiempoFldOtro.setBorderPainted(false); 
                pasatiempoFldOtro.setToolTipText("");
            }
        }
        else{
            pasatiempoFldOtroDescripcion.setVisible(false);
        }
        this.validate();
        if (!model.getMensaje().equals("")){
            JOptionPane.showMessageDialog(this, model.getMensaje(), "",JOptionPane.INFORMATION_MESSAGE);
        }
    } 
}
