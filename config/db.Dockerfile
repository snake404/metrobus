FROM postgres:12-alpine
EXPOSE 5432
COPY *.sql /docker-entrypoint-initdb.d/