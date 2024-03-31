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

# Arrêter le Backend 
echo "Stopping Backend..."


# Start Frontend
echo "Starting Frontend..."
cd frontend
npm run serve
