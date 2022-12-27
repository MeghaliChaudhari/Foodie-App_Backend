FROM openjdk
WORKDIR usr/lib
ENV MONGO_DATABASE="cart_service"
ENV MONGO_URL="mongodb://localhost:27017/cart_service"
ADD ./target/cart-service-0.0.1-SNAPSHOT.jar /usr/lib/cart-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","cart-service-0.0.1-SNAPSHOT.jar"]