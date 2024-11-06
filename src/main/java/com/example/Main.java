package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("client partito...");
        Socket s= new Socket("localhost",3000);
        Scanner scanner=  new Scanner(System.in);

         BufferedReader in= new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        String messaggio;
        String appunto;
        String nNote;
        String scelta;
        System.out.println("inserisci nota");
             System.out.println("Digita ESCI per uscire");
             System.out.println("inserisci la nota da memorizzare o digita la LISTA per visualizzare le note salvate");
        do{
             
             scelta=scanner.nextLine();
             //messaggio=in.readLine();
             if(scelta.equals("ESCI")){
                out.writeBytes("!"+"\n");
                System.out.println("connessione chiusa");
                // esci dal programma
             }
             else if(scelta.equals("LISTA")){
                out.writeBytes("?"+"\n");
                int numeroElementi= Integer.parseInt(in.readLine());
                for (int i = 0; i < numeroElementi; i++){
                    System.out.println(in.readLine());
                }           
             }
             else{
                System.out.println("OK");
             }
             



             






        }while(!scelta.equals("!"));
    }
}