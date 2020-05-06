package subtask4

import kotlin.math.pow
import kotlin.math.sqrt

class SquareDecomposer {

    fun decomposeNumber(number: Int) = members(number * number, number - 1)

    private fun members(square: Int, rootSquare: Int): Array<Int>? {
        if (sqrt(square.toDouble()) < 1) return null

        for (currentRoot in rootSquare downTo 1) {
            val remain = square - currentRoot * currentRoot

            if (remain < 0) return null

            if (remain == 0) return arrayOf(currentRoot)

            val nextSquare = sqrt(remain.toDouble()).toInt()
            val nextSquareRoot =
                if (nextSquare >= currentRoot) members(remain, currentRoot - 1)
                else members(remain, nextSquare)

            if (nextSquareRoot?.isNotEmpty() == true) return nextSquareRoot + arrayOf(currentRoot)
        }

        return null
    }
}
