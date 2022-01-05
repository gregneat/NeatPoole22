#testing...
def isPrime(n):
    div = 2
    while(n%div != 0):
        div = div + 1
    if div == n:
        return True
    else:
        return False
    
    
