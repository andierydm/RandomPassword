import java.lang.StringBuilder
import kotlin.random.Random

fun gen(len: Int): String {
    if (len < 8 || len > 32)
        return ""

    val random = Random(System.nanoTime())
    val password = StringBuilder()
    val symRanges = arrayOf(arrayOf(33, 64), arrayOf(91, 96), arrayOf(123, 126))
    val letterRanges = arrayOf(arrayOf(65, 90), arrayOf(97, 122))

    for (x in 0 until len) {
        val symRang = symRanges[random.nextInt(symRanges.size)]
        val symIndex = random.nextInt(symRang[0], symRang[1] + 1)

        val letterRang = letterRanges[random.nextInt(letterRanges.size)]
        val letterIndex = random.nextInt(letterRang[0], letterRang[1] + 1)

        if (System.nanoTime() % 2 == 0L)
            password.append(symIndex.toChar())
        else
            password.append(letterIndex.toChar())
    }

    return password.toString()
}

fun main() {
    println(gen(16))
}
