package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/produits") // Changement du chemin pour correspondre aux produits
@CrossOrigin("http://localhost:8081")
public class ProduitsController {

    @Autowired
    private ProduitsRepository produitsRepository;

    // Commenter temporairement cette partie car la classe FournisseursRepository n'existe pas encore
    /*
    @Autowired
    private FournisseursRepository fournisseursRepository;
    */

    @PostMapping(path="/add")
    public @ResponseBody String addNewProduit (@RequestParam String nomProduit,
                                               @RequestParam Integer idFournisseur,
                                               @RequestParam Integer quantiteProduit) {
        Produits nouveauProduit = new Produits();
        nouveauProduit.setNomProduit(nomProduit);

        // Récupération du fournisseur par ID
        // Commenter temporairement cette partie car la classe FournisseursRepository n'existe pas encore
        /*
        Fournisseurs fournisseur = fournisseursRepository.findById(idFournisseur).orElse(null);
        if (fournisseur != null) {
            nouveauProduit.setFournisseur(fournisseur);
            nouveauProduit.setQuantiteProduit(quantiteProduit);
            produitsRepository.save(nouveauProduit);
            return "Produit ajouté avec succès";
        } else {
            return "Fournisseur non trouvé";
        }
        */
        return "Fonctionnalité non implémentée";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Produits> getAllProduits() {
        return produitsRepository.findAll();
    }

    @PutMapping(path="/update/{id}")
    public @ResponseBody String updateProduit(@RequestBody Produits produit) {
        // Vérifiez si le produit existe
        if (produitsRepository.existsById(produit.getId())) {
            produitsRepository.save(produit);
            return "Produit mis à jour avec succès";
        } else {
            return "Produit non trouvé";
        }
    }

    @DeleteMapping(path="/delete/{id}")
    public @ResponseBody String deleteProduit(@RequestParam Integer id) {
        // Vérifiez si le produit existe
        if (produitsRepository.existsById(id)) {
            produitsRepository.deleteById(id);
            return "Produit supprimé avec succès";
        } else {
            return "Produit non trouvé";
        }
    }
}
