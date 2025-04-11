
package com.example.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    // Mostrar formulario
    @GetMapping("/inicio")
    public String mostrarFormulario(@RequestParam(required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("mensajeError", "Usuario o contraseña incorrectos");
        }
        return "login";
    }

    // Procesar formulario
    @PostMapping("/inicio")
    public String procesarLogin(@RequestParam String usuario,
                                 @RequestParam String contrasena,
                                 Model model) {
        // Usuario "admin", contraseña "123"
        if ("admin".equals(usuario) && "123".equals(contrasena)) {
            model.addAttribute("usuario", usuario);
            return "home";
        } else {
            return "redirect:/inicio?error=true";
        }
    }
}
