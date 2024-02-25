# Makefile

# Define the path to the directory containing the Tiltfile
TILTFILE_DIR := infrastructure/kubernetes

# PostgreSQL connection details
PG_HOST := localhost
PG_PORT := 5432
PG_USER := ussms
PG_DB := ssms

# Target to check if PostgreSQL is up
db:
	@echo "Checking if PostgreSQL is up..."
	@pg_isready --host=$(PG_HOST) --port=$(PG_PORT) --username=$(PG_USER) --dbname=$(PG_DB) || (echo "PostgreSQL is not ready. Exiting."; exit 1)

app: db
	cd $(TILTFILE_DIR) && tilt up

down:
	cd $(TILTFILE_DIR) && tilt down --delete-namespaces

# Default target
.PHONY: db app down
