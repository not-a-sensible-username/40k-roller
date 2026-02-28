


#default make command, easy to change
default: build

#compiles the project into the bin
build: 
	
	javac src/**/*.java -cp "lib/*:src" -d bin


#runs the main application
run: 
	java -cp bin main/Main

#runs all tests
test:
	java -jar lib/* execute --class-path bin --scan-class-path

#creates docs
docs: clearD
	javadoc src/**/*.java -d docs

#clears both the bin and the docs
clear: clearB clearD
	
#clears the bin	
clearB:
	rm -fr bin


#clears the docs
clearD:
	rm -fr docs



