 # Analyse update formation 26  
## Stories  
Story 1  
En tant qu'utilisateur de la plateforme, un admin ou un professeur (uniquement ces deux rôles-là) doivent pouvoir gérer les données en rapport avec la formation :
Sur la page des reads de formations, 
- je dois mettre un bouton "modification ou une icone de crayon" (Lorsque je clique dessus cela nous emène vers un formulaire de modification de la formation souhaitée. Et après, cela renvoie vers la page d'affichage des formations.


Contrainte: Vérifier que le champ à modifier existe bien dans la table formation. 




Créer une méthode updateFormation().





Story 2  
L'utilisateur, càd l'admin ou le professeur doit être sur qu'il modifie bien la formation voulue.
Vérifier que, lorsqu' un admin ou un professeur modifie une formation:
- qu'il n y ait pas deux personnes en même temps sur la modification d'une formation
-  que la formation ne soit pas terminée.  
- Les champs date de début et date de fin ne peuvent plus être modifiés si la formation a déjà commencé.
- Le champ "titre" de la formation ne peut pas être modifié si la formation a déjà commencé, sauf s'il s'agit d'une erreur de syntaxe sans que cela n'affecte le sens du titre originel.
- Le champ "description" de la formation peut être modifié si la formation a déjà commencé, s'il s'agit d'une erreur de syntaxe sans que cela n'affecte le sens du message descriptif à transmettre.
- Le champ "nom du professeur" (qui est une foreign key, clé étrangère) de la formation peut être modifié si la formation a déjà commencé, en cas de remplacement (de longue durée) par un autre professeur et avec l'accord de la Direction.
- Tous les champs peuvent être modifiés, tant que la formation n'a pas encore eu lieu ou tant qu'il n'y a aucuns élèves inscrits.
- Si le champ "archive" est sur 1, càd en statut archivé, la fiche de la formation ne peut pas etre modifiée. [fonctionalité archive qui sera implémenté dans un autre Epic]







