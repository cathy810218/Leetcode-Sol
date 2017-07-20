# 252. Meeting Rooms
Given an array of meeting time intervals consisting of start and end times

`[[s1,e1],[s2,e2],...]` (si < ei), determine if a person could attend all meetings.

For example,
Given `[[0, 30],[5, 10],[15, 20]]`,
return `false`.


### Java

```java
public boolean conAttendMeetings(Interval[] intervals) {
    if (intervals == null) {
        return false;
    }
    Arrays.sort(intervals, new Comparator<Interval>() {
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    });

    for (int i = 0; i < intervals.length - 1; i++) {
        if (intervals[i].end > intervals[i + 1].start) {
            return false;
        }
    }
    return true;
}
```


### Objective-C

```objective-c
- (BOOL)canAttendMeeting:(NSArray<Interval *>*)intervals {
    if (intervals == nil) {
        return NO;
    }

    NSSortDescriptor *startTimeDescriptor = [NSSortDescriptor sortDescriptorWithKey:@"start" ascending:YES];
    NSArray<Interval *> *sortedIntervals = [intervals sortedArrayUsingDescriptors:@[startTimeDescriptor]];

    for (int i = 0; i < intervals.count - 1; i ++) {
        Interval *thisInterval = sortedIntervals[i];
        Interval *nextInterval = sortedIntervals[i+1];
        if (thisInterval.end > nextInterval.start) {
            return NO;
        }
    }
    return YES;
}
```
