/**
 *Nicolò Perotti  6/02/2017 - 3/03/2017
 *Versione 1.0 data di rilascio 3/03/2017
 *File di main del programma con presente inizializzazione della GUI e rindirizzamento verso le classi.
*/

/*Importo le librerie necessarie*/
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.ImageIcon;

/*Dichiaro la classe dell'file con estenzione JFame*/
public class CallTracert extends javax.swing.JFrame {
    
    /*Inizzializzo oggetti in globale*/
    static boolean stopprint =  true;
    static String filtertype = new String();
    static String filtertext = new String();
    
    private static final long serialVersionUID = 1L;
    /*Oggetto per l'elaborazione dei database*/
    private final Connectdb connessione;                   
    /*Oggetto per l'elaborazione delle opzioni in GUI*/
    private final Option option = new Option();
    
    
    /*Diciaro costruttore*/
    public CallTracert() {
        //Diciaro un ogetto della stessa calsse
        this.connessione = new Connectdb();
        initComponents();
        //Imposto deimensioni minime del frame
        super.setMinimumSize(new Dimension(800, 300));
        //Imposto la chiusura automatica dei processi con la X
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        /*Disattivo posizione sempre sopra*/
        setAlwaysOnTop (false);
        /*Set icona*/
        super.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
        
    }
  
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tracertButtom = new javax.swing.JButton();
        tracertLable = new javax.swing.JLabel();
        filterButtom = new javax.swing.JButton();
        filterText = new javax.swing.JTextField();
        filterSelect = new javax.swing.JComboBox<>();
        filterLable = new javax.swing.JLabel();
        errorlable = new javax.swing.JLabel();
        scrollo = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        opsioni = new javax.swing.JButton();

