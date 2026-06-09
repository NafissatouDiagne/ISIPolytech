**Système de Gestion des Commandes**
**Description
**
Ce projet est une application développée avec Spring Boot permettant la gestion des produits, des clients et des commandes.
Il a été réalisé dans le cadre d'un projet académique afin de mettre en pratique les concepts de développement d'API REST avec Spring.

Technologies utilisées
Java 17
Spring Boot 3.x
Spring Web
Spring Data JPA
Spring Security (configuration en cours)
MySQL
Lombok
Swagger / OpenAPI
Maven

Fonctionnalités réalisées
Gestion des produits

**Les fonctionnalités suivantes ont été implémentées :**

Ajouter un produit ;
Consulter la liste des produits ;
Rechercher un produit par son identifiant ;
Modifier les informations d'un produit ;
Supprimer un produit.


Gestion des clients

Les éléments suivants ont été mis en place :

Création de l'entité Client ;
Création du DTO Client ;
Mise en place du Repository Client ;
Développement du Service Client ;
Développement du Controller Client.


**Configuration du profil de développement**
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/commandes_db
    username: root
    password: votre_mot_de_passe

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true

**Documentation de l'API**

Swagger a été intégré au projet.

Une fois l'application démarrée, la documentation est accessible via :
    


