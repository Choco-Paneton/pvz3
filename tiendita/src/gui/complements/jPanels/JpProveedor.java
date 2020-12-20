package gui.complements.jPanels;

import data.ProveedorData;
import entities.Proveedor;

import gui.complements.jDialogs.JdNuevoProveedor;
import gui.main.Tiendita;
import gui.model.ProveedorModel;
import java.awt.Frame;
import java.awt.Window;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import util.ChangePanel;
import util.TextPrompt;

public class JpProveedor extends javax.swing.JPanel {

    public ProveedorModel proveedorModel;
    
    public JpProveedor() {
        initComponents();
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        proveedorModel = new ProveedorModel();
        paintTable(proveedorModel);
        placeHolder();
    }
    private void placeHolder() {
        TextPrompt textRuc = new TextPrompt("Ruc", TextRuc);
        TextPrompt textEmail = new TextPrompt("Email", TextEmail);
        TextPrompt textTelefono = new TextPrompt("Telefono", TextTelefono);
    }
    private void resetForm() {
        TextRuc.requestFocus();
        TextRuc.setText("");
        TextRuc.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1));
        
        TextEmail.requestFocus();
        TextEmail.setText("");
        TextEmail.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1));
        
        TextTelefono.requestFocus();
        TextTelefono.setText("");
        TextTelefono.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1));
        
        ModificarButton.setText("REGISTRAR");
        ModificarButton.setToolTipText("REGISTRAR");
    }
    public void paintTable(ProveedorModel tableModel) {
        this.proveedorModel = tableModel;
        table.setModel(tableModel);
        table.getColumnModel().getColumn(0).setMaxWidth(100);
    }
    
    private void paintForm() {
        if (table.getSelectedRow() != -1) {
            Proveedor filax = (Proveedor) proveedorModel.getRow(table.getSelectedRow());
            Proveedor d = ProveedorData.getByPId(filax.getId_proveedor());
            TextRuc.setText(d.getRuc());
            TextRuc.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1));

            TextEmail.setText(d.getEmail());
            TextEmail.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1));
            
            TextTelefono.setText(d.getTelefono());
            TextTelefono.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1));
            System.out.printf("getId:%d getSelectedRow:%d \n", d.getId_proveedor(), table.getSelectedRow());

            ModificarButton.setText("MODIFICAR");
            ModificarButton.setToolTipText("MODIFICAR");
        }

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        ModificarButton = new gui.styles.button.ButtonClass();
        EliminarButtom = new gui.styles.button.ButtonClass();
        buttonClass7 = new gui.styles.button.ButtonClass();
        jPanel12 = new javax.swing.JPanel();
        buscarField = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        buttonClass1 = new gui.styles.button.ButtonClass();
        jPanel6 = new javax.swing.JPanel();
        buttonClass3 = new gui.styles.button.ButtonClass();
        TextRuc = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        TextEmail = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        TextTelefono = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        buttonClass4 = new gui.styles.button.ButtonClass();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        jPanel1.setLayout(new java.awt.CardLayout());

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(17, 84, 160));

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Proveedor");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel8.setBackground(new java.awt.Color(255, 255, 204));
        jPanel8.setLayout(new java.awt.CardLayout());

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        ModificarButton.setBackground(new java.awt.Color(13, 71, 161));
        ModificarButton.setText("Modificar proveedor ");
        ModificarButton.setColorNormal(new java.awt.Color(13, 71, 161));
        ModificarButton.setFocusable(false);
        ModificarButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        ModificarButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ModificarButton.setVerifyInputWhenFocusTarget(false);
        ModificarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarButtonActionPerformed(evt);
            }
        });

        EliminarButtom.setBackground(new java.awt.Color(13, 71, 161));
        EliminarButtom.setText("Eliminar proveedor");
        EliminarButtom.setColorNormal(new java.awt.Color(13, 71, 161));
        EliminarButtom.setFocusable(false);
        EliminarButtom.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        EliminarButtom.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        EliminarButtom.setVerifyInputWhenFocusTarget(false);
        EliminarButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarButtomActionPerformed(evt);
            }
        });

        buttonClass7.setBackground(new java.awt.Color(13, 71, 161));
        buttonClass7.setText("Nuevo Proveedor");
        buttonClass7.setColorNormal(new java.awt.Color(13, 71, 161));
        buttonClass7.setFocusable(false);
        buttonClass7.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        buttonClass7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonClass7.setVerifyInputWhenFocusTarget(false);
        buttonClass7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonClass7MouseClicked(evt);
            }
        });
        buttonClass7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClass7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ModificarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EliminarButtom, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonClass7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ModificarButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EliminarButtom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonClass7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        jPanel8.add(jPanel9, "card2");

        jPanel5.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        buscarField.setBackground(new java.awt.Color(255, 255, 255));
        buscarField.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 24)); // NOI18N
        buscarField.setForeground(new java.awt.Color(51, 51, 51));
        buscarField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        buscarField.setBorder(null);
        buscarField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarFieldActionPerformed(evt);
            }
        });
        buscarField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarFieldKeyReleased(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonClass1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator4)
                    .addComponent(buscarField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buscarField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonClass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel12, java.awt.BorderLayout.LINE_START);

        jPanel4.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        buttonClass3.setBackground(new java.awt.Color(13, 71, 161));
        buttonClass3.setText("Acciones");
        buttonClass3.setColorNormal(new java.awt.Color(13, 71, 161));
        buttonClass3.setFocusable(false);
        buttonClass3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonClass3.setVerifyInputWhenFocusTarget(false);
        buttonClass3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClass3ActionPerformed(evt);
            }
        });

        TextRuc.setBackground(new java.awt.Color(255, 255, 255));
        TextRuc.setBorder(null);
        TextRuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextRucKeyReleased(evt);
            }
        });

        TextEmail.setBackground(new java.awt.Color(255, 255, 255));
        TextEmail.setBorder(null);
        TextEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextEmailKeyReleased(evt);
            }
        });

        TextTelefono.setBackground(new java.awt.Color(255, 255, 255));
        TextTelefono.setBorder(null);
        TextTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextTelefonoKeyReleased(evt);
            }
        });

        buttonClass4.setBackground(new java.awt.Color(13, 71, 161));
        buttonClass4.setText("Agregar");
        buttonClass4.setColorNormal(new java.awt.Color(13, 71, 161));
        buttonClass4.setFocusable(false);
        buttonClass4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonClass4.setVerifyInputWhenFocusTarget(false);
        buttonClass4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonClass4MouseClicked(evt);
            }
        });
        buttonClass4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClass4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonClass3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextRuc)
                    .addComponent(jSeparator1)
                    .addComponent(TextEmail)
                    .addComponent(jSeparator2)
                    .addComponent(TextTelefono)
                    .addComponent(jSeparator3)
                    .addComponent(buttonClass4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(buttonClass3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TextRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonClass4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        jPanel4.add(jPanel6, java.awt.BorderLayout.LINE_END);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        table.setModel(new javax.swing.table.DefaultTableModel(
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
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.add(jPanel7, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonClass4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClass4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonClass4ActionPerformed

    private void buttonClass4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonClass4MouseClicked
        
       
    }//GEN-LAST:event_buttonClass4MouseClicked

    private void buttonClass1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClass1ActionPerformed

    }//GEN-LAST:event_buttonClass1ActionPerformed

    private void buttonClass1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonClass1MouseClicked

    }//GEN-LAST:event_buttonClass1MouseClicked

    private void buscarFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarFieldKeyReleased

    }//GEN-LAST:event_buscarFieldKeyReleased

    private void buscarFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarFieldActionPerformed

    private void ModificarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarButtonActionPerformed
        if (TextRuc.getText().trim().isEmpty()) {
            TextRuc.requestFocus();
            TextRuc.setBorder(new LineBorder(new java.awt.Color(255, 0, 0), 3));

        } else {
            Proveedor s = new Proveedor();
            s.setRuc(TextRuc.getText());
            s.setEmail(TextEmail.getText());
            s.setTelefono(TextTelefono.getText());
            if (table.getSelectedRow() != -1) {// ha seleccionado, update
                try {
                    Proveedor fila = (Proveedor) proveedorModel.getRow(table.getSelectedRow());
                    s.setId_proveedor(fila.getId_proveedor());
                    System.out.println("id:" + s.getId_proveedor());
                    if (s.getId_proveedor() > 0) {
                        int returnId = ProveedorData.update(s);
                        if (returnId != 0) {
                            paintTable(new ProveedorModel());
                            resetForm();
                        }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "No se puede editar: " + ex.getMessage());
                }
            } else { // sin seleccionar, insert
                try {
                    int returnId = ProveedorData.create(s);
                    if (returnId != 0) {
                        paintTable(new ProveedorModel());
                        // s.setId(returnId);//necesitamos subir el id, ya no
                        //tableModel.addRow(s);
                        resetForm();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "No se puede insertar: " + ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_ModificarButtonActionPerformed

    private void buttonClass3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClass3ActionPerformed
        ChangePanel change = new ChangePanel(jPanel8, new JpPreveedorButtons());
    }//GEN-LAST:event_buttonClass3ActionPerformed

    private void buttonClass7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClass7ActionPerformed

        JpProductos jpProducts = new JpProductos();
        Window parentWindow = SwingUtilities.windowForComponent(jpProducts);
        Frame parentFrame = null;
        if (parentWindow instanceof Tiendita) {
            parentFrame = (Tiendita)parentWindow;
        }
        JdNuevoProveedor jdNewProduct = new JdNuevoProveedor(parentFrame, false);
        jdNewProduct.setVisible(true);
        paintTable(new ProveedorModel());
    }//GEN-LAST:event_buttonClass7ActionPerformed

    private void buttonClass7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonClass7MouseClicked
        
    }//GEN-LAST:event_buttonClass7MouseClicked

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        paintForm();
    }//GEN-LAST:event_tableMouseClicked

    private void tableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyReleased
        paintForm();
    }//GEN-LAST:event_tableKeyReleased

    private void EliminarButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarButtomActionPerformed
        if (table.getSelectedRow() != -1) {
            try {
                int opc = JOptionPane.showConfirmDialog(this, "¿Realmente desea eliminar?", "Quitar", JOptionPane.YES_NO_OPTION);
                if (opc == JOptionPane.OK_OPTION) {
                    Proveedor fila = (Proveedor) proveedorModel.getRow(table.getSelectedRow());
                    System.out.printf("EliminarButtomActionPerformed getId:%d getSelectedRow:%d \n", fila.getId_proveedor(), table.getSelectedRow());

                    int opcion = ProveedorData.delete(fila.getId_proveedor());
                    if (opcion != 0) {
                        //tableModel.removeRow(table.getSelectedRow());
                        paintTable(new ProveedorModel());
                        resetForm();
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "No se puede eliminar: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registo de la tabla");
        }
    }//GEN-LAST:event_EliminarButtomActionPerformed

    private void TextRucKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextRucKeyReleased
        if (!TextRuc.getText().trim().isEmpty()) { //reset
            TextRuc.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1));
        } else {
            TextRuc.setBorder(new LineBorder(new java.awt.Color(255, 0, 0), 3));
        }
    }//GEN-LAST:event_TextRucKeyReleased

    private void TextEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextEmailKeyReleased
        if (!TextEmail.getText().trim().isEmpty()) { //reset
            TextEmail.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1));
        } else {
            TextEmail.setBorder(new LineBorder(new java.awt.Color(255, 0, 0), 3));
        }
    }//GEN-LAST:event_TextEmailKeyReleased

    private void TextTelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextTelefonoKeyReleased
        if (!TextTelefono.getText().trim().isEmpty()) { //reset
            TextTelefono.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1));
        } else {
            TextTelefono.setBorder(new LineBorder(new java.awt.Color(255, 0, 0), 3));
        }
    }//GEN-LAST:event_TextTelefonoKeyReleased
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.styles.button.ButtonClass EliminarButtom;
    private gui.styles.button.ButtonClass ModificarButton;
    private javax.swing.JTextField TextEmail;
    private javax.swing.JTextField TextRuc;
    private javax.swing.JTextField TextTelefono;
    private javax.swing.JTextField buscarField;
    private gui.styles.button.ButtonClass buttonClass1;
    private gui.styles.button.ButtonClass buttonClass3;
    private gui.styles.button.ButtonClass buttonClass4;
    private gui.styles.button.ButtonClass buttonClass7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
