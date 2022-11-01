# Analyse update formation 26

## Analyse fonctionnelle (Solution proposée d'un point de vue du besoin utilisateur, contraintes, boutons):

### Besoins:
Pour mettre à jour une formation, notre admin ou notre professeur a besoin d'un bouton "mettre à jour ou une icone de crayon" qui renvoit vers un formulaire appellé "Modification d'une formation".  
Ce formulaire contient des champs de saisies de données et
- un bouton "Annuler"
- un bouton "Enregistrer"  
Des contraintes (règles de validation) sont mises en place pour garantir que les bonnes informations sont enregistrées dans la base de données.
Après la soumission du formulaire de "Mise à jour d'une formation, l'admin ou le professeur est redirigé vers la vue qui contient le ou les read des formations.

### Rôles:
Rôle 1: Notre admin a besoin de pouvoir mettre à jour une formation, lorsqu'il a reçu une demande de mise à jour d'une formation de la part d'un professeur.  
Rôle 2: Un professeur peut lui même mettre à jour une formation dont il donne le cours, s'il a reçu l'accord de la Direction.
Rmq: Seuls ces deux rôles peuvent modifier une formation.

### Contraintes:
- Une formation ne peut pas être mise à jour, si elle n'existe pas encore dans la base de données.
- Une formation ne peut pas être mise à jour en même temps par deux personnes différentes. (Par exemple: un admin ne peut pas mettre à jour une formation, 
si un professeur est en train de faire des modifications dans le formulaire de mise à jour de cette formation. Et inversément.
- Les champs date de début et date de fin ne peuvent plus être modifiés si la formation a déjà commencé.
- Le champ "titre" de la formation ne peut pas être modifié si la formation a déjà commencé, sauf s'il s'agit d'une erreur de syntaxe sans que cela n'affecte le sens du titre originel.
- Le champ "description" de la formation peut être modifié si la formation a déjà commencé, s'il s'agit d'une erreur de syntaxe sans que cela n'affecte le sens du message descriptif à transmettreo.
- Le champ "nom du professeur" (qui est une foreign key, clé étrangère) de la formation peut être modifié si la formation a déjà commencé, en cas de remplacement (dde longue durée) par un autre professeur et avec l'accord de la Direction.
- Tous les champs peuvent être modifiés, tant que la formation n'a pas encore eu lieu ou tant qu'il n'y a aucuns élèves inscrits.

Notre admin ou notre professeur modifie les champs de la formation qu'il souhaite rééditer, ensuite il clique sur le bouton "Enregistrer". Et il se retrouve sur la page des read de ses formations.  



![Visual display](https://github.com/corentingoo/Learning_project_group_2/blob/documentation-26-update-formation/Docs/EPIC_update_formation/LProject%20_Formation%20_UX%20UI%20_update%20formation%20_Fin.jpg)  


Rmq: Voir les fichiers joints en annexe dans ce repertoire "Docs" pour en savoir plus sur cet epic.
