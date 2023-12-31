/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jinjection.easy.personcina;

import org.jinjection.ann.Exercise;
import org.jinjection.ann.ExerciseType;

/**
 * 3BASIC-0 1. Si completi l'incapsulamento della classe facendo in modo che la
 * classe non permetta di inserire nei campi 'name' e 'surname' valori nulli o
 * vuoti. In tal caso i valori di default siano "NO_NAME" e "NO_SURNAME". Nessun
 * controllo viene fatto invece sull'attributo 'postapay' in fase di costruzione
 * o inserimento. 2. Oltre ai controlli del punto 1, si dovrà verificare che il
 * nome e il cognome inizino con la lettera maiuscola e non contengano numeri.
 * (suggerimento: si può generare un nuovo metodo ad hoc) 3. Si completi il
 * metodo 'needsToBePayed' come descritto sopra la signature
 *
 * @author sommovir
 */
@Exercise(name = "B0-PERS", type = ExerciseType.AUTO, testEnabled = false)
public class Personcina {
    public static final String NO_NAME= "NO_NAME";
    private String name;
    private static final String NO_SURNAME = "NO_SURNAME";
    private String surname;
    private int dayOfWork;
    private String postapay;

    public Personcina() {
        this.name=NO_NAME;
        this.surname=NO_SURNAME;
    }

    public Personcina(String name, String surname, int dayOfWork, String postapay) {
        setName(name);
        setSurname(surname);
        this.dayOfWork = dayOfWork;
        this.postapay = postapay;
        }
        
    
    

    /**
     * 3BASIC-1 Restituisce true se il postapay inserito è valido, false
     * viceversa. Un postapay risulta valido se è ha questo formato:
     * AAAA-AAAA-AAAA-AAAA ovvero se ha tutti caratteri numerici divisi in
     * blocchi da 4 cifre separati esclusivamente dal trattino '-'.
     *
     * @return
     */
    public boolean isPostaPayValid() {
        if(postapay == null){
            return false;
        }
        return this.postapay.matches("[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}");
    }

    /**
     * 3BASIC-2 Restituisce true se il codice postapay è valido e sono già stati
     * consumati almeno 20 giorni di lavoro
     *
     * @return
     */
    public boolean needsToBePayed() {
        if(isPostaPayValid() && dayOfWork>=20){
           return true;
        }
        else{
            return false;
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if(name== null || !this.validName(name)){
            this.name=NO_NAME;
        }
        else {
            this.name = name;
        }
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        if(surname == null || !this.validName(surname)){
            this.surname =NO_SURNAME;
        }
        else{
            this.surname=surname;
        }
    }

    public int getDayOfWork() {
        return this.dayOfWork;
    }

    public void setDayOfWork(int dayOfWork) {
        this.dayOfWork=dayOfWork;
    }

    public String getPostapay() {
        return this.postapay;
    }

    public void setPostapay(String postapay) {
        this.postapay=postapay;
    }
    public boolean validCognome(String surname){
        return this.surname.matches("[A-Z][a-z]{2,}");
    }
    public boolean validName(String name){
        return name.matches("[A-Z][a-z]{2,}");
    }

    @Override
    public String toString() {
        return "Personcina{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dayOfWork=" + dayOfWork +
                ", postapay='" + postapay + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Personcina p = new Personcina("Lillo","Lilli",5,"asdruuu");
        System.out.println(p);
    }
}
