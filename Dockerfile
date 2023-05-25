FROM postgres:15.1-alpine

LABEL author="Mourad-Rana"
LABEL description="Postgres Image for project"
LABEL version="1.0"

COPY *.sql /docker-entrypoint-initdb.d/