package automaattestimine;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.Mockito;


public class JSonTest {

    @Test
    public void Test1(){
        JSon jSon = new JSon();
        assertEquals("Ilma mockimata",300,jSon.getData());
    }
    
    @Test
    public void Test2(){
    	JSon jSon = new JSon();
        assertEquals("Testime getCommetsArraySize funktsiooni",500,jSon.getCommentsArraySize());
    }
    
    @Test
    public void Test3(){
    	JSon jSon = new JSon();
        assertEquals("Testime getTodosArraySize funktsiooni",200,jSon.getTodosArraySize());
    }



    @Test // Siin kasutame mocki
    public void Mock(){
        JSon mockingJ = Mockito.mock(JSon.class);
        when(mockingJ.getData()).thenCallRealMethod(); // callib päris meetodi
        when(mockingJ.getCommentsArraySize()).thenReturn(500); // teeb nii et getCommentsArraySize tagastab 600
        when(mockingJ.getTodosArraySize()).thenReturn(200); // teeb nii et getTodosArraySize tagastab 200
        assertEquals("Mocki kasutamine", 300, mockingJ.getData());

    }



}