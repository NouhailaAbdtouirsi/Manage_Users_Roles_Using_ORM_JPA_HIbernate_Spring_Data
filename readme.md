# Manage User Role Using ORM JPA HIbernate SpringData
<h2>Structure de projet : </h2>
<img src="Capture/capture1.png" alt="Structure du projet">
## Objectif
### Pre-requis :
1. Installer IntelliJ Ultimate
2. Créer un projet Spring Initializer avec les dépendances JPA, H2, Spring Web et Lombock
## Etapes :
1. Créer les entités JPA :
    - User ayant les attributs :
        - userId de type String
        - userName de type String
        - password de type String
        - role de type List<Role>
          <img src="Capture/capture3.png" alt="user">
    - Patient ayant les attributs :
        - roleId de type Long
        - desc de type String
        - roleName de type String
        - users de type List<User><br>
          <img src="Capture/capture2.png" alt="role">
2. Configurer l'unité de persistance dans le ficher application.properties
   <img src="Capture/capture8.png" alt="application.properties">

3. Créer les interfaces JPA Repository basée sur Spring data
   - UserRepository :
     <img src="Capture/capture5.png" alt="UserRepository">

   - RoleRepository :
     <img src="Capture/capture4.png" alt="RoleRepository">
4. Creer les services permettant de separer la logique metier 
    - UserService Interface :
      <img src="Capture/capture6.png" alt="UserService">
    
    - UserServiceImpl :
      <img src="Capture/capture7.png" alt="RoleService">
5. Tester quelques opérations de gestion de patients :
    - Ajouter un utilisateur <br>
    - Ajouter des roles <br>
    - Ajouter un role a un utilisateur <br>
    - Authentifier un utilisateur et afficher ses infos<br>
      <img src="Capture/capture9.png" alt="Test">
