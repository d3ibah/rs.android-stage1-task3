package subtask3

class ArrayCalculator {

    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        val items: MutableList<Int> = mutableListOf()

        itemsFromArray.forEach {
            if (it::class == Int::class) items.add(it as Int)
        }

        if (items.isEmpty()) return 0

        var result = 1

        if (numberOfItems >= items.size) {
            items.forEach {
                result *= it
            }

            return result
        }

        items.sortDescending()

        if (numberOfItems % 2 == 1) {
            result *= items.first()
            items.removeAt(0)
        }

        val tempResults = mutableListOf<Int>()
        var nextIndex = 1
        items.forEachIndexed { index, item ->
            if (index != nextIndex && nextIndex < items.size) tempResults.add(item * items[nextIndex])
            ++nextIndex
        }
        tempResults.toMutableSet().toMutableList()
        tempResults.sortDescending()

        if (tempResults.isNotEmpty()) {
            tempResults.forEachIndexed { index, item ->
                if (index < numberOfItems / 2) {
                    result *= item
                }
            }

            return result
        }

        return result
    }
}
