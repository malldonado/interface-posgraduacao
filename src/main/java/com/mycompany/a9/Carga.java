/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.a9;

/**
 *
 * @author Matheus
 */
public final class Carga extends Veiculo implements Calcular {
    
    private int cargaMax;
    private int tara;
    
    public Carga() {
        this.cargaMax = 0;
        this.tara = 0;
    }

    
    public void calcVel() {
        float x = (getVelocMax() * 100000);
        System.out.println("\nVelocidade - Carga: " + x + " CM/H");
    }
    
    
    public int calcular() {
        
        int somaNum = 0;
        
        somaNum+= getMotor().getQtdPist();
        somaNum+= getMotor().getPotencia();
        somaNum+= getQtdRodas();
        somaNum+= getVelocMax();
        somaNum+= getTara();
        somaNum+= getCargaMax();
        
        return somaNum;
    }
    
    public int getCargaMax() {
        return cargaMax;
    }
    
    public void setCargaMax(int cargaMax) {
        this.cargaMax = cargaMax;
    }
    
    public int getTara() {
        return tara;
    }
    
    public void setTara(int tara) {
        this.tara = tara;
    }

}
