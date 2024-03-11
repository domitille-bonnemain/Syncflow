package com;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//import java.util.Date;

@Controller
@RequestMapping(path="/parametres")
@CrossOrigin("http://localhost:8081")
public class ParametresController {

    @Autowired
    private ParametresRepository ParametresRepository;

    
    
    
    @PostMapping(path="/add")
    public @ResponseBody String addNewParametres (@RequestParam Integer quantiteCommandee)
   // @DateTimeFormat(pattern="yyyy-MM-dd") Date dateSouhaitee,
   // @RequestParam 
   // @DateTimeFormat(pattern="yyyy-MM-dd") Date dateButoir,
        
     {
        Parametres np = new Parametres();
      //  np.setDateSouhaitee(dateSouhaitee);
       // np.setDateButoir(dateButoir);
        np.setQuantiteCommandee(quantiteCommandee);
        ParametresRepository.save(np);
        return "saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Parametres> getAllParametres() {
        return ParametresRepository.findAll();
    }
}

