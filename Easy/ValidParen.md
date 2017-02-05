# Valid Parentheses

Given a string containing just the characters `(`, `)`, `{`, `}`, `[` and `]`, 
determine if the input string is valid.

The brackets must close in the correct order, `()` and `()[]{}` are all valid but `(]` and `([)]` are not.


[Link to Leetcode](https://leetcode.com/problems/valid-parentheses/)

[Link to Code](ValidParen.java)

--------------------------------
## Solutions: 

First we know that if the given string has an odd length, it returns false.
Then we check each character in the string.


The idea is easy.
You will need a data structure to hold your characters then track if they match.
A good way to do is with Stack. (Last in, first out) Think about this case: '{}()[]' 

First find all the open parentheses, and push the open parentheses to the stack.

````java
Stack<Character> stack = new Stack<>();
for (char c : str.toCharArray()) {
	if (c == '{' || c == '[' || c == '(') {
		stack.push(c);
	} else {
		//....
	}
}
````

but if the current character is a closed parenthese, we will check if the stack is empty.

If the stack is empty, it tells us that, there's no open paren,
which should return false, else pop the stack to see if the paren matches.

Inside the else statement
````java
if (stack.isEmpty()) {
	return false;
}
// check what type of close paren the current character holds
// and find out the very top stack charceter and see if they match.
switch (c) {
	case '}' :
		if (stack.pop() != '{') {
			return false;
		}
		break;
	case ']' :
		if (stack.pop() != '[') {
			return false;
	    }
	    break;
	case ')' :
		if (stack.pop() != '(') {
			return false;
		}
		break;
}
````

Then FINALLY, if nothing until now return false,
that means it could be a valid parentheses.
BUT, what if there are some elements left still in the stack that weren't popped?

Example:
'[[{([])}'

This case would have passed the first check (str.length() %2 == 0)
as well as all other checks in the for loop.

Therefore, the last step is to check if the stack is empty.

````java
if (!stack.isEmpty()) {
	return false;
}
````

