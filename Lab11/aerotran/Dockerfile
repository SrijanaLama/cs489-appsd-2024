# Using OpenJDK version 17 as the base image
FROM openjdk:17
# Create a new app directory in the container for the application files
RUN mkdir /app
# Copy the compiled executable files/folders from host machine filesystem to the container/image's filesystem
COPY build/libs/aerotran-0.0.1-SNAPSHOT.jar /app
# Set the working directory for where next commands will execute at
WORKDIR /app
EXPOSE 8080
# Define the command to run the app when the contain is started
CMD ["java", "-jar", "./aerotran-0.0.1-SNAPSHOT.jar"]

# FROM openjdk:17

# RUN mkdir /app

# COPY aerotran-0.0.1-SNAPSHOT.jar /app/app.jar

# WORKDIR /app

# EXPOSE 8080
# ENTRYPOINT ["java", "-jar", "app.jar"]
