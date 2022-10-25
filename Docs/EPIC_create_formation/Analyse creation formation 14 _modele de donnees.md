#Analyse creation formation 14  
##Modèle de données pour cet Epic  
![Visual display](https://github.com/corentingoo/Learning_project_group_2/blob/documentation-14-analyse-creation-formation/Docs/EPIC_create_formation/LP%20_Learning%20DB%20_schema%20DB%20_table%20formation%20_Fin.jpg)

Creation de la table "Formation":



> CREATE TABLE if not exists formation(  
   id_formation INT AUTO_INCREMENT PRIMARY KEY,  
   titre VARCHAR(200) NOT NULL,  
   description VARCHAR(255),  
   nom_prof VARCHAR(180) NOT NULL,  
   prerequis TINYINT(1),  
   nbre_eleve INT(2) NOT NULL,  
   date_debut DATE NOT NULL,  
   date_fin DATE NOT NULL,  
   archive TINYINT(1)  
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;  




Exemples d'insertion de formations:



> INSERT INTO `formation` (`id_formation`, `titre`, `description`, `nom_prof`, `prerequis`, `nbre_eleve`, `date_debut`, `date_fin`, `archive`) VALUES   
(NULL, 'Veille Technologique', 'Ce cours nous apprend à manier les outils pour se tenir au courant de l évolution Hardware et Software en IT.', 'Mr Barmarin', '0','25','20220905','20221215','0'),  
(NULL, 'Programmation Niv 1', 'Ce cours nous apprend les bases en programmation.', 'Mr Renard', '0','15','20180103','20180528','1'),   
(NULL, 'Programmation Niv 2', 'Ce cours nous apprend l orienté Objet, le design pattern MVC ...', 'Mr Delbard', '1','28','20190909','20191218','1'),   
(NULL, 'Mathématique en IT', 'Ce cours nous apprend à manipuler des matrices.', 'Mr Burda', '1','30','20191001','20191218','1'),  
(NULL, 'Stage de 2e', 'Ce stage de 120 périodes vous plonge dans l univers du travail en IT.', 'Mr Jacquet', '1','20','20191001','20191015','1'),  
(NULL, 'Stage de 3e', 'Ce stage de 240 périodes vous replonge dans l univers du travail en IT.', 'Mr Martin', '0','30','20230101','20230130','0');  



Si l'on veut supprimer la table "Formation":


> DROP TABLE formation  



[Rmq: Il restera à réaliser les liaisons inter-table avec user, rôle.]
