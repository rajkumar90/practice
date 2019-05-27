System that manages resources. All resources are identical - each has an Id
1. Allocate - return an unused id
2. release(id) - make a resource free
3. initialize - number of resources as input (n) - 0 to n-1
class TreeNode {
boolean isThisFree, isLeftFree, isRightFree;
TreeNode left, right;
}
class ResourceAllocator {
    LinkedList<Integer> free = new LinkedList<Integer>();
    HashSet<Integer> allocated = new HashSet<Integer>();
    
    TreeNode root;
    int capacity;
    
    void initialize(int capacity) {
        this.capacity = capacity;
        free = new LinkedList<Integer>(capacity);
        for (int i = 0; i < capacity; i++)
        free.add(i);
    }
    
    public Integer allocate() {
        return allocateHelper(root, capacity);
    }
    
    public Integer allocateHelper(TreeNode root, int n) {
        // if (n < 0 || n > capacity)
        // throw new Exception("No free resources to allocate");
        if (root.isThisFree) {
            return capacity/2;
            root.isThisFree = false;
        }
        else if (root.isLeftFree)
            return allocateHelper(root.left, n/2 - 1);
        else if (root.isRightFree)
            return allocateHelper(root.right, n/2 + 1);
        else
        throw new Exception("No free resources to allocate");
    }
    
    public void release(int resourceId) {
        if (!allocated.contains(resourceId))
            throw new Exception("Invalid resourceId passed as input");
        allocated.remove(resourceId);
        free.add(resourceId);
    }
    
}
