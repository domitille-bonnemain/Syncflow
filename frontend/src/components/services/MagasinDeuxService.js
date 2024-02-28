import axios from 'axios'
// eslint-disable-next-line no-unused-vars
const MAGASIN2_API_BASE_URL ='http://localhost:8080/demo/all'

class Magasin2Service{
    getMagasin2(){
        // eslint-disable-next-line no-undef
       
        return axios.get(MAGASIN2_API_BASE_URL);
    }
}

export default new Magasin2Service()
