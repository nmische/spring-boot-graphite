build-docker:
	docker build -t example/spring-boot-graphite .

run: build-docker
	docker-compose up
