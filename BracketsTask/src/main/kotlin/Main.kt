/**
 * Just main with example of checkBrackets works
 *
 * @author Vorozhtsov Misha
 */
fun main() {
    val exmp = "({[([])]})"
    println("The sequence of brackets $exmp is ${checkBrackets(exmp)}")
}