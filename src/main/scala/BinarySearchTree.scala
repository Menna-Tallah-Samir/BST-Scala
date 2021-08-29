import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks._

class BinarySearchTree {
  var root : Option[Fruit] = None

  def insert(value : Fruit):Unit={
    if(value==null){
      return
    }

    var currentNode = root
    var node : Option[Fruit] = None;

    currentNode match {
      case None => root = Some(value)
      case Some(_) =>
        while(currentNode!=None){
          value.compare(currentNode.get).sign match{
            case 0 =>
              value.left = currentNode.get.left
              value.right = currentNode.get.right
              currentNode = None
            case -1 =>
              node = currentNode
              currentNode = currentNode.get.left
            case _ =>
              node = currentNode
              currentNode = currentNode.get.right
          }
        }

        if(node==None){
          root = Some(value)
        }else{
          value.compare(node.get).sign match{
            case -1 => node.get.left = Some(value)
            case _ => node.get.right = Some(value)
          }
        }
    }
  }


  def delete(node : Fruit):Unit={
    var current : Option[Fruit] = root
    var prev : Option[Fruit] = None

    if(current == None){
      return
    }

    while(current != None && node.compare(current.get)!=0){
      prev = current
      node.compare(current.get).sign match{
        case -1 => current = current.get.left
        case 1 => current = current.get.right
      }
    }

    if(current==None){
      return
    }

    if(current.get.left == None && current.get.right==None){
      if(prev==None){
        root = None
        return
      }

      if(prev.get.left==current){
        prev.get.left = None
      }else{
        prev.get.right = None
      }

    }else if(current.get.left == None || current.get.right==None){
      var newCurrent : Option[Fruit] = None
      if(current.get.left == None){
        newCurrent = current.get.right
      }else{
        newCurrent = current.get.left
      }

      if(prev==None){
        root = newCurrent
        return
      }

      if(prev.get.left == current){
        prev.get.left = newCurrent
      }else{
        prev.get.right = newCurrent
      }

    }else{
      var successor : Option[Fruit] = getSuccessor(current)
      delete(successor.get)

      if(prev==None){
        root = successor
      }else{
        if(prev.get.right == current){
          prev.get.right = successor
        }else{
          prev.get.left = successor
        }
      }

      successor.get.left = current.get.left

      if(current.get.right!=successor){
        successor.get.right = current.get.right
      }
    }

    current.get.right = None
    current.get.left = None
  }


  def getSuccessor(node : Option[Fruit]): Option[Fruit]={
    var current : Option[Fruit] = None
    var prev : Option[Fruit] = None

    if(node.get.right!=null){
      current = node.get.right
    }

    Some(leftMost(current))
  }


  def getLargestWeight(): Fruit={
    rightMost(root)
  }


  def rightMost(node : Option[Fruit]): Fruit={
    if(node==None){
      return null
    }

    if(node.get.right==None){
      return node.get
    }else{
      return rightMost(node.get.right)
    }
  }


  def getLeastWeight(): Fruit={
    leftMost(root)
  }


  def leftMost(node : Option[Fruit]): Fruit={
    if(node==None){
      return null
    }

    if(node.get.left==None){
      return node.get
    }else{
      return leftMost(node.get.left)
    }
  }


  def getElements(): List[Fruit]={
    var result : ListBuffer[Fruit] = ListBuffer()
    InOrderTraverse(root,result)
    result.toList
  }


  def InOrderTraverse(node : Option[Fruit],result : ListBuffer[Fruit]): Unit={
      if(node==None){
        return
      }

      InOrderTraverse(node.get.left,result)
      result += node.get
      InOrderTraverse(node.get.right,result)
  }
}
