# Analyse create user 
## Analyse technique stories 1

### prérequis:
- champ e-mail(format e-mail taille 50) à ajouter dans la table 'users'

### comportement:
- contrôle des données encodées selon contraintes avant envoi en DB
- le compte est créé avec la mention expiré(' credentials_non_expired'), non verrouillé


## Analyse technique stories 2

### prérequis:
- récupération de l'info compte expiré(' credentials_non_expired')
### comportement:
- lors de la vérification de connexion, un compte expiré déclenche l'ajout de l'obligation de changer de mot de passe sur la page login
    