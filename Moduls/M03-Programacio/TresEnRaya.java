package com.mycompany.arrays;
import java.util.Scanner;

public class TresEnRaya {
    public static void main(String[] args){
        System.out.println(inici());
        System.out.println();
        System.out.println(tauller());
        }
    public static int[][] taulell(int filas, int columnas){
            int[][] taula = new int[filas][columnas];
            return taula;
    }
    public static int[][] inici(){
        int mostra[][] = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("Benvingut al Tres En Raya");
        System.out.println("Les normes son facils, el primer que fagui 3 en raya, dona igual si en diagonal, paralel, o linea, guanyara.");
        System.out.println("Per escriure al taulell hauras d'intrudir el numero de casella i si esta dins del rang s'intruduira");
        for(int i=0; i<mostra.length; i++){
            for(int t=0; t<mostra[i].length; t++){
                System.out.print(" "+mostra[i][t]);
            }
            System.out.println();
        }
            return mostra;
        }
       
    public static int[][] tauller(){
        int longtaula = 3; 
        int longtaula1 = 3;
        int taula[][] = taulell(longtaula, longtaula1);
        for(int i=0; i<taula.length; i++){
            for(int t=0; t<taula[i].length; t++){
                taula[i][t] = 0;
                if(taula[i][t] == 0){
                    System.out.print(" ");
                }
                
            }
            System.out.println();
        }
        return taula;
        }
    
    public static void jugar(char jugadorX, char jugadorO){
         boolean partidaEnJoc = false;
         jugadorX = 'X';
         jugadorO = 'O';
         if(!partidaEnJoc){
             tauller();
             
         }
        }
    }
    

