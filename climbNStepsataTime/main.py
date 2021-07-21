#######################################################################################
# Challenge description:
# There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time.
# Given N, write a function that returns the number of unique ways you can climb the staircase.
# The order of the steps matters.
#
# For example, if N is 4, then there are 5 unique ways:
#
# 1, 1, 1, 1
# 2, 1, 1
# 1, 2, 1
# 1, 1, 2
# 2, 2
# What if, instead of being able to climb 1 or 2 steps at a time,
# you could climb any number from a set of positive integers X? For example,
# if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.
#######################################################################################

n = 3


#method to find out how to climb the steps
#1 or 2 at a time
def simpleclimb(n):
    #count the number of results
    counter = 0
    end = n//2

    for i in range (0,end+1):
        counter = counter + nCk(n-i,i)
        #print("n: " + str(n-i) + "; k: " + str(i) + "; counter: " + str(counter)) #used for testing purposes

    return counter


#implement n Choose k formula
#looks like: n!/k!(n-k)!
def nCk(n: int, k: int):

    #not needed as I can control the incoming data in the previous function call
    # if(n < k): #if n is 1
    #     return 0
    # elif(n==k):
    #     return 1
    nfact = factorial(n) #get the factorial of n (n!)
    kfact = factorial(k) #get the factorial of k (k!)
    nmkfact = n-k #find n-k (n-k)
    nmkfact = factorial(nmkfact) #find the factorial of the difference [(n-k)!]

    kfact *= nmkfact #multiply k! and (n-k)!
    return nfact/kfact #return the result of dividing numerator and denominator

#implement factorial solution
def factorial(fact):
    value: int = 1 #start with one
    for i in range (1, fact+1): #iterate through all n and multiple by each value all the way up
        value = value * i

    return value

print(simpleclimb(n))