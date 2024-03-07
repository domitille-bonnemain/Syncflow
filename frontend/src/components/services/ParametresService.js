import axios from 'axios'

const PARAMETRES_API_BASE_URL = 'http://localhost:8080/parametres/all'

class ParametresService{
    getParametres(){

        
        return axios.get(PARAMETRES_API_BASE_URL);
    }
}

export default new ParametresService()