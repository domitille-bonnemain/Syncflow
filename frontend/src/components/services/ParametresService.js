import axios from 'axios'

const PARAMETRES_API_BASE_URL = 'http://localhost:8080/parametres/add'

class ParametresService{
    setParametres(){

        
        return axios.set(PARAMETRES_API_BASE_URL);
    }
}

export default new ParametresService()