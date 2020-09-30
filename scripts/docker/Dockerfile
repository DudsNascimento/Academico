FROM openjdk:13-alpine
RUN mkdir /opt/Academico
COPY Academico.jar /opt/Academico
COPY start-academico.sh /opt/Academico
ENTRYPOINT ["sh", "/opt/Academico/start-academico.sh"]