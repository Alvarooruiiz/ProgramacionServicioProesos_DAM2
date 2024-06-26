/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.aplicaciongraficaapilibros;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Yeray
 */
public class VentanaInformación extends javax.swing.JFrame {

    /**
     * Creates new form VentanaInformación
     */
    public VentanaInformación() {
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

        jLabel1 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("INFORMACIÓN DE LOS LIBROS");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnVolver.setText("VOLVER");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnVolver))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVolver)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnVolverActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new VentanaInformación().setVisible(true));
    }

    public void setContenido(String contenido) {
        String formattedContent = formatJSON(contenido);
        jTextArea1.setText(formattedContent);
    }

    private String formatJSON(String rawJSON) {
    StringBuilder formattedJSON = new StringBuilder();

    try {
        JSONObject jsonObject = new JSONObject(rawJSON);
        JSONArray dataArray = jsonObject.getJSONArray("data");

        for (int i = 0; i < dataArray.length(); i++) {
            JSONObject dataObject = dataArray.getJSONObject(i);

            formattedJSON.append("-------------Libro-------------\n");
            formattedJSON.append("ID: ").append(dataObject.getInt("id")).append("\n");
            formattedJSON.append("Título: ").append(dataObject.getString("Title")).append("\n");
            formattedJSON.append("Año: ").append(dataObject.getInt("Year")).append("\n");
            formattedJSON.append("Editorial: ").append(dataObject.getString("Publisher")).append("\n");
            formattedJSON.append("ISBN: ").append(dataObject.getString("ISBN")).append("\n");
            formattedJSON.append("Páginas: ").append(dataObject.getInt("Pages")).append("\n");

            formattedJSON.append("\n-------------Notas-------------\n");
            JSONArray notesArray = dataObject.getJSONArray("Notes");
            for (int j = 0; j < notesArray.length(); j++) {
                formattedJSON.append("- ").append(notesArray.getString(j)).append("\n");
            }

            formattedJSON.append("\nFecha de creación: ").append(dataObject.getString("created_at")).append("\n");

            formattedJSON.append("\n-------------Villanos-------------\n");
            JSONArray villainsArray = dataObject.getJSONArray("villains");
            for (int j = 0; j < villainsArray.length(); j++) {
                JSONObject villainObject = villainsArray.getJSONObject(j);
                formattedJSON.append("Nombre: ").append(villainObject.getString("name")).append("\n");
            }
        }
    } catch (JSONException e) {
        // Maneja la excepción según tus necesidades
        e.printStackTrace();
        formattedJSON.append("Error al procesar el JSON: ").append(e.getMessage());
    }

    return formattedJSON.toString();
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
