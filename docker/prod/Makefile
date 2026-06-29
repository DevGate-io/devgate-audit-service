DOCKER_COMPOSE = docker compose
COMPOSE_FILE = ./compose.yaml

up: down build-app
	$(DOCKER_COMPOSE) -f $(COMPOSE_FILE) up --build -d

start: down
	$(DOCKER_COMPOSE) -f $(COMPOSE_FILE) up -d

down:
	$(DOCKER_COMPOSE) -f $(COMPOSE_FILE) down

seed:
	$(DOCKER_COMPOSE) -f $(COMPOSE_FILE) exec -T -e PGPASSWORD=devgate-audit db psql -U postgres -d audit < ./seed.sql

build-app:
	cd ../.. && ./gradlew bootJar