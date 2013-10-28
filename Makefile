CMP=scalac-2.10
JVM=scala-2.10
LIB=scalatest.jar
all: cmp ss te in

cmp: $(LIB)
	$(CMP) -cp $< *.scala
	javac -cp .:./* -encoding latin1 *.java
ss:
	$(JVM) -cp $(LIB) org.scalatest.run mt.ss.StringSetTest

te:
	$(JVM) -cp $(LIB) org.scalatest.run mt.te.TEngineTest

me:
	$(JVM) -cp $(LIB) org.scalatest.run mt.me.AExprTest
cmpin:	
	javac -cp .:./* -encoding latin1 *.java
in:	
	java -cp .:./* TestUnit
clear:
	rm *.class 
	rm \#*\#