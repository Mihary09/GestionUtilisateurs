Description :
Cette application de gestion d'utilisateurs est développée en Java avec Swing pour l'interface utilisateur. Elle permet aux utilisateurs de s'enregistrer, de se connecter, et d'accéder à un menu personnalisé. Les données des utilisateurs sont stockées dans une base de données MySQL.

Fonctionnalités :
Inscription : Permet à un utilisateur de créer un compte en fournissant ses informations (nom, nom d'utilisateur, mot de passe, téléphone, email, genre et image de profil).

Connexion : Permet aux utilisateurs enregistrés de se connecter en utilisant leur nom d'utilisateur et mot de passe.

Menu utilisateur : Affiche un message de bienvenue et l'image de profil de l'utilisateur connecté.

Structure du projet :
Classes principales :
ConnectionDB :

Gère la connexion à la base de données MySQL.

Fournit des mécanismes de gestion des erreurs.

Login :

Interface utilisateur pour la connexion.

Vérifie les informations de l'utilisateur dans la base de données.

Register :

Interface utilisateur pour l'inscription.

Vérifie la validité des informations avant de les enregistrer dans la base de données.

Menu :

Affiche un message de bienvenue et une image de profil pour l'utilisateur connecté.

Technologies utilisées :
Java : Langage de programmation principal.

Swing : Utilisé pour créer l'interface utilisateur.

MySQL : Base de données pour stocker les informations des utilisateurs.

JDBC : Permet la connexion entre Java et MySQL.

Configuration requise :
JDK 8 ou supérieur.

Serveur MySQL avec une base de données nommée users et une table users contenant les colonnes suivantes :

name : Nom de l'utilisateur (VARCHAR).

username : Nom d'utilisateur (VARCHAR).

password : Mot de passe (VARCHAR).

phone : Numéro de téléphone (VARCHAR).

mail : Adresse email (VARCHAR).

gender : Genre (VARCHAR).

image : Image de profil (BLOB).

Installation :
Clonez ce projet : git clone https://github.com/Mihary09/GestionUtilisateurs

Configurez la base de données MySQL et mettez à jour l'URL, le nom d'utilisateur et le mot de passe dans la classe ConnectionDB.

Compilez et exécutez les fichiers Java :

bash
javac *.java
java Login
