abstract class Fruit(var weight : Int) extends Ordered[Fruit]{
  override def compare(that: Fruit): Int = this.weight - that.weight
  var right : Option[Fruit]
  var left : Option[Fruit]
  def getType(): String = "Fruit"
  def printFruit():Unit={
    println("type = "+this.getType()+" weight = "+this.weight)
  }
}
