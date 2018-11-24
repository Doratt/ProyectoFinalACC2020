FROM debian:9.6

RUN apt update
RUN apt install openjdk-8-jdk -y

RUN apt install git -y
RUN cd /home/ && git clone https://dm97:okEstesoyyo97@bitbucket.org/dm97/ticketsystem.git && cd ticketsystem && ./mvnw spring-boot:run
