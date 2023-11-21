package com.codingdojo.luis.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.luis.Modelos.Estado;
import com.codingdojo.luis.Modelos.Usuario;
import com.codingdojo.luis.Servicios.Servicios;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorUsuarios {
	@Autowired
    private Servicios servicio;

    @GetMapping("/")
    public String index(@ModelAttribute("nuevoUsuario") Usuario nuevoUsuario,
    					Model model) {
    	model.addAttribute("estados", Estado.Estados);
        return "index.jsp";
    }

 

    @PostMapping("/registro")
    public String registro(@Valid @ModelAttribute("nuevoUsuario") Usuario nuevoUsuario,
                           BindingResult result,
                           HttpSession session,
                           Model model) {

        servicio.registrar(nuevoUsuario, result);

        if(result.hasErrors()) {
        	model.addAttribute("estados", Estado.Estados);
            return "index.jsp";
        } else {
            session.setAttribute("usuarioEnSesion", nuevoUsuario);
            return "redirect:/dashboard";
        }

    }

    @PostMapping("/login") 
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        RedirectAttributes redirectAttributes, 
                        HttpSession session) {

        Usuario usuarioInicioSesion = servicio.login(email, password); //null o Obj(Usuario)

        if(usuarioInicioSesion == null) {
            //Tiene algo incorrecto
            //Flash me permite enviar errores de validación a un form normal
            redirectAttributes.addFlashAttribute("error_login", "El correo/password es incorrecto");
            return "redirect:/";
        } else {
            //Guardamos en sesión al usuario que quiere inicar sesión
            session.setAttribute("usuarioEnSesion", usuarioInicioSesion);
            return "redirect:/dashboard";
        }


    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("usuarioEnSesion");
        return "redirect:/";
    }
}
