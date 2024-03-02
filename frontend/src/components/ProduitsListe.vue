<template>
    <div class="container">
      <div class="row">
        <div class="col-md-3">
          <!-- Ajouter un titre pour les produits -->
          <div class="title-left">Produits</div>
        </div>
        <div class="col-md-3 produits-container">
          <!-- Ajouter un titre pour le dropdown des produits -->
          <div class="produits-left">Produits</div>
          <!-- Dropdown pour les produits -->
          <div class="dropdown-content">
            <select v-model="selectedProduit" @change="selectProduit" class="form-control">
              <option value="" disabled>Sélectionner un produit<span class="dropdown-arrow">&#9660;</span></option>
              <option v-for="produit in produits" :key="produit.id" :value="produit.id">
                {{ produit.nomProduit }}
              </option>
            </select>
          </div>
        </div>
        <div class="col-md-3">
          <!-- Ajouter un titre pour la quantité de produit -->
          <div class="quantite-left">Quantité disponible</div>
        </div>
        <div class="col-md-3">
          <!-- Afficher la quantité de produit sélectionné -->
          <div class="quantite-box">{{ selectedProduitDetails.quantite || '-' }}</div>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  import ProduitsService from './services/ProduitsService';
  
  export default {
    name: 'ProduitsListe',
    data() {
      return {
        produits: [],
        selectedProduit: '', // Variable pour stocker le produit sélectionné dans le menu déroulant
        selectedProduitDetails: {}, // Détails du produit sélectionné
      };
    },
    methods: {
      getProduits() {
        ProduitsService.getProduits().then(response => {
          this.produits = response.data;
        });
      },
      selectProduit() {
        // Trouver les détails du produit sélectionné
        this.selectedProduitDetails = this.produits.find(produit => produit.id === this.selectedProduit) || {};
      },
    },
    created() {
      this.getProduits();
    },
  };
  </script>
  
  <style scoped>
  /* Style pour les produits */
  .produits-container {
    display: flex;
    align-items: center;
    margin-bottom: 6px;
  }
  
  /* Style pour le mot "Produits" à gauche du dropdown */
  .produits-left {
    margin-right: 10px;
  }
  
  /* Style pour le titre "Quantité disponible" */
  .quantite-left {
    font-weight: bold;
    margin-bottom: 6px;
  }
  
  /* Style pour le champ d'affichage de la quantité */
  .quantite-box {
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
  
  /* Ajustement manuel pour réduire l'espace entre "Destination" et "Produits" */
  .produits-container {
    display: flex;
    align-items: left;
    margin-bottom: 0px;
  }
  
  /* Style pour le dropdown */
  .dropdown-content select {
    width: 100%;
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
  </style>
  