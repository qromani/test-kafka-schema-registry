
build:
	rm -rf build-proto/*
	mkdir -p build-proto
	# protoc -I=$(PWD) --java_out=build-proto --kotlin_out=build-proto my-message.proto
	protoc -I=$(PWD) --java_out=build-proto my-message.proto
	cp -R build-proto/* demo-producer/src/main/kotlin/