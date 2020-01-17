/**
 *Nicolò Perotti  6/02/2017 - 3/03/2017
 *Versione 1.0 data di rilascio 3/03/2017
 *Classe per la connessione e la scrematura delle informazioni prese dal db
*/

/*Importo librerie*/
import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;

/**
 *
 * @author Tirocinio
 */

public class Connectdb extends Thread{

    /*Dichiaro le variabili utilizzate*/
    public static String username = "root";
    public static String host = "localhost";
    public static String password = "root";
    public static int delay = 1000;
    private static boolean stop = false;
    private static int tot, num, flag;
    public static Vector vettorechiamate = new Vector(1, 1);
    private Telefonate chiamata;
    private Telefonate appchiam;
    public static boolean flagtot = false;
    public static boolean flagrec = false;
    public static String datain = new String();
    public static String datafi = new String();
    public int recflag = 0;
    public static DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    Date date = new Date();
   
  
    /*Dichiaro la funsione per stoppare il thread*/
    public void out(boolean estop){
        stop=estop;
    }
   
    
    /*Dichiaro il metodo run per far partire il Thread*/
    public void run(){
        
        /*Diciaro stringhe*/
        String testo;
        String query;
        /*Indici e contatori*/
        int i=0;
        tot=0;
                
        /*Esegui finche non viene stoppato il Thread*/
        while(!stop){
            /*Provo a connettermi al db*/
            Connection con = null;
            try {
                /*Faccio la conessione*/
                con = DriverManager.getConnection("jdbc:mysql://" + host + "/asteriskcdrdb", username, password);
            } catch (SQLException ex) {
                Logger.getLogger(Connectdb.class.getName()).log(Level.SEVERE, null, ex);
                CallTracert.errore(1);
                out(true);
//                System.err.println("Errore eccezzione: " + ex);
            }
            
            /*Provo ad eseguire lo operazioni di queri scrittura ed elaborazione*/
            try {
                /*Se non è il primo cilco*/
                if(num!=0){
                    
                    /*Setto la query generale*/
                    query = "select * from cel where ID > " + num + ";";
                    /*Creo un tipo di oggetto*/
                    Statement stm = con.createStatement();
                    /*Faccio la querry*/
                    ResultSet rs = stm.executeQuery(query);

                    /*Se ci sono nuovi risultati dalla querry*/
                    while(rs.next()){
                        /*Setto il flag a 0*/
                        flag=0;
                        /*Incremento il contatore dell'indice*/
                        num++;

                        /*Inserisco i risultati in un appoggio*/
                        date = rs.getTimestamp("eventtime");
                        String datestring = dateFormat.format(date); 
                        appchiam = new Telefonate(rs.getInt("id"), rs.getString("linkedid"), rs.getString("eventtype"), rs.getString("cid_num"), "", rs.getString("context"), datestring);
//                        System.out.println("Genero spazio");
                        
                        /*Verifico se ci sono gia degli elementi dentro il vettore e li ciclo*/
                        for(i=0; i<vettorechiamate.size(); i++){
                            /*Vrifico se c'è un altra chiamata con lo stesso id*/
                            chiamata = (Telefonate) vettorechiamate.elementAt(i);
                            if(appchiam.idChiamata.equals(chiamata.idChiamata)){
                                /*Se sta chiamado*/
                                if(chiamata.event.equals("In chiamata") && appchiam.event.equals("CHAN_START") && flag!=1  && flag!=50){
                                    chiamata.destinatario=appchiam.mittente;
                                    chiamata.data = appchiam.data;
                                    vettorechiamate.setElementAt(chiamata, i);
                                    flag=1;
                                }
                                /*Se è stata deviata*/
                                if(chiamata.event.equals("In chiamata") && appchiam.event.equals("FORWARD") && flag==1 || flag==4 && flag!=50){
                                    chiamata.destinatario=appchiam.mittente;
                                    chiamata.event="Deviata";
                                    chiamata.data = appchiam.data;
                                    vettorechiamate.setElementAt(chiamata, i);
                                    flag=7;
                                }
                                /*Se non ha ricevuto risposta*/
                                if(chiamata.event.equals("In chiamata") && appchiam.event.equals("HANGUP") && flag!=2 && flag!=7 && flag!=50){
                                    chiamata.event="Senza risposta";
                                    chiamata.data = appchiam.data;
                                    vettorechiamate.setElementAt(chiamata, i);
                                    flag=2;
                                }
                                /*Se sono in conversazione*/
                                if(chiamata.event.equals("In chiamata") && appchiam.event.equals("BRIDGE_ENTER")&& flag!=2 && flag!=3 && flag!=50){
                                    chiamata.event="In conversazione";
                                    chiamata.data = appchiam.data;
                                    vettorechiamate.setElementAt(chiamata, i);
                                    flag=3;
                                }
                                /*Se la chiamata è terminata*/
                                if(chiamata.event.equals("In conversazione") && appchiam.event.equals("LINKEDID_END") && flag!=2 && flag!=4 && flag!=7 && flag!=50){
                                    chiamata.event="Terminata";
                                    chiamata.data = appchiam.data;
                                    vettorechiamate.setElementAt(chiamata, i);
                                    flag=4;
                                }
                            }
                        }
                        
                        /*Se è il primo interupt di chiamata*/
                        if(appchiam.event.equals("CHAN_START") && flag==0 && !appchiam.contesto.equals("from-trunk ")){
//                            System.out.println("Genero spazio");
                            chiamata = new Telefonate(appchiam.ID , appchiam.idChiamata, "In chiamata", appchiam.mittente,"", "", appchiam.data);
                            vettorechiamate.addElement(chiamata);
                            flag=8;
                        }
                        
                        /*Se è si è creata una coda*/
                        if (appchiam.event.equals("CHAN_START") && flag==0 && appchiam.contesto.equals("from-trunk ")){
                            flag=50;
//                            System.out.println("Genero spazio");
                            chiamata = new Telefonate(appchiam.ID , appchiam.idChiamata, "In coda", appchiam.mittente,"", "", appchiam.data);
                            vettorechiamate.addElement(chiamata);
                        }
                        
                        /*Se è attiva la funsione di chiamte non risposte*/
                        if(flagrec == true){
                            for(i=0; i<vettorechiamate.size(); i++){
                                chiamata = new Telefonate(0 ,"","","","","","");
                                chiamata = (Telefonate) vettorechiamate.elementAt(i);
                                for(int k=recflag; k<vettorechiamate.size(); k++){
                                    appchiam = new Telefonate(0 ,"","","","","","");
                                    appchiam = (Telefonate) vettorechiamate.elementAt(k);
                                    if((chiamata.mittente.equals(appchiam.mittente)||chiamata.mittente.equals(appchiam.destinatario)) && i<k && (chiamata.destinatario.equals(appchiam.destinatario) || chiamata.destinatario.equals(appchiam.mittente)) && chiamata.event.equals("Senza risposta") && (appchiam.event.equals("In conversazione") || appchiam.event.equals("Terminata"))){
                                        vettorechiamate.remove(i);
                                        recflag = i;
                                    }
                                }
                            }   
                        
                        }
                    }
                    try {
                        /*Richiamo il metodo di output*/
                        CallTracert.scrivi();
                    } catch (IOException ex) {
                        Logger.getLogger(Connectdb.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                /*Se devo eseguire la lettura dall' ultimo*/
                if(num==0 && flagtot==false){
                    query = "select * from cel;";
                    /*Creo un tipo di oggetto*/
                    Statement stm = con.createStatement();
                    /*Faccio la querry*/
                    ResultSet rs = stm.executeQuery(query);
                    /*Conto fino alla ultima chiamata*/
                    tot=0;
                    while(rs.next()){
                        tot++;
                    }
                    num=tot;
                   
                }
                
                /*Se devo eseguire la lettura da date ben precise*/
                if(num==0 && flagtot==true){
                    /*Genero la query*/
                    query="SELECT  * FROM cel WHERE eventtime >= '" + datain +  "' AND eventtime <= '" + datafi + "';";
                    /*Creo l'oggetto di risposta*/
                    Statement stm = con.createStatement();
                    /*Faccio la query*/
                    ResultSet rs = stm.executeQuery(query);
                    /*Setto l'id da dove cominciare*/
                    if(rs.next()){
                        num = rs.getInt("id");
                    }
                }
            } 
            
            /*Altrimanti mando in output il messagio di errore*/
            catch (SQLException exc) {
//                System.err.println("Errore eccezzione: " + exc);
                CallTracert.errore(1);
                out(true);
                
            }
            
            /*Delay del thread*/
            try {
                Thread.sleep(delay);
            } catch (InterruptedException ex1) {
//                System.err.println("Errore eccezzione: " + ex1);
                Logger.getLogger(Connectdb.class.getName()).log(Level.SEVERE, null, ex1);
                CallTracert.errore(1);
                out(true);
            }
            
            /*Chiusura thread con*/
            try {
                con.close();
            } catch (SQLException ex) {
//                System.err.println("Errore eccezzione: " + ex);
                Logger.getLogger(Connectdb.class.getName()).log(Level.SEVERE, null, ex);
                CallTracert.errore(1);
                out(true);
            }
        }

    }

}



