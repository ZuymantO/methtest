
all: ss te me

ss: run

run: scalatest.jar StringSet.scala StringSetTest.scala
	scalac-2.10 -cp $^