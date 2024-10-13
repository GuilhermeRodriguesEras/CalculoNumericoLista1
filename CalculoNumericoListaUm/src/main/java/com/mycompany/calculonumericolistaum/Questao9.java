package com.mycompany.calculonumericolistaum;

public class Questao9 {
    
    private final double e;
    private int iterations;

    public Questao9(double e) {
        this.e = e;
        this.iterations = 0;
        if(this.e >= 0)
            throw new IllegalArgumentException("e value should be negative"); 
    }
    
    private double func(double x){
        return (-1/(Math.pow(x, 3))) + (-1/(Math.pow(x, 2))) - e;
    }
    
    private double derivadaFunc(double x){
        return (2*x + 3)/(Math.pow(x, 4));
    }
   
    public double bisseccao(){
        this.iterations = 0;
        double start = 1E-10, end = 100, mid = (start + end)/2;
       
        while(Math.abs(func(mid)) > Double.MIN_VALUE){
            mid = (start + end)/2;
            this.iterations++;
            if(func(start)*func(mid)<0)
                end = mid;
            else
                start = mid;
        }
        return mid;
    } 

    public double falsaPosicao(){
        this.iterations = 0;
        double a = 0.4, b = 10, raiz = 1;
        
        while(Math.abs(func(raiz)) > Double.MIN_VALUE){
            this.iterations++;
            raiz = b - ((func(b) * (b - a))/(func(b) - func(a)));
            
            if(func(a)*func(raiz)<0)
                b = raiz;
            else
                a = raiz;
        }
        
        return raiz;
    } 
    
    public double newtonRahson(){
        this.iterations = 0;
        double chute = 10E-5;
        
        while(Math.abs(func(chute)) > Double.MIN_VALUE){
            this.iterations++;
            chute -= func(chute)/derivadaFunc(chute);
        }
        return chute;
    }
    
   
    public int getIterations() {
        return iterations;
    }
    
}
