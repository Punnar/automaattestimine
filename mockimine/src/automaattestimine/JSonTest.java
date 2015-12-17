package automaattestimine;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.Mockito;


public class JSonTest {
	
	
	@Test
    public void Mock(){
        JSon mockingJ = Mockito.mock(JSon.class);
        when(mockingJ.getCommentsArraySize()).thenReturn(500); // teeb nii et getCommentsArraySize tagastab 600
        when(mockingJ.getTodosArraySize()).thenReturn(200); // teeb nii et getTodosArraySize tagastab 200
        when(mockingJ.getData()).thenCallRealMethod();
        assertEquals("Mocki kasutamine", 300, mockingJ.getData());
    }
	
	
	@Test
	public void Test1(){
	JSon jSon = new JSon();
	assertEquals("Ilma mockimata",300,jSon.getData());
	}



}