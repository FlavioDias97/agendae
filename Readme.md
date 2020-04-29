access db in cli
docker-compose exec  mysql-development mysql -u root -p root agendae

docker run -t -p 8000:8080 --name dockerize agendae/dockerized-spring
