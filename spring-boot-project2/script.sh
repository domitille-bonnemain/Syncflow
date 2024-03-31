# Commandes

# Start Backend
echo "Starting Backend..."
cd spring-boot-project2/spring-boot-project2/
./mvnw spring-boot:run &

# Attendre un court instant pour laisser le backend démarrer
sleep 10

# Test Backend
echo "Testing Backend..."
curl http://localhost:8080/demo/all

# Arrêter le Backend (vous pouvez remplacer cela par une autre commande appropriée)
echo "Stopping Backend..."
# Vous pouvez remplacer cette ligne par une commande pour terminer le processus de Maven

# Start Frontend
echo "Starting Frontend..."
cd frontend
npm run serve
