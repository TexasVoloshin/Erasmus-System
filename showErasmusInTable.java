/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erazmus.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author KasiaW
 */
public class showErasmusInTable extends javax.swing.JFrame {
    PreparedStatement pst = null;
    Connection conn = null;
    ResultSet rs = null;

    /**
     * Creates new form showErasmusInTable
     */
    public showErasmusInTable() {
        initComponents();
        findErasmus();
        
        
       
    }
    
//    public Connection getConnection()
//    {
//       
//        
////        try{
////            conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\KasiaW\\Desktop\\kurs javy\\JavaByExample\\Programy\\Erazmus System\\erazmusdatabase.sqlite\\");
////        }catch(Exception ex){
////            System.out.println(ex.getMessage());
////        }
////        
////        return conn;
//    }
//       private void fetchTbl(){
//        try{
//           String sql ="select first_name,last_name,gender,dob,country,telephone,email,university,department,mentor_first_name,mentor_last_name,menotr_email, mentor_telephone,Supervisor_last_name from Erasmus_information";
//           pst=conn.prepareStatement(sql); 
//            
//            //
//            jTableSupervisor.setModel(DbUtils.resultSetToTableModel(rs));
//        }
//        catch(Exception e){
//            JOptionPane.showMessageDialog(null,e);
//            
//        }
//    }
  public ArrayList<Erasmus> ListErasmus(String ValToSearch)
    {
        ArrayList<Erasmus> erasmusList = new ArrayList<Erasmus>();
        Statement st;
        ResultSet rs;
        
        try{
            
            st = conn.createStatement();
            String sql ="select first_name,last_name,gender,dob,country,telephone,email,university,department,mentor_first_name,mentor_last_name,menotr_email, mentor_telephone,Supervisor_last_name from Erasmus_information";
           pst=conn.prepareStatement(sql); 
           
       
        
           // st=conn.createStatement();
            String searchQuery = "select* from Erasmus_information WHERE CONCAT(first_name,last_name,gender,dob,country,telephone,email,university,department,mentor_first_name,mentor_last_name,menotr_email, mentor_telephone,supervisor_last_name) LIKE '%"+ValToSearch+"%'";
             
            rs = st.executeQuery(searchQuery); 
//            jTableSupervisor.setModel(DbUtils.resultSetToTableModel(rs));
            Erasmus erasmus;
            while(rs.next())
            {
                erasmus = new Erasmus(
                              rs.getInt("id"),
                              rs.getString("first_name"),
                              rs.getString("last_name"),
                              rs.getString("gender"),
                              rs.getString("country"),
                              rs.getString("email"),
                              rs.getString("telephone"),
                              rs.getString("university"),
                              rs.getString("supervisor_last_name")
                                
                               );
                erasmusList.add(erasmus);
            }
        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        //*finally { 
         //   try{ 
           // rs.close(); 
           // pst.close(); } 
         //   catch(Exception e){ 
        //JOptionPane.showMessageDialog(null,e); } }
       
        return erasmusList;
        
    }
  //
  public void findErasmus() 
    {
        ArrayList<Erasmus> erasmus = ListErasmus(textSearchErasmo.getText());
        
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Ename","ELastName", "EGender","ECountry","EEmail", "EP9one", "EUni","ESupervisor"});
        Object[] row = new Object[9];
        
        for(int i = 0; i <erasmus.size(); i++)
        {
            //row[0] = erasmus.get(i).getEId();
            row[1] = erasmus.get(i).getEname();
            row[2] = erasmus.get(i).getELastName();
            row[3] = erasmus.get(i).getEGender();
            row[4] = erasmus.get(i).getECountry();
            row[5] = erasmus.get(i).getEEmial();
            row[6] = erasmus.get(i).getEPhone();
            row[7] = erasmus.get(i).getEUni();
            
            model.addRow(row);
        }
       jTableSupervisor.setModel(model);
       
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSupervisor = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        textSearchErasmo = new javax.swing.JTextPane();
        CheckErasmo = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableSupervisor.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableSupervisor);

        jScrollPane2.setViewportView(textSearchErasmo);

        CheckErasmo.setText("Check Erasmus Students");
        CheckErasmo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckErasmoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(238, 238, 238)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CheckErasmo)
                .addContainerGap(668, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(177, 177, 177)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(178, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CheckErasmo)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(294, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(88, 88, 88)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(88, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CheckErasmoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckErasmoActionPerformed
        findErasmus();
        
    }//GEN-LAST:event_CheckErasmoActionPerformed

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
            java.util.logging.Logger.getLogger(showErasmusInTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(showErasmusInTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(showErasmusInTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(showErasmusInTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new showErasmusInTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton CheckErasmo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableSupervisor;
    private javax.swing.JTextPane textSearchErasmo;
    // End of variables declaration//GEN-END:variables
}
