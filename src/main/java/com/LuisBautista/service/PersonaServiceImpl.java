
package com.LuisBautista.service;

import com.LuisBautista.dao.IPersonaDao;
import com.LuisBautista.domain.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Luis Bautista
 */

// se implementa la interfaz de PersonaService
@Service
public class PersonaServiceImpl implements PersonaService{
    //agregar anotaciones transaccionales debido a que se puede
    //hacer uso de mas operaciones a la ves y eso puede traer error
    
    
    //Inyectar nuestra clase de tipo DAO
    //con esto ya el controlador ya no utulizara directamente 
    //la capa de personaDAO, si no que ya utilizara PersonaServiceImpl
    @Autowired
    private IPersonaDao personaDao;

    @Override
    @Transactional(readOnly = true) //solo trae info no modifica
    public List<Persona> listarPersonas() {
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    @Transactional
    public void eliminae(Persona persona) {
        personaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona persona) {
        return personaDao.findById(persona.getIdPersona()).orElse(null);
    }
    
}
