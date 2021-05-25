clean:
	mvn clean

package: clean
	mvn package

build-docker: package
	docker build --build-arg JAR_FILE=target/\*.jar -t example/spring-boot-graphite .

run: build-docker
	docker-compose up

