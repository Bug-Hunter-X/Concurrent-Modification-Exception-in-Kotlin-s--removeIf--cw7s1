# Concurrent Modification Exception in Kotlin's `removeIf` Function

This repository demonstrates a common, yet subtle, error that can occur when using the `removeIf` function with mutable lists in Kotlin. The `removeIf` function modifies the list while iterating over it, leading to unexpected behavior and potentially a `ConcurrentModificationException`.

## Problem

The following code snippet attempts to remove all even numbers from a mutable list using `removeIf`:

```kotlin
fun main() {
    val list = mutableListOf<Int>(1, 2, 3, 4, 5)
    list.removeIf { it % 2 == 0 }
    println(list) // Expected: [1, 3, 5], but might not be the case due to the bug
}
```

While seemingly simple, this code can lead to unpredictable results, as the removal of elements affects the iteration process.

## Solution

To avoid this error, iterate over a copy of the list or use an iterator with safe removal operations, making sure you handle exceptions properly.

```kotlin
fun main() {
    val list = mutableListOf<Int>(1, 2, 3, 4, 5)
    val iterator = list.iterator()
    while (iterator.hasNext()){
        if (iterator.next() % 2 == 0) {
            iterator.remove()
        }
    }
    println(list) //This will produce the correct result [1,3,5]
}
```