./clearallcontainers.sh
./generate_jwtKeys.sh
cd island-report
mvn clean compile package
cd ../techfields-jwt
mvn clean compile package
cd ../
docker-compose up