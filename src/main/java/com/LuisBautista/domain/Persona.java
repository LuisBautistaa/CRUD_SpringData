/*
CLASE DE TIPO DOMINIO
Clase persona que contiene los atributos
que se compartiran con la vista
*/
package com.LuisBautista.domain;

import lombok.Data;

/**
 *
 * @author Luis Bautista
 */

//anotacion de loombok para agregar los getter y setteRS 
//y demas anotaciones
@Data
public class Persona {
    
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    
}
