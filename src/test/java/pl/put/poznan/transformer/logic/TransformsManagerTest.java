package pl.put.poznan.transformer.logic;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;


public class TransformsManagerTest {

    private TransformsManager manager = null;

    @Mock
    private static Transformer transformerMock;
    private static TransformerFactory factoryMock;

    @BeforeClass
    public static void globalSetUp()
    {
        transformerMock = mock(Transformer.class);
        when(transformerMock.transform()).thenReturn("test");

        factoryMock = mock(TransformerFactory.class);
        when(factoryMock.CreateBaseTransformer(any())).thenReturn(transformerMock);

        when(factoryMock.CreateCapitalizer(any())).thenReturn(transformerMock);
        when(factoryMock.CreateInverser(any())).thenReturn(transformerMock);
        when(factoryMock.CreateLatexTransformer(any())).thenReturn(transformerMock);
        when(factoryMock.CreateLowerCaseTransformer(any())).thenReturn(transformerMock);
        when(factoryMock.CreateNumberToWord(any())).thenReturn(transformerMock);
        when(factoryMock.CreatePokemonTransformer(any())).thenReturn(transformerMock);
        when(factoryMock.CreateReplicRemoval(any())).thenReturn(transformerMock);
        when(factoryMock.CreateSentenceInverser(any())).thenReturn(transformerMock);
        when(factoryMock.CreateShortcutExtender(any())).thenReturn(transformerMock);
        when(factoryMock.CreateShortcutShortener(any())).thenReturn(transformerMock);
        when(factoryMock.CreateUnicode(any())).thenReturn(transformerMock);
        when(factoryMock.CreateUpperCaseTransformer(any())).thenReturn(transformerMock);

    }

    @Before
    public void setUp1(){
        String[] t = new String[] {"capitalize"};
        manager = new TransformsManager(t, factoryMock);
    }

    @Test
    public void TransformTest1(){
        manager.applyTransformations("test");
        verify(factoryMock, times(1)).CreateCapitalizer(any());
    }


    @Before
    public void setUp2(){
        String[] t = new String[] {"capitalize", "inverse"};
        manager = new TransformsManager(t, factoryMock);
    }

    @Test
    public void TransformTest2(){
        manager.applyTransformations("test");

        verify(factoryMock, times(1)).CreateCapitalizer(any());
        verify(factoryMock, times(1)).CreateInverser(any());

        /*InOrder inOrder = inOrder(factoryMock);
        inOrder.verify(factoryMock).CreateBaseTransformer(any());
        inOrder.verify(factoryMock).CreateCapitalizer(any());
        inOrder.verify(factoryMock).CreateInverser(any());*/
    }

}