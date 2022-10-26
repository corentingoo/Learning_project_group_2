#Analyse creation formation 14  
##Stories  
Story 1  
En tant qu'utilisateur de la plateforme, un admin ou un professeur (uniquement ces deux rôles-là) doivent pouvoir gérer les données en rapport avec la formation :
Sur la page Formulaire de "creation d'une formation", 
- je dois mettre un bouton "Annuler" (Lorsque je clique dessus cela renvoie vers la page d'affichage des formations.
- un bouton "Enregistrer"

Créer la table formation avec les champs: 
`id_formation`, `titre`, `description`, `nom_prof`, `prerequis`, `nbre_eleve`, `date_debut`, `date_fin`, `archive`.

Créer une méthode createFormation().


Story 2  
Accès à la liste des formations et au détail d'une formation en cliquant sur le bouton "Apercu  (en forme d'oeil).
Cela permet d'afficher un détail comme la description. 



Story 3  
Créer le lien inter-table avec user, rôle, formation (clé primaire, clé étrangère).


Story 4  
Vérifier que, lorsque qu'un admin ou un professeur crée une formation, il fournit les champs marqué comme requis : 
`titre`
`nom_prof`
`prerequis`
`nbre_eleve`
`date_debut`
`date_fin`
`archive`



Story 5  
En tant qu'utilisateur, un professeur doit pouvoir gérer le quotidien d'un formation auquel il est assigné.
Sécurité: un admin et/ou un professeur ne peuvent pas créer une même formation en même temps dans la base de données.



Story 6  
Accès à la page de modification d'une formation pour changer ses infos (en cliquant sur un bouton en forme de "Crayon"). 
Créer, plus tard, une méthode updateFormation.


Story 7  
Créer une méthode deleteFormation.


Story 8  
Créer une méthode archive, lorsque le champ "archive" est mis à 1 et que cette formation est entièrement terminée.  

Story9:
Lorsqu'il y a plus que 24 formations sur la page de formations, il est proposé un bouton de pagination (page précedente et page suivante, par saut de 24).


