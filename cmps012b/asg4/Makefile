# Makefile for Programming Assignment 2

JAVASRC    = cyoa.java room.java
SOURCES    = ${JAVASRC} Makefile README
MAINCLASS  = cyoa
CLASSES    = cyoa.class room.class
JARCLASSES = ${CLASSES}
JARFILE    = cyoa
SUBMITDIR  = cmps12b-nojw.f14 asg4

all : ${JARFILE}

${JARFILE} : ${CLASSES}
	echo "Main-class: ${MAINCLASS}" >Manifest
	jar cvfm ${JARFILE} Manifest ${JARCLASSES}
	chmod +x ${JARFILE}
	rm Manifest

%.class : %.java
	javac -Xlint $<

clean :
	rm -f *.class Manifest

spotless : clean
	rm -f ${JARFILE}

submit : ${SOURCES}
	submit ${SUBMITDIR} ${SOURCES}

.PHONY:all clean spotless submit
