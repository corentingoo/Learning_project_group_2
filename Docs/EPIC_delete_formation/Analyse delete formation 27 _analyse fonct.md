# Analyse delete formation 27

## Analyse fonctionnelle (Solution proposée d'un point de vue du besoin utilisateur, contraintes, boutons):

### Besoins:
Pour supprimer une formation, notre admin a besoin d'un bouton "Supprimer ou une icone de corbeille" qui réalisera un softdelete de la formation selectionnée et la mettra dans un mode archive (e ncas d'enquete judiciaire). 
Sur la ligne de la formation à supprimer, on a besoin d':
- un bouton "Supprimer ou d'une icone de corbeille"
 
Des contraintes (règles de validation) sont mises en place pour garantir que cette formation peut bien être supprimée (par exemple: ne pas encore avoir eu lieu, ni d'élèves inscrits).
Après le clic sur le bouton supprimer, cela déplace la formation voulue et la met en mode archive et cela revient sur la page de read des formations.

### Rôles:
Rôle 1: uniquement le rôle admin a le pouvoir de supprimer une formation, lorsqu'il a reçu une demande de suppression d'une formation de la part d'un professeur.  


### Contraintes:
- Une formation ne peut pas être supprimée, si elle est déjà en cours d'être donnée.
- Une formation ne peut pas être supprimée en même temps par deux admins différents.



![Visual display](https://github.com/corentingoo/Learning_project_group_2/blob/documentation-27-delete-formation/Docs/EPIC_delete_formation/LProject%20_Formation%20_UX%20UI%20_delete%20formation%20_Fin.jpg)

Rmq: Voir les fichiers joints en annexe dans ce repertoire "Docs" pour en savoir plus sur cet epic.
