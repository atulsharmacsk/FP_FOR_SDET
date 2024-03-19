**Filter:**
An intermediate operation which allows you to select elements from a stream based on a specified condition. It takes a Predicate as an argument, which defines the condition for selection. Elements that satisfy the predicate are retained, while others are discarded.

**ForEach:**
A terminal operation which allows you to perform an action on each element of the stream. It takes a Consumer as an argument, which specifies the action to be performed on each element. For example, you can use forEach to print each element of the stream or perform some other side effect.

**Collect:**
A terminal operation which accumulates the elements of a stream into a data structure such as a List, Set, or Map. It takes a Collector as an argument, which specifies how the elements should be collected. Collectors provide various methods like toList(), toSet(), toMap(), etc., for collecting elements into different types of collections.

**Sorted:**
An intermediate operation which sorts the elements of a stream according to a specified Comparator. It can sort elements in either natural or custom order. If no comparator is provided, it sorts elements based on their natural order (if applicable).

**Limit:**
An intermediate operation which restricts the size of the stream to a specified maximum number of elements. It takes a long value as an argument, indicating the maximum number of elements to be retained in the stream. This is useful for operations like selecting the top N elements from a stream.

**Map:**
An intermediate operation which transforms each element in a stream into another object. It takes a Function as an argument, which is applied to each element, resulting in a new stream of transformed elements. For example, you can use map to convert a stream of objects into a stream of their properties or attributes.

**Reduce:**
A terminal operation which combines the elements of a stream into a single result. It takes a BinaryOperator as an argument, which specifies how two elements should be combined. reduce can be used for tasks like finding the maximum or minimum value, calculating the sum or product, or performing any other associative operation on the elements of the stream.