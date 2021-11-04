package com.mycompany.act8;

import java.util.Collections;
import java.util.List;
import java.util.Random;
/**
 *
 * @author Cortez Ramos
 */
public class Deck {
    private List<Card> card;
    private Integer numCard = 52;

    public List<Card> getCard() {
        return card;
    }

    public void setCard(List<Card> card) {
        this.card = card;
    }

    public Integer getNumCard() {
        return numCard;
    }

    public void setNumCard(Integer numCard) {
        this.numCard = numCard;
    }

    public void shuffle() {
        Collections.shuffle(card);
        System.out.println("Se mezcló el Deck");
    }
    
    public void head() throws Exception{
        System.out.println(card.get(0).getAll());
        card.remove(0);
        numCard-=1;
        System.out.println("Quedan: "+numCard);
        if(numCard==0){
            throw new Exception("Se han agotado las cartas");
        }
    }
    
    public void pick() throws Exception{
        Random randomNumbers = new Random();
        int aleatorio = randomNumbers.nextInt(numCard);
        System.out.println(card.get(aleatorio).getAll());
        card.remove(aleatorio);
        numCard-=1;
        System.out.println("Quedan: "+numCard);
        if(numCard==0){
            throw new Exception("Se han agotado las cartas");
        }
    }
    
    public void hand() throws Exception{
        int i = 1;
        while(i <= 5) {
        Random randomNumbers = new Random();
        int aleatorio = randomNumbers.nextInt(numCard);
        System.out.println(card.get(aleatorio).getAll());
        card.remove(aleatorio);
        numCard-=1;
        if(numCard==0){
            System.out.println("Quedan: "+numCard);
            throw new Exception("Se han agotado las cartas");
        }
        i++;
        } 
        System.out.println("Quedan: "+numCard);
    }
    
    public void mostrar() {
        for(int i = 0; i < numCard; i++) {
            System.out.println(card.get(i).getAll());
        }
    }
}
