FROM tomcat:latest
ADD target/ROOT.war /usr/local/tomcat/webapps/
EXPOSE 80
CMD ["catalina.sh", "run"]