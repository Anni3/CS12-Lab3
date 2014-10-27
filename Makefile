//Annie Volovik
//1260637
//CMPS12B/m
//10/26/2014

JFLAGS = -g
JC = javac
JVM= java
FILE=
.SUFFIXES:  .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java
CLASSES = \
	Calc.java \
	CalcTest.java
default: classes
classes: $(CLASSES:.java=.class)
run: $(MAIN).class
	$(JVM) $(MAIN)
java -cp "junit-4.12-beta-1.jar:hamcrest-core-1.3.jar:." org.junit.runner.JUnitCore
CalcTest
clean:
	$(RM) *.class
