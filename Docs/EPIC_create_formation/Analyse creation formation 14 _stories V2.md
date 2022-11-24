 # Analyse creation formation 14  
## Stories  
Story 1  
En tant qu'utilisateur de la plateforme, un admin (uniquement ce rôle-là) doit pouvoir gérer les données en rapport avec la formation :
Sur la page Formulaire de "creation d'une formation", 
- je dois mettre un bouton "Annuler" (Lorsque je clique dessus cela renvoie vers la page d'affichage des formations.
- un bouton "Enregistrer"

Créer la table formation avec les champs: 
`id_formation`, `titre`, `description`, `fk_nom_prof`, `prerequis`, `nbre_eleve`, `date_debut`, `date_fin`, `archive`.

Rmq: prerequis et archive ne seront pas utilisés pour le moment.
Archive servira pour un softdelete (pour avoir une trace en cas d'enquête judiciaire).

Créer une méthode create().


Story 2  
L'utilisateur, càd l'admin doit pouvoir selectionner le nom d'un professeur. 
Créer le lien inter-table avec user, rôle, formation (clé primaire, clé étrangère).


Story 3  
L'utilisateur, càd l'admin doit être sur qu'il n'envoit pas des données arronnées ou partiellement incorrect.
Vérifier que, lorsque un admin crée une formation, il fournit les champs marqué comme requis : 
titre
fk_prof
prerequis (Cela viendra plus tard)
nbre_eleve
date_debut
date_fin
archive  (Cela viendra plus tard pour gérer le softdelete) => (pour avoir une trace en cas d'enquête judiciaire)



Story 4  
En tant qu'utilisateur, un professeur doit pouvoir gérer le quotidien d'un formation auquel il est assigné, il doit pouvoir faire un update.
Sécurité: Deux admins ne peuvent pas créer une même formation en même temps dans la base de données. => A venir dans un autre Epic
