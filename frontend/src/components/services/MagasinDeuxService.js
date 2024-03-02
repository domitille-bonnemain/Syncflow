import axios from 'axios'

const MAGASIN2_API_BASE_URL ='http://localhost:8080/demo/all'

class Magasin2Service{
    getMagasin2(){
        
       
        return axios.get(MAGASIN2_API_BASE_URL);
    }
}

export default new Magasin2Service()
