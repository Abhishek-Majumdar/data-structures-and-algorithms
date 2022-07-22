> HashMap vs. HashTable

| S.no. |                                          HashMap                                           |                                                                                        HashTable |
|-------|:------------------------------------------------------------------------------------------:|-------------------------------------------------------------------------------------------------:|
| 1     |                                 No method is synchronized.                                 |                                                                    Every method is synchronized. |
| 2     | Multiple threads can operate simultaneously and hence hashmap’s object is not thread-safe. | At a time only one thread is allowed to operate the Hashtable’s object. Hence it is thread-safe. |
| 3     |         Threads are not required to wait and hence relatively performance is high.         |                        It increases the waiting time of the thread and hence performance is low. |
| 4     |                          Null is allowed for both key and value.                           |     Null is not allowed for both key and value. Otherwise, we will get a null pointer exception. |

> HashMap vs. TreeMap

| S.no. |                                      HashMap                                       |                                                                 Treemap |
|-------|:----------------------------------------------------------------------------------:|------------------------------------------------------------------------:|
| 1     |         Java HashMap is a hashtable based implementation of Map interface.         | Java TreeMap is a Tree structure-based implementation of Map interface. |
| 2     |             HashMap allows a single null key and multiple null values.             |     TreeMap does not allow null keys but can have multiple null values. |
| 3     | HashMap allows heterogeneous elements because it does not perform sorting on keys. |          TreeMap allows homogeneous values as a key because of sorting. |
| 4     |                       The HashMap class uses the hash table.                       |                               TreeMap internally uses a Red-Black tree. |

