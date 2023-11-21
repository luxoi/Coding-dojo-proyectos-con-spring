package com.example.demo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.modelos.Contacto;
import com.example.demo.modelos.Dormitorio;
import com.example.demo.modelos.Estudiante;
import com.example.demo.servicios.Servicio;

import jakarta.validation.Valid;

@Controller
public class Maincontroller {
    @Autowired
    private Servicio service;

    @GetMapping("/")
    public String index(Model model) {
        List<Estudiante> listaDeEstudiantes = service.mostrarEst();
        model.addAttribute("estudiantes", listaDeEstudiantes);
        return "index.jsp";
    }

    @GetMapping("/new/estudiante")
    public String crearEstudiante(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        return "estudiante.jsp";
    }

    @PostMapping("/crear/estudiante")
    public String crearEstudiantes(@Valid Estudiante estudiante, BindingResult result) {
        service.saveEst(estudiante);
        return "redirect:/";
    }

    @GetMapping("/new/contacto")
    public String newContacto(Model model) {
        List<Estudiante> estudiantes = service.mostrarEst();
        model.addAttribute("estudiantes", estudiantes);
        model.addAttribute("contacto", new Contacto());
        return "contacto.jsp";
    }

    @PostMapping("/crear/contacto")
    public String crearContacto(@Valid Contacto contacto, BindingResult result) {
        service.saveCont(contacto);
        return "redirect:/";
    }

    @GetMapping("/dormitory/new")
    public String newDormitory(@ModelAttribute("dormitory") Dormitorio newDormitory) {
        return "new.jsp";
    }

    @PostMapping("/dormitory/create")
    public String createDormitory(@Valid Dormitorio newDormitory, BindingResult res) {
        if (res.hasErrors()) {
            return "new.jsp";
        } else {
            service.saveDorm(newDormitory);
            return "redirect:/dormitory/new";
        }
    }

    @GetMapping("/dormitory/{id}")
    public String dormDetails(@PathVariable("id") Long id, Model model) {
        List<Estudiante> studentList = service.findStudentWithoutDormitory();
        model.addAttribute("estudiante", studentList);

        Dormitorio dorm = service.findDorm(id);
        model.addAttribute("dormitory", dorm);
        return "details.jsp";
    }

    @PostMapping("/dormitory/{id}/add")
    public String addStudent(@RequestParam(value = "estudiante") Long sid, @PathVariable("id") Long did) {
        service.addStudentToDorm(did, sid);
        return "redirect:/dormitory/" + did;
    }

    @DeleteMapping("/dormitory/{id}/remove/{student}")
    public String removeStudent(@PathVariable(value = "estudiante") Long sid, @PathVariable("id") Long did) {
        service.deleteStudentFromDorm(sid);
        return "redirect:/dormitory/" + did;
    }
}