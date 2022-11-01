# Analyse creation formation 14  
## Analyse technique (càd le comment cela va être réalisé techniquement):  
### Pré-requis:  
Nous sommes dans une architecture client - server.  
Nous considérons que notre admin est déjà connecté à notre site web "Learning Project - Gestion de formations".  
Nous considérons que notre projet fonctionne en design pattern MVC (selon le modèle: C - S - R, où C est le Controleur, S pour Service et R comme Repository).

### Déroulement:
Sur le poste client, depuis la page internet de son navigateur (le Front), notre admin appuye sur le bouton "Création d'une formation".  
Il arrive sur un formulaire appellé "Création d'une formation".  
Il rempli les champs fournis dans ce formulaire.  
Les champs sont les suivants:
- titre de la formation (de type: char 200)  
  => Condition: ne peut pas etre vide ou null.
- description de la formation (de type: char 250)  
  => Condition: peut etre vide ou null.  
  => Condition: Une description peut-être rajoutée plus tard, mais avant que la formation ne commence.
- Nom du professeur (de type: char 180)  
  => Condition: Le nom du professeur peut-être rajouté plus tard, mais avant que la formation ne commence.  
  => Condition: Seuls les professeurs autorisés à donner le cours peuvent associer leur nom à cette formation.

- nombre d'élèves (de type: int)  
  => Condition: ne peut pas etre null.  
     Min = 1  
     Max = 35  
  => Condition: Si plus que 35 participants, alors la formation sera étalée en deux salles de classes.
- date de début (de type: date)  
  => Condition: la date de début ne peut pas etre vide ou null.  
  => Condition: la date de début ne peut pas etre crée à une date antérieure à celle du jour actuel lors de la création de la formation.  
  => Condition: la date de début ne peut pas être après la date de fin de la formation.  
  => Condition: Si le cours a commencé, la date de début et de fin ne peuvent plus être modifiées.
- date de fin (de type: date)  
  => Condition: la date de fin ne peut pas etre vide ou null.  
   => Condition: la date de fin ne peut pas etre crée à une date antérieure à celle du jour actuel lors de la création de la formation  
  => Condition: la date de fin ne peut pas être avant la date de début de la formation.  
  => Condition: Si le cours a commencé, la date de début et de fin ne peuvent plus être modifiées.
- archive (de type: booléen)  
  Pour gerer le softdelete.
    [ 0 = pas archivé]
    [ 1 = archivé]


### Déroulement caché:
- Création de la table "Formation"  
  => Condition: vérification qu'elle n'existe pas déjà dans la base de données. Si non, la créer.  
  => Condition: vérification qu'elle soit au standard innoDB (pour gérer les relations inter-tables).  
  => Condition: vérification que les polices de charactères soient au standard UTF-8.

Rmq: Voir le fichier "Analyse creation formation 14 _modele de donnees.md" en annexe à ce dossier.

- pour ramener la fk (clé étrangère) du nom du professeur, il faut une liaison avec la table User et la table Rôle vers la table Formation.  
   => Condition: vérification si ce professeur est autorisé à donner cette formation.  
      Par exemple: mettre un champ "Autorisé" dans la table User. (de type: booléen)   
      [ 0 = non autorisé]
      [ 1 = autorisé]  






### C - S - R:  
Pour cet Epic, nous avons besoin d'une classe "Formation" qui prendra juste les informations dont nous avons besoin depuis le formulaire de "Création d'une formation".
Cette classe hérite de la classe User avec un constructeur spécial qui n'autorise uniquement l'Admin (... extends User( ) ...).

Ensuite, nous allons dans notre "FormationService" et on y crée un méthode "Create" qui permettra de construire notre objet et qui sera stocké dans la base de données.

Nous passons par le controleur "FormationController" pour créer la route qui nous redirigera vers la vue de remplissage du formulaire de "Création d'une formation".  


Une fois le formulaire de formation complété et envoyé, nous repassons par le controleur "FormationController" pour créer le mapping pour la sauvegarde des données de la formation.  
En amont, nous aurons une vérification si les champs requis ont été correctement remplis. Si ce n'est pas le cas, l'admin est invité a compléter les champs erronés ou manquants.  
Cette vérification se fait via "FormationService", méthode "Validate". Une fois validé par ce service, nous passons par le FormationController qui envoie à la Db via Flyway.

![Visual display](https://github.com/corentingoo/Learning_project_group_2/blob/documentation-14-analyse-creation-formation/Docs/EPIC_create_formation/LProject%20_Formation%20_MindMap%20_Path%20_Fin.jpg)

Rmq: Voir le fichier Mockup "Analyse creation formation 14 _mockup.md" pour un rendu UX/UI de la présentation du formulaire de "Création d'une formation" (étapes Avant, Pendant et Après).  
Pour le respect de la charte graphique et de la police, voir le fichier "LProject _Formation _UX UI _Fin.jpg"



### Modules requis pour cet Epic:  
Java JDK 17  => Source: https://www.oracle.com/java/technologies/downloads/#jdk17-mac  
Spring 5.3.23 (Framework Java) => Source: https://spring.io/projects/spring-framework  
Spring Boot 2.7.5 => Source: https://spring.io/projects/spring-boot  
Spring Security 5.7.4 => Source: https://spring.io/projects/spring-security  
Spring Data JPA 2.7.5 (DAL) => Source: https://spring.io/projects/spring-data-jpa  
Spring Web MVC => Source: https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/mvc.html  
Spring Web Services 3.1.3 => Source: https://spring.io/projects/spring-ws  
Lombok 1.18.24 (Java Library - Automate the generation of Java Beans getters and setters) => Source: https://projectlombok.org/changelog  
Thymeleaf 3.0.15 (Moteur de template - interface) => Source: https://www.thymeleaf.org/  
Flyway 9.5.1 (outil de migration de db) => Source: https://flywaydb.org/  
WampServer 3.2.6 => Source: https://www.wampserver.com/  
MySQL 8.0.30 (gestion de bases de données relationnelles - Back end) => Source: https://www.mysql.com/  
Maven 3.8.6 (Java Project Builder - pom.xml) => Source: https://maven.apache.org/  
CSS Icon (FontAwesome Library - Sous license Open Font License OFL) => Source: https://fontawesome.com/  





### Gérer les exceptions et problèmes qui pourraient être rencontrés:  
![Visual display](https://github.com/corentingoo/Learning_project_group_2/blob/documentation-14-analyse-creation-formation/Docs/EPIC_create_formation/LProject%20_Formation%20_MindMap%20_Code%20HTTP%20_Fin.jpg)

- Code 200: Réussite d'une requête. Par exemple: Page Ok.

Erreurs côté client (4xx):
- Erreur 403, le server comprend la requête mais refuse de l'autoriser.
- Erreur 404, liens erronés ou page introuvable.
- Erreur 408, le temps de la requête est écoulé.

Erreurs côté server (5xx):
- Erreur 500: erreur interne dans le server.
(Par exemple: Le server Back-End MySQL est inacessible au moment de l'enregistrement du formulaire de "Création d'une formation".)
- Erreur 503: Service non disponible.
- Erreur 505: Version HTTP non supportée.

- Les champs à remplir dans le formulaire ne sont pas encodé correctement. 
Solution: afficher un message d'erreur adéquat (voir erreur de 1 à 7) et corriger la donnée jusqu'a ce qu'elle soit Ok.  


Source: IANA (RFC ...) https://www.iana.org/assignments/http-status-codes/http-status-codes.xhtml

