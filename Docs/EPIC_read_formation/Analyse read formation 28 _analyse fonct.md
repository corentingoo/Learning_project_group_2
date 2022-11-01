# Analyse read formation 28

## Analyse fonctionnelle (Solution proposée d'un point de vue du besoin utilisateur, contraintes, boutons):

### Besoins:
Pour lire une ou plusieurs formation(s), notre admin, notre professeur ou notre élève a besoin d'arriver directement sur la page des read de formation, lorsqu'il clic sur l'onglet "Formation".  
 


Des contraintes (règles de validation) sont mises en place pour garantir que les bonnes informations sont affichées depuis la base de données
(selon que l'on soit admin ou professeur ou élève).  
L'admin voit toutes les formations de la base de données.  
Le professeur est dirigé vers la vue qui contient uniquement ses formations à lui.
L'élève voit les formations qu'il est en train de suivre avec une icone d'oeil pour voir cette formation en détail. Il voit aussi les formations qu'il a terminées.

### Rôles:
Rôle 1: Notre admin a besoin de voir toutes les formations de la base de données, lorsqu'il a reçu une demande de consultation d'une formation de la part d'un professeur.  
Rôle 2: Un professeur peut lui même consulter la ou les formation(s) dont il va donner le cours, s'il a reçu l'accord de la Direction.
Rôle 3: Un élève peut voir les formations qu'il est en train d'apprendre et il peut consulter les formations qu'il a déjà terminé.

### Contraintes:
- Une fiche d'une formation peut être visionnée, par plusieurs utilisateurs en même temps (par exemple: un admin peut regarder une fiche de formations en même qu'un professeur ou un élève).  




![Visual display](https://github.com/corentingoo/Learning_project_group_2/blob/documentation-28-read-formation/Docs/EPIC_read_formation/LProject%20_Formation%20_UX%20UI%20_read%20formation%20_Fin.jpg)  


Rmq: Voir les fichiers joints en annexe dans ce repertoire "Docs" pour en savoir plus sur cet epic.
