package com.mycompany.act8;

import java.util.ArrayList;
/**
 *
 * @author Cortez Ramos
 */
public class Main {
    public static void main(String[] args) {
        String[] palo = {"Pika", "Corazon", "Diamante", "Trebol"};
        String[] valor = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        Deck deck = new Deck();
        deck.setCard(new ArrayList<Card>());
        for (int i = 0; i < palo.length; i++) {
            for (int j = 0; j < valor.length; j++) {
                Card card = new Card(palo[i], getColor(palo[i]), valor[j]);
                deck.getCard().add(card);
            }
        }
        System.out.println("Deck:");
        deck.mostrar();
        System.out.println("El tamaño del deck es de:" + deck.getCard().size());
        System.out.println("----------------------------------------");
        System.out.println("Mezclar Deck\n" + deck.mezclar());
        deck.mostrar();
        System.out.println("----------------------------------------");
        System.out.println("Cabeza de la baraja:");
        deck.head();
        System.out.println("----------------------------------------");
        System.out.println("Carta aleatoria de la baraja:");
        deck.pick();
        System.out.println("----------------------------------------");
        System.out.println("Mano:");
        deck.hand();
        System.out.println("----------------------------------------");
        deck.mostrar();
        System.out.println("Tamaño del deck:" + deck.getCard().size());
        
    }
    
    public static String getColor(String palo) {
        if (palo.toLowerCase().equals("pika") || palo.toLowerCase().equals("trebol")) {
            return "negro";
        }
        if (palo.toLowerCase().equals("corazon") || palo.toLowerCase().equals("diamante")) {
            return "rojo";
        }

        return null;
    }
}
