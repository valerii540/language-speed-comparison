import scala.io.Source
import scala.collection.mutable
import scala.collection.immutable

object Main extends App {
  
  val file =  Source.fromFile("../input_data.txt")
  val lines = file.getLines
  val size = lines.next.toInt

  val buffer = mutable.ListBuffer.empty[Int]
  for (_ <- (1 to size)) buffer += lines.next.toInt
  
  file.close()

  val data = immutable.ArraySeq.from(buffer)

  println(s"${data.length} integers have been loaded into memory")

  val tic = System.nanoTime
  data.sorted
  val toc = System.nanoTime

  val elapsed = ((toc - tic) / 1_000_000_000d)
  println(f"\n==> sorted in $elapsed%.2f seconds <==")
}