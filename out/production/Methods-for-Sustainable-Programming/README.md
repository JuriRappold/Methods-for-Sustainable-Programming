# Methods-for-Sustainable-Programming
Repo for Methods for sustainable programming; experimenting with stuff here; also this way its device independent

## Lecture 2 - What is Functional Programming?
### Chapter 17 Lambdas & Streams Vocab
**For Streams**
- Stream
- stream pipeline
- intermediate operation
- terminal operation
- reduction
- lazy evaluation/operation
- eager evaluation/operation
- intermediate stream
- data source

**General**
- lambda expresions
- declaritive programming
- imperative programming
- programming paradigm
  - procedural
  - OOP
  - Generic
  - Functional
- 
**Error Prevention**
For a stream operation that returns an Optional<T>, store
the result in a variable of that type, then use the object’s
isPresent method to confirm that there is a result, before
calling the Optional’s get method. This prevents
NoSuchElementExceptions.
