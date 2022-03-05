#build file
#sudo ./mvnw package && java -jar target/shopping-0.0.1-SNAPSHOT.jar -Dmaven.test.skip
sudo ./mvnw install -Dmaven.test.skip


#build docker 
docker build -t shopping.jar .
#run on docker container
#docker run -p 8080:8080 shopping:latest --net shopping-net
