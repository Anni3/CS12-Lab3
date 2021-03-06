#Annie Volovik
#1260637
#CMPS12B/m
#10/26/2014

JFLAGS = -g
JFLAGSCP = -cp
JC = javac
JVM = java
JUNITJAR = "junit-4.12-beta-1.jar:hamcrest-core-1.3.jar:."
JUNITVAR = org.junit.runner.JUnitCore
.SUFFIXES:  .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = Calc.java

default: classes

classes: $(CLASSES:.java=.class)

JAVATEST= CalcTest

test: UnitTest

UNITTESTCLASSES = CalcTest.java

UnitTest: 	
	$(JC) $(JFLAGSCP) $(JUNITJAR) $(UNITTESTCLASSES)
	java -cp $(JUNITJAR) $(JUNITVAR) $(JAVATEST)

clean:
	$(RM) *.class
