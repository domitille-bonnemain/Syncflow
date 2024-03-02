import axios from 'axios'

const PRODUITS_API_BASE_URL = 'http://localhost:8080/produits/all'

class ProduitsService{
    getProduits(){

        
        return axios.get(PRODUITS_API_BASE_URL);
    }
}

export default new ProduitsService()
