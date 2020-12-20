
package gui.complements.jPanels;

import data.CompraData;
import entities.Categoria;
import entities.Compra;
import entities.Proveedor;
import gui.complements.jDialogs.JdAcess;
import gui.complements.jDialogs.JdProveedor;
import gui.main.Tiendita;
import gui.model.CompraModel;
import gui.model.DetalleCompraModel;
import java.awt.Frame;
import java.awt.Window;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import util.ChangePanel;
import util.Config;

public class JpCompra extends javax.swing.JPanel {
    
    CompraModel compraModel;
    static SimpleDateFormat dfIGU = new SimpleDateFormat(Config.DEFAULT_DATE_STRING_FORMAT_PE);
    private static Proveedor proveedor;
    private static Categoria categoria;
    private Compra compraSelected;
    
    public JpCompra() {
        initComponents();
        jTable1.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        jDateChooser1.setDate(new Date());
        System.out.println(jDateChooser1.getCalendar().DATE);
        jDateChooser2.setDate(new Date());
        //traer datos de hoy
        CompraModel tableModel = new CompraModel("",jDateChooser1.getDate(), jDateChooser2.getDate());
        paintTable(tableModel);
        
    }

    public Compra getCompraSelected() {
        return compraSelected;
    }

    public void setCompraSelected(Compra compraSelected) {
        this.compraSelected = compraSelected;
    }
    
    public static void setProveedor(Proveedor proveedor) {
        JpCompra.proveedor = proveedor;
    }
    public static Proveedor getProveedor() {
        return proveedor;
    }
    
    public static void setCategoria(Categoria categoria) {
        JpCompra.categoria = categoria;
    }
    
    public static Categoria getCategoria() {
        return categoria;
    }
   
