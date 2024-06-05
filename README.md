
# Accéder aux services sur votre naviguateur ou Postman

Service Calendar : http://localhost:8080

Service Planning : http://localhost:8081

Service Site : http://localhost:8083

API Gateway : http://localhost:8082

Documentation Swagger pour Calendar : http://localhost:8080/swagger-ui/index.html

Documentation Swagger pour Planning : http://localhost:8081/swagger-ui/index.html

Documentation Swagger pour Site : http://localhost:8082/swagger-ui/index.html

# Example comment deployer et executer un service

## Requis

- Docker
- Minikube

1. Accéder [site-service/src/k8s](https://github.com/thienkonphap/olympic-2024/tree/main/sites-service/k8s)
2. Executer le script

```sh
./script.sh
```
3. Accéder au document de service avec l'adresse: http://127.0.0.1:54650/swagger-ui/index.html

   ![Screenshot 2024-06-04 at 21 52 26](https://github.com/thienkonphap/olympic-2024/assets/79655393/9a91623f-ec20-4d61-9485-42df4877d651)


