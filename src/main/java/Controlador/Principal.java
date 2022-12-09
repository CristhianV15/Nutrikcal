/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.Paciente;

/**
 *
 * @author crist
 */
public class Principal {
    public static void main(String[] args) {
        Paciente objetoPaciente= new Paciente();
        objetoPaciente.setVisible(true);
        //Prueba para verificar conexion
        //        Conexion objetoConexion= new Conexion();
        //        objetoConexion.establecerConexion();
    }
}
