# MIAGELAND

## Application miageland pour Applications d'Entreprises

Projet sur les Applications d'Entreprises avec Spring

[Sujet en pdf](./ressources/AE_projet_Spring_22-23.pdf)

## Utilisation de l'API

| Méthode | URL                         | Body                                      | Réponse Body                                              | Description                                  |
|---------|-----------------------------|-------------------------------------------|-----------------------------------------------------------|----------------------------------------------|
| GET     | /comptes/login/{mail}       | X                                         | compte.id                                                 | Connection a un compte                       |
| POST    | /comptes/creer              | nom - prenom - adresse mail               | compte.id                                                 | Créer un compte Visiteur                     |                        
|         | /comptes/{cptId}            |                                           |                                                           |                                              |
| POST    | /attractions/creer          | nom                                       | attraction.id                                             | Créer une attraction (nom uniques)           |
| DELETE  | /attractions/{id}           | X                                         | X                                                         | Supprime une attraction par son id           |
| PUT     | /attractions/{attId}/ouvrir | X                                         | X                                                         | Ouvre une attraction par son id              |
| PUT     | /attractions/{attId}/fermer | X                                         | X                                                         | Ferme une attraction par son id              |
| POST    | /employes/inscrire          | nom - prenom - adresse mail - typeEmploye | employe.id                                                | Un gérant ajoute un compte employe           |
| DELETE  | /employes/retirer           | nom                                       | X                                                         | Supprime un compte employe                   |
| POST    | /billets/reserver           | dateVisite                                | billet.id                                                 | Un visiteur réserve un billet                |
| GET     | /billets/{id}               | X                                         | billet.id - billet.dateVisite - billet.prix - billet.etat | Permet de consulter un billet                |                 
| PUT     | /billets/{billetId}/annuler | X                                         | billet.prix                                               | Un visiteur annule un billet                 |
| PUT     | /billets/{billetId}/valider | X                                         | EtatBillet                                                | Un employé valide un billet                  |
| GET     | /statistiques/              | X                                         | toutes les stats du sujet                                 | Permet de consulter les statistiques du parc |
| PUT     | /jauges/{date}/{int}        | X                                         | X                                                         | Permet de modifier la jauge d'une date       |

### Configuration

Ce projet utilise une base de données MySQL qu'on peut créer sous Docker avec la commande :
docker run --name=mysql_miageland -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=test -p 3306:3306 mysql

---

# Tutoriels

Ce qui suit est le fichier Readme original (utile pour les liens vers les tutoriels).

# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.2/maven-plugin/reference/html/#build-image)
* [Validation](https://docs.spring.io/spring-boot/docs/3.0.2/reference/htmlsingle/#io.validation)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.0.2/reference/htmlsingle/#data.sql.jpa-and-spring-data)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.0.2/reference/htmlsingle/#web)

### Guides

The following guides illustrate how to use some features concretely:

* [Validation](https://spring.io/guides/gs/validating-form-input/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