        setTitle("CallTracert");
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(getIconImage());
        setIconImages(null);
        setMaximumSize(new java.awt.Dimension(15, 15));
        setMinimumSize(new java.awt.Dimension(15, 15));
        setSize(new java.awt.Dimension(15, 5));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        tracertButtom.setText("Tracert");
        tracertButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tracertButtomActionPerformed(evt);
            }
        });

        tracertLable.setText("Tracert:");

        filterButtom.setText("Filter");
        filterButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterButtomActionPerformed(evt);
            }
        });

        filterText.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        filterSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Stato", "Numero mittente", "Numero destinatario" }));

        filterLable.setText("Filter:");

        scrollo.setAutoscrolls(true);

        textArea.setColumns(20);
        textArea.setRows(5);
        textArea.setAutoscrolls(false);
        textArea.setEnabled(false);
        scrollo.setViewportView(textArea);

        opsioni.setText("Option");
        opsioni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opsioniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(tracertLable, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tracertButtom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorlable, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(filterLable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filterText, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(filterButtom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filterSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addComponent(opsioni)
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollo)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tracertLable)
                        .addComponent(filterText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(filterButtom)
                        .addComponent(filterSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tracertButtom)
                        .addComponent(filterLable)
                        .addComponent(opsioni))
                    .addComponent(errorlable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollo, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                .addContainerGap())
        );

        filterText.getAccessibleContext().setAccessibleName("");
        filterText.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /*Metodo di esecuzione su pulsante tracer*/
    private void tracertButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tracertButtomActionPerformed
        //Se la connessione è ferma allora parti*/
        if("Tracert:".equals(tracertLable.getText())){
            if(stopprint){
            tracertLable.setText("Stop tracert:");
            connessione.out(false);
            errore(0);
            connessione.start();
            }
            /*Cambio scritta pulsante tracert*/
            else{
                stopprint = true;
                tracertLable.setText("Stop tracert:");
            }
        }
        //Altrimenti fermala e rempostala per partire
        else{
            stopprint = false;
            tracertLable.setText("Tracert:");
        }
    }//GEN-LAST:event_tracertButtomActionPerformed

    
    /*Metodo per far apparire la GUI di option*/
    private void opsioniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opsioniActionPerformed
        option.setVisible(true);
    }//GEN-LAST:event_opsioniActionPerformed

    
    /*Metodo per far chiudere tutti i processi aperti al termine dell' esecuzione della GUI*/
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        connessione.out(true);
        Connectdb.interrupted();
        option.dispose();
    }//GEN-LAST:event_formWindowClosed

    
    /*Pulsante filtra*/
    private void filterButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterButtomActionPerformed
        filtertype = (String) filterSelect.getSelectedItem();
        filtertext = filterText.getText();
    }//GEN-LAST:event_filterButtomActionPerformed

    
    /*Metodo di scrittura sulla textarea*/
    static public void scrivi() throws MalformedURLException, IOException{
        if(stopprint){
            String testo = "ID\tMittente\tDestinatario\tStato\t\tData";
            Telefonate appchiamata;
            /*Creazione stringa senza filtro*/
            if(filtertext.equals("")){
                for(int i=0; i<Connectdb.vettorechiamate.size(); i++){
                    appchiamata = (Telefonate) Connectdb.vettorechiamate.elementAt(i);
                    testo = testo + "\n" + appchiamata.ID + "\t" + appchiamata.mittente + "\t" + appchiamata.destinatario + "\t" + appchiamata.event + "\t\t" + appchiamata.data;
                }
            }
            /*Creazione stringa con filtro stato*/
            else if (filtertype.equals("Stato") && !filtertext.equals("")){
               for(int i=0; i<Connectdb.vettorechiamate.size(); i++){
                    appchiamata = (Telefonate) Connectdb.vettorechiamate.elementAt(i);
                    if(appchiamata.event.equals(filtertext)){
                        testo = testo + "\n" + appchiamata.ID + "\t" + appchiamata.mittente + "\t" + appchiamata.destinatario + "\t" + appchiamata.event + "\t\t" + appchiamata.data;
                    }
                }
            }
            /*Creazione stringa con filtro destinatario*/
            else if (filtertype.equals("Numero destinatario") && !filtertext.equals("")){
               for(int i=0; i<Connectdb.vettorechiamate.size(); i++){
                    appchiamata = (Telefonate) Connectdb.vettorechiamate.elementAt(i);
                    if(appchiamata.destinatario.equals(filtertext)){
                        testo = testo + "\n" + appchiamata.ID + "\t" + appchiamata.mittente + "\t" + appchiamata.destinatario + "\t" + appchiamata.event + "\t\t" + appchiamata.data;
                    }
                }
            }
            /*Creazione stringa con filtro mittente*/
            else if (filtertype.equals("Numero mittente") && !filtertext.equals("")){
               for(int i=0; i<Connectdb.vettorechiamate.size(); i++){
                    appchiamata = (Telefonate) Connectdb.vettorechiamate.elementAt(i);
                    if(appchiamata.mittente.equals(filtertext)){
                        testo = testo + "\n" + appchiamata.ID + "\t" + appchiamata.mittente + "\t" + appchiamata.destinatario + "\t" + appchiamata.event + "\t\t" + appchiamata.data;
                    }
                }
            }
            textArea.setText(testo);
        }
    }
    
    
    /*Metodo per segnalare un errore di connesione*/
    static public void errore(int errr){
        switch (errr){
            /*Se la connessione errata*/
            case 1:
                errorlable.setText("Errore di connessione");
                errorlable.setForeground(Color.RED);
            break;
            /*Se la connesione è OK*/
            case 0:
                errorlable.setText("");
                errorlable.setForeground(Color.BLACK);
            break;        
        }    
    }
    
    
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
            java.util.logging.Logger.getLogger(CallTracert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CallTracert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CallTracert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CallTracert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CallTracert().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel errorlable;
    private javax.swing.JButton filterButtom;
    private javax.swing.JLabel filterLable;
    private javax.swing.JComboBox<String> filterSelect;
    private javax.swing.JTextField filterText;
    private javax.swing.JButton opsioni;
    public static javax.swing.JScrollPane scrollo;
    public static javax.swing.JTextArea textArea;
    private javax.swing.JButton tracertButtom;
    private javax.swing.JLabel tracertLable;
    // End of variables declaration//GEN-END:variables

}