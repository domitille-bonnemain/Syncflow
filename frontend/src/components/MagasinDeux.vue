<template>
    <div class="container">
        <!-- Section pour les magasins -->
        <div class="row">
            <div class="col-md-3 magasin-container">
                
                <div class="magasin-left"><label for = "Magasin">Magasin</label></div>
            </div>
            <div class="col-md-3 dropdown-container">
                <div class="dropdown-content" :class="{ 'open': isDropdownOpen }">
                    <select v-model="selectedMagasin" @change="selectMagasin" class="form-control">
                        <option value="" disabled>Sélectionner un magasin<span class="dropdown-arrow" :class="{ 'up': selectedMagasin, 'down': !selectedMagasin }" @click="toggleDropdown">&#9660;</span></option>
                        <option v-for="magasin in magasin2" :key="magasin.id" :value="magasin.id">
                            {{ magasin.nomMagasin2 }}
                        </option>
                    </select>
                </div>
            </div>
            <div class="col-md-3 adresse-container">
                <div class="adresse-box">{{ selectedMagasinDetails.adresseMagasin2 || '-' }}</div>
            </div>
        </div>

        <!-- Espace entre les sections -->
        <div style="height: 10px;"></div>

        <!-- Section pour les produits -->
        <div class="row">
            <div class="col-md-3 produit-container">
                <div class="produit-left"><label for = "Produit"> Produit</label></div>
            </div>
            <div class="col-md-3 dropdown-container">
                <div class="dropdown-content" :class="{ 'open': isProduitDropdownOpen }">
                    <select v-model="selectedProduit" @change="selectProduit" class="form-control">
                        <option value="" disabled>Sélectionner un produit<span class="dropdown-arrow" :class="{ 'up': selectedProduit, 'down': !selectedProduit }" @click="toggleProduitDropdown">&#9660;</span></option>
                        <option v-for="produit in produits" :key="produit.id" :value="produit.id">
                            {{ produit.nomProduits }}
                        </option>
                    </select>
                </div>
            </div>
            <div class="col-md-3 quantiteSelected-container">
                <input type="text" v-model="quantiteProduitSelected" @keyup.enter="saveQuantiteCommande" class="form-control">

            </div>
        </div>
    </div>
</template>

<script>
import axios from 'axios';
import MagasinDeuxService from './services/MagasinDeuxService';
import ProduitsService from './services/ProduitsService';
import ParametresService from './services/ParametresService';

export default {
    name: 'MagasinDeux',
    data() {
        return {
            magasin2: [],
            selectedMagasin: '', // Variable pour stocker le magasin sélectionné dans le menu déroulant
            selectedMagasinDetails: {}, // Détails du magasin sélectionné
            isDropdownOpen: false, // Variable pour suivre l'état du dropdown
            produits: [],
            selectedProduit: '', // Variable pour stocker le produit sélectionné dans le menu déroulant
            selectedProduitDetails: {}, // Détails du produit sélectionné
            isProduitDropdownOpen: false, // Variable pour suivre l'état du dropdown des produits
            quantiteProduitSelected: 0, // Ajout de la propriété pour la quantité de produit sélectionné
            quantiteCommande: '' // Ajout de la propriété pour la quantité de commande
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
            this.isDropdownOpen = false; // Fermer le dropdown après la sélection
        },
        toggleDropdown() {
            this.isDropdownOpen = !this.isDropdownOpen;
        },
        getProduits() {
            ProduitsService.getProduits().then(response => {
                this.produits = response.data;
            }).catch(error => {
                console.error('Error fetching products:', error);
            });
        },
        selectProduit() {
            // Trouver les détails du produit sélectionné
            this.selectedProduitDetails = this.produits.find(produit => produit.id === this.selectedProduit) || {};
            this.isProduitDropdownOpen = false; // Fermer le dropdown après la sélection
        },
        toggleProduitDropdown() {
            this.isProduitDropdownOpen = !this.isProduitDropdownOpen;
        },
        saveQuantiteCommande() {
            // Récupérer la quantité de commande depuis votre vue
            const quantiteCommande = this.quantiteProduitSelected;

            // Envoyer la quantité de commande au backend
            axios.post('http://localhost:8080/parametres/add', {
                quantiteCommande: quantiteCommande
            })
            .then(response => {
                console.log(response.data);
                // Réinitialiser le champ de texte ou effectuer d'autres actions si nécessaire
                // Enregistrer la quantite dans ParametresService
                ParametresService.saveQuantite(quantiteCommande).then(response => {
                    console.log(response.data);
                }).catch(error => {
                    console.error('Error saving quantity:', error);
                });
                // Au dessus ce qui doit enregistrer dans ParametresService
            })
            .catch(error => {
                console.error(error);
            });
        }
    },
    created() {
        this.getMagasin2();
        this.getProduits(); // Appeler la fonction pour obtenir les produits
    },
};


</script>

<style scoped>
/* Style du conteneur principal */
.container {
    max-width: 1200px;
   /* background-color: brown; */
}

/* Style pour les labels "Magasin et Produit" à gauche du dropdown */
label {
    font-weight: bold;
 
}


.magasin-container{
    width: 6%;
 
}

.produit-container{
    width: 6%;
 
}

/* Style pour le dropdown */
.dropdown-content {
   /* position: relative;*/
}

/* Style pour le select */
.dropdown-content select {
    /*width: calc(100% - 20px); Réduit la largur du champ dropdown*/
    padding: 3px 3px 3px 3px;
    border: 1px solid #060606;
    border-radius: 3px;
    background-color: #f0f0f0;
 
}

/* Style pour le champ d'affichage de l'adresse */
.adresse-box {
    width: 100%;
    padding: 3px 3px 3px 3px;
    border: 1px solid #060606;
    border-radius: 3px;
    background-color: #f0f0f0;
}

/* Style pour le champ texte utilisé pour la quantité*/
input{
    width: 100%;
    padding: 3px 3px 3px 3px;
    border: 1px solid #060606;
    border-radius: 3px;
    background-color: #f0f0f0;
}

/* Style pour les colonnes */
.col-md-3 {
    padding-right: 3px;
    padding-left: 3px;
    margin-bottom: 3px;
}

/* Ajustement des marges entre les colonnes */
.magasin-container, .dropdown-container, .adresse-container, .produit-container, .details-produit-container {
    margin-right: 5px; /* Ajustez selon vos besoins */
    text-align:left ;
}
</style>