    private void paintTable(CompraModel tableModel) {
        this.compraModel = tableModel;
        jTable1.setModel(tableModel);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(35);
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
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        buttonClass1 = new gui.styles.button.ButtonClass();
        buttonClass3 = new gui.styles.button.ButtonClass();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        buttonClass6 = new gui.styles.button.ButtonClass();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        buttonClass5 = new gui.styles.button.ButtonClass();
        buttonClass4 = new gui.styles.button.ButtonClass();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jPanel1.setLayout(new java.awt.CardLayout());

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(17, 84, 160));

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Compra");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        buttonClass1.setBackground(new java.awt.Color(13, 71, 161));
        buttonClass1.setText("Buscar");
        buttonClass1.setColorNormal(new java.awt.Color(13, 71, 161));
        buttonClass1.setFocusable(false);
        buttonClass1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonClass1.setVerifyInputWhenFocusTarget(false);
        buttonClass1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonClass1MouseClicked(evt);
            }
        });
        buttonClass1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClass1ActionPerformed(evt);
            }
        });

        buttonClass3.setBackground(new java.awt.Color(13, 71, 161));
        buttonClass3.setText("Iniciar compra");
        buttonClass3.setColorNormal(new java.awt.Color(13, 71, 161));
        buttonClass3.setFocusable(false);
        buttonClass3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonClass3.setVerifyInputWhenFocusTarget(false);
        buttonClass3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClass3ActionPerformed(evt);
            }
        });

        jDateChooser1.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooser1.setForeground(new java.awt.Color(51, 51, 51));

        jDateChooser2.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooser2.setForeground(new java.awt.Color(51, 51, 51));

        buttonClass6.setBackground(new java.awt.Color(13, 71, 161));
        buttonClass6.setText("Eligir proveedor");
        buttonClass6.setColorNormal(new java.awt.Color(13, 71, 161));
        buttonClass6.setFocusable(false);
        buttonClass6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonClass6.setVerifyInputWhenFocusTarget(false);
        buttonClass6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClass6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonClass3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonClass6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonClass1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonClass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonClass3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonClass6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );

        jPanel5.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        buttonClass5.setBackground(new java.awt.Color(13, 71, 161));
        buttonClass5.setText("Compra detalle");
        buttonClass5.setColorNormal(new java.awt.Color(13, 71, 161));
        buttonClass5.setFocusable(false);
        buttonClass5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonClass5.setVerifyInputWhenFocusTarget(false);
        buttonClass5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClass5ActionPerformed(evt);
            }
        });

        buttonClass4.setBackground(new java.awt.Color(13, 71, 161));
        buttonClass4.setText("Eliminar compra");
        buttonClass4.setColorNormal(new java.awt.Color(13, 71, 161));
        buttonClass4.setFocusable(false);
        buttonClass4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonClass4.setVerifyInputWhenFocusTarget(false);
        buttonClass4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClass4ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Proveedor:");

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(204, 204, 204));
        jTextField1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(51, 51, 51));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField1.setBorder(null);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonClass5, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addComponent(buttonClass4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(41, 41, 41))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
                .addComponent(buttonClass4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonClass5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jPanel6.add(jPanel8, java.awt.BorderLayout.LINE_START);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.add(jPanel9, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonClass1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonClass1MouseClicked

    }//GEN-LAST:event_buttonClass1MouseClicked

    private void buttonClass1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClass1ActionPerformed
        
        if (jDateChooser1.getDate().equals("")) {
            
        } else if (jDateChooser2.getDate().equals("")) {
            
        } else {
            CompraModel tableModel = new CompraModel("", jDateChooser1.getDate(), jDateChooser2.getDate());
            paintTable(tableModel);
        }
    }//GEN-LAST:event_buttonClass1ActionPerformed

    private void buttonClass3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClass3ActionPerformed
                
        if (proveedor != null) {
            JpCompraNuevo.setProveedor(proveedor);
            ChangePanel change = new ChangePanel(jPanel1, new JpCompraNuevo());
            proveedor = null;
        } else {
            JpProductos jpProducts = new JpProductos();
            Window parentWindow = SwingUtilities.windowForComponent(jpProducts);
            Frame parentFrame = null;
            if (parentWindow instanceof Tiendita) {
                parentFrame = (Tiendita)parentWindow;
            }
            JdAcess jdAcess = new JdAcess(parentFrame, false);
            jdAcess.peligro("Proveedor es necesario", "¡Debes de agregar un proveedor!", "Proveedor");
            jdAcess.setVisible(true);
        }
    }//GEN-LAST:event_buttonClass3ActionPerformed

    private void buttonClass4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClass4ActionPerformed
        if (jTable1.getSelectedRow() != -1) {

            Compra fila = (Compra) compraModel.getRow(jTable1.getSelectedRow());
            System.out.println(fila.getId_compra());
            try {
                int opcion = CompraData.delete(fila.getId_compra());
                if (opcion != 0) {
                    paintTable(new CompraModel(null, jDateChooser1.getDate(), jDateChooser2.getDate()));
                } else {
                    System.out.println("no funciona");
                }
                
            } catch (Exception ex) {
                Logger.getLogger(JpCompra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_buttonClass4ActionPerformed

    private void buttonClass5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClass5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonClass5ActionPerformed

    private void buttonClass6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClass6ActionPerformed
        JpProductos jpProducts = new JpProductos();
        Window parentWindow = SwingUtilities.windowForComponent(jpProducts);
        Frame parentFrame = null;
        if (parentWindow instanceof Tiendita) {
            parentFrame = (Tiendita)parentWindow;
        }
        JdProveedor proveedor = new JdProveedor(parentFrame, true);
        proveedor.setVisible(true);
    }//GEN-LAST:event_buttonClass6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.styles.button.ButtonClass buttonClass1;
    private gui.styles.button.ButtonClass buttonClass3;
    private gui.styles.button.ButtonClass buttonClass4;
    private gui.styles.button.ButtonClass buttonClass5;
    private gui.styles.button.ButtonClass buttonClass6;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    public static javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
