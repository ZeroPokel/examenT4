package com.mafv.springprojects.exament4.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mafv.springprojects.exament4.model.Grupo;
import com.mafv.springprojects.exament4.model.Usuario;
import com.mafv.springprojects.exament4.services.GruposService;
import com.mafv.springprojects.exament4.services.UsuariosService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuariosService usuariosService;

    @Autowired
    GruposService gruposService;


    @GetMapping(value = "/list")
    public ModelAndView list(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        Iterable<Usuario> usuarios = usuariosService.findAll();

        modelAndView.addObject("usuarios", usuarios);
        modelAndView.setViewName("usuarios/list");
        return modelAndView;
    }


    @GetMapping(value = "/create")
    public ModelAndView create(Usuario usuario) {

        ModelAndView modelAndView = new ModelAndView();

        Iterable<Grupo> grupos = gruposService.findAll();
        modelAndView.addObject("usuario", new Usuario());
        modelAndView.addObject("grupos", grupos);
        modelAndView.setViewName("usuarios/create");

        return modelAndView;
    }

    @PostMapping(path = "/save")
    public ModelAndView save(Usuario usuario, @RequestParam("opcion") int optionValue) throws IOException{

        Grupo grupo = gruposService.findByID(optionValue);
        List<Usuario> usuarios = new ArrayList<Usuario>();
        usuarios.add(usuario);
        grupo.setUsuario(usuarios);
        gruposService.update(grupo);
        usuario.setGrupo(grupo);
        usuariosService.insert(usuario);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + usuario.getCodigo());

        return modelAndView;
    }

    @GetMapping(path = { "/edit/{codigo}" })
    public ModelAndView edit(
            @PathVariable(name = "codigo", required = true) int codigo) {

        Usuario usuario = usuariosService.findByID(codigo);

        Iterable<Grupo> grupos = gruposService.findAll();
                
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("usuario", usuario);
        modelAndView.addObject("grupos", grupos);
        modelAndView.setViewName("usuarios/edit");
        return modelAndView;
    }

    @PostMapping(path = { "/update" })
    public ModelAndView update(Usuario usuario) {

        usuariosService.update(usuario);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + usuario.getCodigo());
        
        return modelAndView;
    }

    @GetMapping(path = { "/delete/{codigo}" })
    public ModelAndView delete(
            @PathVariable(name = "codigo", required = true) int codigo) {

        usuariosService.delete(codigo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/usuarios/list");

        return modelAndView;
    }
    
}
