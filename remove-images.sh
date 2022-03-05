docker ps -q --filter "name=postgresql-container" | grep -q . && docker stop postgresql-container && docker rm -fv postgresql-container
