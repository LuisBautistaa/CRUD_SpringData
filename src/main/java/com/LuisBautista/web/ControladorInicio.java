package com.LuisBautista.web;

import com.LuisBautista.dao.IPersonaDao;
import com.LuisBautista.service.PersonaService;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

}
