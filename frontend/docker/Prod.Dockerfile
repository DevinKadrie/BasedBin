FROM oven/bun:latest AS builder

COPY .. /build
WORKDIR /build

RUN bun install
RUN bun run build

FROM nginx:latest

COPY --from=builder /build/dist /usr/share/nginx/html
