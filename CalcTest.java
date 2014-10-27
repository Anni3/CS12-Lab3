//Annie Volovik
//1260637
//CMPS12B/M
//10/26/2014

// CalcTest.java
// Unit tests for Calc class

import org.junit.*;
import static org.junit.Assert.*;

public class CalcTest {

    private double EPSILON = 1e-15;

    @Test
    public void basicTest() {
        Calc c = new Calc();
        c.push(2.0);
        c.push(2.0);
        c.add();
        assertEquals(4.0, c.pop(), EPSILON);
    }

    @Test
    public void exprTest() {
        Calc c = new Calc();
        c.push(2.0);
        c.push(3.0);
        c.multiply();
        c.push(4.0);
        c.push(5.0);
        c.multiply();
        c.add();
        assertEquals(26.0, c.pop(), EPSILON);
    }

    @Test
    public void pushDepthTest() {
        Calc c = new Calc();
        c.push(5.0);
        assertEquals(1, c.depth());
        c.push(6.0);
        assertEquals(2, c.depth());
        c.push(-10.0);
        assertEquals(3, c.depth());
    }

    @Test
    public void pushPopDepthTest() {
        Calc c = new Calc();
        c.push(5.0);
        c.pop();
        assertEquals(0, c.depth());
        c.push(6.0);
        c.push(-10.0);
        c.pop();
        assertEquals(1, c.depth());
    }

    @Test(expected=Exception.class)
    public void emptyPopTest() {
        Calc c = new Calc();
        c.pop();
    }

    @Test(expected=Exception.class)
    public void tooManyPopTest() {
        Calc c = new Calc();
        c.push(3.0);
        c.push(4.0);
        c.add();
        c.pop();
        c.pop();
    }

    @Test(expected=Exception.class)
    public void tooManyPushTest() {
        Calc c = new Calc();
        for(int i = 0; i < 1e6; i++)
            c.push(100.0);
    }

    @Test(expected=Exception.class)
    public void nopeekTest() {
        Calc c = new Calc();
        double v = c.peek();
    }

    @Test
    public void peekTest() {
        Calc c = new Calc();
        c.push(2.0);
        assertEquals(2.0, c.peek(), EPSILON);
        c.push(3.0);
        assertEquals(3.0, c.peek(), EPSILON);
        c.multiply();
        assertEquals(6.0, c.peek(), EPSILON);
        c.push(4.0);
        assertEquals(4.0, c.peek(), EPSILON);
        c.push(5.0);
        assertEquals(5.0, c.peek(), EPSILON);
        c.multiply();
        assertEquals(20.0, c.peek(), EPSILON);
        c.add();        
        assertEquals(26.0, c.peek(), EPSILON);
    }

    @Test(expected=Exception.class)
    public void underflowAddTest() {
        Calc c = new Calc();
        c.push(2.0);
        c.add();
    }

    @Test(expected=Exception.class)
    public void underflowSubtractTest() {
        Calc c = new Calc();
        c.push(2.0);
        c.subtract();
    }

    @Test(expected=Exception.class)
    public void underflowMultiplyTest() {
        Calc c = new Calc();
        c.push(2.0);
        c.multiply();
    }

    @Test(expected=Exception.class)
    public void underflowDivideTest() {
        Calc c = new Calc();
        c.push(2.0);
        c.divide();
    }

    @Test
    public void singleAddTest() {
        Calc c = new Calc();
        c.push(2.0);
        c.push(-10.0);
        c.add();
        assertEquals(-8.0, c.pop(), EPSILON);
    }

    @Test
    public void doubleAddTest() {
        Calc c = new Calc();
        c.push(-1.0);
        c.push(37.0);
        c.push(10.0);
        c.add();
        c.add();
        assertEquals(46.0, c.pop(), EPSILON);
    }

    @Test
    public void singleSubtractTest() {
        Calc c = new Calc();
        c.push(2.0);
        c.push(-10.0);
        c.subtract();
        assertEquals(12.0, c.pop(), EPSILON);
    }

    @Test
    public void doubleSubtractTest() {
        Calc c = new Calc();
        c.push(-1.0);
        c.push(37.0);
        c.push(10.0);
        c.subtract();
        c.subtract();
        assertEquals(-28.0, c.pop(), EPSILON);
    }

    @Test
    public void singleMultiplyTest() {
        Calc c = new Calc();
        c.push(2.0);
        c.push(-10.0);
        c.multiply();
        assertEquals(-20.0, c.pop(), EPSILON);
    }

    @Test
    public void doubleMultiplyTest() {
        Calc c = new Calc();
        c.push(-1.0);
        c.push(37.0);
        c.push(10.0);
        c.multiply();
        c.multiply();
        assertEquals(-370.0, c.pop(), EPSILON);
    }

    @Test
    public void singleDivideTest() {
        Calc c = new Calc();
        c.push(2.0);
        c.push(-10.0);
        c.divide();
        assertEquals(-0.2, c.pop(), EPSILON);
    }

    @Test
    public void doubleDivideTest() {
        Calc c = new Calc();
        c.push(-1.0);
        c.push(20.0);
        c.push(10.0);
        c.divide();
        c.divide();
        assertEquals(-0.5, c.pop(), EPSILON);
    }

    @Test
    public void addHundredTest() {
        Calc c = new Calc();
        int i;
        for(i = 0; i < 100; i++) {
            c.push(1.0);
        }
        for(i = 0; i < 99; i++) {
            c.add();
        }
        assertEquals(100.0, c.pop(), EPSILON);        
    }

    @Test(expected=Exception.class)
    public void underflowTest() {
        Calc c = new Calc();
        int i;
        for(i = 0; i < 100; i++) {
            c.push(1.0);
        }
        for(i = 0; i < 100; i++) {
            c.add();
        }
    }
    @Test
    public void compoundExpession() {
        Calc c = new Calc();
        //(2*(4+6))/10
	c.push(4.0);
	c.push(6.0);
	//addition
	c.add();

	c.push(2.0);
	//multiple
	c.multiply();

	c.push(10.0);
	//divide
	c.divide();

	assertEquals(2.0, c.pop(), EPSILON);
    }
    @Test
    public void compoundExpessionDepthPeek() {
        Calc c = new Calc();
	//(2*(4+6))/10
        c.push(4.0);
        c.push(6.0);
	//addition
        c.add();

	c.push(2.0);
        //multiple
        c.multiply();
	assertEquals(1,c.depth(),EPSILON);
        assertEquals(20,c.peek(),EPSILON);
    }
    @Test
    public void throwExceptionTest() {
        Calc c = new Calc();
	boolean asrt = false;

 	try {
    	for(int i=1;i<150;i++){
	c.push(i*10);
	}
  } catch (IndexOutOfBoundsException e) {
    asrt = true;
  }
	assertTrue(asrt);
    }

    @Test
    public void reciprocalTest() {
	Calc c = new Calc();
	c.push(4.0);
	
	assertEquals(0.25,c.reciprocal(),EPSILON);
    }
}
