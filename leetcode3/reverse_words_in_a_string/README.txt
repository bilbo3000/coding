Reverse the words in a string. 

Note that leading and trailing spaces should be ignored. Multiple spaces between words 
should be only counted as one space. 

-- Use two pointers to extract words and push each words onto stack. 
-- Two pointers i and j. i points to the start of a word. j points to the first space after 
	a word. 
-- The popping order of the stack would be the reverse order of the words. 
-- Do not add space in front when popping the first word. 