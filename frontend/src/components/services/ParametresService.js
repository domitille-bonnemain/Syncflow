import axios from 'axios'

const PARAMETRES_API_BASE_URL = 'http://localhost:8080/parametres/add'

class ParametresService{
    setParametres(parametres){

        
        return axios.post(PARAMETRES_API_BASE_URL,parametres);
    }
}

export default new ParametresService();