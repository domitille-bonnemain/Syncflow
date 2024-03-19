/*package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(path="/parametres")
@CrossOrigin("http://localhost:8081")
public class ParametresController {

    @Autowired
    private ParametresRepository ParametresRepository;

    // Endpoint pour ajouter une quantité commandée
    @PostMapping(path="/add")
    public String setQuantiteCommandee (@RequestBody SetQuantiteRequest request) {
        // Création d'un nouvel objet Parametres
        Parametres np = new Parametres();
        // Définition de la quantité commandée à partir de la requête
        np.setQuantiteCommandee(Integer.valueOf(request.getquantiteCommandee()));
        // Sauvegarde de l'objet Parametres dans le repository
        ParametresRepository.save(np);
        // Renvoi de "saved" comme confirmation
        return "saved";
    }

    // Endpoint pour ajouter des dates souhaitées et des dates butoir
    @PostMapping(path="/addDate")
    public String setDateSouhaitee (@RequestBody SetDateRequest request) {
        // Création d'un nouvel objet Parametres
        Parametres np = new Parametres();
        try {
            // Convertir les chaînes de date en objets Date
            np.setDateSouhaitee(stringToDate(request.getDateSouhaitee()));
            np.setDateButoir(stringToDate(request.getDateButoir()));
        } catch (ParseException e) {
            // Gérer les erreurs de conversion de date
            e.printStackTrace();
            return "error"; // En cas d'erreur, renvoyer une indication d'erreur
        }
        // Sauvegarde de l'objet Parametres dans le repository
        ParametresRepository.save(np);
        // Renvoi de "saved" comme confirmation
        return "saved";
    }

    // Méthode pour convertir une chaîne en objet Date
    private Date stringToDate(String dateString) throws ParseException {
        // Créer un formateur de date avec le format attendu
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        // Tenter de convertir la chaîne en objet Date
        return formatter.parse(dateString);
    }

    // Endpoint pour récupérer tous les paramètres
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Parametres> getAllParametres() {
        // Récupérer tous les Parametres du repository et les renvoyer
        return ParametresRepository.findAll();
    }
}*/



package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable; // Assurez-vous d'importer PathVariable
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping; // Import pour @PutMapping
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Optional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(path="/parametres")
@CrossOrigin("http://localhost:8081")
public class ParametresController {

    @Autowired
    private ParametresRepository ParametresRepository;

    // Endpoint pour ajouter une quantité commandée
    //@PostMapping(path="/add")
        // Endpoint pour ajouter une quantité commandée
        @PostMapping(path="/add")
        public String setQuantiteCommandee (@RequestBody SetQuantiteRequest request) {
            // Mettre ce code en commentaire pour éviter d'ajouter de nouvelles lignes dans la base de données
            /*
            // Création d'un nouvel objet Parametres
            Parametres np = new Parametres();
            // Définition de la quantité commandée à partir de la requête
            np.setQuantiteCommandee(Integer.valueOf(request.getquantiteCommandee()));
            // Sauvegarde de l'objet Parametres dans le repository
            ParametresRepository.save(np);
            */
            // Renvoi de "saved" comme confirmation
            return "saved";
        }
    
        // Endpoint pour ajouter des dates souhaitées et des dates butoir
        @PostMapping(path="/addDate")
        public String setDateSouhaitee (@RequestBody SetDateRequest request) {
            // Mettre ce code en commentaire pour éviter d'ajouter de nouvelles lignes dans la base de données
            /*
            // Création d'un nouvel objet Parametres
            Parametres np = new Parametres();
            try {
                // Convertir les chaînes de date en objets Date
                np.setDateSouhaitee(stringToDate(request.getDateSouhaitee()));
                np.setDateButoir(stringToDate(request.getDateButoir()));
            } catch (ParseException e) {
                // Gérer les erreurs de conversion de date
                e.printStackTrace();
                return "error"; // En cas d'erreur, renvoyer une indication d'erreur
            }
            // Sauvegarde de l'objet Parametres dans le repository
            ParametresRepository.save(np);
            */
            // Renvoi de "saved" comme confirmation
            return "saved";
        }
    

    // Méthode pour convertir une chaîne en objet Date
    private Date stringToDate(String dateString) throws ParseException {
        // Créer un formateur de date avec le format attendu
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        // Tenter de convertir la chaîne en objet Date
        return formatter.parse(dateString);
    }

   

// Endpoint pour récupérer tous les paramètres
@GetMapping(path="/all")
public @ResponseBody Iterable<Parametres> getAllParametres() {
    // Récupérer tous les Parametres du repository et les renvoyer
    return ParametresRepository.findAll();
}

// Endpoint pour mettre à jour la quantité commandée avec l'ID 854
@PutMapping(path="/add")
public String updateQuantiteCommandee(@RequestBody SetQuantiteRequest request) {
    Long idQuantiteCommandee = 854L; // ID pour la quantité commandée
    // Recherchez l'objet Parametres à mettre à jour dans la base de données en utilisant l'ID 854
    Optional<Parametres> existingQuantiteCommandeeOptional = ParametresRepository.findById(idQuantiteCommandee);
        
    if (existingQuantiteCommandeeOptional.isPresent()) {
        Parametres existingQuantiteCommandee = existingQuantiteCommandeeOptional.get();
        // Mettre à jour la quantité commandée avec la valeur de la requête
        existingQuantiteCommandee.setQuantiteCommandee(Integer.valueOf(request.getquantiteCommandee()));
        // Sauvegardez les modifications dans le repository
        ParametresRepository.save(existingQuantiteCommandee);
        return "updated"; // Renvoyer une confirmation de mise à jour réussie
    } else {
        return "error"; // Gérer le cas où l'objet n'est pas trouvé
    }
}

// Endpoint pour mettre à jour les dates souhaitées et les dates butoir avec l'ID 852
@PutMapping(path="/addDate")
public String updateDates(@RequestBody SetDateRequest request) {
    Long idDates = 852L; // ID pour les dates souhaitées et les dates butoir
    // Recherchez l'objet Parametres à mettre à jour dans la base de données en utilisant l'ID 852
    Optional<Parametres> existingDatesOptional = ParametresRepository.findById(idDates);
        
    if (existingDatesOptional.isPresent()) {
        Parametres existingDates = existingDatesOptional.get();
        try {
            // Convertir les chaînes de date en objets Date
            existingDates.setDateSouhaitee(stringToDate(request.getDateSouhaitee()));
            existingDates.setDateButoir(stringToDate(request.getDateButoir()));
        } catch (ParseException e) {
            // Gérer les erreurs de conversion de date
            e.printStackTrace();
            return "error"; // En cas d'erreur, renvoyer une indication d'erreur
        }
        // Sauvegarde de l'objet Parametres mis à jour dans le repository
        ParametresRepository.save(existingDates);
        // Renvoi de "updated" comme confirmation
        return "updated";
    } else {
        return "error"; // Gérer le cas où l'objet n'est pas trouvé
    }
}



}
