FROM openjdk

WORKDIR /app

COPY target/Cart-0.0.1-SNAPSHOT.jar /app/cart.jar

ENTRYPOINT ["java", "-jar", "cart.jar"]