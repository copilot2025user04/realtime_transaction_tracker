docker compose up

docker exec -it 7087ccfd10d3 bash

kafka-topics --bootstrap-server localhost:9092 \
--create --if-not-exists \
--topic transaction_initiation \
--partitions 2 \
--replication-factor 1

kafka-topics --bootstrap-server localhost:9092 --list


docker exec -it e6d6676f0fce mongosh
use mybank
db.createCollection("withdrawals", {
timeseries: {
timeField: "timestamp",
metaField: "accountNumber",
granularity: "seconds"
}
});

db.withdrawals.insertOne({
accountNumber: "1234567890",            
timestamp: ISODate("2025-04-10T14:32:00Z"),
amount: 500,
status: "SUCCESS",
transactionId: "TXN123XYZ"
});

db.withdrawals.find({}).pretty()
db.withdrawals.find({accountNumber: "1234567890"}).pretty()
db.withdrawals.find({accountNumber: "1234567890", status: "SUCCESS"}).pretty()
db.withdrawals.find({accountNumber: "123457"}).pretty()
kafka-console-producer --broker-list localhost:9092 --topic transaction_initiation
enter below message 
{"accountNumber":"123456","amount":100.0,"timestamp":"2025-04-10T12:00:00Z"}

docker build -t realtime-transaction-tracker:3 .
docker tag realtime-transaction-tracker:3 bikashhasmobile/realtime-transaction-tracker:1.0.0
docker push bikashhasmobile/realtime-transaction-tracker:1.0.0

minikube start --memory=6144 --cpus=2 --disk-size=20g
minikube addons enable ingress
kubectl apply -f k8s-deployment.yaml
kubectl get pods
kubectl get svc
kubectl get pvc

kubectl logs deployment/realtime-transaction-tracker

kubectl logs kafka-75fbccc55d-kpf6z

minikube service <service-name>
minikube pause
minikube stop
minikube delete
