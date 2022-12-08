# Analyse create user 
## Analyse technique création d'un user

### prérequis:
- champ e-mail(format e-mail taille 50) à ajouter dans la table 'users'

### comportement:
- contrôle des données encodées selon contraintes avant envoi en DB
- le compte est créé avec la mention expiré(' credentials_non_expired'), non verrouillé

### design:
![visual display](https://github.com/corentingoo/Learning_project_group_2/blob/dev/Docs/EPIC_create_user/sch%C3%A9ma%20create%20user.JPG)


## Analyse technique première connexion

___ce point sera géré via un autre épic___

### prérequis:
- récupération de l'info compte expiré(' credentials_non_expired')
### comportement:
- lors de la vérification de connexion, un compte expiré déclenche l'ajout de l'obligation de changer de mot de passe sur la page login

