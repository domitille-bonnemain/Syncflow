<template>
    <div class="container">
        <div class="row">
            <div class="col-md-3">
           <!-- <div class="title-left">Destination</div>-->
            </div>
            <div class="col-md-3 magasin-container">
                <div class="magasin-left">Magasin</div>
                <div class="dropdown-content">
                    <select v-model="selectedMagasin" @change="selectMagasin" class="form-control">
                        <option value="" disabled>Sélectionner un magasin<span class="dropdown-arrow">&#9660;</span></option>
                        <option v-for="magasin in magasin2" :key="magasin.id" :value="magasin.id">
                            {{ magasin.nomMagasin2 }}
                        </option>
                    </select>
                </div>
            </div>
            <div class="col-md-3">
               <!-- <div class="adresse-left">Adresse magasin</div>-->
            </div>
            <div class="col-md-3">
                <div class="adresse-box">{{ selectedMagasinDetails.adresseMagasin2 || '-' }}</div>
            </div>
        </div>
    </div>
</template>

<script>
import MagasinDeuxService from './services/MagasinDeuxService';

export default {
    name: 'MagasinDeux',
    data() {
        return {
            magasin2: [],
            selectedMagasin: '', // Variable pour stocker le magasin sélectionné dans le menu déroulant
            selectedMagasinDetails: {}, // Détails du magasin sélectionné
        };
    },
    methods: {
        getMagasin2() {
            MagasinDeuxService.getMagasin2().then(response => {
                this.magasin2 = response.data;
            });
        },
        selectMagasin() {
            // Trouver les détails du magasin sélectionné
            this.selectedMagasinDetails = this.magasin2.find(magasin => magasin.id === this.selectedMagasin) || {};
        },
    },
    created() {
        this.getMagasin2();
    },
};
</script>

<style scoped>
/* Style du conteneur principal */
.container {
   /* margin: 0 auto;  Centre le conteneur horizontalement */
    max-width: 1200px; /* Définir la largeur maximale du conteneur */
    padding-left:0px; /* Marge à gauche (ajustez selon vos besoins) */
    padding-right: 20px; /* Marge à droite (ajustez selon vos besoins) */
}

/* Style pour les titres */
.title-left, .magasin-left, .adresse-left {
    font-weight: bold;
    margin-bottom: 6px;
}

/* Style pour les conteneurs flexibles */
.dropdown-content, .magasin-container, .adresse-container {
    display: flex; /* Utilisation de flexbox */
    align-items: center; /* Centrage vertical des éléments */
    margin-bottom: 6px; /* Marge en bas de chaque conteneur */
}

/* Style pour le mot "Magasin" à gauche du dropdown */
.magasin-left {
    margin-right: 10px; /* Ajuste la marge entre le mot "Magasin" et le dropdown */
}

/* Style pour le dropdown */
.dropdown-content select {
    width: 100%; /* Largeur du select à 100% */
    padding: 3px;
    border: 1px solid #ccc;
    border-radius: 3px;
    background-color: #f2f2f2;
}

/* Style pour la flèche du dropdown */
.dropdown-arrow {
    position: absolute;
    top: 50%;
    right: 3px;
    transform: translateY(-50%);
    cursor: pointer;
}

/* Style pour le mot "Adresse magasin" */
.adresse-left {
    margin-right: -140px; /* Ajuste la marge entre "Adresse magasin" et le champ affichant l'adresse */
}

/* Style pour le champ d'affichage de l'adresse */
.adresse-box {
    padding: 3px;
    border: 1px solid #ccc;
    border-radius: 3px;
    background-color: #f2f2f2;
    margin-bottom: 6px;
}

/* Style pour les colonnes */
.col-md-3 {
    padding-right: 3px;
    padding-left: 3px;
    margin-bottom: 3px;
}

/* Ajustement manuel pour réduire l'espace entre "Destination" et "Magasin" */
.magasin-container {
    display: flex;
    align-items: left;
    margin-bottom: 0px;
}
</style>

