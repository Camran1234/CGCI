/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chtml.parser;

import com.script.parser.ScriptLex;
import java.io.Reader;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.script.parser.ScriptSyntax;
import java_cup.runtime.Scanner;

/**
 *
 * @author camran1234
 */
public class HUD extends javax.swing.JFrame {

    /**
     * Creates new form HUD
     */
    public HUD() {
        initComponents();
    }

    /*Script
        PROCESS_calc() [
               
               integer @global contador_fallas = 5;             
               boolean hola_mundo;
               hola_mundo = true && false;
               string result_caja_texto = getElemenById('entrada_1');
                              string result = "10 ";
                              string mensaje_fallo = "El captcha no fue validado intente otra vez "+10;
                              string mensaje_acierto = "El captcha fue validado ";
                              string mensaje_final = "El captcha no logró ser validado :( intente mas tarde";
                             
                              
                              IF (contador_fallas == 0) THEN
                  INIT {:
                     ALERT_INFO(mensaje_final);
                     EXIT();
                  :} END 

                              
                              IF (result_caja_texto == result ) THEN
                  
                  INIT {:
                     ALERT_INFO(mensaje_acierto);
                  :} END   
               ELSE 
                  
                  INIT {:
                     ALERT_INFO(mensaje_fallo);
                     contador_fallas = contador_fallas -1;
                  :} END
    
                  IF (result_caja_texto == result ) THEN
                        IF(result_caja_texto != result) THEN
                            ALERT_INFO (mensaje_fallo);
    
                  contador_fallas = contador_fallas-1;
            ]
    */
    
    
    
    
    /*Html
        

<!-- Mi primer captcha
     en el curso de Organización de Lenguajes y Compiladores 1
 -->

<C_GCIC [id= "captcha_matematico_1"] [name= "Captcha Matemático 1"]>
    !! El encabezado de la página que tendrá mi captcha
    <C_HEAD>
       <C_LINK 
          !! El link al que redirige mi captcha
          [href= "https://www.mclibre.org/consultar/htmlcss/html/html-etiquetas.html"]>
       </C_LINK>
          !! El título de mi página
       <C_TITLE> Mi primer Captcha Matemático</C_TITLE>
    </C_HEAD>
    !! El cuerpo de la página"
    <C_BODY [background= "#e5e6ea"] >
        !! un título simple estilizado
        <C_H1 [id= "title_1"] [text-align= "center"] [color= "#7eff33"] >
           Mi primer Captcha Matemático
        </C_H1>
        !! Un salto normal
        <C_BR>
        !! Información de la operación a resolver en el  captcha
        <C_SPAM [id= "mostrar_1"] [text-align= "center"] [color= "#3366ff"] >
           ¿ Qué resultado genera la operación siguiente: 5+5 ?
        </C_SPAM>
        !! Input para la Respuesta del usuario generado con un scripting
        <C_SCRIPTING>
           ON_LOAD () [
              !!Estas instrucciones se ejecutan media vez se entra al scripting
              !! Insertamos el input con sus parámetros con la instrucción INSERT
              INSERT('<C_INPUT [type= "text"] [text-align= "center"]
                 [id= "entrada_1"] >');
              INSERT('</C_INPUT>');
           ]
        </C_SCRIPTING>
        !! Boton que llama a la funcionalidad calc
        <C_BUTTON [id= "boton_1"] [onclick= "PROCESS_calc()"] [background="green"]>            
           Procesar...
        </C_BUTTON> 
   
        !! Scripting para la función calc
        <C_SCRIPTING>
            PROCESS_calc() [
               !! Estas instrucciones no se ejecutan hasta llamar a PROCESS_calc() 
               integer @global contador_fallas = 5;             
               string result_caja_texto = getElemenById('entrada_1');
                              string result = "10 ";
                              string mensaje_fallo = "El captcha no fue validado intente otra vez ";
                              string mensaje_acierto = "El captcha fue validado ";
                              string mensaje_final = "El captcha no logró ser validado :( intente mas tarde";
                             
                              !! Validacion del numero de oportunidades restantes
                              IF (contador_fallas = 0) THEN
                  INIT {:
                     ALERT_INFO(mensaje_final);
                     EXIT();
                  :} END 

                              !! Validación de fallas y aciertos
                              IF (result_caja_texto == result ) THEN
                  !!si el resultado es correcto
                  INIT {:
                     ALERT_INFO(mensaje_acierto);
                  :} END   
               ELSE 
                  !!si el intento es incorrecto
                  INIT {:
                     ALERT_INFO(mensaje_fallo);
                     contador_fallas = contador_fallas -1;
                  :} END
            ]
        </C_SCRIPTING>  
    </C_BODY>
</C_GCIC>
!! Fin de estructura GCIC




    */
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("HTML");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("SCRIPT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String codeHtml = this.jTextArea1.getText();
            StringReader reader = new StringReader(codeHtml);
            ChtmlLex lexic = new ChtmlLex(reader);
            parser parser = new parser(lexic);
            parser.parse();            
        } catch (Exception ex) {
            Logger.getLogger(HUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            String codeScript = this.jTextArea1.getText();
            StringReader reader = new StringReader(codeScript);
            ScriptLex lexic = new ScriptLex(reader);
            ScriptSyntax parser = new ScriptSyntax(lexic);
            parser.parse();
        } catch (Exception ex) {
            Logger.getLogger(HUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(HUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HUD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
