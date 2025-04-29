docker compose up

docker exec -it 4f2ad0aee7e0  bash

kafka-topics --bootstrap-server localhost:9092 \
--create --if-not-exists \
--topic transaction_initiation \
--partitions 2 \
--replication-factor 1

kafka-topics --bootstrap-server localhost:9092 --list

docker exec -it 3d833990aef8 mongosh
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
`kafka-console-producer --broker-list localhost:9092 --topic transaction_initiation
`enter below message
{ "transactionId": "txn_ABC123", "amount": 500.00, "sender": "123456710", "receiver": "987654322" }
{ "transactionId": "txn_ABC123", "amount": 200.00, "sender": "123456711", "receiver": "987654322" }
{ "transactionId": "txn_ABC123", "amount": 300.00, "sender": "123456711", "receiver": "987654322" }
{ "transactionId": "txn_ABC123", "amount": 300.00, "sender": "123456711", "receiver": "987654322" ,status:"F" }

{"uuid":"123e4567-e89b-12d3-a456-426614174000","account":{"accountId":1,"accountHolderName":"John Doe","accountType":"SAVINGS","branchName":"Main Branch","ifscCode":"IFSC0001"},"benefetryAccount":{"accountId":2,"accountHolderName":"Jane Smith","accountType":"CURRENT","bankName":"XYZ Bank","branchName":"Downtown Branch","ifscCode":"IFSC0002","balance":10000.50},"transactionType":"IMPS","amount":501.75,"timeStamp":"2025-04-14T10:30:00","balenceCheckStatus":true,"transLimitChkStatus":true,"status":"F"}

docker build -t realtime-transaction-tracker:4 .
docker tag realtime-transaction-tracker:4 bikashhasmobile/realtime-transaction-tracker:4.0.0
docker push bikashhasmobile/realtime-transaction-tracker:4.0.0

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

docker-compose up -d --force-recreate --no-deps realtime-transaction-tracker`
docker-compose up -d --force-recreate --no-deps realtime-transaction-tracker
