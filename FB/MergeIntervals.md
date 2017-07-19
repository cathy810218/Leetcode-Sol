# 56. Merge Intervals

Given a collection of intervals, merge all overlapping intervals.

For example,
Given `[1,3],[2,6],[8,10],[15,18]`,
return `[1,6],[8,10],[15,18]`.


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
public List<Interval> merge(List<Interval> intervals) {
    List<Interval> result = new ArrayList<>();
    int[] start = new int[intervals.size()];
    int[] end = new int[intervals.size()];

    for (int i = 0; i < intervals.size(); i ++) {
        start[i] = intervals.get(i).start;
        end[i] = intervals.get(i).end;
    }

    Arrays.sort(start);
    Arrays.sort(end);
    for (int i = 0, j = 0; i < intervals.size(); i++) {
        if (i == intervals.size() - 1 || start[i + 1] > end[i]) {
            result.add(new Interval(start[j], end[i]));
            // update j
            j = i+1;
        }
    }
    return result;
}
```


### Objective-C
```objective-c
- (NSArray<Interval*> *)merge:(NSArray<Interval *>*)intervals {
    NSMutableArray *result = [[NSMutableArray alloc] init];
    NSMutableArray *start = [[NSMutableArray alloc] init];
    NSMutableArray *end = [[NSMutableArray alloc] init];

    for (int i = 0; i < intervals.count; i++) {
        [start addObject:intervals[i].start];
        [end addObject:intervals[i].end];
    }
    NSSortDescriptor *lowToHighDescriptor = [NSSortDescriptor sortDescriptorWithKey:@"self" ascending:YES];
    [start sortUsingDescriptors:@[lowToHighDescriptor]];
    [end sortUsingDescriptors:@[lowToHighDescriptor]];

    for (int i = 0, j = 0; i < intervals.count; i ++) {
        if (i == intervals.count - 1 || start[i + 1] > end[i]) {
            Interval *interval = [[Interval alloc] initWithStart:start[j] andEnd:end[i]];
            [result addObject: interval];
            j = i + 1;
        }
    }

    return result;
}
```
