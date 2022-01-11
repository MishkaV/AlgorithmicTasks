/**
 * Simple checks for input string: is it empty or blank and check all characters in string -
 * they should be brackets
 *
 * @exception Exception if empty string
 * @exception Exception if bad character
 * @author Vorozhtsov Misha
 */
fun simpleChecksForString(str: String) {
    val bracketsList = arrayListOf('(', ')', '{', '}', '[', ']')

    if (str.isEmpty() || str.isBlank())
        throw Exception("Empty string")
    str.forEach { bracket ->
        if (bracket !in bracketsList)
            throw Exception("Bad character")
    }
}

/**
 * CheckBrackets function need to understand is the sequence of brackets
 * correct (each open bracket has its own closed one) or not
 *
 * @exception Exception if not enough open brackets
 * @author Vorozhtsov Misha
 */
fun checkBrackets(str: String): Boolean {
    var roundBracket = 0
    var curlyBracket = 0
    var squareBracket = 0

    simpleChecksForString(str)

    str.forEach { bracket ->
        when (bracket) {
            '(' -> roundBracket++
            '{' -> curlyBracket++
            '[' -> squareBracket++
            ')' -> if (roundBracket > 0) roundBracket-- else throw Exception("Not enough open brackets for $bracket")
            '}' -> if (curlyBracket > 0) curlyBracket-- else throw Exception("Not enough open brackets for $bracket")
            ']' -> if (roundBracket > 0) squareBracket-- else throw Exception("Not enough open brackets for $bracket")
        }
    }
    if (roundBracket != 0 || curlyBracket != 0 || squareBracket != 0)
        return false
    return true
}
