/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Portafolio_MariaFernanda.Portafolio.controller;

import Portafolio_MariaFernanda.Portafolio.service.ProductoService;
import java.math.BigDecimal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/consultas")
public class ConsultaController {

    private final ProductoService productoService;

    public ConsultaController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/listado")
    public String listado(Model model) {
        var productos = productoService.getProductos(false);
        model.addAttribute("productos", productos);
        return "/consultas/listado";
    }

    @PostMapping("/consultaDerivada")
    public String consultaDerivada(@RequestParam BigDecimal precioInf,
                                   @RequestParam BigDecimal precioSup,
                                   Model model) {
        var productos = productoService.consultaDerivada(precioInf, precioSup);
        model.addAttribute("productos", productos);
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        return "/consultas/listado";
    }

    // consultaJPQL y consultaSQL: igual, cambiando la ruta y el método del servicio
    @PostMapping("/consultaJPQL")
    public String consultaJPQL(@RequestParam BigDecimal precioInf,
                               @RequestParam BigDecimal precioSup,
                               Model model) {
        var productos = productoService.consultaJPQL(precioInf, precioSup);
        model.addAttribute("productos", productos);
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        return "/consultas/listado";
    }

    @PostMapping("/consultaSQL")
    public String consultaSQL(@RequestParam BigDecimal precioInf,
                              @RequestParam BigDecimal precioSup,
                              Model model) {
        var productos = productoService.consultaSQL(precioInf, precioSup);
        model.addAttribute("productos", productos);
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        return "/consultas/listado";
    }
    
    //Tarea 2
    @PostMapping("/consultaPractica2")
    public String consultaPractica2(@RequestParam String palabra,
            @RequestParam Integer existenciasMin,
            Model model) {
        var productos = productoService.consultaPractica2(palabra, existenciasMin);
        model.addAttribute("productos", productos);
        model.addAttribute("palabra", palabra);
        model.addAttribute("existenciasMin", existenciasMin);
        return "/consultas/listado";
    }
}
