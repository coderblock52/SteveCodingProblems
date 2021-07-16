# challenge description:
# A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.
#
# Given the root to a binary tree, count the number of unival subtrees.
#
# For example, the following tree has 5 unival subtrees:


from binarytree \
    import tree, bst, heap, Node, build

#root = tree(height=3, is_perfect = False) #generic build-tree function

def buildtree():
    #values = [1,2,2,1,1,1,1,1] #can be used to test other tree setups
    #root = build(values) #builds based on values given
    ###############example given
    root = Node(0)
    root.left = Node(1)
    root.right = Node(0)
    root.right.right = Node(0)
    root.right.left = Node(1)
    root.right.left.left = Node(1)
    root.right.left.right = Node(1)
    ###############example given
    print(root)
    print("properties in buildtree:")
    print(root.leaves)
    print(root.values)
    return root

