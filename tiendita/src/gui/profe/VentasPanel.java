/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.profe;

import gui.profe.data.ClienteDatas;
import data.VentaData;
import entities.Cliente;
import entities.ClienteProfe;
import entities.Venta;
import entities.VentaProfe;
import gui.profe.Validate;
import gui.profe.data.VentaDatas;
import java.awt.event.ItemEvent;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import util.Config;

public class VentasPanel extends javax.swing.JPanel {

    private DefaultComboBoxModel clientesComboxModel;
    private List<ClienteProfe> clientes;

    VentaLineasTableModel mtdc;

    private boolean esActualizacion;
    private ClienteProfe clienteSelected;
    private VentaProfe ventaSelected;

    public VentaProfe getVentaSelected() {
        return ventaSelected;
    }

    public boolean isEsActualizacion() {
        return esActualizacion;
    }

    public ClienteProfe getClienteSelected() {
        return clienteSelected;
    }

    /**
     * Creates new form VentasPanel
     */
    public VentasPanel() {
        initComponents();
        userId.setText(Validate.userId+"");
        
        clientes = ClienteDatas.listCmb("");
        clientesComboxModel = new DefaultComboBoxModel(clientes.toArray());
        jComboBox1.setModel(clientesComboxModel);

        mtdc = new VentaLineasTableModel();
        tabla.setModel(mtdc);
        tabla.setEnabled(false);
        estado.setText("");
        paintTable(mtdc);

    }

