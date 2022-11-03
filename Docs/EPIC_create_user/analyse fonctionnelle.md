# Analyse create user

## Analyse fonctionnelle création d'un user

### Besoins:
- un bouton "Ajout d'un utilisateur" sur la page admin (ouverture du formulaire) 
- un formulaire de création d'utilisateur reprenant: 
  + des champs d'encodages légendés:
    + le nom
    + le prénom
    + l'email
    + l'identifiant
    + le role
  + un bouton d'enregistrement (validation des données) disponible uniquement si les contraintes sont respectées
  + un bouton d'annulation (retour en arrière sans sauver)

### Rôles: 
- Seul le Rôle "ADMIN" est autorisé à créer des utilisateurs

### Contraintes:
- un seul utilisateur par adresse e-mail
- un seul utilisateur par identifiant
- l'e-mail doit correspondre au format e-mail
- l'identifiant correspond à l'identifiant générique des autres systèmes informatiques de la société,  
  il aura systématiquement le format suivant: 4 lettres(2 premières prénom + 2 premières nom) suivi de 4 chiffres

## Analyse fonctionnelle première connexion

### Besoins: 
- deux champs supplémentaires légendés sur la page login pour le choix d'un autre mot de passe(+ confirmation)   
  apparaissant en cas d'utilisation d'un compte temporaire
- un bouton d'enregistrement du nouveau mot de passe

### Rôles:
- le nouvel utilisateur(tous les rôles) se connecte avec son accès temporaire et change de mot de passe

### Contraintes:

- le mot de passe créé doit contenir un minimum de 10 caractères de 3 casses différentes
- le mot de passe créé ne peut pas être identique au mot de passe temporaire
- le mot de passe créé doit être identique à la vérification de mot de passe

