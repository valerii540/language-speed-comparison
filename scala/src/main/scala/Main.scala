import scala.io.Source
import scala.collection.mutable
import scala.collection.immutable

object Main {

  def main(args: Array[String]): Unit = { 
    if (args.length < 1) throw new Exception("Argument hasn't been provided")

    val file =  Source.fromFile("../input_data.txt")
    val lines = file.getLines
    val size = lines.next.toInt
  

    val buffer = mutable.ListBuffer.empty[Int]
    for (_ <- (1 to size)) buffer += lines.next.toInt
  
    file.close()

    val data = getDataStructure(args.head, buffer)

    println(s"${data.length} integers have been loaded into memory")

    val tic = System.nanoTime
    data.sorted
    val toc = System.nanoTime

    val elapsed = ((toc - tic) / 1_000_000_000d)
    println(f"\n==> sorted in $elapsed%.2fs <==")
  } 

  def getDataStructure(desired: String, data: Iterable[Int]): scala.collection.Seq[Int] = 
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