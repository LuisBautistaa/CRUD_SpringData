package com.LuisBautista.web;

import com.LuisBautista.dao.IPersonaDao;
import com.LuisBautista.domain.Persona;
import com.LuisBautista.service.PersonaService;
import java.util.HashMap;
import java.util.List;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
/**
 *
 * @author Luis Bautista
 * Clase que contiene un controlador, para desplegar inffo al navegador
 * asi como el servidor enviando informacion con el log.
 */
@Controller
@Slf4j //para tener acceso a la variable log
public class ControladorInicio {

    //inyectar nuestro interfaz aca en el controlador
    //se pone autowired paara inyectar y poder tener acceso a los datos del DAO
    @Autowired
    private PersonaService personaService;
    
    //para procesar la informacion de tipo get e indicar el path para la ruta de inicio 
    @GetMapping("/")      
    public String inicio(Model model){  
        //acceder  a los metodos del DAO
        var personas = personaService.listarPersonas();
        log.info("Ejecutando el Controlador Spring MVC"); 
        model.addAttribute("personas", personas);
        return "index";
    }
    
    @GetMapping("/jsonData")
    public String jsonUsers(Persona persona){
        String msj ="Hola aca se visualizara la data en formato json";
        return "jsonView";
    }
    
    @GetMapping("/agregar")
    public String agregar(Persona persona){
        //retorna la vista de modificar y en el parametro se inyecta una persona
        return "modificar";
    }
    
    //metodo de tipo post que recuperara la info del form de insert 
    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores){
        if(errores.hasErrors()){
            return "modificar";
        }
        personaService.guardar(persona);
        return "redirect:/";
    }
    
    //metodo para modificar persona con el atributo del idPersona
    //y con el parametro persona ya asocia el id con la persona inyectada
    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model){
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona",persona);
        return "modificar";
    }
    
    //metodo que elimina un registro cuando se le da al link de la fila
    @GetMapping("/eliminar")
    public String eliminar(Persona persona){
        personaService.eliminae(persona);
        return "redirect:/";
    }

}
