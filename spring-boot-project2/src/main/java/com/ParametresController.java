package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/parametres")
@CrossOrigin("http://localhost:8081")
public class ParametresController {

    @Autowired
    private ParametresRepository parametresRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewParametres (
        @RequestParam Integer quantiteCommande
    ) {
        Parametres nouveauParametres = new Parametres();
        nouveauParametres.setQuantiteCommande(quantiteCommande);
        parametresRepository.save(nouveauParametres);
        return "saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Parametres> getAllParametres() {
        return parametresRepository.findAll();
    }
}
