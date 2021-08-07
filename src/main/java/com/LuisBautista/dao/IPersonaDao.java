
package com.LuisBautista.dao;

import com.LuisBautista.domain.Persona;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author LuisBautista
 */

//se crea nuestra clase de tipo interfaz para 
//crear nuestra clase de repositorio
public interface IPersonaDao extends CrudRepository<Persona, Long>{
    
}
