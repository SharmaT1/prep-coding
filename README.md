# prep-coding
Coding Preparation

## Leetcode

|  #  |      Title     |   Solutions   | Difficulty  | Tag
|-----|----------------|---------------|-------------|-------------
|5|[Find Pivot Index](https://leetcode.com/problems/find-pivot-index/)|[Java](../master/leetcode/PivotIndex.java), [Python](../master/leetcode/PivotIndex.py)| Easy | Array
|4|[Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/)|[Java](../master/leetcode/SortedArray.java)| Medium | Array
|3|[Three Sum](https://leetcode.com/problems/3sum/)|[Java](../master/leetcode/ThreeSum.java)| Medium | Array, Two Pointers
|2|[Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)|[Java](../master/leetcode/AddTwoNo.java)| Medium | LinkedList
|1|[Two Sum](https://leetcode.com/problems/two-sum/)|[Java](../master/leetcode/TwoSum.java)| Easy | HashMap

## Python


1. What's the difference between tuple & list?

2. What's the difference between return and yield in python?

3. What's the output?

```python
class Parent(object):
    x = 1

class Child1(Parent):
    pass

class Child2(Parent):
    pass

print(Parent.x, Child1.x, Child2.x)

Child1.x = 2
print(Parent.x, Child1.x, Child2.x)

Parent.x = 3
print(Parent.x, Child1.x, Child2.x)
```

4. What's the output?

```python

def foo(f):
    def wrapper(*args, **kwargs):
       g = f(*args, **kwargs)
       value = list(g)[::-1]
       return "".join(str(x) for x in value)
    return wrapper

def bar(f):
    def wrapper(*args, **kwargs):
        g = f(*args, **kwargs)
        return '$' + str(abs(g))

    return wrapper

def @foo
def @bar
def myFunc(arr):
    return arr[-1] * 2

arr = [-1 , 2, 3, -4]
print(myFunc(arr))
```
