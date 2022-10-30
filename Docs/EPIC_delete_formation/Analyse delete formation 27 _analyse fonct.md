# Analyse delete formation 27

## Analyse fonctionnelle (Solution proposée d'un point de vue du besoin utilisateur, contraintes, boutons):

### Besoins:
Pour supprimer une formation, notre admin ou notre professeur a besoin d'un bouton "Supprimer ou une icone de corbeille" qui effacera la formation selectionnée.  
Sur la ligne de la formation à supprimer:
- un bouton "Supprimer ou une icone de corbeille"
 
Des contraintes (règles de validation) sont mises en place pour garantir que cette formation peut bien être supprimée (par exemple: ne pas encore avoir eu lieu, ni d'élèves inscrits).
Après le clic sur le bouton supprimer, cela efface la formation voulue et cela revient sur la page de read des formations.

### Rôles:
Rôle 1: Notre admin a besoin de pouvoir supprimer une formation, lorsqu'il a reçu une demande de suppression d'une formation de la part d'un professeur.  
Rôle 2: Un professeur peut lui même supprimer une formation dont il va donner le cours, s'il a reçu l'accord de la Direction et que ce cours n'a pas encore commencé, ni d'èlèves inscrits).

### Contraintes:
- Une formation ne peut pas être supprimée, si elle est déjà en cours d'être donnée.
- Une formation ne peut pas être supprimée en même temps par deux personnes différentes. (Par exemple: un admin ne peut pas supprimer une formation, 
si un professeur est en train de la supprimer. Et inversément.

Notre admin ou notre professeur clic sur le bouton de la formation à supprimer.


![Visual display](https://github.com/corentingoo/Learning_project_group_2/blob/documentation-27-delete-formation/Docs/EPIC_delete_formation/LProject%20_Formation%20_UX%20UI%20_delete%20formation%20_Fin.jpg)

Rmq: Voir les fichiers joints en annexe dans ce repertoire "Docs" pour en savoir plus sur cet epic.
