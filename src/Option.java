/**
 *Nicolò Perotti  6/02/2017 - 3/03/2017
 *Versione 1.0 data di rilascio 3/03/2017
 *Jframe per la finestra di option
*/

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.UIManager;

/**
 *
 * @author Tirocinio
 */
public class Option extends javax.swing.JFrame {

    /*Costruttore di finsione*/
    public Option() {
        /*Setto la finestra visibile*/
        initComponents();
        setVisible(false);
        /*Setto l'operazione di default per la chiusura*/
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        /*Setto la dimenzione minima*/
        super.setMinimumSize(new Dimension(1000, 300));
        /*Setto la posizione del layer*/
        setAlwaysOnTop (true);
        /*Set icona*/
        super.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCalendar1 = new com.toedter.calendar.JCalendar();
        ok = new javax.swing.JButton();
        username = new javax.swing.JTextField();
        hostname = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        delay = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        password = new javax.swing.JTextField();
        fileButtom = new javax.swing.JButton();
        dataIn = new com.toedter.calendar.JDateChooser();
        dataFi = new com.toedter.calendar.JDateChooser();
        jCheckBox2 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ok.setText("OK");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Selezziona per data");

        jLabel1.setText("Hostname:");

        jLabel2.setText("Username:");

        jLabel3.setText("Password:");

        jLabel4.setText("Refresce rate:");

        jLabel5.setText("Influisce sul carico della machina e del centralino");

        fileButtom.setText("Set ultimate use");
        fileButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileButtomActionPerformed(evt);
            }
        });

        jCheckBox2.setText("Visualizza solo chimate senza risposta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hostname, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox1)
                .addGap(18, 18, 18)
                .addComponent(dataIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dataFi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(delay, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fileButtom)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ok)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hostname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox1)
                    .addComponent(dataIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataFi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(delay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fileButtom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ok, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /*Metodo se clicco il pulsante ok*/
    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        /*Se i campi obbligatori sono pieni*/
        if(!"".equals(username.getText()) && !"".equals(hostname.getText()) && !"".equals(password.getText())){
            
            /*Prendo in input i valori delle label*/
            Connectdb.password = password.getText();
            Connectdb.username = username.getText();
            Connectdb.host = hostname.getText();
            Connectdb.delay = ((Integer)delay.getValue())*1000;
            
            /*Prendo in input e setto la ricerca di chiamate perse*/
            if(jCheckBox2.isSelected()){
                Connectdb.flagrec=true;
            }
            
            /*Se la ricerca per datata è settata*/
            if(jCheckBox1.isSelected()){
                /*Setto il flag di ricerca come attiva*/
                Connectdb.flagtot = true;
                String datain;
                String datafi;
                Date date = null;
                Calendar cal;
                /*Traduco il dato in input dell'inizio in una stringa*/
                date = dataIn.getDate();
                cal = Calendar.getInstance();
                cal.setTime(date);
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH); 
                datain = String.valueOf(year) + "-" + String.valueOf(month+1) + "-" + String.valueOf(day);
                Connectdb.datain = datain;
                /*Traduco il dato in input della fine in una stringa*/
                date = dataFi.getDate();
                cal = Calendar.getInstance();
                cal.setTime(date);
                year = cal.get(Calendar.YEAR);
                month = cal.get(Calendar.MONTH);
                day = cal.get(Calendar.DAY_OF_MONTH); 
                datafi = String.valueOf(year) + "-" + String.valueOf(month+1) + "-" + String.valueOf(day);
                Connectdb.datafi = datafi;
            }
            
            /*Provo ad aprire i file d'accesso*/
            String accessfile = "acces.dat";
            try{
                /*Creo il tipo file*/
                File file = new File(accessfile);
                /*Se il file esiste lo riempio*/
                if(file.exists()){
                    FileWriter filewriten = new FileWriter(file);
                    BufferedWriter buffer = new BufferedWriter(filewriten);
                    filewriten.write(hostname.getText() + ";" + username.getText() + ";" + password.getText());
                    filewriten.flush();
                    filewriten.close();
                }
                /*Se il file non esiste lo creo e riempio*/
                else if(file.createNewFile()){
                    FileWriter filewriten = new FileWriter(file);
                    filewriten.write(hostname.getText() + ";" + username.getText() + ";" + password.getText());
                    filewriten.flush();
                    filewriten.close();
                }
            }
            
            /*Se non riesco a gestire i file*/
            catch (IOException e) {
//            System.err.println("Errore eccezzione: " + e);
            }
            
            /*Chiusura del pannello opsioni*/
            super.dispose();
        }
    }//GEN-LAST:event_okActionPerformed

    
    /*Metodo compilazione automatica dei campi*/
    private void fileButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileButtomActionPerformed
        /*Inizializzo variabili locali*/
        int size, flag;
        String host = "";
        String user = "";
        String pass = "";
        char[] contenitore = new char[100];
        
        /*Provo ad fare un accesso al file*/
        try{
            /*Costruisco file*/
            String accessfile = "acces.dat";
            File file = new File(accessfile);
            
            /*Se il file seiste allora leggilo*/
            if(file.exists()){
                /*Provo a leggere il file*/
                try (FileReader filereader = new FileReader(file)) {
                    size = filereader.read(contenitore);
                    StringBuilder hostapp = new StringBuilder();
                    StringBuilder userapp = new StringBuilder();
                    StringBuilder passapp = new StringBuilder();
                    flag=0;
                    /*Pulisco l'input*/
                    for(int i=0; i<size; i++){
                        if(contenitore[i] == ';'){
                            i++;
                            flag++;
                        }
                        if(flag==0 && contenitore[i] != ';'){
                            hostapp.append(contenitore[i]);
                        }
                        if(flag==1 && contenitore[i] != ';'){
                            userapp.append(contenitore[i]);
                            
                        }
                        if(flag==2 && contenitore[i] != ';'){
                            passapp.append(contenitore[i]);
                            
                        }
                    }
                    /*Setto le stringe appena caricate*/
                    host = hostapp.toString();
                    user = userapp.toString();
                    pass = passapp.toString();
//                    System.out.println(contenitore[1] + "" + host + " " + user + " " + pass);
                    hostname.setText(host);
                    username.setText(user);
                    password.setText(pass);
                }
            }
            /*Gestione errore debug*/
            else{
//                System.err.println("File non trovato!");
            }
        }
        /*Se il file non riesco ad accedere*/
        catch (IOException e) {
//            System.err.println("Errore eccezzione: " + e);
        }
    }//GEN-LAST:event_fileButtomActionPerformed

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
            java.util.logging.Logger.getLogger(Option.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Option.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Option.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Option.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Option().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dataFi;
    private com.toedter.calendar.JDateChooser dataIn;
    private javax.swing.JSpinner delay;
    private javax.swing.JButton fileButtom;
    private javax.swing.JTextField hostname;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton ok;
    private javax.swing.JTextField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
