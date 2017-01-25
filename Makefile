CLASSES = \
TCPClient.java \
TCPThread.java \
UDPClient.java \
UDPserver.java \
web.java \
TCPServer.java 

#JFLAGS=-g
# 设置你的java编译器
# Set your java compiler here:
JC = javac

.SUFFIXES:.java .class
.java.class:
	$(JC)$(JFLAGS) $*.java

default: classes

classes:$(CLASSES:.java=.class)

clean:
	rm -f *.class
