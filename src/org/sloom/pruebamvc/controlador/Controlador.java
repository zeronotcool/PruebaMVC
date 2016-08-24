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
package org.sloom.pruebamvc.controlador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.sloom.pruebamvc.modelo.Modelo;
import org.sloom.pruebamvc.vista.DialogoNombre;
import org.sloom.pruebamvc.vista.VistaPrincipal;

/**
 *
 * @author Antonio Martínez Palao <martinezpalao@hotmail.com>
 */
public class Controlador implements ActionListener {

    private Modelo modelo;
    private VistaPrincipal vistaPrincipal;
    private DialogoNombre dialogoNombre;

    /**
     *
     * @param modelo
     * @param vistaPrincipal
     */
    public Controlador(Modelo modelo, VistaPrincipal vistaPrincipal) {
        this.modelo = modelo;
        this.vistaPrincipal = vistaPrincipal;
        vistaPrincipal.setupListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        // Obtiene el atributo "name" del componente
        Component o = (Component) actionEvent.getSource();
        String name = o.getName();

        // Controla la acción de los botones de la ventana principal
        if (name.equals("btnSalir")) {
            vistaPrincipal.dispose();
        } else if (name.equals("btnAsignar")) {
            // Muestra el diálogo asignar
            DialogoNombre dialogoNombre = new DialogoNombre(vistaPrincipal, true);
            dialogoNombre.setupListener(new DialogoNombreActionListener(modelo, dialogoNombre, vistaPrincipal) );
            dialogoNombre.setLocationRelativeTo(vistaPrincipal);
            dialogoNombre.setVisible(true);
        }

    }

}

class DialogoNombreActionListener implements ActionListener {
    
    Modelo modelo;
    DialogoNombre vista;
    VistaPrincipal vistaPrincipal;
    

    public DialogoNombreActionListener(Modelo modelo, DialogoNombre vista, VistaPrincipal vistaPrincipal) {
        this.modelo = modelo;
        this.vista = vista;
        this.vistaPrincipal = vistaPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        // Obtiene el atributo "name" del componente
        Component o = (Component) actionEvent.getSource();
        String name = o.getName();

        // Controla la acción de los botones de la ventana principal
        if (name.equals("btnCancel")) {
            vista.dispose();
        } else if(name.equals("btnOK")){            
            modelo.setNombre(vista.getNombre()); // actualiza el modelo            
            vistaPrincipal.setLabel(modelo.getNombre()); // actualiza la vista principal
            vista.dispose();
        }
    }
}
