class OvalFruit(weight : Int) extends Fruit(weight) {
  override var right: Option[Fruit] = None
  override var left: Option[Fruit] = None
  override def getType(): String = "Oval Fruit"
}
