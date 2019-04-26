
package pharmacie.graph;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import pharmacie.DAO.PatientDAO;
import pharmacie.metier.Patient;


public class CreaPatient extends javax.swing.JPanel {

    PatientDAO patientDAO = null;

    public CreaPatient() {
        initComponents();
    }

    public void setPatientDAO(PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblcode = new javax.swing.JLabel();
        llblnumpat = new javax.swing.JLabel();
        lblprenom = new javax.swing.JLabel();
        lbltel = new javax.swing.JLabel();
        txtnumpat = new javax.swing.JTextField();
        txtprenom = new javax.swing.JTextField();
        txtnom = new javax.swing.JTextField();
        txttel = new javax.swing.JTextField();
        btcreate = new javax.swing.JButton();

        lblcode.setText("nom");

        llblnumpat.setText("numéro de patient");

        lblprenom.setText("prénom");

        lbltel.setText("numéro de téléphone");

        txtnumpat.setEditable(false);
        txtnumpat.setMinimumSize(new java.awt.Dimension(50, 20));
        txtnumpat.setNextFocusableComponent(txtnom);
        txtnumpat.setPreferredSize(new java.awt.Dimension(150, 30));
        txtnumpat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumpatActionPerformed(evt);
            }
        });

        txtprenom.setMinimumSize(new java.awt.Dimension(50, 20));
        txtprenom.setNextFocusableComponent(txttel);
        txtprenom.setPreferredSize(new java.awt.Dimension(150, 30));

        txtnom.setMinimumSize(new java.awt.Dimension(50, 20));
        txtnom.setNextFocusableComponent(txtprenom);
        txtnom.setPreferredSize(new java.awt.Dimension(150, 30));

        txttel.setMinimumSize(new java.awt.Dimension(50, 20));
        txttel.setPreferredSize(new java.awt.Dimension(150, 30));

        btcreate.setText("création");
        btcreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcreateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblprenom)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(llblnumpat)
                                    .addComponent(lblcode)
                                    .addComponent(lbltel))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txttel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtprenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnumpat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btcreate)))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(llblnumpat)
                    .addComponent(txtnumpat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcode)
                    .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblprenom)
                    .addComponent(txtprenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltel)
                    .addComponent(txttel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(101, 101, 101)
                .addComponent(btcreate)
                .addContainerGap(75, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtnumpatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumpatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumpatActionPerformed

    private void btcreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcreateActionPerformed
        try {
            String nom = txtnom.getText();
            String prenom = txtprenom.getText();
            String tel = txttel.getText();
            Patient patient = new Patient(0, nom, prenom, tel);
            try {
                patient = patientDAO.create(patient);
                txtnumpat.setText("" + patient.getIdpat());
                JOptionPane.showMessageDialog(this, "patient créé", "SUCCES", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException f) {
                if (f.getMessage().contains("UK")) {
                    JOptionPane.showMessageDialog(this, "patient déjà existant", "ERREUR", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, f.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
        }
        txtnumpat.setText("");
        txtnom.setText("");
        txtprenom.setText("");
        txttel.setText("");

    }//GEN-LAST:event_btcreateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btcreate;
    private javax.swing.JLabel lblcode;
    private javax.swing.JLabel lblprenom;
    private javax.swing.JLabel lbltel;
    private javax.swing.JLabel llblnumpat;
    private javax.swing.JTextField txtnom;
    private javax.swing.JTextField txtnumpat;
    private javax.swing.JTextField txtprenom;
    private javax.swing.JTextField txttel;
    // End of variables declaration//GEN-END:variables
}
