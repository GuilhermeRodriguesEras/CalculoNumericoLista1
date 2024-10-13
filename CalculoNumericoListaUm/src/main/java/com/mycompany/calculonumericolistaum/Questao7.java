package com.mycompany.calculonumericolistaum;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;

public class Questao7 extends JFrame{
    private int totalIterations;
    private final double maxIterations;
    private DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    
    public Questao7(double a){
        this.maxIterations = 1000;
        double resp = achaRaiz(a);
        JFreeChart chart = ChartFactory.createLineChart(
                "Grafico Variações de erro por Iterações", "Iteracoes",
                "Variação do Erro", dataset);
        System.out.printf("raiz de %.2f = %.2f, encontrado em %d iteracoes \n", 
                          a, resp, totalIterations);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        setContentPane(chartPanel);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private double func(double x, double a){
        return (Math.pow(x,3) + 3*a*x) / (3* Math.pow((x), 2) + a);
    }
    private double achaRaiz(double a){
        double erro, aux, chute = 1; 

        for(totalIterations = 0; totalIterations < this.maxIterations; 
             totalIterations++){
            aux = chute;
            chute = func(aux, a);  
            erro = Math.abs(aux - chute);
            
            if(Math.abs(aux - chute) < Double.MIN_VALUE){
                break;
            }
            
            this.dataset.addValue((Number)erro, "Variacao da aproximiacao", 
                                  totalIterations);
        }       
        return chute;
    }   
}
