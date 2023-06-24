/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jinjection.easy.morder;


import org.jinjection.ann.Exercise;
import org.jinjection.ann.ExerciseType;

/**
 * 3 BASIC 2 Completare l'incapsulamento di questa classe secondo queste
 * specifiche:
 * 1. il commander è un nome composto dal grado seguito da uno
 * spazio e poi dal cognome del comandante. I gradi possono essere
 * esclusivamente:
 * - 'Gen.'
 * - 'Ten.'
 * non ne sono ammessi altri. Il cognome non deve contenere numeri e deve
 * iniziare con la maiuscola. Alcuni esempi validi: 'Gen. Badoglio', 'Ten. Fasulli'.
 * Se si tenta di inserire un commander invalido si setti con il valore: 'INVALID'.
 * <p>
 * 2. il campo order specifica il tipo di ordine che il comandante impartisce:
 * L'ordine è rappresentato da una stringa alfa numerica criptata. Si può
 * riconoscere però se è un ordine valido se contiene il codice segreto 'NUC'.
 * e contenga subito dopo almeno altri 3 caratteri.
 * Se si tenta di inserire un codice invalido si setti il valore 'INVALID'.
 * <p>
 * 3. isLaunchOrder()
 * Implementare il metodo secondo le specifiche che troveretesopra la signature
 * <p>
 * 4. isValid()
 * Implementare il metodo secondo le specifiche che troverete sopra la signature
 * <p>
 * IMPORTANTE: Attivare il tester Lesson3TUTORUnitTest
 *
 * @author sommovir
 */
@Exercise(name = "B2-MORDER", type = ExerciseType.AUTO, testEnabled = true)
public class MilitaryOrder {

    private String commander;
    private String order;

    private static final String INVALID = "INVALID";

    public MilitaryOrder() {
        this.commander = INVALID;
        this.order = INVALID;
    }

    public MilitaryOrder(String commander, String order) {
        setCommander(commander);
        setOrder(order);
    }

    /**
     * Questo metodo ritorna true se il codice 'order' sia un codice di lancio
     * Si presuppone che il codice a questo punto sia già validato.
     * Per capire la tipologia di codice si dovranno guardare i 3 caratteri
     * successivi alla parola chiave 'NUC. Se nei 3 seguenti c'è almeno una lettera
     * allora sarà un codice di lancio viceversa sarà un codice di ripristino (false).
     */
    public boolean isLaunchOrder() {
        //  AABABABABABNUC2AB
        int nucStart = this.order.indexOf("NUC");
        String afterNUC3 = this.order.substring(nucStart+3,nucStart+6);
        return afterNUC3.matches(".*[A-Za-z].*");
    }

    //Questo metodo ritorna true se sia commander che order sono validi, false viceversa. 
    public boolean isCommValid() {

        return this.commander!=null && this.commander.matches("(G|T)en\\.\\s[A-Z][a-z]{3,}");

    }
    public boolean isValid(){
        return this.commander!=null && this.commander.matches("(G|T)en\\.\\s[A-Z][a-z]{3,}")  && isOrderValid(this.order);
    }
    public boolean isOrderValid(String order){
        return order!=null && order.matches(".*NUC[A-z0-9]{3}.*");
    }


    public String getCommander() {
        return this.commander;
    }

    public void setCommander(String commander) {
        this.commander = commander;
        if (!this.isCommValid()) {
           this.commander= INVALID ;
        }
    }

    public String getOrder() {
       return this.order;
    }

    public void setOrder(String order) {
        if(isOrderValid(order) ){
            this.order = order;
        }
        else{
            this.order= INVALID;
        }
    }

    public static void main(String[] args) {

        String order = "ABVBABANUC123ASDADASD";
        int nucStart = order.indexOf("NUC");
        String afterNUC3 = order.substring(nucStart+3,nucStart+6);

        System.out.println(afterNUC3);



    }

}
