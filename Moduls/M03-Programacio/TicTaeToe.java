package com.mycompany.arrays;

public class TicTaeToe {
    
    public static void main(String[] args){
        jugar();
    }
    public static void jugar(){
        char J1='X';
        char J2 = 'O';
        char celda='-';
        boolean torn = true;
        char tauler [][] = new char[3][3];
        omplirTauler(tauler, celda);
        int fila, columna;
        
        while(finalPartida(tauler)){
            mostrarTauler(tauler);
            
        }
    }
    public static void mostrarTornActual(boolean torn){
        if(torn){
            System.out.println("Et toca Jugador 1");
        }
    }
    public static void omplirTauler(char[][] taula, char guio){
        for(int i=0; i<taula.length; i++){
            for(int t=0; t<taula[i].length; t++){
                taula[i][t] = guio;
            }
        }
    }
    public static boolean finalPartida(char[][] taula){
        
    }
    public static void mostrarTauler(char[][] taula){
      for(int i=0; i<taula.length; i++){
            for(int t=0; t<taula[0].length; t++){
                System.out.print(taula[i][t]);
            }
            System.out.println("");
        }
        
    }
}