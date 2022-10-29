 # Analyse delete formation 27  
## Stories  
Story 1  
En tant qu'utilisateur de la plateforme, un admin ou un professeur (uniquement ces deux rôles-là) doivent pouvoir gérer les données en rapport avec la formation :
Sur la page des reads de formations, 
- je dois mettre un bouton "supprimer ou une icone de corbeille" (Lorsque je clique dessus cela supprime la formation souhaitée et cela renvoie vers la page d'affichage des formations.


Contrainte: Vérifier que le champ à supprimer existe bien dans la table formation. 




Créer une méthode deleteFormation().





Story 2  
L'utilisateur, càd l'admin ou le professeur doit être sur qu'il supprime bien la formation voulue.
Vérifier que, lorsque un admin ou un professeur supprime une formation:
- qu'il n y ait pas deux personnes en même temps sur la suppression d'une formation
-  que la formation n'ai pas encore commencé
- qu'il n'y ait aucun élève d'inscrit





