<!---<template>
  <div class="produits-container">
    <div class="produits-left">Produits</div>
    <div class="dropdown-content">
      <select v-model="selectedProduit" @change="selectProduit" class="form-control">
        <option value="" disabled>Sélectionner un produit<span class="dropdown-arrow">&#9660;</span></option>
        <option v-for="produit in produits" :key="produit.id" :value="produit.id">
          {{ produit.nomProduit }}
        </option>
      </select>
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
      selectedProduit: '',
    };
  },
  methods: {
    getProduits() {
      ProduitsService.getProduits().then(response => {
        this.produits = response.data;
      });
    },
    selectProduit() {
      // Vos actions lorsque le produit est sélectionné
    },
  },
  created() {
    this.getProduits();
  },
};
</script>

<style scoped>
/* Styles CSS pour la mise en page */
/* Ajoutez vos styles ici */
</style> */
