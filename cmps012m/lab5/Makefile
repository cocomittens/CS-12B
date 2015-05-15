# Name: Corrie Gripenstraw
# ID: cgripens
# Class: CMPS 12B
# Date: Nov 17, 2014
# Filename: Makefile
# Description: Makefile for lab 5

CC = gcc
CFLAGS = -std=c99 -Wall -Werror -Wfatal-errors -g
OBJS = list.o
OUTPUT = list
HEADERS = minunit.h

${OUTPUT}: ${OBJS}
	${CC} $< -o ${OUTPUT}

%.o: %.c ${HEADERS}
	${CC} -c ${CFLAGS} $<

clean:
	rm -f *.o

spotless: clean
	rm -f ${OUTPUT}

test: ${OUTPUT}
	./${OUTPUT}

.PHONY: clean spotless test

