 # Analyse delete formation 27  
## Stories  
Story 1  
En tant qu'utilisateur de la plateforme, un admin doit pouvoir gérer les données en rapport avec la formation :
Sur la page des reads de formations, 
- je dois mettre un bouton "supprimer ou une icone de corbeille" (Lorsque je clique dessus cela réalise un softdelete qui tag la formation souhaitée  comme archivée (en cas d'enquête judiciaire) et cela renvoie vers la page d'affichage des formations.


Contrainte: Vérifier que le champ archive existe bien dans la table formation. 




Créer une méthode softDelete().





Story 2  
L'utilisateur, càd l'admin doit être sur qu'il supprime bien la formation voulue (en softdelete, çàd en archive pour les enquetes judiciaires).
Vérifier que, lorsque un admin supprime une formation:
- qu'il n y ait pas deux admins en même temps sur la suppression d'une formation
-  que la formation n'ai pas encore commencé
- qu'il n'y ait aucun élève d'inscrit





