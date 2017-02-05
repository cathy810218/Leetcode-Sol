# Flip Game

You are playing the following Flip Game with your friend: 

Given a string that contains only these two characters: `+` and `-`, 

you and your friend take turns to flip two consecutive `"++"` into `"--"`. 

The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to compute all possible states of the string after one valid move.

For example, given `s = "++++"`, after one move, it may become one of the following states:

````
[
  "--++",
  "+--+",
  "++--"
]
````

[Link to Leetcode](https://leetcode.com/problems/flip-game/)

[Link to Code](FlipGame.java)

------------------------------

##Solutions

Iterate through the given string and if we see two consecutive string `"++"`, we replace it with `"--"`.

Use a for loop to check if the current and next character are the both `"+"`, if they are, we create a new string but replace them with `"--"`. 

It sounds straightforward, but you have to be careful.

Start out your for loop at `index = 1` to avoid index out of bound exception.
And use `substring()` to get the original string from range (a, b).

````Java
for (int i = 1; i < s.length(); i++) {
    if (s.charAt(i) == '+' && s.charAt(i-1) == '+') {
        String str = s.substring(0,i-1) + "--" + s.substring(i+1, s.length());
        result.add(str);
    }
}
````
