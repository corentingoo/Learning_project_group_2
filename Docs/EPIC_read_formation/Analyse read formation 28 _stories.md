 # Analyse read formation 28  
## Stories  
Story 1  
En tant qu'utilisateur de la plateforme, un admin doit pouvoir visionner toutes les formations qui sont en base de données.  
En tant que professeur, il doit pouvoir voir les formations dont ils donnent cours.  
En tant ou élève, il doit pouvoir regarder les cours qu'il suit.


Sur la page des reads de formations, 
- je dois mettre un bouton "voir en détail ou une icone d'un oeil" (Lorsque je clique dessus cela affichera la formation souhaitée en détail et cela renvoie vers la page d'affichage d'1 formation détaillée. [Qui sera réalise dans l'Epic read formation detaillee]


Contrainte: Une fiche d'une formation peut être consultée, par plusieurs utilisateurs en même temps (par exemple: un admin peut regarder une fiche de formations en même qu'un professeur ou un élève).




Créer une méthode readFormationAll() pour le rôle admin.





Story 2  
Créer une méthode readFormationPartiel() pour le rôle professeur, élève.  



Story 3  
L'utilisateur, càd l'admin ou le professeur ou l'élève doit être sur qu'il visionne bien la ou les formation(s) voulue(s).
Vérifier que, lorsque un admin ou un professeur ou un élève regarde une formation:
- que cette formation soit bien en autorisation de lecture pour ce rôle d'utilisateur
- que l'élément que l'on veut afficher soit bien existant dans la base données





