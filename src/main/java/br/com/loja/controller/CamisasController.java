/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loja.controller;

import br.com.loja.model.Camisas;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import br.com.loja.repository.CamisasRepository;

/**
 *
 * @author breno
 */
@Controller
public class CamisasController {

    @Autowired
    private CamisasRepository camisasRepository;

    @GetMapping("/gerenciarCamisas")
    public String listarCamisas(Model model) {
        model.addAttribute("listarCamisas", camisasRepository.findAll());
        return "gerenciar_camisas";
    }

    @GetMapping("/novoCamisas")
    public String novoCamisas(Model model) {
        model.addAttribute("camisas", new Camisas());
        return "editar_camisas";
    }

    @GetMapping("/editarCamisas/{id}")
    public String editarCamisas(@PathVariable("id") long idCamisas, Model model) {
        Optional<Camisas> camisas = camisasRepository.findById(idCamisas);
        model.addAttribute("camisas", camisas.get());
        return "editar_camisas";
    }

    @PostMapping("/salvarCamisas")
    public String salvarCamisas(Camisas camisas, BindingResult result) {
        if (result.hasErrors()) {
            return "editar_camisas";
        }
        camisasRepository.save(camisas);
        return "redirect:/gerenciarCamisas";
    }

    @GetMapping("/excluirCamisas/{id}")
    public String excluirCamisas(@PathVariable("id") long idCamisas) {
        camisasRepository.deleteById(idCamisas);
        return "redirect:/gerenciarCamisas";
    }
}