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
@RequestMapping(path="/parametres") // Chemin pour correspondre aux parametres
@CrossOrigin("http://localhost:8081")
public class ParametresController {

    @Autowired
    private ParametresRepository parametresRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
public @ResponseBody String addNewParametres (
      @RequestParam Integer dateSouhaitee,
      @RequestParam Integer dateButoir,
      @RequestParam Integer quantiteCommande,
      @RequestParam Integer magasinId,
      @RequestParam Integer quantiteProduit) { // Ajout du paramètre pour la quantité de produit
    Parametres nouveauParametres = new Parametres();
    nouveauParametres.setDateSouhaitee(dateSouhaitee);
    nouveauParametres.setDateButoir(dateButoir);
    nouveauParametres.setQuantiteCommande(quantiteCommande);
    parametresRepository.save(nouveauParametres);
    return "saved";
}


    @GetMapping(path="/all")
    public @ResponseBody Iterable<Parametres> getAllParametres() {
        return parametresRepository.findAll();
    }
}
