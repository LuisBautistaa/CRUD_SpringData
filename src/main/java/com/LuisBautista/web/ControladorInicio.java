package com.LuisBautista.web;

import com.LuisBautista.domain.Persona;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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

    
    //para procesar la informacion de tipo get e indicar el path para la ruta de inicio 
    @GetMapping("/")      
    public String inicio(Model model){  
                        
        log.info("Ejecutando el Controlador Spring MVC"); 
        //model.addAttribute("personas", personas);
        return "index";
    }

}
