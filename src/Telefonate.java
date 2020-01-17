/**
 *Nicolò Perotti  6/02/2017 - 3/03/2017
 *Versione 1.0 data di rilascio 3/03/2017
 *Classe per gli oggetti Telefonate
*/

public class Telefonate{
    /*Dichiarazione variablili*/
    int ID;
    String idChiamata, event, mittente, destinatario, contesto, data;
    public boolean note = false;

    /*Dichiarazione costruttore*/
    public Telefonate( int ID, String idChiamata, String event, String mittente, String destinatario, String contesto, String data) {
        /*Assegnazione in fase di costruzzione*/
        this.ID=ID;
        this.idChiamata=idChiamata;
        this.event=event;
        this.mittente=mittente;
        this.destinatario=destinatario;
        this.contesto = contesto;
        this.data = data;
    
    }
        
}