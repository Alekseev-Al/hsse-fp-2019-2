import scala.io.StdIn.{readChar} 
object Main {
  def main(args: Array[String]) {
    val wordlist = new Wordlist
    val word = wordlist.getWord

    var game = new Game(word)
    var isOver = false

    while (!isOver) {
      println
      println(game)

      print("Next guess (Ctrl-D to quit): ")
      val ich = readChar() 
      isOver = (ich == 4)
      println

      if (!isOver) {
        val ch = ich.toChar
        game = game.next(ch)
        isOver = game.isOver
      }
    } 

    println
    println(game.answer)
    println

    println(if (game.isWin) "Victory!!!" else "Man was hanged!!!")
    println
  }
}