    public void paintTable(VentaLineasTableModel tableModel) {
        this.mtdc = tableModel;
        tabla.setModel(mtdc);
        tabla.getColumnModel().getColumn(0).setMaxWidth(35);

        tabla.getColumnModel().getColumn(3).setCellEditor(new TableCelCantEditor(this));
        //tabla.getColumnModel().getColumn(3).setCellRenderer(new TableCellNumber("#,##0.00")); // "#,##0.00"

        tabla.getColumnModel().getColumn(5).setCellRenderer(new AccionTableCellRenderer(this));
        tabla.getColumnModel().getColumn(5).setCellEditor(new CeldaAccionEditor(this));

        setEventTable();
        if (ventaSelected != null) {
            if (ventaSelected.getActivo() == 1) {
                estado.setText("EN PROCESO");
            }
            if (ventaSelected.getActivo() == 2) {
                estado.setText("COMPLETADO");
            }
        }

    }

    
    
    
    private void setEventTable() {
        TableModelListener tml = new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                System.out.printf("tableChanged \n");
                tableHandlerEvent();
            }
        };
        this.tabla.getModel().addTableModelListener(tml);

    }

    private void tableHandlerEvent() {
        if (ventaSelected != null) {
            System.out.printf("ventaSelected \n");
            double sal = sumRow(this.mtdc, 4); //CompraDetData.getSaldosByCompId(compraSelected.getId());
            total.setText(new DecimalFormat(Config.DEFAULT_DECIMAL_STRING_FORMAT).format(sal));

        } else {
            System.out.printf("venta no Selected \n");
            total.setText("0");

        }
    }

    public double sumRow(VentaLineasTableModel mdl, int col) {
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

        jPanel11 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        estado = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        theButton2 = new igu.util.buttons.TheButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        total = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        userId = new javax.swing.JLabel();
        theButton1 = new igu.util.buttons.TheButton();

        setLayout(new java.awt.BorderLayout());

        jPanel11.setBackground(new java.awt.Color(17, 84, 160));

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Venta");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(741, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        add(jPanel11, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("CLIENTE:");

        jComboBox1.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        estado.setForeground(new java.awt.Color(51, 51, 51));
        estado.setText("ESTADO");

        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("ESTADO DE LA VENTA:");

        theButton2.setBackground(new java.awt.Color(13, 71, 161));
        theButton2.setText("Terminar");
        theButton2.setColorHover(new java.awt.Color(38, 86, 186));
        theButton2.setColorNormal(new java.awt.Color(13, 71, 161));
        theButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                theButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addComponent(theButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(estado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(theButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabla.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla.setRowHeight(30);
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        total.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        total.setForeground(new java.awt.Color(51, 51, 51));
        total.setText("0");
        total.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("TOTAL:");

        userId.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        userId.setForeground(new java.awt.Color(51, 51, 51));
        userId.setText("¿?");

        theButton1.setBackground(new java.awt.Color(13, 71, 161));
        theButton1.setText("Agregar/continuar");
        theButton1.setColorHover(new java.awt.Color(38, 86, 186));
        theButton1.setColorNormal(new java.awt.Color(13, 71, 161));
        theButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                theButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(theButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(userId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(total, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(theButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(userId)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jPanel3, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void theButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_theButton1ActionPerformed
        // TODO add your handling code here:
        if (clienteSelected != null) { //.getId() >0
            
            if (ventaSelected != null) {
                paintTable(new VentaLineasTableModel(ventaSelected));
            } else {
                ventaSelected = null;
                VentaProfe d = new VentaProfe();
                d.setClie_id(clienteSelected.getId());
                d.setClie_nom(clienteSelected.getNombres());
                int ventaId = VentaDatas.create(d);

                if (ventaId > 0) {
                    ventaSelected = VentaDatas.getByPId(ventaId);
                    paintTable(new VentaLineasTableModel(ventaSelected));

                } else {

                    ventaSelected = null;
                   
                }

            }

            //new
            if (ventaSelected != null) {
                System.out.printf("ventaSelected \n");
                double sal = sumRow(this.mtdc, 4); //CompraDetData.getSaldosByCompId(compraSelected.getId());
                total.setText(new DecimalFormat(Config.DEFAULT_DECIMAL_STRING_FORMAT).format(sal));
            } else {
                System.out.printf("venta no Selected \n");
                total.setText("0");

            }

        } else {
           
        }
    }//GEN-LAST:event_theButton1ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
       

        if (evt.getStateChange() == ItemEvent.SELECTED) {
            clienteSelected = (ClienteProfe) jComboBox1.getSelectedItem();
            int id = clienteSelected.getId();
            if (id > 0) {
                List<VentaProfe> ventasDelCliente = VentaDatas.listActivesByCliente(clienteSelected.getId());
                if (ventasDelCliente.size() > 0) {
                    int ventaId = ventasDelCliente.get(0).getId();// coge el primero
                    ventaSelected = VentaDatas.getByPId(ventaId);
                   // MsgPanel.success(" ventaSelected: " + ventaSelected.getId() + " de " + ventaSelected.getClie_nom() + " continuar con la venta");
                } else {
                    estado.setText("");
                    ventaSelected = null;
                    //MsgPanel.success(" cliente: " + clienteSelected.getNombres() + " sin ventas pendientes, se va crear nueva venta");
                }
                tabla.setEnabled(true);
                esActualizacion = true;
                // cmbProveedor.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1));
                // MsgPanel.error("");
                paintTable(new VentaLineasTableModel());

                
                
                
            } else {
                estado.setText("");
               // MsgPanel.success("seleccione cliente");
                clienteSelected = null;
                tabla.setEnabled(false);
                paintTable(new VentaLineasTableModel());

            }
        }
        tableHandlerEvent();
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void theButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_theButton2ActionPerformed
        // TODO add your handling code here:
        if (ventaSelected != null) {
            int opc = JOptionPane.showConfirmDialog(null, "¿Realmente desea terminar la venta? Una vez cerrada ya no podrá modificar esta venta", "TERMINAR COMPRA", JOptionPane.YES_NO_OPTION);
            if (opc == JOptionPane.OK_OPTION) {
                ventaSelected.setActivo(2);
                int op = VentaDatas.update(ventaSelected);

                if (op > 0) {
                   // MsgPanel.success("compra id:" + ventaSelected.getId() + " estado :" + ventaSelected.getActivo());
                } else {
                   // MsgPanel.error("No se pudo cambiar el estado ", true);
                }
            }
            if (ventaSelected.getActivo() == 1) {
                estado.setText("EN PROCESO");
            }
            if (ventaSelected.getActivo() == 2) {
                estado.setText("COMPLETADO");
            }
        }
    }//GEN-LAST:event_theButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel estado;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private igu.util.buttons.TheButton theButton1;
    private igu.util.buttons.TheButton theButton2;
    private javax.swing.JLabel total;
    private javax.swing.JLabel userId;
    // End of variables declaration//GEN-END:variables
}
