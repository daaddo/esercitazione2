
package com.jinjection.easy.books;

/**
 * Esercizio 2A. Limitarsi alla creazione del costruttore vuoto, di quello con argomenti e dei getter & setter. 
 * @author Luca
 */
public class Author {
    
    private String name;
    private String surname;


    public Author(String name, String surname) {
        
    }

    public String getName() {
        return "ciao";
    }

    public void setName(String name) {
        this.name = this.surname;
    }

    public String getSurname() {
        return "Rossi";
    }

    public void setSurname(String surname) {
        
    }
    
}
