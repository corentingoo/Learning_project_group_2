# Analyse FrontEnd Page Connexion 59
## Analyse technique (càd le comment cela va être réalisé techniquement):  
### Pré-requis:  
Nous sommes dans une architecture client - server.  
Nous considérons que notre admin ou notre professeur ou étudiant n'est pas encore connecté à notre site web "Learning Project - Gestion de formations".  
Nous considérons que notre projet fonctionne en design pattern MVC (selon le modèle: C - S - R, où C est le Controleur, S pour Service et R comme Repository).

### Déroulement:
Sur le poste client, depuis la page internet de son navigateur (le Front), n'importe quel utilisateur doit pouvoir arriver sur la page de Connexion du site. 
Pour cela, nous passons par Thymeleaf, le moteur de template - interface.






### C - S - R:  
Nous modifions le fichier login.html selon les éléments repris dans l'analyse fonctionnelle de cet Epic.




Rmq: Voir le fichier Mockup "Analyse FrontEnd Page Connexion 59 _mockup.md" pour un rendu UX/UI de la connexion  
avec la charte graphique et le type de police.



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
![Visual display](https://github.com/corentingoo/Learning_project_group_2/blob/documentation-59-frontend-connexion/Docs/EPIC_create_formation/LProject%20_Formation%20_MindMap%20_Code%20HTTP%20_Fin.jpg)

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

- Les champs remplis sur la page de connexion ne sont pas encodés correctement. 
Solution: afficher un message d'erreur adéquat (voir erreur de 1 et 2) et corriger la donnée jusqu'a ce qu'elle soit Ok.  


Source: IANA (RFC ...) https://www.iana.org/assignments/http-status-codes/http-status-codes.xhtml

