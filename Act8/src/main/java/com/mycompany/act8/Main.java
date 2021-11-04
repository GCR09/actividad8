package com.mycompany.act8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/**
 *
 * @author Cortez Ramos
 */
public class Main {
    public static BufferedReader entrada =new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        boolean repetir = true;
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
        System.out.println("Bienvenido a Poker!");

        while(repetir){
            try {
                showMenu(deck);
                repetir = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public static void showMenu(Deck deck) throws Exception{
        System.out.println("---------------------------");
        System.out.println("Selecciona una opción:");
        System.out.println("1 Mezclar deck");
        System.out.println("2 Sacar una carta");
        System.out.println("3 Carta al azar");
        System.out.println("4 Generar una mano de 5 cartas");
        System.out.println("0 Salir");
        String opcion= entrada.readLine();
        
        switch(opcion){
            case "1":
                System.out.println("Seleccionaste 'Mezclar deck':");
                deck.shuffle();
                showMenu(deck);
                break;
            case "2":
                System.out.println("Seleccionaste 'Sacar carta':");
                try {
                deck.head();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println("Fin del programa");
                    System.exit(0);
                }
                showMenu(deck);
                break;
            case "3":
                System.out.println("Seleccionaste 'Carta al azar':");
                try {
                deck.pick();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println("Fin del programa");
                    System.exit(0);
                }
                showMenu(deck);
                break;
            case "4":
                System.out.println("Seleccionaste 'Generar una mano de "
                        + "5 cartas':");
                try {
                deck.hand();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println("Fin del programa");
                    System.exit(0);
                }
                showMenu(deck);
                break;
            case "0":
                System.out.println("Seleccionaste 'Salir'");
                System.out.println("Adios, has salido del Poker");
                break;
            default:
                throw new Exception("Opción no válida");
        } 
    }
    
    public static String getColor(String palo) {
        if (palo.toLowerCase().equals("pika") 
                || palo.toLowerCase().equals("trebol")) {
            return "negro";
        }
        if (palo.toLowerCase().equals("corazon") 
                || palo.toLowerCase().equals("diamante")) {
            return "rojo";
        }

        return null;
    }
}
