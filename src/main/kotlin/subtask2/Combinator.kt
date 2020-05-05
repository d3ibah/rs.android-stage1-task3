package subtask2

class Combinator {

    fun checkChooseFromArray(array: Array<Int>): Int? {
        val c = array[0]
        val n = array[1]
        var bruteforceC: Long = 0
        var k: Int = 0

        for (i in 1..n) {
            k = i
            bruteforceC = factorial(n) / (factorial(n - k) * factorial(k))

            if (bruteforceC == c.toLong()) return k

            if (bruteforceC > c) return k
        }

        if (bruteforceC > c) return k else return null
    }

    fun factorial(n: Int): Long = if (n < 2) 1 else n * factorial(n - 1)
}
