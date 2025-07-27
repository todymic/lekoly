# Utilise une image Java officielle comme base
FROM eclipse-temurin:24-jdk-alpine

# Installe les outils nécessaires pour Maven Wrapper
RUN apk add --no-cache curl bash

# Définit le répertoire de travail dans le conteneur
WORKDIR /app

# Copie le fichier pom.xml et les dépendances Maven
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

# Télécharge les dépendances (mise en cache des layers Docker)
RUN ./mvnw dependency:go-offline -B

# Copie le code source
COPY src src

# Compile l'application
RUN ./mvnw clean package -DskipTests

# Expose le port de l'application
EXPOSE 8080

# Commande pour démarrer l'application
CMD ["java", "-jar", "target/lekoly-0.0.1-SNAPSHOT.jar"]