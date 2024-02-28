<template>
    

    <div class="container">
        <h1 class="text-center"> Magasin2 </h1>
        <table class="table table-striped">
        <thead>
            <th> Magasin2 id</th>
            <th> Nom magasin2</th>
            <th> Adresse magasin2</th>
        </thead>
        <tbody>
            <tr v-for = "magasin in magasin2" v-bind:key = "magasin.id">
                <td> {{magasin.id}}</td>
                <td> {{magasin.nomMagasin2}}</td>
                <td> {{magasin.adresseMagasin2}}</td>
            </tr>
        </tbody>
    </table>

    </div>

</template>

<script>
import MagasinDeuxService from './services/MagasinDeuxService';

export default {
 
    name: 'MagasinDeux',
    data(){
        return {
            magasin2 : []
        }
       
    },
    methods:{
        getMagasin2(){
            MagasinDeuxService.getMagasin2().then((response) =>{
                this.magasin2 = response.data;

            });
            
        }
    },
    created() {
        this.getMagasin2()

    }

}
</script>

