/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.a9;

/**
 *
 * @author Matheus
 */
public abstract class Veiculo {
    
    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private float velocMax;
    private int qtdRodas;
    private Motor motor;
    
    public Veiculo() {
        this.placa = " ";
        this.marca = " ";
        this.modelo = " ";
        this.cor = " ";
        this.velocMax = 0;
        this.qtdRodas = 0;
        motor = new Motor();
    }
    
    public Veiculo(String placa, String marca, String modelo, String cor, float velocMax, int qtdRodas) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.velocMax = velocMax;
        this.qtdRodas = qtdRodas;
        motor = new Motor();
    }
    
    public Veiculo(String placa, String marca, String modelo, String cor, float velocMax, int qtdRodas, int qtdPist, int potencia) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.velocMax = velocMax;
        this.qtdRodas = qtdRodas;
        this.motor = new Motor(qtdPist, potencia);
    }
    
    public String getPlaca() {
        return this.placa;
    }
    
    public String getMarca() {
        return this.marca;
    }
    
    public String getModelo() {
        return this.modelo;
    }
    
    public String getCor() {
        return this.cor;
    }
    
    public float getVelocMax() {
        return this.velocMax;
    }
    
    public int getQtdRodas() {
        return this.qtdRodas;
    }
    
    public Motor getMotor() {
        return this.motor;
    }
    
    public final void setPlaca(String placa) {
        this.placa = placa;
    }
    
    public final void setMarca(String marca) {
        this.marca = marca;
    }
    
    public final void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public final void setCor(String cor) {
        this.cor = cor;
    }
    
    public final void setVelocMax(float velocMax) throws VelocException {
        if(velocMax < 80 || velocMax > 110) {
            throw new VelocException();
        } else {
          this.velocMax = velocMax;   
        }
    }
    
    public final void setQtdRodas(int qtdRodas) {
        this.qtdRodas = qtdRodas;
    }
    
    public abstract void calcVel();
    
}
