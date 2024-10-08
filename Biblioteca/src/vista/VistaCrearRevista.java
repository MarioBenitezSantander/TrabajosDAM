/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.Controlador;
import excepciones.AptoMenoresNoEspecificadoException;
import excepciones.DocExisteException;
import excepciones.NombreDocVacioException;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

/**
 *
 * @author Mario
 */
public class VistaCrearRevista extends javax.swing.JFrame {

    /**
     * Creates new form VistaCrearRevista
     */
    
    private ButtonGroup grupoRadio;
    
    public VistaCrearRevista() {
        initComponents();
        setIconImage(getIconImage());
        grupoRadio = new ButtonGroup();
        grupoRadio.add(radioSi);
        grupoRadio.add(radioNo);
    }
    
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/logo_biblioteca.png"));
        return retValue;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textFieldNombre = new javax.swing.JTextField();
        textFieldAutor = new javax.swing.JTextField();
        radioSi = new javax.swing.JRadioButton();
        radioNo = new javax.swing.JRadioButton();
        textFieldEditorial = new javax.swing.JTextField();
        textFieldNum = new javax.swing.JTextField();
        botonCrearRevista = new javax.swing.JButton();
        botonAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(231, 255, 232));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("A�ADIR REVISTA");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Autor:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Apto para menores:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Editorial:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("N�mero:");

        textFieldNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        textFieldAutor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        radioSi.setBackground(new java.awt.Color(231, 255, 232));
        radioSi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        radioSi.setText("Si");

        radioNo.setBackground(new java.awt.Color(231, 255, 232));
        radioNo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        radioNo.setText("No");

        textFieldEditorial.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        textFieldNum.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        botonCrearRevista.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botonCrearRevista.setText("A�adir Revista");
        botonCrearRevista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearRevistaActionPerformed(evt);
            }
        });

        botonAtras.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botonAtras.setText("Atr�s");
        botonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(316, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(radioSi)
                        .addGap(59, 59, 59)
                        .addComponent(radioNo))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(textFieldEditorial, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                        .addComponent(textFieldAutor, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(textFieldNum, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textFieldNombre, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(317, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonCrearRevista)
                .addGap(107, 107, 107)
                .addComponent(botonAtras)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textFieldAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(radioSi)
                    .addComponent(radioNo))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textFieldEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(textFieldNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCrearRevista)
                    .addComponent(botonAtras))
                .addContainerGap(102, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCrearRevistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearRevistaActionPerformed
        try{
            boolean apto;
            if(radioSi.isSelected()){
                apto = true;
            }else if(radioNo.isSelected()){
                apto = false;
            }else{
                throw new AptoMenoresNoEspecificadoException();
            }
            if(this.textFieldNombre.getText().equals("")){
                throw new NombreDocVacioException();
            }
            Controlador.crearNuevaRevista(this.textFieldEditorial.getText(), Integer.parseInt(this.textFieldNum.getText()), this.textFieldNombre.getText(), this.textFieldAutor.getText(), apto);
            JOptionPane.showMessageDialog(null, "Documento creado con �xito", "Biblioteca de Alejandr�a", JOptionPane.INFORMATION_MESSAGE);
            Controlador.cargarVistaMenuAdmin();
            this.setVisible(false);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "El n�mero de la revista debe ser un n�mero", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (AptoMenoresNoEspecificadoException e) {
            JOptionPane.showMessageDialog(null, "No se ha especificado si el documento es apto para menores", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (DocExisteException e) {
            JOptionPane.showMessageDialog(null, "Ya existe un documento con ese nombre", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (NombreDocVacioException ex) {
            JOptionPane.showMessageDialog(null, "El nombre del documento no puede estar vac�o", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonCrearRevistaActionPerformed

    private void botonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtrasActionPerformed
        Controlador.cargarVistaMenuAdmin();
        this.setVisible(false);
    }//GEN-LAST:event_botonAtrasActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton botonCrearRevista;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton radioNo;
    private javax.swing.JRadioButton radioSi;
    private javax.swing.JTextField textFieldAutor;
    private javax.swing.JTextField textFieldEditorial;
    private javax.swing.JTextField textFieldNombre;
    private javax.swing.JTextField textFieldNum;
    // End of variables declaration//GEN-END:variables
}
