# Use uma imagem base do Java 17
FROM eclipse-temurin:17-jre

# Argumento para o nome do JAR
ARG JAR_FILE=target/*.jar

# Copia o JAR para dentro do container
COPY ${JAR_FILE} app.jar

# Porta padrão (ajuste se necessário)
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]