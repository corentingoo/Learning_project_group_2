# Analyse read formation 28  
## Analyse technique (càd le comment cela va être réalisé techniquement):  
### Pré-requis:  
Nous sommes dans une architecture client - server.  
Nous considérons que notre admin ou notre professeur est déjà connecté à notre site web "Learning Project - Gestion de formations".  
Nous considérons que notre projet fonctionne en design pattern MVC (selon le modèle: C - S - R, où C est le Controleur, S pour Service et R comme Repository).

### Déroulement:
Sur le poste client, depuis la page internet de son navigateur (le Front), notre admin ou notre professeur clic sur l'onglet "Formation(s)" qui le dirige vers la page des read des formations.  
 

  => Condition: Pour l'admin, il s'agit d'un read all des formations dans la base de données, càd qu'il voit toutes les formations de la base de données.   
  => Condition: Le professeur est dirigé vers la vue qui contient uniquement ses formations à lui. Il s'agit d'un read partiel.
  => Condition: Une fiche d'une formation peut être consultée, par plusieurs utilisateurs en même temps (par exemple: un admin peut regarder une fiche de formations en même qu'un professeur ou un élève).



### Déroulement caché:
- Read de la ou les formation(s) souhaitée(s) depuis la table "Formation"  
  => Condition: vérification que ces formations existent bien dans la base de données et que l'utilisateur (admin, professeur, élève) a les droits en lecture.  
  

Rmq: Voir le fichier "Analyse read formation 28 _modele de donnees.md" en annexe à ce dossier.








### C - S - R:  
Pour cet Epic, nous avons besoin d'une classe "ReadFormation" qui prendra juste les informations dont nous avons besoin depuis le clic sur l'onglet "Formation(s)".
Cette classe hérite de la classe User avec un constructeur spécial qui n'autorise uniquement l'Admin  à faire un read all de toutes les formations.  
Tandis que pour le professeur et les élèves, il s'agit d'un read partiel   (... extends User( ) ...).

Ensuite, nous allons dans notre "UserService" et on y crée un méthode "ReadFormation" qui permettra de lire notre objet depuis la base de données.



Une fois le l'onglet "Formation(s)" cliqué et la méthode ReadFormation appellée, nous passons par le controleur "ReadFormationController" pour créer le mapping pour la lecture des données de la formation ou des formations à afficher, 
que  l'on appelle "ValidateReadFormation".
En amont, nous aurons une vérification si la formation ou les formations sont à lire selon le role de l'utilisateur qui se connecte, càd un read all pour l'admin et un read partiel pour les professeurs et élèves.  

Contrainte : Une fiche d'une formation peut être consultée, par plusieurs utilisateurs en même temps (par exemple: un admin peut regarder une fiche de formations en même qu'un professeur ou un élève).  


Une fois ces vérifications ok, nous repassons par le controleur "ReadFormationController" pour avoir la route qui nous redirigera vers la page des reads des formations.


![Visual display](https://github.com/corentingoo/Learning_project_group_2/blob/documentation-28-analyse-read-formation/Docs/EPIC_read_formation/LProject%20_Formation%20_MindMap%20_Path%20du%20read%20_Fin.jpg)

Rmq: Voir le fichier Mockup "Analyse read formation 28 _mockup.md" pour un rendu UX/UI de la lecture d'une ou plusieurs formation(s) (Etape: Pendant).  
Pour le respect de la charte graphique et de la police, voir le fichier "LProject _Formation _UX UI _read formation _Fin.jpg"



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
![Visual display](https://github.com/corentingoo/Learning_project_group_2/blob/documentation-28-analyse-read-formation/Docs/EPIC_read_formation/LProject%20_Formation%20_MindMap%20_Code%20HTTP%20_Fin.jpg)

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

