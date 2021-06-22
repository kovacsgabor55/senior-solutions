mvnw clean package
docker build -t locations .
docker run -d -p 8080:8080 --name my-locations locations
