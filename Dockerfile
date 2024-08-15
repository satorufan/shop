FROM openjdk:17-jdk-slim
ENV APP_HOME=/app/
WORKDIR ${APP_HOME}
RUN chmod +x gradlew
RUN ./gradlew clean build
COPY build/libs/*.jar shop.jar
RUN mkdir -p /app/shop/item
RUN chmod -R +w /app/shop 
EXPOSE 9898
CMD ["java", "-jar", "shop.jar"]