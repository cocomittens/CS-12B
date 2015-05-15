# Name: Corrie Gripenstraw
# ID: 1381682
# Class: CMPS 12B
# Date: Oct 29, 2014
# Filename: Makefile
# Description: Compiles Calc.java and compiles and runs the unit test CalcTest.java

JAVASRC = Calc.java
MAINCLASS = Calc
CLASSES = Calc.class
TESTSRC = CalcTest.java
TEST = CalcTest

all: ${CLASSES}

CalcTest: ${TESTSRC}
	javac -cp "junit-4.12-beta-2.jar:hamcrest-core-1.3.jar:." ${TESTSRC}
	java -cp "junit-4.12-beta-2.jar:hamcrest-core-1.3.jar:." org.junit.runner.JUnitCore ${TEST}

${CLASSES}: ${JAVASRC}
	javac -Xlint ${JAVASRC}

clean:
	rm ${CLASSES} ${JARFILE}

.PHONY: clean all CalcTest
