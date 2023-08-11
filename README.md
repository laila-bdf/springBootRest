# springBootRest
Mise en place d'une application REST avec Spring Boot comprenant :

L'application est capable de lire un fichier au format .CSV lors de son démarrage, afin de créer une liste d'objets (1 objet par ligne).

Elle inclue les fonctionnalités suivantes :

Une API de type "GET" qui renvoie une liste d'objets au format JSON.
Une API de type "POST" qui permet d'ajouter un objet à la base de données en le passant en tant que paramètre.
Une autre API de type "POST" qui offre la possibilité d'ajouter un objet à la base de données en générant des valeurs aléatoires.
La documentation est accessible via Swagger UI.

L'application est empaquetée sous forme de fichier WAR.

Toutes les trois APIs sont testables via l'interface Swagger UI.

L'application est développée en Java 11.
