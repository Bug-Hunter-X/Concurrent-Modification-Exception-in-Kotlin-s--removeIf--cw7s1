fun main() {
    val list = mutableListOf<Int>(1, 2, 3, 4, 5)
    val iterator = list.iterator()
    while (iterator.hasNext()){
        if (iterator.next() % 2 == 0) {
            iterator.remove()
        }
    }
    println(list)
}

//This code iterates through the list using an iterator. The iterator's remove() method is used to remove elements safely, avoiding the concurrent modification issue. This will correctly output [1, 3, 5].