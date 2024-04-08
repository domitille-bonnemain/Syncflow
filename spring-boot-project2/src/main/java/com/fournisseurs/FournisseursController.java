package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.Fournisseurs;
import com.FournisseursRepository;

@Controller
@RequestMapping(path="/fournisseurs") // Chemin pour correspondre aux fournisseurs
@CrossOrigin("http://localhost:8081")
public class FournisseursController {

    @Autowired
    private FournisseursRepository fournisseursRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewFournisseur(
            @RequestParam String nomFournisseurs,
            @RequestParam String adresseFournisseurs) {
        Fournisseurs nouveauFournisseur = new Fournisseurs();
        nouveauFournisseur.setNomFournisseurs(nomFournisseurs);
        nouveauFournisseur.setAdresseFournisseurs(adresseFournisseurs);
        fournisseursRepository.save(nouveauFournisseur);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Fournisseurs> getAllFournisseurs() {
        return fournisseursRepository.findAll();
    }
}
