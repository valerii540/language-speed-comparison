import scala.io.Source
import scala.collection.mutable
import scala.collection.immutable

object Main {

  def main(args: Array[String]): Unit = { 
    if (args.length < 1) throw new Exception("Argument hasn't been provided")

    val file         = Source.fromFile("../input_data.txt")
    val lineIterator = file.getLines.iterator
    val size         = lineIterator.next.toInt
  
    val buffer = new Array[Int](size)
    for (i <- (0 until size)) buffer(i) = lineIterator.next.toInt

    file.close()
    
    val data = getDataStructure(args.head, buffer)

    println(f"${data.length} integers have been loaded into ${args.head}")

    val tic = System.nanoTime
    data.sorted
    val toc = System.nanoTime

    val duration = (toc - tic) / 1_000_000f
    println(f"\n==>$duration%.2f")
  } 

  def getDataStructure(desired: String, data: Array[Int]): scala.collection.Seq[Int] = 
    desired match {
      case "list"         => immutable.List.from(data)
      case "vector"       => immutable.Vector.from(data)
      case "java_array"   => Array.from(data)
      case "array_seq"    => immutable.ArraySeq.from(data)
      case "list_buffer"  => mutable.ListBuffer.from(data)
      case "m_array_seq"  => mutable.ArraySeq.from(data)
      case "array_buffer" => mutable.ArrayBuffer.from(data)
    }
}