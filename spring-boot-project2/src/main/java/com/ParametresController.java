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
    public @ResponseBody Integer addNewParametres (
        @RequestParam Integer dateSouhaitee,
        @RequestParam Integer dateButoir,
        @RequestParam Integer quantiteCommande
    ) {
        Parametres nouveauParametres = new Parametres();
        nouveauParametres.setDateSouhaitee(dateSouhaitee);
        nouveauParametres.setDateButoir(dateButoir);
        nouveauParametres.setQuantiteCommande(quantiteCommande);
        parametresRepository.save(nouveauParametres);
        return 1;
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Parametres> getAllParametres() {
        return parametresRepository.findAll();
    }
}

