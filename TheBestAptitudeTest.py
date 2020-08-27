# Enter your code here. Read input from STDIN. Print output to STDOUT
import numpy as np
 
for t in range(int(input())):
    input() # we'll ignore this input
    gpa = list(map(float, input().split()))
    max_r = -2
    max_i = 0
    for i in range(1, 6):
        at = list(map(float, input().split()))
        r = np.corrcoef(gpa, at)[0][1]          #provides co-relation calculation
        if r > max_r:
            max_r = r
            max_i = i
    print(max_i)
