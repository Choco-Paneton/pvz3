/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.complements.jPanels;


import data.ClienteData;
import data.VentaData;
import entities.Cliente;
import entities.Venta;
import gui.actions.CeldaActionVentaProducto;
import gui.actions.CeldaRenderVentaProducto;
import gui.complements.jDialogs.JdAgregarProductosVenta;
import gui.main.Tiendita;
import gui.model.DetalleVentaModel;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ItemEvent;
import java.text.DecimalFormat;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import util.Config;
/**
 *
 * @author Jhoselyn
 */
public class JpVentas extends javax.swing.JPanel {
    private DefaultComboBoxModel clientesComboxModel;
    private  List<Cliente> clientes;
    
    DetalleVentaModel dvmodel;
    
    private Cliente clienteSelected;
    private Venta ventaSelected;
    
    public  Cliente getClienteSelected() {
        return clienteSelected;
    }
    
    public  Venta getVentaSelected() {
        return ventaSelected;
    }

    /**
     * Creates new form JpVentas
     */
    public JpVentas() {
        initComponents();
        clientes = ClienteData.listCombo("");
        clientesComboxModel  = new DefaultComboBoxModel(clientes.toArray());
        jComboBox1.setModel(clientesComboxModel);
           
        dvmodel = new DetalleVentaModel();
        jTable1.setModel(dvmodel);
        //jTable1.setEnabled(false);
        paintTable(dvmodel);
    }
    
    public  void paintTable(DetalleVentaModel tableModel){
        this.dvmodel = tableModel;
        jTable1.setModel(dvmodel);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(35);
        jTable1.getColumnModel().getColumn(0);
        jTable1.getColumnModel().getColumn(1);
        jTable1.getColumnModel().getColumn(4).setCellRenderer(new CeldaRenderVentaProducto(this));
        jTable1.getColumnModel().getColumn(4).setCellEditor(new CeldaActionVentaProducto(this));
        
        setEventTable();
    }
    
    private void setEventTable() {
        TableModelListener tml = new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                System.out.printf("tableChanged \n");
                tableHandlerEvent();
            }
        };
        this.jTable1.getModel().addTableModelListener(tml);

    }

    private void tableHandlerEvent() {
        if (ventaSelected != null) {
            System.out.printf("ventaSelected \n");
            double sal = sumRow(this.dvmodel, 4); //CompraDetData.getSaldosByCompId(compraSelected.getId());
            

        } else {
            System.out.printf("venta no Selected \n");

        }
    }

    public double sumRow(DetalleVentaModel mdl, int col) {
        double total = 0;
        // iterate over all columns
        for (int i = 0; i < mdl.getRowCount(); i++) {
            // null or not Integer will throw exception
            total += (double) mdl.getValueAt(i, col);
        }
        return total;
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
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        buttonClassAgregar = new gui.styles.button.ButtonClass();
        jLabel2 = new javax.swing.JLabel();
        buttonClassVenta = new gui.styles.button.ButtonClass();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(17, 84, 160));

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ventas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        buttonClassAgregar.setBackground(new java.awt.Color(13, 71, 161));
        buttonClassAgregar.setText("Agregar");
        buttonClassAgregar.setColorNormal(new java.awt.Color(13, 71, 161));
        buttonClassAgregar.setFocusable(false);
        buttonClassAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonClassAgregar.setVerifyInputWhenFocusTarget(false);
        buttonClassAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonClassAgregarMouseClicked(evt);
            }
        });
        buttonClassAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClassAgregarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Cliente");

        buttonClassVenta.setBackground(new java.awt.Color(13, 71, 161));
        buttonClassVenta.setText("Iniciar Venta");
        buttonClassVenta.setColorNormal(new java.awt.Color(13, 71, 161));
        buttonClassVenta.setFocusable(false);
        buttonClassVenta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonClassVenta.setVerifyInputWhenFocusTarget(false);
        buttonClassVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonClassVentaMouseClicked(evt);
            }
        });
        buttonClassVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClassVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonClassAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap(694, Short.MAX_VALUE)
                    .addComponent(buttonClassVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 19, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonClassAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap(31, Short.MAX_VALUE)
                    .addComponent(buttonClassVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

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
        jTable1.setRowHeight(30);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.LINE_START);

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void buttonClassAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonClassAgregarMouseClicked
        JpCategorias jpCategorys = new JpCategorias();
       
    }//GEN-LAST:event_buttonClassAgregarMouseClicked

    private void buttonClassAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClassAgregarActionPerformed
       // TODO add your handling code here:
       JpVentas jpCategorys = new JpVentas();
        Window parentWindow = SwingUtilities.windowForComponent(jpCategorys);
        Frame parentFrame = null;
        if (parentWindow instanceof Tiendita) {
            parentFrame = (Tiendita)parentWindow;
        }
        JdAgregarProductosVenta jpNewCategorys = new JdAgregarProductosVenta(parentFrame, true);
        jpNewCategorys.setVisible(true);
    }//GEN-LAST:event_buttonClassAgregarActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED){
            clienteSelected = (Cliente) jComboBox1.getSelectedItem();
            int id = clienteSelected.getId_cliente();
            if (id == 0){
                clienteSelected = null;
            }
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void buttonClassVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonClassVentaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonClassVentaMouseClicked

    private void buttonClassVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClassVentaActionPerformed
        // TODO add your handling code here:
        if(clienteSelected != null) {
            System.out.println("yes");
            System.out.println(clienteSelected.getId_cliente());
            if (ventaSelected != null){
                System.out.println("venta Exists");
            } else {
                ventaSelected = null;
                Venta v = new Venta();
                v.setCliente_id(clienteSelected.getId_cliente());
                int vid = VentaData.create(v);

                if (vid > 0) {
                    ventaSelected = VentaData.getById(vid);
                    System.out.println("create venta");
                    System.out.println(ventaSelected.getId_venta());
                    paintTable(new DetalleVentaModel(ventaSelected));
                } else {
                    System.out.println("fail venta");
                }
            }
        } else {
            System.out.println("no");
            
        }
    }//GEN-LAST:event_buttonClassVentaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.styles.button.ButtonClass buttonClassAgregar;
    private gui.styles.button.ButtonClass buttonClassVenta;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
