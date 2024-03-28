
---VERSION FRANCAISE---
# Syncflow :outil de Prise de Commandes - Java SpringBoot avec MySQL et Vue.js

## Introduction

Ce projet personnel vise à développer un outil de prise de commandes en utilisant Java SpringBoot avec MySQL. L'outil servira d'API pour gérer les commandes, en utilisant la manipulation des données et en intégrant des fonctionnalités d'intelligence artificielle. Tout au long du processus de développement, j'ai mis l'accent sur l'utilisation d'outils standard de l'industrie, la recherche de conseils d'experts et la mise en place de pratiques de test robustes.

## Présentation du Projet

L'Outil de Prise de Commandes est conçu pour rationaliser le processus de gestion des commandes en fournissant une API backend. En utilisant SpringBoot et MySQL, l'outil facilite la création, la récupération et la modification des commandes, tout en intégrant des fonctionnalités d'IA pour une prise de décision améliorée.

## Fonctionnalités Clés

- **Développement de l'API** : Utilisation de SpringBoot pour créer une API backend robuste pour la gestion des commandes.
- **Intégration de la Base de Données** : Mise en œuvre de MySQL pour la gestion de la base de données, assurant un stockage et une récupération des données efficaces.
- **Consultation d'Experts** : Consultation de professionnels de Java pour recueillir des idées et des expertises, améliorant le développement du projet.
- **Wireframing** : Développement de wireframes pour visualiser la structure du projet et le flux d'interaction utilisateur, guidant les décisions de développement.
- **Développement Piloté par les Tests** : Réalisation de tests rigoureux à chaque étape de mise en œuvre pour garantir la fiabilité et la fonctionnalité du code.
- **Développement Frontend** : Intégration de Vue.js pour le développement frontend, permettant une interaction utilisateur transparente.
- **Intégration Continue** : Utilisation de commandes curl pour les tests de connectivité backend et base de données pendant le développement du projet.
- **Gestion des Versions** : Adaptation des versions de Java et de SpringBoot du projet selon les besoins pour s'aligner avec les exigences des dépendances.
- **Documentation** : Maintien d'une documentation complète du projet, incluant des wireframes, des journaux de commandes et des diagrammes architecturaux.

## Technologies Utilisées

- Java
- SpringBoot
- MySQL
- Vue.js

## Progression du Projet

1. **Initiation du Projet** : Définition de la portée, des objectifs et de la pile technologique du projet en fonction des apprentissages en immersion et des intérêts personnels.
2. **Développement Backend** : Développement d'une API backend en utilisant SpringBoot, intégrant MySQL pour la gestion de la base de données.
3. **Consultation d'Experts** : Recherche de conseils auprès de professionnels de Java pour des idées et des bonnes pratiques en développement backend.
4. **Wireframing et Conception** : Création de wireframes pour visualiser la structure du projet et le flux d'interaction utilisateur.
5. **Tests et Itération** : Réalisation de tests rigoureux à chaque étape de développement pour garantir la fiabilité et la fonctionnalité du code.
6. **Intégration Frontend** : Intégration de Vue.js pour le développement frontend, offrant une interface conviviale pour la gestion des commandes.
7. **Amélioration Continue** : Adaptation des versions et des dépendances du projet selon les besoins, assurant la compatibilité et la stabilité.

## Mise en Avant du Projet

Je présenterai le processus de développement du projet à travers des vidéos, démontrant les wireframes, l'exécution des commandes, les journaux de terminal, les résultats de données JSON et l'architecture du projet.

## Conclusion

Le projet Outil de Prise de Commandes met en valeur mon engagement envers le développement backend en utilisant Java SpringBoot et MySQL, en tirant parti des outils et des meilleures pratiques standard de l'industrie. Grâce à la consultation d'experts, aux tests complets et au développement itératif, le projet vise à fournir une solution robuste et efficace pour la gestion des commandes.


### Guide d'exécution du projet

Ce document fournit des instructions sur la façon d'exécuter le backend et le frontend de ce projet.

## Backend

1. Ouvrez un terminal.

2. Accédez à la racine du projet.

3. Pour lancer le backend, exécutez la commande suivante :
    ```bash
    ./mvnw spring-boot:run
    ```

## Test du Backend avec cURL

1. Ouvrez un autre terminal (pour le test du backend avec cURL).

2. Pour tester les endpoints du backend, utilisez la commande cURL. Par exemple, pour récupérer tous les paramètres, exécutez la commande suivante :
    ```bash
    curl http://localhost:8080/parametres/all
    ```

