# 253. Meeting Rooms II
Given an array of meeting time intervals consisting of start and end times
`[[s1,e1],[s2,e2],...]` `(si < ei)`,
find the minimum number of conference rooms required.
For example,
Given `[[0, 30],[5, 10],[15, 20]]`, return `2`.

### Java
```java
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public int minMeetingRooms(Interval[] intervals) {
	if (intervals.length == 0 || intervals == null) {
		return 0;
	}

	// Sort array based on the start time
	Arrays.sort(intervals, new Comparator<Interval>() {
		public int compare(Interval a, Interval b) {
			return a.start - b.start;
		}
	});

	// min heap to track the min end time of merged intervals
	PriorityQueue<Interval> heap = new PriorityQueue<Interval>(intervals.length, new Comparator<Integer>() {
		public int compare(Interval a, Interval b) {
			return a.end - b.end;
		}
	});

	heap.add(intervals[0]);
	for (int i = 1; i < intervals.length; i ++) {
		Interval currInterval = heap.remove();
		if (intervals[i].start < currInterval.end) {
			heap.add(intervals[i]);
		} else {
			// merge the end interval
			currInterval.end = intervals[i].end;
		}
		heap.add(currInterval); // add it back
	}
	return heap.size();
}
```

### Objective-C

```objective-c

- (int)minMeetingRooms:(NSArray<Interval *>*)intervals {
    // create a start and a end array
    NSMutableArray *start = [[NSMutableArray alloc] init];
    NSMutableArray *end = [[NSMutableArray alloc] init];

    for (int i = 0; i < intervals.count; i ++) {
        [start addObject:intervals[i].start];
        [end addObject:intervals[i].end];
    }
    NSSortDescriptor *sortDescriptor = [[NSSortDescriptor alloc]
                                        initWithKey: @"self"
                                         ascending: YES];
    NSArray *sortedStart = [start sortedArrayUsingDescriptors:@[sortDescriptor]];
    NSArray *sortedEnd = [end sortedArrayUsingDescriptors:@[sortDescriptor]];
    int rooms = 0;

    int endIndex = 0;
    for (int i = 0; i < start.count; i ++) {
        if (sortedStart[i] < sortedEnd[endIndex]) {
            rooms++;
        } else {
            endIndex++;
        }
    }
    return rooms;
}

```
