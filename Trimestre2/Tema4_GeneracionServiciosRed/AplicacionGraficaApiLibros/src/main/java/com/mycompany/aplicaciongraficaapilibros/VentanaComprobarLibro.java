package com.mycompany.aplicaciongraficaapilibros;

import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import org.json.JSONArray;
import org.json.JSONObject;


/**
 *
 * @author Yeray
 */
public class VentanaComprobarLibro extends javax.swing.JFrame {

    /**
     * Creates new form VentanaComprobarNumero
     */
    public VentanaComprobarLibro() {
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
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnComprobar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Introduzca el id del libro que desea comprobar:");

        jLabel2.setText("COMPROBAR LIBRO");

        btnComprobar.setText("COMPROBAR");
        btnComprobar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprobarActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        btnVolver.setText("VOLVER");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnComprobar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnVolver))
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnComprobar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                .addGap(13, 13, 13)
                .addComponent(btnVolver)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnComprobarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprobarActionPerformed
        try {
            String esquema = "https://";
            String servidor = "stephen-king-api.onrender.com/api/book/";
            String aBuscar = jTextField1.getText();
            String recurso = URLEncoder.encode(aBuscar, StandardCharsets.UTF_8.name());

            String direccion = esquema + servidor + recurso;
            StringBuilder resultado = getContenidoMetodoGet(direccion);

            // Formatear la respuesta JSON
            String formattedResult = formatJSON(resultado.toString());

            jTextArea1.setText(formattedResult);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnComprobarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnVolverActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaComprobarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaComprobarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaComprobarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaComprobarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaComprobarLibro().setVisible(true);
            }
        });
    }

    public StringBuilder getContenidoMetodoGet(String direccion) throws Exception {

        StringBuilder respuesta = new StringBuilder();
        URL url = new URL(direccion);
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("GET");
        conexion.setRequestProperty("Content-Type", "text-plain");
        conexion.setRequestProperty("charset", "utf-8");
        conexion.setRequestProperty("User-Agent", "Mozilla/5.0");
        int estado = conexion.getResponseCode();

        Reader streamReader = null;
        if (estado == HttpURLConnection.HTTP_OK) {

            streamReader = new InputStreamReader(conexion.getInputStream());
            int caracter;
            while ((caracter = streamReader.read()) != -1) {
                respuesta.append((char) caracter);
            }

        } else {
            throw new Exception("Error HTTP " + estado);
        }

        conexion.disconnect();
        return respuesta;
    }

    private String formatJSON(String rawJSON) {
        StringBuilder formattedJSON = new StringBuilder();

        JSONObject jsonObject = new JSONObject(rawJSON);
        JSONObject dataObject = jsonObject.getJSONObject("data");

        formattedJSON.append("-------------Libro-------------\n");
        formattedJSON.append("ID: ").append(dataObject.getInt("id")).append("\n");
        formattedJSON.append("Título: ").append(dataObject.getString("Title")).append("\n");
        formattedJSON.append("Año: ").append(dataObject.getInt("Year")).append("\n");
        formattedJSON.append("Editorial: ").append(dataObject.getString("Publisher")).append("\n");
        formattedJSON.append("ISBN: ").append(dataObject.getString("ISBN")).append("\n");
        formattedJSON.append("Páginas: ").append(dataObject.getInt("Pages")).append("\n");

        formattedJSON.append("\n-------------Notas-------------\n");
        JSONArray notesArray = dataObject.getJSONArray("Notes");
        for (int i = 0; i < notesArray.length(); i++) {
            formattedJSON.append("- ").append(notesArray.getString(i)).append("\n");
        }

        formattedJSON.append("\nFecha de creación: ").append(dataObject.getString("created_at")).append("\n");

        formattedJSON.append("\n-------------Villanos-------------\n");
        JSONArray villainsArray = dataObject.getJSONArray("villains");
        for (int i = 0; i < villainsArray.length(); i++) {
            JSONObject villainObject = villainsArray.getJSONObject(i);
            formattedJSON.append("Nombre: ").append(villainObject.getString("name")).append("\n");
        }

        return formattedJSON.toString();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComprobar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
