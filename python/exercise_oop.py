# Example from GeeksForGeeks
def greet(func): # higher-order function
    return func("Hello")

def uppercase(text): # function to be passed
    return text.upper()

print(greet(uppercase))

# higher order function returning a function
def fun(n):
    return lambda x: x * n

# creating mutiliplier functions
double = fun(2)
triple = fun(3)

print(double(5))
print(triple(5))

#-----------------------------

