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
public class VeicExistException extends Exception{
    public void veicExistException() {
        JOptionPane.showMessageDialog(null,"Já existe um veículo com esta placa", "Erro", JOptionPane.ERROR_MESSAGE);
    }
}