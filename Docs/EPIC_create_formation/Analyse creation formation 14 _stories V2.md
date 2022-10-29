 # Analyse creation formation 14  
## Stories  
Story 1  
En tant qu'utilisateur de la plateforme, un admin ou un professeur (uniquement ces deux rôles-là) doivent pouvoir gérer les données en rapport avec la formation :
Sur la page Formulaire de "creation d'une formation", 
- je dois mettre un bouton "Annuler" (Lorsque je clique dessus cela renvoie vers la page d'affichage des formations.
- un bouton "Enregistrer"

Créer la table formation avec les champs: 
`id_formation`, `titre`, `description`, `fk_nom_prof`, `prerequis`, `nbre_eleve`, `date_debut`, `date_fin`, `archive`.

Rmq: prerequis et archive ne seront pas utilisés pour le moment.

Créer une méthode createFormation().


Story 2  
L'utilisateur, càd l'admin ou le professeur doit pouvoir selectionner le nom d'un professeur. 
Créer le lien inter-table avec user, rôle, formation (clé primaire, clé étrangère).


Story 3  
L'utilisateur, càd l'admin ou le professeur doit être sur qu'il n'envoit pas des données arronnées ou partiellement incorrect.
Vérifier que, lorsque un admin ou un professeur crée une formation, il fournit les champs marqué comme requis : 
titre
fk_nom_prof
prerequis (Cela viendra plus tard)
nbre_eleve
date_debut
date_fin
archive  (Cela viendra plus tard)



Story 4  
En tant qu'utilisateur, un professeur doit pouvoir gérer le quotidien d'un formation auquel il est assigné.
Sécurité: un admin et/ou un professeur ne peuvent pas créer une même formation en même temps dans la base de données.
