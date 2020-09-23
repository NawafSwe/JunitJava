//importing packages

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * StackTest class is a class that tests all the functions before looking at the implementation of the code.
 * the class contains the stack implementation functions, and tests for each function and its expected result documented
 **/
public class StackTest {
    /**
     * stack is an object of type StackImpl where it will carries all the functions to test them within this class
     **/
    private StackImpl stack;

    /**
     * setStack function that will runs before any test where it will init the stack with some values
     **/
    @Before
    public void setStack() {
        this.stack = new StackImpl();
    }

    /**
     * emptyStackTest is a function that tests the functionality of making stack empty
     * first we empty the stack by calling stack.makeEmpty(), where it will clear all the stack
     * the test here where we check is the stack empty or not.
     * if Asserted true then the result of the test 'PASS' otherwise 'FAIL' which means there is a bug
     * in the implementation code.
     * expected result is PASS.
     * actual test result 'FAIL'
     **/
    @Test
    public void emptyStackTest() {
        // Making the stack empty first.
        this.stack.push(32);
        this.stack.push(56);
        this.stack.push(81);
        this.stack.push(32);
        this.stack.push(56);
        this.stack.push(81);
        this.stack.makeEmpty();
        // Asserting that the stack is empty, Expected result of this.stack.isEmpty() is true.
        Assert.assertTrue("the value of stack.isEmpty must be true where it returns " + this.stack.isEmpty(), this.stack.isEmpty());
    }

    /**
     * pushItemTest is a function that tests the functionality of adding new item to the stack
     * pushing an item into stack must increase the size of the stack.
     * if the size of the stack did not increased after pushing a new item then the test is failed otherwise its successful
     * first we capture the size of the stack
     * second we create an Object of type Object
     * third we push the object into the stack
     * lastly we assert that is the size of the stack increased or not, if yes test result 'PASS' otherwise 'FAIL'
     * expected result is PASS
     * actual test result 'PASS'
     **/
    @Test
    public void pushItemTest() {
        //before push an item to the stack we want to capture tha value of the size to make sure it was added after the operation
        int holdStackSize = this.stack.size();
        //creating an items
        this.stack.push(394);
        this.stack.push(2019);
        this.stack.push(2017);
        this.stack.push(334);
        this.stack.push(2049);
        this.stack.push(2049);
        this.stack.push(394);
        this.stack.push(2019);
        this.stack.push(2017);
        this.stack.push(334);

        //assert now if the size of the stack increased or not.
        Assert.assertTrue("the size of the stack must be increased", this.stack.size() > holdStackSize);
        //assert that the stack has no null values where all elements was added
        System.out.println(this.stack.toString());
        Assert.assertFalse("A null values was found in the stack", this.stack.toString().contains("null"));

    }

    /**
     * popItemTest function which tests the functionality of popping an item from the top of a stack
     * popping item from stack must decreases the size of the stack
     * if the stack is empty null must be returned
     * first we capture the size of the stack before popping any item from the stack
     * second we pop item from the stack
     * lastly we assert if the size of the stack decreased the test 'PASS' otherwise 'FAIL'
     * expected result 'PASS'
     * actual test result 'FAIL'
     **/
    @Test
    public void popItemTest() {
        //checking if the stack is empty or not
        if (this.stack.size() == 0) {
            Assert.assertEquals("the value of pop must be null if the size is zero", null, this.stack.pop());
        }
        //init the stack with some items
        this.stack.push(1);
        this.stack.push(2);
        this.stack.push(3);

        // before popping an object from the stack we want to hold the stack size to compare at the end
        int holdStackSize = this.stack.size();
        //before popping
        System.out.println(this.stack.toString());

        // popping the object from the stack if it is not empty
        this.stack.pop();
        //after popping
        System.out.println(this.stack.toString());
        // the size of the stack must be decreased after popping an element.
        Assert.assertTrue("the stack size must be decreased but it was not", holdStackSize > this.stack.size());
    }

    /**
     * topItemTest function that tests the functionality of getting the top element in the stack
     * pushing new element in the stack will be at the top, and calling the function top will return that item.
     * if the stack is empty null must be returned
     * first we capture the size of the stack before adding a new item to the stack
     * second we create new object and push it into the stack where it will be at the top
     * third we assert that the item was added by asserting that the size of the stack was increased
     * fourth we assert that stack.top equals the object created in step 2.
     * if the object equals then the test result is 'PASS' otherwise is 'FAIL'
     * expected result is 'PASS'
     * actual test result 'PASS'
     **/
    @Test
    public void topItemTest() {
        //checking if the stack is empty or not
        if (this.stack.size() == 0) {
            Assert.assertEquals("the value of top must be null if the size is zero", null, this.stack.pop());
        }
        //pushing elements to the stack
        this.stack.push(1);
        this.stack.push(2);
        this.stack.push(3);
        this.stack.push(4);
        this.stack.push(5);
        this.stack.push(6);
        this.stack.push(7);
        // after pushing an item in the stack it should be at the top of the stack
        int holdStackSize = this.stack.size();
        //creating new item
        int item = 2020;
        //pushing the object to the stack
        this.stack.push(item);
        //also we can assert that the size was increased
        Assert.assertTrue(this.stack.size() > holdStackSize);
        System.out.println(this.stack.toString());
        // assert that created item must be equals to the stack.top item to make sure it was added to the top and returned correctly
        Assert.assertEquals("the last item added was not returned with stack.top", item, stack.top());

        //trying to get the top again and making sure it is the top again means it was not removed when it was returned
        Assert.assertEquals("the last item added was not returned with stack.top", item, stack.top());

    }

    /**
     * toStringrTest function that tests the format of applying toString function
     * where it must be in the following format [1,2,4].
     * where it starts by [ and ends with ] and do not have any spaces.
     **/
    @Test
    public void toStringTest() {
        // checking the begging of the string starts with [ and ends with ] and does not have spaces
        String stackRepresentation = this.stack.toString();
        Assert.assertNotNull(stackRepresentation);
        Assert.assertFalse("stack string must not contains any spaces", stackRepresentation.contains(" "));
        String startOfString = stackRepresentation.substring(0, 1);
        Assert.assertEquals("stack string must be start with [", "[", startOfString);
        String endOfString = stackRepresentation.substring(stackRepresentation.length() - 1);
        Assert.assertEquals("stack string must be end with ]", "]", endOfString);
    }


}

