/*
CLASE DE TIPO DOMINIO
Clase persona que contiene los atributos
que se compartiran con la vista
*/
package com.LuisBautista.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 *
 * @author Luis Bautista
 */

//anotacion de loombok para agregar los getter y setteRS 
//y demas anotaciones
//converntir la clase a una de ENTIDAD poniendo Entity
@Data
@Entity
@Table(name = "persona")
public class Persona implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPersona;
    
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String apellido;
    @NotEmpty
    @Email
    private String email;
    private String telefono;
    
}
