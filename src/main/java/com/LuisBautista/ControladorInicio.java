package com.LuisBautista;

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
    
    //para acceder valores dentro del application.properties hacemos lo sig.
    @Value("${index.saludo}")
    private String saludo;//aca se inyecta el valor de los properties
    
    //para procesar la informacion de tipo get e indicar el path para la ruta de inicio 
    @GetMapping("/")      
    public String inicio(Model model){  
        //para enviar info a la vista se hace uso de model para enviar el atributo
        var mensaje = "Enviando info a la vista con Model y Thymeleaf";
        
        var persona = new Persona();//se agrega constructor para acceder a los metodos
        persona.setNombre("clase");
        persona.setApellido("de tipo dominio");
        persona.setEmail("clase@dominio.com");
        persona.setTelefono("12324");
        
        var persona2 = new Persona();//se agrega constructor para acceder a los metodos
        persona2.setNombre("Alfredo");
        persona2.setApellido("diaZ");
        persona2.setEmail("ADiaz@dominio.com");
        persona2.setTelefono("6428734");
        
        //se crea un array lis para al macenar los objetos
//        List<Persona> personas = new ArrayList();
//        personas.add(persona);
//        personas.add(persona2);
        //otra forma mas simplificada es con Arrays.asList
        var personas = Arrays.asList(persona, persona2);
        //var personas = Arrays.asList();
        
        log.info("Ejecutando el Controlador Spring MVC"); 
        //se agrega el atributo a model de clave valor para que lo pueda usar la vista
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("saludo", saludo);
        
        //model.addAttribute("persona", persona);
        model.addAttribute("personas", personas);
        return "index";
    }

}
