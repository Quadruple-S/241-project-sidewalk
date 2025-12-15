# reflection.md

### what aspects of my code are not working?
knock on wood but... ***NONE** (:

I think I could've done more work to ensure that dijkstra's was finding the shortest path every time, since I am trusting the native `PriorityQueue` with my custom comparartor to kind of do its magic, but I have written out multiple graphs on paper and tested its pathfinding. Seems good!

Additionally — although they work, — I think my test cases are a bit lacking. Writing good test cases that balance conciseness and completeness is **hard**.


### what lessons did I learn?
- when working with a new style of code (like test cases), it's important to understand the core ideas behind it before writing too much nonsense. Looking at other examples of test code such as the ones already implemented in `ShortestPathsTest.java` were helpful.
- As a sort of counterpoint to my previous lesson, sometimes writing bad code leads to to discover good code. When I didn't totally understand how the `paths` hashmap and the `PathData` class were supposed to work, I wrote a clunky `NodeWrapper` class that didn't work, which made me realize how I could use `PathData` properly.
- simplicity is beautiful! (see [[#what was the most challenging part]])

### what was the most challenging part?
I think understanding the existing code was the most difficult part, but eventually also the most rewarding. At first I was frustrated with...

- the simplicity of the `PathData` class (it only points to previous... how was that supposed to work?)
- `compute()` takes in a `Node`, not the whole graph. I wanted to be able to iterate over each node.
- `shortestPath()` can't find the path when I'm not directly tracking the entire path (can it?).

All three of these things lead to "aha moment" revelations down the road. For example: `PathData` in combination with the paths `HashMap` can accomplish everything I need to implement, including backtracking to find paths and tracking visited nodes. I was considering implementing djikstras a second time before I realized I could just backtrack.

Getting the native `PriorityQueue` collection to compare based on distances was similarly challenging. At first, I made an awkward `NodeWrapper` class that stored a node and a distance, but it was ugly to look at, and eventually just plain problematic. Intead I implemented a custom comparator called `DistanceComparator` that can take the `paths` hashmap pointer **as an argument**. This means it can refer to paths to find distances. 

    Declare/discuss any aspects of your code that are not working. What are your intuitions about why they are not working? Acknowledge and discuss any parts of the program that appear to be inefficient.
    What are some of the most important lessons you learned while working on this assignment? Why do you think so?
    What was the most challenging aspect of this assignment? Why?

