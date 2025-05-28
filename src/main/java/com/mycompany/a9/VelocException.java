/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.a9;

import javax.swing.JOptionPane;

/**
 *
 * @author Matheus
 */
public class VelocException extends Exception{
    public void velocException() {
        JOptionPane.showMessageDialog(null, "\"A velocidade\n" + "máxima está fora dos limites brasileiros");
    }
}
