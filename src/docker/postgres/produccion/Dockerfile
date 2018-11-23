FROM debian:9.6

RUN wget https://download.oracle.com/otn-pub/java/jdk/8u191-b12/2787e4a523244c269598db4e85c51e0c/jdk-8u191-linux-x64.tar.gz
RUN mkdir /home/jdk
RUN tar -xzvf jdk-8u191-linux-x64.tar.gz /home/jdk

RUN apt install git -y

RUN git clone https://dm97:okEstesoyyo97@bitbucket.org/dm97/ticketsystem.git
RUN cd ticketsystem
RUN ./mvnw spring-boot:run
