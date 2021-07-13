# Challenge description:
# cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element of that pair. For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.
#
# Given this implementation of cons:
#
# def cons(a, b):
#     def pair(f):
#         return f(a, b)
#     return pair
# Implement car and cdr.


def cons(a, b):
    def pair(f):
        return f(a, b)
    return pair


def car(funcall):
    def retleft(x, y):
        return x;
    return funcall(retleft)


#lambda implementation
def carlambda(funcall):
    return funcall(lambda x, y: x)
    #given x, y - return x

def cdr(funcall):
    def retright(x, y):
        return y;
    return funcall(retright)


#lambda implementation
def cdrlambda(funcall):
    return funcall(lambda x, y: y)
    #given x, y - return y


a = 2
b = 3
pair = cons(a, b)


print(carlambda(pair))
print(cdrlambda(pair))