# Analyse technique 
## Table
Ajout de la table 'inscption' dans la db avec les colonnes suivantes:
'id_inscription'  - bigint
'id_user'  - bigint
'id_formation' - bigint

### Foreign key 
'id_user' referencement à l'id de la table users
'id_formation' referencement à l'id de la table formations

## Contraintes techniques
### Solution 1
Utilisation de l'annotation @ManytoMany dans l'entité User et Formation

### Solution 2
Création d'une nouvelle entité Inscription
Utilisation de l'annotion @ManyToOne dans l'entité Inscription
Utilisation de l'annotation @OnetoMany dans l'entité User et Formation


