<template>
    <div class="container">
        <!-- Section pour les magasins -->
        <div class="row">
            <div class="col-md-3 magasin-container">
                <div class="magasin-left">Magasin</div>
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
        <div style="height: 20px;"></div>

        <!-- Section pour les produits -->
        <div class="row">
            <div class="col-md-3 produit-container">
                <div class="produit-left">Produit</div>
            </div>
            <div class="col-md-3 dropdown-container">
                <div class="dropdown-content" :class="{ 'open': isDropdownOpen }">
                    <select v-model="selectedProduit" @change="selectProduit" class="form-control">
                        <option value="" disabled>Sélectionner un produit<span class="dropdown-arrow" :class="{ 'up': selectedProduit, 'down': !selectedProduit }" @click="toggleDropdown">&#9660;</span></option>
                        <option v-for="produit in produits" :key="produit.id" :value="produit.id">
                            {{ produit.nomProduits }}
                        </option>
                    </select>
                </div>
            </div>
            <div class="col-md-3 produit-container">
                <div class="adresse-box">{{ selectedProduitDetails.quantiteProduits || '-' }}</div>
            </div>
        </div>
    </div>
</template>

<script>
import MagasinDeuxService from './services/MagasinDeuxService';
import ProduitsService from './services/ProduitsService';

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
            quantiteProduitSelected: 0 // Ajout de la propriété pour la quantité de produit sélectionné
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
                console.log(this.produits); // Ajoutez ceci pour vérifier les produits récupérés
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
    padding-left: 0;
    padding-right: 20px;
}

/* Style pour le mot "Magasin" à gauche du dropdown */
.magasin-left, .produit-left {
    font-weight: bold;
}

/* Style pour le dropdown */
.dropdown-content {
    position: relative;
}

/* Style pour le select */
.dropdown-content select {
    width: calc(100% - 20px); /* Réduire la largeur pour laisser de la place à la flèche */
    padding: 3px;
    border: 1px solid #040404;
    border-radius: 3px;
    background-color: #ffffff;
    appearance: none; /* Supprimer les styles natifs du select */
    -webkit-appearance: none;
    -moz-appearance: none;
}

/* Style pour la flèche du dropdown */
.dropdown-arrow {
    position: absolute;
    top: 50%;
    right: 5px; /* Ajuster la distance du bord droit */
    transform: translateY(-50%);
    cursor: pointer;
    border: solid rgb(1, 1, 1);
    border-width: 0 2px 2px 0;
    display: inline-block;
    padding: 3px;
    transition: transform 0.3s ease; /* Animation de transition pour l'effet visuel */
}

/* Style pour la flèche vers le bas par défaut */
.dropdown-arrow.down {
    transform: translateY(-50%) rotate(45deg);
}

/* Style pour la flèche vers le haut lorsqu'un magasin est sélectionné */
.dropdown-arrow.up {
    transform: translateY(-50%) rotate(-135deg);
}

/* Style pour le champ d'affichage de l'adresse */
.adresse-box {
    width: 100%;
    padding: 3px;
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
}
</style>
