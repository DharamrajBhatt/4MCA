import numpy as np

def byBoundary(arr, n):
    bin=np.zeros(n)
    mid = arr[n-1] - arr[0]
    temp = mid//2
    smallest= arr[0]
    largest = arr[n-1]
    l=arr[0]+temp
    for j in range(n):
        if (arr[j] <= l):
            bin[j]=smallest
        else:
            bin[j]=largest
    print("bin by boundary is:",bin)

def byMedian(arr, n):
    if n % 2 == 0:
        median1 = arr[n//2]
        median2 = arr[n//2 - 1]
        median = (median1 + median2)/2
    else:
        median = arr[n//2]
    bin=np.zeros(n)
    for j in range(n):
        bin[j]=median
    print("bin by median is:",bin)

def byMeans(arr, n):
    mean=np.sum(arr)//n
    bin=np.zeros(n)
    for j in range(n):
        bin[j]=mean
    print("bin by mean is:",bin)

def equiBins(arr1, m):

    a = len(arr1)
    n = int(a / m)
    for i in range(0, m):
        arr = []
        for j in range(i * n, (i + 1) * n):
            if j >= a:
                break
            arr = arr + [arr1[j]]
        print("bin",i,":",arr)
        byMeans(arr,n)
        byMedian(arr,n)
        byBoundary(arr,n)


numbers = np.random.randint(1,100,15)
num= np.sort(numbers)
print(num)
m=3
print("Equal frequency binning")
equiBins(num, m)
