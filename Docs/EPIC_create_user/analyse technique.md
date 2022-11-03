# Analyse create user 
## Analyse technique création d'un user

### prérequis:
- champ e-mail(format e-mail taille 50) à ajouter dans la table 'users'

### comportement:
- contrôle des données encodées selon contraintes avant envoi en DB
- le compte est créé avec la mention expiré(' credentials_non_expired'), non verrouillé


## Analyse technique première connexion

### design: 
![visual display](https://github.com/corentingoo/Learning_project_group_2/blob/documentation-13-creation-d'un-user/Docs/EPIC_create_user/sch%C3%A9ma%20create%20user.JPG)
### prérequis:
- récupération de l'info compte expiré(' credentials_non_expired')
### comportement:
- lors de la vérification de connexion, un compte expiré déclenche l'ajout de l'obligation de changer de mot de passe sur la page login
    
