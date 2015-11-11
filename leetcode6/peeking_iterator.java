// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
/**
 * The idea was to cache next value from the iterator and use a boolean flag 
 * to mark if the cached value exists or not. When calling peek(), just return
 * the cache. When calling next(), prepare the cache for return, if there are 
 * more values in the iterator, update the cache, otherwise, meaning no more 
 * value can be put into the cache, then set the flag to false. When call 
 * hasNext() just returns the value of the flag. 
 */ 
class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> it; 
    private boolean hasNext = false; 
    private int nextCache; 

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.it = iterator; 
	    hasNext = it.hasNext(); 
	    
	    if (hasNext) {
	        nextCache = it.next(); 
	    }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return Integer.valueOf(nextCache);
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    int curr = nextCache; 
	    
	    if (it.hasNext()) {
	        nextCache = it.next(); 
	    } else {
	        hasNext = false; 
	    }
	    
	    return curr; 
	}

	@Override
	public boolean hasNext() {
	    return hasNext; 
	}
}
