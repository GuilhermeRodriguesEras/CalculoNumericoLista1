package com.mycompany.calculonumericolistaum;

public class CalculoNumericoListaUm {

    public static void main(String[] args) {

        Questao9 exe = new Questao9(-5);
        System.out.printf("para e = -5, temos f(x) = 0 em %.6f em %d iteracoes pelo metodo bisseccao\n",
                    exe.bisseccao(), exe.getIterations());
        System.out.printf("para e = -5, temos f(x) = 0 em %.6f em %d iteracoes pelo metodo da falsa Posicao"
                + "\n",exe.falsaPosicao(), exe.getIterations());
        System.out.printf("para e = -5, temos f(x) = 0 em %.6f em %d iteracoes pelo metodo de newton\n",
                exe.newtonRahson(), exe.getIterations());
                       
    }
    
    
}


