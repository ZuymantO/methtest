/**
 * MethTest
 * mt.te
 * TEngineTest.scala
 * (c)JC on 21 oct. 2013 00:32:34
 *
 */
package mt.te

import org.scalatest.BeforeAndAfterEach
import org.scalatest.FlatSpec

/**
 * @author JC
 *
 */
class TEngineTest  extends FlatSpec with BeforeAndAfterEach {

  private var ste:TEngine = _
  private var sste:TEngine = _
  private var scte:TEngine = _
  private var cte:TEngine = _

  override def beforeEach() {
    ste   = new TEngine("Simple texte with out any variable", Map())
    sste   = new TEngine("Simple texte with $one simple variable", Map("one" -> "my")) 
    scte   = new TEngine("Simple texte with ${$any} complex variable", Map("any" -> "some", "some" -> "my own"))
    cte   = new TEngine("""
        Simple texte with $first simple follow by a ${$complex} one 
        and an other ${${$var}} one variable
        """, Map("first" -> "Premier", "complex" -> "olala", "olala" -> "Compliqué",
            "var" -> "variable", "variable" -> "change", "change" -> "Arrivé"))
   }

   // Close and delete the temp file
   override def afterEach() {
    ste = null
    sste = null
    scte = null
    cte = null
    
   }

   
   "A Simple Template Engine" should "recognize well formed template string" in {
  }

   it should "returns a not null string value for any entries" in {
     assert(false)
   }

   it should "raise exception when variable does not exists" in {
     assert(false)
   }

   it should "evaluate simple single variable expression" in {
     assert(false)
   }

   it should "evaluate simple multiple variables expression" in {
     assert(false)
   }

   it should "evaluate complexe single variable expression" in {
     assert(false)
   }

   it should "evaluate complexe multiple variables expression" in {
     assert(false)
   }

   it should "evaluate simple and complexe cases expression" in {
     assert(false)
   }
}