.PHONY: build start

build:
	./gradlew --status
	./gradlew build

start:
	./gradlew run