# Bun is our primary dependency, the rest comes from node modules.
FROM oven/bun:1-slim

# Get curl to perform a health check.
# NOTE: We could do the following:
# bun repl --eval "let response; try { response = (await fetch('http://localhost:5173')).status; } catch { process.exit(response == 200 ? 0 : 1); }"
RUN apt-get update && DEBIAN_FRONTEND=noninteractive apt-get -qq -y install curl

# Move the source code and ourselves into the /app directory
COPY .. /app
WORKDIR /app

# Install dependencies.
RUN bun install
