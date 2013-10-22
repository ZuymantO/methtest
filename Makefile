CMP=scalac-2.10
JVM=scala-2.10
LIB=scalatest.jar
all: cmp ss te

cmp: $(LIB)
	$(CMP) -cp $< *.scala

ss:
	$(JVM) -cp $(LIB) org.scalatest.run mt.ss.StringSetTest

te:
	$(JVM) -cp $(LIB) org.scalatest.run mt.te.TEngineTest

me:
	$(JVM) -cp $(LIB) org.scalatest.run mt.me.AExprTest
