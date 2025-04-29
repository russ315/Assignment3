Assignment 3: HashTable and Binary Search Tree (BST)

Course: Data Structures and AlgorithmsOpened: Tuesday, 22 April 2025, 12:00 AMDue: Tuesday, 29 April 2025, 11:59 PM

Project Overview

This repository contains implementations and tests for two custom data structures in Java, completed without using recursion:

MyHashTable<K, V> (25%)

BST<K, V> (Binary Search Tree) (25%)

Additionally, testing and performance verification are provided to ensure correct behavior and uniform distribution of hash codes.

Part 1: MyHashTable<K, V> (25%)

1.1 Implementation

Custom hash table using separate chaining (LinkedList-based buckets).

Supports basic operations: put(K key, V value), get(K key), delete(K key), size(), and containsKey(K key).

No recursion used.

1.2 Testing (25%)

A MyTestingClass with a user-defined hashCode() method (avoiding default hashing or Objects.hash()).

A Student class (or similar) as the table value type.

A test driver that:

Instantiates MyHashTable<MyTestingClass, Student>.

Inserts 10,000 random elements.

Prints the number of elements in each bucket.

Adjusts and verifies MyTestingClass.hashCode() to achieve uniform distribution across buckets.

Part 2: Binary Search Tree (BST<K, V>) (25%)

2.1 Implementation

Custom BST without recursion.

Node structure: key, value, left, right, and subtree size.

Methods: put(K key, V val), get(K key), delete(K key), size(), and an in-order iterator().

2.2 Enhancements (25%)

Size (5%)

Each node tracks the size of its subtree for O(1) size queries.

In-order Traversal Iterator (10%)

Non-recursive, stack-based traversal.

Key & Value Access in Iteration (10%)

Node class exposes getKey() and getValue() for use in for (var elem : tree).
