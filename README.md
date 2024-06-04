Lancer les services : 


Assurez-vous d'avoir Docker et Docker Compose installés sur votre machine.

Étapes pour lancer les services : 
1. Cloner le dépôt

Copier et coller le code sur votre terminal :
git clone https://github.com/thienkonphap/olympic-2024.git

cd olympic-2024

2. Construire les images Docker

Copier et coller le code : 
docker-compose build

3. Démarrer les services

Copier le code : 
docker-compose up

4. Accéder aux services sur votre naviguateur ou Postman

Service Calendar : http://localhost:8080

Service Planning : http://localhost:8081

Service Site : http://localhost:8082

Documentation Swagger pour Calendar : http://localhost:8080/swagger-ui/index.html

Documentation Swagger pour Planning : http://localhost:8081/swagger-ui/index.html

Documentation Swagger pour Site : http://localhost:8082/swagger-ui/index.html

5. Arrêter les services
Pour arrêter les services, utilisez la commande :

docker-compose down
