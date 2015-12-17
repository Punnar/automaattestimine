package automaattestimine;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.Mockito;


public class JSonTest {

    @Test // Siin kasutame mocki
    public void Mock(){
        JSon mockingJ = Mockito.mock(JSon.class);
        when(mockingJ.getCommentsArraySize()).thenReturn(500); // teeb nii et getCommentsArraySize tagastab 600
        when(mockingJ.getTodosArraySize()).thenReturn(200); // teeb nii et getTodosArraySize tagastab 200
        assertEquals("Mocki kasutamine", 300, (mockingJ.getCommentsArraySize()-mockingJ.getTodosArraySize()));

    }



}