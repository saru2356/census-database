/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package censusdbp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class countof_children extends javax.swing.JFrame {

    /**
     * Creates new form countof_children
     */
    String g;
    
    public countof_children() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cb1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Count");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 120, 73));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Age range");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 128, -1));

        cb1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0 - 1 ", "1-5 ", "6-15 ", "16-60", "above 60", " " }));
        cb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb1ActionPerformed(evt);
            }
        });
        getContentPane().add(cb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("BACK");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("NEXT");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 0, 51));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/censusdbp/Love_Wallpapers_041.jpg"))); // NOI18N
        jLabel6.setText("Count");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        String s,str,str1,day,month,year;
        s=cb1.getSelectedItem().toString();
        if(cb1.getSelectedIndex()==0)
        {
           str="select * from familymembers where age>0 and age<1"; 
           str1="select count(name) from familymembers where age>0 and age<1";
        }
        else if(cb1.getSelectedIndex()==1)
        {
                str="select * from familymembers where age>=1 and age<=5";
                str1="select count(name) from familymembers where age>=1 and age<=5";
        }
        else if(cb1.getSelectedIndex()==2)
        {
            str="select * from familymembers where age>=6 and age<=15"; 
            str1="select count(name) from familymembers where age>=6 and age<=15"; 
        }
        else if(cb1.getSelectedIndex()==3)
        {
            str="select * from familymembers where age>=15 and age<60";
            str1="select count(name) from familymembers where age>=15 and age<60";
        }
        else
        {
            str="select * from familymembers where age>60";
            str1="select count(name) from familymembers where age>60";
        }
        try
         {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/censusdb?zeroDateTimeBehavior=convertToNull","root","");
           // PreparedStatement st1=con.prepareStatement(str1);
            //ResultSet rs1=st1.executeQuery();
            PreparedStatement st2=con.prepareStatement(str);
            ResultSet rs2=st2.executeQuery();
            PreparedStatement st3=con.prepareStatement(str1);
            ResultSet rs3=st3.executeQuery();
            count f=new count();
            DefaultTableModel table=(DefaultTableModel)f.tb1.getModel();
            while(rs2.next())
            {
                 Object row[]={rs2.getString(3),rs2.getString(7),rs2.getString(4),rs2.getString(6),rs2.getString(5)};
                 table.addRow(row); 
                f.setVisible(true);
                this.setVisible(false);
            }
            while(rs3.next())
            {
                f.l1.setText(rs3.getString(1));
            }
            
         }catch(ClassNotFoundException | SQLException e){}
    }//GEN-LAST:event_jLabel5MouseClicked

    private void cb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb1ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
admin a=new admin();
a.setVisible(true);
this.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

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
            java.util.logging.Logger.getLogger(countof_children.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(countof_children.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(countof_children.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(countof_children.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new countof_children().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cb1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
