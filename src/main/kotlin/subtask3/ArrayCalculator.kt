package subtask3

class ArrayCalculator {

    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        val items: MutableList<Int> = mutableListOf()
//        val positiveItems: MutableList<Int> = mutableListOf()
//        val negativeItems: MutableList<Int> = mutableListOf()

        itemsFromArray.forEach {
            if (it::class == Int::class) items.add(it as Int)
        }

        if (items.isEmpty()) return 0

        var result = 1
//
        if (numberOfItems >= items.size) {
            items.forEach {
                result *= it
            }
            return result
        }
//
//        items.forEach {
//            if (it >= 0) positiveItems[it]
//            else negativeItems[abs(it)]
//        }
//
//        positiveItems.sortDescending()
//        negativeItems.sortDescending()
//        val positiveSize = positiveItems.size
//        val negativeSize = negativeItems.size
//
//        if (numberOfItems == 1 && positiveItems.isNotEmpty()) return positiveItems.max() as Int
//        if (numberOfItems == 1 && positiveItems.isEmpty() && negativeItems.isNotEmpty()) return items.min() as Int
//
////        if (checkSize(numberOfItems, positiveItems)) {
////            if (positiveItems[numberOfItems-1] > negativeItems[0]) {
////                positiveItems.forEachIndexed { index, it ->
////                    while (index < numberOfItems)  result *= it
////                    return result
////                }
////            }
////        }

        items.sortDescending()


        if (numberOfItems % 2 == 1) {
            result = result * items.first()
            items.removeAt(0)
        }

        val tempResults = mutableListOf<Int>()
        var nextIndex = 1

//        while (nextIndex < items.size) {
            items.forEachIndexed { index, item ->
                if (index != nextIndex && nextIndex < items.size) tempResults.add(item * items[nextIndex])
                ++nextIndex
//            }
//            ++nextIndex
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

    private fun checkSize(numberOfItems: Int, list: List<Int>): Boolean {
        return list.size >= numberOfItems
    }
}
