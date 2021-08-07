
package com.LuisBautista.service;

import com.LuisBautista.domain.Persona;
import java.util.List;

/**
 *
 * @author Luis Bautista
 */

//Capa de servicio que contiene una interfaz y se implementa en PersonaServiceImpl
public interface PersonaService {
    //contiene todo los metodos que vamos a emplear en nustra clase
    
    //lista de tipo persona
    public List<Persona> listarPersonas();
    
    //metodos que reciben un objeto de tipo persona
    public void guardar(Persona persona);
    
    public void eliminae(Persona persona);
    
    public Persona encontrarPersona(Persona persona);
}
