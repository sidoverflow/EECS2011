import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

public class AVLTreeTest {

	

	@Test
	void test1() {
        
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outContent));
        AVLTree t = new AVLTree();
        
        t.insert(30, 30);
        t.insert(40, 40);
        t.insert(50, 50);

        t.insert(60, 60);
        t.insert(70, 70);

        t.insert(80, 80);

        t.insert(90, 90);
        
        AVLTree.printPreOutput(t);
       
		assertEquals("Preorder : 60 40 30 50 80 70 90 ", outContent.toString());
	}
	
	@Test
	void test2() {
        
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outContent));
        AVLTree t = new AVLTree();
        
        t.insert(30, 30);
        t.insert(40, 40);
        t.insert(50, 50);

        t.insert(60, 60);
        t.insert(70, 70);

        t.insert(80, 80);

        t.insert(90, 90);
        
        AVLTree.printPostOutput(t);
       
		assertEquals("Postorder: 30 50 40 70 90 80 60 ", outContent.toString());
	}

	@Test
	void test3() {
        
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outContent));
        AVLTree t = new AVLTree();
        
        t.insert(90, 90);
        t.insert(80, 80);
        t.insert(70, 70);

        t.insert(60, 60);
        t.insert(50, 50);

        t.insert(40, 40);


        t.insert(30, 30);
        
        AVLTree.printPreOutput(t);
       
		assertEquals("Preorder : 60 40 30 50 80 70 90 ", outContent.toString());
	}
	
	
	
	@Test
	void test4() {
        
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outContent));
        AVLTree t = new AVLTree();
        
        t.insert(90, 90);
        t.insert(80, 80);
        t.insert(70, 70);

        t.insert(60, 60);
        t.insert(50, 50);

        t.insert(40, 40);


        t.insert(30, 30);
        
        AVLTree.printPostOutput(t);
       
		assertEquals("Postorder: 30 50 40 70 90 80 60 ", outContent.toString());
	}
	
	@Test
	void test5() {
        
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outContent));
        AVLTree t = new AVLTree();
        
        t.insert(30, 30);
        t.insert(40, 40);
        t.insert(35, 35);

        t.insert(50, 50);
        t.insert(45, 45);

        t.insert(38, 38);

        t.insert(48, 48);
        
        AVLTree.printPreOutput(t);
       
		assertEquals("Preorder : 40 35 30 38 48 45 50 ", outContent.toString());
	}
	
	
	
	@Test
	void test6() {
        
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outContent));
        AVLTree t = new AVLTree();
        
        t.insert(30, 30);
        t.insert(40, 40);
        t.insert(35, 35);

        t.insert(50, 50);
        t.insert(45, 45);

        t.insert(38, 38);

        t.insert(48, 48);
        
        AVLTree.printPostOutput(t);
       
		assertEquals("Postorder: 30 38 35 45 50 48 40 ", outContent.toString());
	}
	
	@Test
	void test7() {
        
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outContent));
        AVLTree t = new AVLTree();
        
        t.insert(50, 50);
        t.insert(40, 40);
        t.insert(45, 45);

        t.insert(30, 30);
        t.insert(35, 35);

        t.insert(42, 42);

        t.insert(32, 32);
        
        AVLTree.printPreOutput(t);
       
		assertEquals("Preorder : 40 32 30 35 45 42 50 ", outContent.toString());
	}
	
	
	
	@Test
	void test8() {
        
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outContent));
        AVLTree t = new AVLTree();
        
        t.insert(50, 50);
        t.insert(40, 40);
        t.insert(45, 45);

        t.insert(30, 30);
        t.insert(35, 35);

        t.insert(42, 42);

        t.insert(32, 32);
        
        AVLTree.printPostOutput(t);
       
		assertEquals("Postorder: 30 35 32 42 50 45 40 ", outContent.toString());
	}
	
	@Test
	void test9() {
        
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outContent));
        AVLTree t = new AVLTree();
        
        t.insert(40, 40);
        t.insert(30, 30);
        t.insert(50, 50);


        t.insert(35, 35);
        t.insert(38, 38);
        
        AVLTree.printPreOutput(t);
       
		assertEquals("Preorder : 40 35 30 38 50 ", outContent.toString());
	}
	
	
	
	@Test
	void test10() {
        
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outContent));
        
        
        AVLTree t = new AVLTree();
        t.insert(40, 40);
        t.insert(30, 30);
        t.insert(50, 50);


        t.insert(35, 35);
        t.insert(38, 38);
        
        AVLTree.printPostOutput(t);
       
		assertEquals("Postorder: 30 38 35 50 40 ", outContent.toString());
	}
	
	@Test
	void test11() {
        
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outContent));
        AVLTree t = new AVLTree();
        
        t.insert(40, 40);
        t.insert(30, 30);
        t.insert(50, 50);


        t.insert(45, 45);
        t.insert(42, 42);
        
        AVLTree.printPreOutput(t);
       
		assertEquals("Preorder : 40 30 45 42 50 ", outContent.toString());
	}
	
	
	
	@Test
	void test12() {
        
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outContent));
        
        
        AVLTree t = new AVLTree();
        t.insert(40, 40);
        t.insert(30, 30);
        t.insert(50, 50);


        t.insert(45, 45);
        t.insert(42, 42);
        
        AVLTree.printPostOutput(t);
       
		assertEquals("Postorder: 30 42 50 45 40 ", outContent.toString());
	}
	
	@Test
	void test13() {
        
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outContent));
        AVLTree t = new AVLTree();
        
        t.insert(35, 35);
        t.insert(20, 20);
        t.insert(50, 50);

        t.insert(30, 30);
        t.insert(25, 25);
        
        AVLTree.printPreOutput(t);
       
		assertEquals("Preorder : 35 25 20 30 50 ", outContent.toString());
	}
	
	
	
	@Test
	void test14() {
        
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outContent));
        
        
        AVLTree t = new AVLTree();
        t.insert(35, 35);
        t.insert(20, 20);
        t.insert(50, 50);

        t.insert(30, 30);
        t.insert(25, 25);
        
        AVLTree.printPostOutput(t);
       
		assertEquals("Postorder: 20 30 25 50 35 ", outContent.toString());
	}

	@Test
	void test15() {
        
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outContent));
        AVLTree t = new AVLTree();
        
        t.insert(35, 35);
        t.insert(20, 20);
        t.insert(50, 50);

        t.insert(40, 40);
        t.insert(45, 45);
        
        AVLTree.printPreOutput(t);
       
		assertEquals("Preorder : 35 20 45 40 50 ", outContent.toString());
	}
	
	
	
	@Test
	void test16() {
        
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outContent));
        
        
        AVLTree t = new AVLTree();
        
        t.insert(35, 35);
        t.insert(20, 20);
        t.insert(50, 50);

        t.insert(40, 40);
        t.insert(45, 45);
        
        AVLTree.printPostOutput(t);
       
		assertEquals("Postorder: 20 40 50 45 35 ", outContent.toString());
	}
	
	@Test
	void test17() {
        
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outContent));
        AVLTree t = new AVLTree();
        
        int numItems = 100;
        for( int i = 37; i != 0; i = ( i + 37 ) % numItems )
	    t.insert( i, i );
        
        AVLTree.printPreOutput(t);
       
		assertEquals("Preorder : 37 22 11 7 3 2 1 5 4 6 9 8 10 18 14 13 12 16 15 17 20 19 21 29 25 24 23 27 26 28 33 31 30 32 35 34 36 74 59 48 44 40 39 38 42 41 43 46 45 47 55 51 50 49 53 52 54 57 56 58 66 62 61 60 64 63 65 70 68 67 69 72 71 73 85 81 77 76 75 79 78 80 83 82 84 92 88 87 86 90 89 91 96 94 93 95 98 97 99 ", outContent.toString());
	}
	
	
	
	@Test
	void test18() {
        
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outContent));
        
        
        AVLTree t = new AVLTree();
        int numItems = 100;
        for( int i = 37; i != 0; i = ( i + 37 ) % numItems )
	   t.insert( i, i );
        
        AVLTree.printPostOutput(t);
       
		assertEquals("Postorder: 1 2 4 6 5 3 8 10 9 7 12 13 15 17 16 14 19 21 20 18 11 23 24 26 28 27 25 30 32 31 34 36 35 33 29 22 38 39 41 43 42 40 45 47 46 44 49 50 52 54 53 51 56 58 57 55 48 60 61 63 65 64 62 67 69 68 71 73 72 70 66 59 75 76 78 80 79 77 82 84 83 81 86 87 89 91 90 88 93 95 94 97 99 98 96 92 85 74 37 ", outContent.toString());
	}
	
	
	
	

}