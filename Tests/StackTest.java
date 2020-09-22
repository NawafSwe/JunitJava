//importing packages

import org.junit.Assert;
import org.junit.Test;

public class StackTest {
    public StackImpl stack = new StackImpl();

    /**
     * test description
     **/
    @Test
    public void emptyStackTest() {
        //making the stack empty first
        stack.makeEmpty();
        //asserting that the stack is empty
        Assert.assertTrue(stack.isEmpty());
    }

    /**
     * test description
     **/
    @Test
    public void popItemTest() {
        //before popping an object from the stack we want to holds the stack size to compare at the end
        int holdStackSize = stack.size();
        //popping the object from the stack
        stack.pop();
        //the size of the stack must be not equals to the stackSize after poping an element
        Assert.assertTrue(holdStackSize != stack.size());
    }

    /**
     * test description
     **/
    @Test
    public void pushItemTest() {
        //before push an item to the stack we want to capture tha value of the size to make sure it was added after the operation
        int holdStackSize = stack.size();
        Object item = new Object();
        stack.push(item);
        //assert now if the size of the stack went bigger or not.
        Assert.assertTrue(stack.size() > holdStackSize);

    }

    /**
     * test description
     **/
    @Test
    public void topItemTest() {
        //after pushing an item in the stack it should be at the top of the stack
        int holdStackSize = stack.size();
        Object item = new Object();
        stack.push(item);
        //also we can assert that the size was increased
        Assert.assertTrue(stack.size() > holdStackSize);
        //they must be equals to make sure it was added to the top 
        Assert.assertEquals(item, stack.top());

    }

}

