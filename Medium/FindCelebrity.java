// Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, 
// there may exist one celebrity. The definition of a celebrity 
// is that all the other n - 1 people know him/her but he/she does not know any of them.

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
public int findCelebrity(int n) {
	int target = 0;
	for (int i = 0; i < n; i++)) {
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