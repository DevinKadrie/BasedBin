# All we need is the JDK, since gradelw downloads gradle.
FROM openjdk:17-jdk-slim

# Get curl to perform a health check.
RUN apt-get update && DEBIAN_FRONTEND=noninteractive apt-get -qq -y install curl dos2unix

# Move the source code and ourselves into the /app directory
COPY . /app
WORKDIR /app

# Install our runner script.
COPY docker/run.sh /app/run.sh
RUN chmod +x /app/run.sh
RUN find /app  -print0 | xargs -0 dos2unix
