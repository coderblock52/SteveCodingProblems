from BuildTree import buildtree


def is_unival(root):
    #print("is_unival: " + str(root.value))
    return is_unival_recurse(root, root.value)

def is_unival_recurse(root, value):
    if root is None: #for every leaf, it will be true
        #print("returning true")
        return True
    #print("value: " + str(value) + " root.value: " + str(root.value))
    if root.value == value: #if root value is equal to head value, it's true
        return is_unival_recurse(root.left, value) and is_unival_recurse(root.right, value) #determine if both are true - if not, it's false
    return False #if value differs from head value, it's false

def count_univals(root):
    if root is None: #if we walked passed a leaf or there is no list
        return 0; #don't count it
    left = count_univals(root.left) #count how many univals on left
    right = count_univals(root.right) #count how many univals on right
    if is_unival(root): #if my own current root is a unival
        return 1 + left + right #return gathered values + 1
    else: #otherwise
        return left + right #just return the values gathered

root=buildtree()#build tree
counter = count_univals(root)
print("number of unival subtrees: " + str(counter))
