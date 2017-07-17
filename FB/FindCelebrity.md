# 277. Find the Celebrity
Suppose you are at a party with n people (labeled from 0 to n - 1) and among them,
there may exist one celebrity. The definition of a celebrity
is that all the other n - 1 people know him/her but he/she does not know any of them.


### Java

```java
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
public int findCelebrity(int n) {
	int target = 0;
	for (int i = 1; i < n; i++)) {
		if (knows(target, i)) {
			target = i;
		}
	}

	for (int i = 0; i < n; i++) {
		if (i != target && knows(target, i) || !knows(i, target)) {
			return -1; // no celebrity
		}
	}
	return target;
}
```

### Objective-C

```objective-c
- (int)findCelebrity:(int)n {
    int candidate = 0;
    for (int i = 1; i < n; i++) {
        if ([self personA:candidate knowsPersonB:i]) {
            // if candidate knows i, then i could be candidate
            candidate = i;
        }
    }

    // if there's no celebrity, then the current celebrity would probably know someone from the group or someone does not know the current celebrity, so we return -1
    for (int i = 0; i < n; i++) {
        if (i != celebrity &&
            [self personA:candidate knowsPersonB:i] ||
            ![self personA:i knowsPersonB:candidate]) {
            return -1;
        }
    }
    return candidate;
}
```
