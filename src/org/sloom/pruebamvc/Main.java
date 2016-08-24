/*
 * Copyright (C) 2016 Antonio Martínez Palao <martinezpalao@hotmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.sloom.pruebamvc;

//import org.sloom.pruebamvc.controlador.Controlador;
import org.sloom.pruebamvc.controlador.ControladorMonolito;
import org.sloom.pruebamvc.modelo.Modelo;
import org.sloom.pruebamvc.vista.VistaPrincipal;

/**
 *
 * @author Antonio Martínez Palao <martinezpalao@hotmail.com>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Modelo modelo;
        VistaPrincipal vistaPrincipal;
        ControladorMonolito controlador;
        
        // Crea los tres objetos del patrón MVC
        modelo = new Modelo("<nombre no válido>");
        vistaPrincipal = new VistaPrincipal();
        controlador = new ControladorMonolito(modelo, vistaPrincipal);
        
        // Quita el foco de los botones y hace visible la ventana
        vistaPrincipal.getContentPane().requestFocusInWindow();
        vistaPrincipal.setLocationRelativeTo(null);
        vistaPrincipal.setVisible(true);
                      
        // Esto hay que investigar y solucionarlo
//        java.awt.EventQueue.invokeLater(new Runnable() {                        
//            public void run() {
//                new VistaPrincipal().setVisible(true);
//            }
//        });
    }
    
}
