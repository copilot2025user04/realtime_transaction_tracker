#!/bin/bash

# Wait for Kafka and MongoDB to be ready
echo "Waiting for Kafka and MongoDB to be ready..."
sleep 10

# Create Kafka topic
echo "Creating Kafka topic 'transaction_initiation'..."
docker exec -it $(docker ps -qf "name=kafka") kafka-topics --bootstrap-server localhost:9092 \
  --create --if-not-exists \
  --topic transaction_initiation \
  --partitions 2 \
  --replication-factor 1

# Create MongoDB collection
echo "Creating MongoDB collection 'withdrawals'..."
docker exec -it $(docker ps -qf "name=mongo-db") mongosh --eval '
use mybank;
if (!db.getCollectionNames().includes("withdrawals")) {
  db.createCollection("withdrawals", {
    timeseries: {
      timeField: "timestamp",
      metaField: "accountNumber",
      granularity: "seconds"
    }
  });
}

echo "Setup complete."