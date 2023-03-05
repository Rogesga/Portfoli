package com.mycompany.projects;

import java.util.Scanner;

public class Projects {

    static Scanner teclat = new Scanner(System.in);

    public static void main(String[] args) {
        inici();
        jugar();
    }

    public static void jugar() {
        char J1 = 'X';
        char J2 = 'O';
        char jugar = 'S';
        char celda = '-';
        boolean torn = true;
        char tauler[][] = new char[3][3];
        omplirTauler(tauler, celda);
        int fila, columna;
        boolean valida, be;

        while (!finalPartida(tauler, celda)) {
            

            do {
                mostrarTornActual(torn);
                mostrarTauler(tauler);
                
                be = false;
                fila = demanarDades("Digam la Fila");
                columna = demanarDades("Digam la Columna");
                valida = validarPosicio(tauler, fila, columna);
                if (valida) {
                    if (!posicioBuida(tauler, fila, columna, celda)) {
                        be = true;
                    }
                }

            } while (!be);

            if (torn) {
                introduirA(tauler, fila, columna, J1);
            } else {
                introduirA(tauler, fila, columna, J2);
            }

            torn = !torn;
        }
        
        mostrarTauler(tauler);
        guanyador(tauler, J1, J2, celda);
        tornarAJugar(tauler, celda, jugar);
    }
    
    public static void inici(){
        int mostra[][] = {{00,01,02},{10,11,12},{22,21,22}};
        System.out.println("Benvingut al Tres En Raya");
        System.out.println("Les normes son facils, el primer que fagui 3 en raya, dona igual si en diagonal, paralel, o linea, guanyara.");
        System.out.println("Per escriure al taulell hauras d'intrudir el numero de casella i si esta dins del rang s'intruduira");
        for(int i=0; i<mostra.length; i++){
            for(int t=0; t<mostra[i].length; t++){
                System.out.print(" "+mostra[i][t]);
            }
            System.out.println();
        }
    }
    
    public static void tornarAJugar(char[][] taula, char defecte, char jugar){
        
      if(finalPartida(taula, defecte)){
          System.out.println("Vols Tornar a jugar? escriu S sino N");
          jugar = teclat.next().charAt(0);
          if(jugar == 'S'){
              jugar();
          }
      }  
           
     } 
    
    
    public static void guanyador(char[][] taula, char J1, char J2, char defecte){
        
        char guio = guanyaLinea(taula, defecte); 
        if(guio != defecte){
            
            if(guio==J1){
                System.out.println("Felicitats J1, guanyas per LINEA");
            }else{
                System.out.println("Felicitats J2, guanyas per LINEA");
            }
            return;
        }
        
        guio = guanyaColumna(taula, defecte); 
        if(guio != defecte){
            
            if(guio==J1){
                System.out.println("Felicitats J1, guanyas per COLUMNA");
            }else{
                System.out.println("Felicitats J2, guanyas per COLUMNA");
            }
            return;
        }
        
        guio = guanyaDiagonal(taula, defecte); 
        if(guio != defecte){
            
            if(guio==J1){
                System.out.println("Felicitats J1, guanyas per DIAGONAL");
            }else{
                System.out.println("Felicitats J2, guanyas per DIAGONAL");
            }
            return;
        }
        
        System.out.println("Hi ha un empat!");
        
    }
    

    public static void introduirA(char[][] taula, int fila, int columna, char zelda) {

        taula[fila][columna] = zelda;

    }

    public static void mostrarTornActual(boolean torn) {
        if (torn) {
            System.out.println("Et toca Jugador 1");
        } else {
            System.out.println("Et toca jugador 2");
        }
    }

    public static int demanarDades(String demanar) {
        System.out.println(demanar);
        int dades = teclat.nextInt();

        return dades;
    }

    public static void omplirTauler(char[][] taula, char guio) {
        for (int i = 0; i < taula.length; i++) {
            for (int t = 0; t < taula[i].length; t++) {
                taula[i][t] = guio;
            }
        }
    }

    public static boolean validarPosicio(char[][] taula, int fila, int columna) {
        if (fila >= 0 && fila < taula.length && columna >= 0 && columna < taula.length) {
            return true;
        }
        System.out.println("Valor Fora de Rang");
        return false;
    }

    public static boolean posicioBuida(char[][] taula, int fila, int columna, char defecte) {
        if (taula[fila][columna] != defecte) {
            return true;
        }else{
            System.out.println("La celda esta ja omplerta");
        }
        
        return false;
    }

    public static void mostrarTauler(char[][] taula) {
        for (int i = 0; i < taula.length; i++) {
            for (int t = 0; t < taula[0].length; t++) {
                System.out.print(" "+taula[i][t]);
            }
            System.out.println("");
        }

    }

    public static boolean taulaPlena(char[][] taula, char defecte) {

        for (int i = 0; i < taula.length; i++) {
            for (int t = 0; t < taula[0].length; t++) {
                if (taula[i][t] == defecte) {
                    return false;
                }
            }
        }
        return true;

    }

    public static boolean finalPartida(char[][] taula, char defecte) {

        if (taulaPlena(taula, defecte) 
                || guanyaLinea(taula, defecte) != defecte
                || guanyaColumna(taula, defecte) != defecte
                || guanyaDiagonal(taula, defecte) != defecte) {

            return true;
        }
        return false;
    }

    public static char guanyaLinea(char[][] taula, char defecte) {

        char guio;
        boolean guanyaL;

        for (int i = 0; i < taula.length; i++) {

            guanyaL = true;
            guio = taula[i][0];
            if (guio != defecte) {
                for (int j = 1; j < taula[0].length; j++) {
                    if (guio != taula[i][j]) {
                        guanyaL = false;
                    }
                }
                if (guanyaL) {
                    return guio;
                }
            }
        }
        return defecte;
    }

    public static char guanyaColumna(char[][] taula, char defecte) {

        char guio;
        boolean guanyaC;

        for (int c = 0; c < taula.length; c++) {

            guanyaC = true;
            guio = taula[0][c];
            if (guio != defecte) {
                for (int j = 1; j < taula[0].length; j++) {
                    if (guio != taula[j][c]) {
                        guanyaC = false;
                    }
                }
                if (guanyaC) {
                    return guio;
                }
            }
        }
        return defecte;
    }

    public static char guanyaDiagonal(char[][] taula, char defecte) {

        char guio;
        boolean guanyaD = true;
        guio = taula[0][0];

        if (guio != defecte) {
            for (int i = 1; i < taula.length; i++) {
                if (guio != taula[i][i]) {
                    guanyaD = false;
                }
            }
            if(guanyaD){
                return guio;
            }
        }

        guio = taula[0][2];
        if (guio != defecte) {
            for (int i = 1, j = 1; i < taula.length; i++, j--) {
                if (guio != taula[j][i]) {
                    guanyaD = false;
                }
            }
            if(guanyaD){
                return guio;
            }
        }

        return defecte;
    }
}