## Frontend

1. Ouvrez un troisième terminal.

2. Assurez-vous d'avoir Node.js installé. Si ce n'est pas le cas, installez Node.js à partir du site officiel : [Télécharger Node.js](https://nodejs.org/)

3. Accédez au répertoire du frontend dans votre projet.

4. Pour lancer le frontend, exécutez la commande suivante :
    ```bash
    npm run serve
    ```

Assurez-vous que le backend est en cours d'exécution avant de démarrer le frontend pour éviter les erreurs de connexion.

---

Note : Assurez-vous d'avoir toutes les dépendances nécessaires installées et configurées correctement avant d'exécuter les commandes ci-dessus.



---ENGLISH VERSION---

# Syncflow: Order Management Tool - Java SpringBoot with MySQL and Vue.js

## Introduction

This personal project aims to develop an order management tool using Java SpringBoot with MySQL. The tool will serve as an API to manage orders, utilizing data manipulation and integrating AI features. Throughout the development process, emphasis has been placed on using industry-standard tools, seeking expert advice, and implementing robust testing practices.

## Project Overview

The Order Management Tool is designed to streamline the order management process by providing a backend API. Using SpringBoot and MySQL, the tool facilitates the creation, retrieval, and modification of orders, while integrating AI features for enhanced decision-making.

## Key Features

- **API Development**: Utilizing SpringBoot to create a robust backend API for order management.
- **Database Integration**: Implementing MySQL for database management, ensuring efficient data storage and retrieval.
- **Expert Consultation**: Seeking advice from Java professionals to gather insights and expertise, enhancing project development.
- **Wireframing**: Developing wireframes to visualize the project structure and user interaction flow, guiding development decisions.
- **Test-Driven Development**: Conducting rigorous testing at every implementation stage to ensure code reliability and functionality.
- **Frontend Development**: Integrating Vue.js for frontend development, enabling seamless user interaction.
- **Continuous Integration**: Using curl commands for backend and database connectivity testing during project development.
- **Version Management**: Adapting project Java and SpringBoot versions as needed to align with dependency requirements.
- **Documentation**: Maintaining comprehensive project documentation, including wireframes, command logs, and architectural diagrams.

## Technologies Used

- Java
- SpringBoot
- MySQL
- Vue.js

## Project Progression

1. **Project Initiation**: Defining project scope, goals, and technology stack based on immersion learnings and personal interests.
2. **Backend Development**: Developing a backend API using SpringBoot, integrating MySQL for database management.
3. **Expert Consultation**: Seeking advice from Java professionals for backend development ideas and best practices.
4. **Wireframing and Design**: Creating wireframes to visualize project structure and user interaction flow.
5. **Testing and Iteration**: Conducting rigorous testing at each development stage to ensure code reliability and functionality.
6. **Frontend Integration**: Integrating Vue.js for frontend development, providing a user-friendly interface for order management.
7. **Continuous Improvement**: Adapting project versions and dependencies as needed, ensuring compatibility and stability.

## Project Showcase

I will showcase the project development process through videos, demonstrating wireframes, command execution, terminal logs, JSON data results, and project architecture.

## Conclusion

The Order Management Tool project highlights my commitment to backend development using Java SpringBoot and MySQL, leveraging industry-standard tools and best practices. Through expert consultation, comprehensive testing, and iterative development, the project aims to provide a robust and efficient solution for order management.


### Project Execution Guide

This document provides instructions on how to run the backend and frontend of this project.

## Backend

1. Open a terminal.

2. Navigate to the project root directory.

3. To launch the backend, execute the following command:
    ```bash
    ./mvnw spring-boot:run
    ```

## Backend Testing with cURL

1. Open another terminal (for backend testing with cURL).

2. To test the backend endpoints, use the cURL command. For example, to retrieve all parameters, execute the following command:
    ```bash
    curl http://localhost:8080/parametres/all
    ```

## Frontend

1. Open a third terminal.

2. Ensure you have Node.js installed. If not, install Node.js from the official website: [Download Node.js](https://nodejs.org/)

3. Navigate to the frontend directory within your project.

4. To launch the frontend, execute the following command:
    ```bash
    npm run serve
    ```

Make sure the backend is running before starting the frontend to avoid connection errors.

---

Note: Ensure you have all necessary dependencies installed and configured correctly before executing the above commands.
