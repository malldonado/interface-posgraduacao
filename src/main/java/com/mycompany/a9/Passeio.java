/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.a9;

/**
 *
 * @author Matheus
 */
public final class Passeio extends Veiculo implements Calcular{
    
    private int qtdPassageiros;
    
    public Passeio() {
        this.qtdPassageiros = 0;
    }

    public void calcVel() {
        float x = (getVelocMax() * 1000);
        System.out.println("\nVelocidade - Passeio: " + x + " M/H");
    }
    
    public int calcular() {
        
        int somaLetras = 0;
        
        somaLetras += getPlaca().length();
        somaLetras += getMarca().length();
        somaLetras += getModelo().length();
        somaLetras += getCor().length();
        
        return somaLetras;
    }
    
    public int getQtdPassageiros() {
        return qtdPassageiros;
    }
    
    public void setQtdPassageiros(int qtdPassageiros) {
        this.qtdPassageiros = qtdPassageiros;
    }
    
}
