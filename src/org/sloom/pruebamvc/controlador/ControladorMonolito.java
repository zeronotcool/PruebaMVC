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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import org.sloom.pruebamvc.modelo.Modelo;
import org.sloom.pruebamvc.vista.DialogoNombre;
import org.sloom.pruebamvc.vista.VistaPrincipal;

/**
 *
 * @author Antonio Martínez Palao <martinezpalao@hotmail.com>
 */
public class ControladorMonolito implements ActionListener, KeyListener {

    private Modelo modelo;
    private VistaPrincipal vistaPrincipal;
    private DialogoNombre dialogoNombre;

    public ControladorMonolito(Modelo modelo, VistaPrincipal vistaPrincipal) {
        this.modelo = modelo;
        this.vistaPrincipal = vistaPrincipal;
        vistaPrincipal.setupListener(this); // controla los listener de la vista
        vistaPrincipal.setupKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent action) {

        // Obtiene el atributo "name" del componente que se ha tocado
        Component o = (Component) action.getSource();
        String name = o.getName();

        // Controla la acción de los botones de la ventana principal
        if (name.equals("btnSalir")) {
            vistaPrincipal.dispose();
        } else if (name.equals("btnAsignar")) {
            // Muestra el diálogo
            dialogoNombre = new DialogoNombre(vistaPrincipal, true);
            dialogoNombre.setupListener(this);
            dialogoNombre.setupKeyListener(this);
            dialogoNombre.setLocationRelativeTo(vistaPrincipal);
            dialogoNombre.setVisible(true);
        } else if (name.equals("btnCancel")) {
            dialogoNombre.dispose();
        } else if (name.equals("btnOK") || name.equals("txtNombre")) {
            modelo.setNombre(dialogoNombre.getNombre());
            dialogoNombre.dispose();
            vistaPrincipal.setLabel(modelo.getNombre());
        }

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        // Obtiene el atributo "name" del componente que se ha tocado
        Component o = (Component) keyEvent.getSource();
        String name = o.getName();

        if (name.equals("btnSalir")) {
            vistaPrincipal.dispose();
        } else if (name.equals("btnAsignar")) {
            // Muestra el diálogo
            dialogoNombre = new DialogoNombre(vistaPrincipal, true);
            dialogoNombre.setupListener(this);
            dialogoNombre.setupKeyListener(this);
            dialogoNombre.setLocationRelativeTo(vistaPrincipal);
            dialogoNombre.setVisible(true);
        } else if (name.equals("btnCancel")) {
            dialogoNombre.dispose();
        } else if (name.equals("btnOK")) {
            modelo.setNombre(dialogoNombre.getNombre());
            dialogoNombre.dispose();
            vistaPrincipal.setLabel(modelo.getNombre());
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
