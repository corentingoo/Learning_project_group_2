# Analyse creation formation 14

## Analyse fonctionnelle (Solution proposée d'un point de vue du besoin utilisateur, contraintes, boutons):

### Besoins:
Pour créer une formation, notre admin a besoin d'un bouton "Créer une formation" qui renvoit vers un formulaire appellé "Création d'une formation".  
Ce formulaire contient des champs de saises de données et
- un bouton "Annuler"
- un bouton "Enregistrer"  
  Des contraintes (règles de validation) sont mises en place pour garantir que les bonnes informations sont enregistrées dans la base de données.
  Après la soumission du formulaire de "Création d'une formation, l'admin est redirigé vers la vue qui contient les formations.

### Rôles:
Rôle 1: Notre admin a besoin de pouvoir créer une formation, lorsqu'il a reçu une demande de création d'une formation de la part d'un professeur.


### Contraintes:
- Une formation ne peut pas être crée, si elle existe déjà dans la base de données.
- Une formation ne peut pas être crée en même temps par deux personnes différentes. (Par exemple: deux admins ne peuvent pas créer une même formation en même temps.) => A venir dans un autre Epic


Notre admin fournit le nom de la formation, une description et le nom du professeur qui donnera le cours.
Il mentionne aussi le nombre d'élèves qu'il peut former à cette session, la date de début et la date de fin de la formation.



![Visual display](https://github.com/corentingoo/Learning_project_group_2/blob/documentation-14-analyse-creation-formation/Docs/EPIC_create_formation/LProject%20_Formation%20_UX%20UI%20_Fin.jpg)  


Rmq: Voir les fichiers joints en annexe dans ce repertoire "Docs" pour en savoir plus sur cet epic.
