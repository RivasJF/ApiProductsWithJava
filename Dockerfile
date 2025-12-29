FROM eclipse-temurin:21-jre-alpine

RUN adduser -D appuser
USER appuser

WORKDIR /app
COPY target/ServicioProductos-1.0.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]
