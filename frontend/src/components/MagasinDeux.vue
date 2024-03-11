<template>
    <div class="container">
        <!-- Section pour les dates souhaitées -->
        <div class="row">
            <div class="col-md-3">
                <label for="DateSouhaitee">Date souhaitée</label>
            </div>
            <div class="col-md-3">
                <input type="date" v-model="dateSouhaitee" @keyup.enter="saveDates" class="form-control">
            </div>
        </div>

        <!-- Espace entre les sections -->
        <div style="height: 10px;"></div>

        <!-- Section pour les dates butoir -->
        <div class="row">
            <div class="col-md-3">
                <label for="DateButoir">Date butoir</label>
            </div>
            <div class="col-md-3">
                <input type="date" v-model="dateButoir" @keyup.enter="saveDates" class="form-control">
            </div>
        </div>

        <!-- Espace entre les sections -->
        <div style="height: 10px;"></div>

        <!-- Section pour les magasins -->
        <div class="row">
            <div class="col-md-3">
                <label for="Magasin">Magasin</label>
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
            <div class="col-md-3">
                <label for="Produit">Produit</label>
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
                <input type="text" v-model="quantiteCommandeSelected" @keyup.enter="saveQuantiteCommande" class="form-control">
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
            dateSouhaitee: '',
            dateButoir: '',
            magasin2: [],
            selectedMagasin: '',
            selectedMagasinDetails: {},
            isDropdownOpen: false,
            produits: [],
            selectedProduit: '',
            selectedProduitDetails: {},
            isProduitDropdownOpen: false,
            quantiteCommandeSelected: '',
            quantiteCommande: 0,      
        };
    },
    methods: {
        getMagasin2() {
            MagasinDeuxService.getMagasin2().then(response => {
                this.magasin2 = response.data;
            });
        },
        selectMagasin() {
            this.selectedMagasinDetails = this.magasin2.find(magasin => magasin.id === this.selectedMagasin) || {};
            this.isDropdownOpen = false;
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
            this.selectedProduitDetails = this.produits.find(produit => produit.id === this.selectedProduit) || {};
            this.isProduitDropdownOpen = false;
        },
        toggleProduitDropdown() {
            this.isProduitDropdownOpen = !this.isProduitDropdownOpen;
        },
        saveQuantiteCommande() {
            const quantiteCommande = this.quantiteCommandeSelected;
            //const dateSouhaitee = this.dateSouhaitee;
            //const dateButoir = this.dateButoir;

            const data = {
               // dateSouhaitee: dateSouhaitee,
               // dateButoir: dateButoir,
                quantiteCommande: this.quantiteCommandeSelected
            }

            axios.post('http://localhost:8080/parametres/add', data)
                .then(response => {
                    console.log(response.data);
                    // Appel du service pour sauvegarder la quantité
                    ParametresService.saveQuantite(quantiteCommande)
                        .then(response => {
                            console.log(response.data);
                        })
                        .catch(error => {
                            console.error('Erreur lors de la sauvegarde de la quantité :', error);
                        });
                })
                .catch(error => {
                    console.error('Erreur lors de l\'appel Axios pour sauvegarder la quantité :', error);
                });
        },

        saveDates() {
            const dateSouhaitee = new Date(this.dateSouhaitee);
            const dateButoir = new Date(this.dateButoir);
            const quantiteCommande = this.quantiteCommande;

            const data = {
                dateSouhaitee: dateSouhaitee,
                dateButoir: dateButoir,
                quantiteCommande: quantiteCommande
            };

            axios.post('http://localhost:8080/parametres/add', data)
                .then(response => {
                    console.log(response.data);
                })
                .catch(error => {
                    console.error('Erreur lors de l\'appel Axios pour sauvegarder les dates :', error);
                });
        }
    },
    created() {
        this.getMagasin2();
        this.getProduits();
    },
};

</script>


<style scoped>
.date-container {
    margin-right: 5px;
    margin-left: 5px;
    margin-bottom: 3px;
    text-align: left;
}

.container {
    max-width: 1200px;
}

label {
    font-weight: bold;
}

.dropdown-content select {
    padding: 3px 3px 3px 3px;
    border: 1px solid #060606;
    border-radius: 3px;
    background-color: #f0f0f0;
}

.adresse-box {
    width: 100%;
    padding: 3px 3px 3px 3px ;
    border: 1px solid #060606;
    border-radius: 3px;
    background-color: #f0f0f0;
}

input {
    width: 100%;
    padding: 3px 3px 3px 3px ;
    border: 1px solid #060606;
    border-radius: 3px;
    background-color: #f0f0f0;
}

.col-md-3 {
    padding-right: 3px ;
    padding-left: 3px   ;
    margin-bottom: 3px ;
}

.magasin-container, .dropdown-container, .adresse-container, .produit-container, .details-produit-container, .date-container {
    margin-right: 5px;
    text-align: left;
}
</style>
