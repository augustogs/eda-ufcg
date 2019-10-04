import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DoubleLinkedListTestes {

	DoubleLinkedList lista = new DoubleLinkedList();
	
	@Test
	void test() {
		assertEquals(0, lista.size());
		assertTrue(lista.isEmpty());
		assertTrue(lista.isSorted());
		assertEquals(0, lista.soma());
		//[]
			
		lista.addLast(1);
		assertEquals(1, lista.size());
		assertFalse(lista.isEmpty());
		assertTrue(lista.isSorted());
		assertEquals(1, lista.soma());
		//[1]
		
		lista.add(0, 2);
		assertEquals(2, lista.size());
		assertFalse(lista.isEmpty());
		assertFalse(lista.isSorted());
		assertEquals(3, lista.soma());
		//[2,1]
		
		lista.remove(0);
		assertEquals(1, lista.size());
		assertFalse(lista.isEmpty());
		assertTrue(lista.isSorted());
		assertEquals(1, lista.soma());
		//[1]
		
		lista.add(10, 2);
		assertEquals(1, lista.size());
		assertFalse(lista.isEmpty());
		assertTrue(lista.isSorted());
		assertEquals(1, lista.soma());
		//[1]
		
		lista.add(1, 2);
		assertEquals(2, lista.size());
		assertFalse(lista.isEmpty());
		assertTrue(lista.isSorted());
		assertEquals(3, lista.soma());
		//[1,2]
		
		lista.add(1, 3);
		assertEquals(3, lista.size());
		assertFalse(lista.isEmpty());
		assertFalse(lista.isSorted());
		assertEquals(6, lista.soma());
		//[1,3,2]
		
		lista.remove(2);
		assertEquals(2, lista.size());
		assertFalse(lista.isEmpty());
		assertTrue(lista.isSorted());
		assertEquals(4, lista.soma());
		//[1,3]
		
		lista.remove(10);
		assertEquals(2, lista.size());
		assertFalse(lista.isEmpty());
		assertTrue(lista.isSorted());
		assertEquals(4, lista.soma());
		//[1,3]
		
		lista.add(100, 100);
		assertEquals(2, lista.size());
		assertFalse(lista.isEmpty());
		assertTrue(lista.isSorted());
		assertEquals(4, lista.soma());
		//[1,3]
		
		
		lista.addLast(4);
		assertEquals(3, lista.size());
		assertFalse(lista.isEmpty());
		assertTrue(lista.isSorted());
		assertEquals(8, lista.soma());
		//[1,3,4]
		
		lista.add(1, 2);
		assertEquals(4, lista.size());
		assertFalse(lista.isEmpty());
		assertTrue(lista.isSorted());
		assertEquals(10, lista.soma());
		//[1,2,3,4]
		
		
		lista.remove(lista.size());
		assertEquals(4, lista.size());
		assertFalse(lista.isEmpty());
		assertTrue(lista.isSorted());
		assertEquals(10, lista.soma());
		//[1,2,3,4]
		
		lista.remove(lista.size()-1);
		assertEquals(3, lista.size());
		assertFalse(lista.isEmpty());
		assertTrue(lista.isSorted());
		assertEquals(6, lista.soma());
		//[1,2,3]
		
		
		lista.remove(lista.size()-1);
		assertEquals(2, lista.size());
		assertFalse(lista.isEmpty());
		assertTrue(lista.isSorted());
		assertEquals(3, lista.soma());
		//[1,2]
		
		lista.remove(lista.size()-1);
		assertEquals(1, lista.size());
		assertFalse(lista.isEmpty());
		assertTrue(lista.isSorted());
		assertEquals(1, lista.soma());
		//[1]
		
		lista.remove(lista.size()-1);
		assertEquals(0, lista.size());
		assertTrue(lista.isEmpty());
		assertTrue(lista.isSorted());
		assertEquals(0, lista.soma());
		//[]
		
		lista.remove(lista.size()-1);
		assertEquals(0, lista.size());
		assertTrue(lista.isEmpty());
		assertTrue(lista.isSorted());
		assertEquals(0, lista.soma());
		//[]
		
	}

}
