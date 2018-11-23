FROM postgres:9.4-alpine
ENV POSTGRES_PASSWORD: 1234
ENV POSTGRES_DB: ticketsystem
ADD 1ticketsystemdb.sql /docker-entrypoint-initdb.d
ADD 2ticketsystemdatos.sql /docker-entrypoint-initdb.d

