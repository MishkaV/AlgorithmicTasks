import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails

class BracketsCheckTests {
    companion object {
        val testExceptionsList = listOf(
            "",
            "               ",
            "askdnkjansdasdlmasd",
            "(((a)))",
            "{{)"
        )

        val testBracketsList = mapOf(
            true to "((((()))))",
            true to "({[]})",
            false to "(()"
        )
    }

    @Test
    fun checkBracketsTest() {
        testExceptionsList.forEach { item ->
            assertFails {
                checkBrackets(item)
            }
        }
        for ((key, item) in testBracketsList) {
            assertEquals(
                expected = key,
                actual = checkBrackets(item)
            )
        }
    }
}