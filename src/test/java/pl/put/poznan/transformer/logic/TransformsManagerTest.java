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
    private Transformer transformerMock;
    private TransformerFactory factoryMock;

    @Before
    public void globalSetUp()
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

    @Test //single invocation #1
    public void TransformTest1(){
        String[] t = new String[] {"capitalize"};
        manager = new TransformsManager(t, factoryMock);

        manager.applyTransformations("test");

        verify(factoryMock, times(1)).CreateCapitalizer(any());
    }

    @Test //single invocation #2
    public void TransformTest2(){
        String[] t = new String[] {"numberToWord"};
        manager = new TransformsManager(t, factoryMock);

        manager.applyTransformations("test");

        verify(factoryMock, times(1)).CreateNumberToWord(any());
    }

    @Test //single invocation #3
    public void TransformTest3(){
        String[] t = new String[] {"unicode"};
        manager = new TransformsManager(t, factoryMock);

        manager.applyTransformations("test");

        verify(factoryMock, times(1)).CreateUnicode(any());
    }


    @Test //sequence of invocations #1
    public void TransformTest4(){
        String[] t = new String[] {"capitalize", "inverse"};
        manager = new TransformsManager(t, factoryMock);

        manager.applyTransformations("test");

        verify(factoryMock, times(1)).CreateCapitalizer(any());
        verify(factoryMock, times(1)).CreateInverser(any());


        InOrder inOrder = inOrder(factoryMock);
        inOrder.verify(factoryMock).CreateBaseTransformer(any());
        inOrder.verify(factoryMock).CreateCapitalizer(any());
        inOrder.verify(factoryMock).CreateInverser(any());
    }

    @Test //sequence of invocations #2
    public void TransformTest5(){
        String[] t = new String[] {"shorten", "removeInterpunction", "inverseSentence"};
        manager = new TransformsManager(t, factoryMock);

        manager.applyTransformations("test");

        verify(factoryMock, times(1)).CreateShortcutShortener(any());
        verify(factoryMock, times(1)).CreateremoveInterpunction(any());
        verify(factoryMock, times(1)).CreateSentenceInverser(any());


        InOrder inOrder = inOrder(factoryMock);
        inOrder.verify(factoryMock).CreateShortcutShortener(any());
        inOrder.verify(factoryMock).CreateremoveInterpunction(any());
        inOrder.verify(factoryMock).CreateSentenceInverser(any());
    }

    @Test //sequence of invocations #3
    public void TransformTest6(){
        String[] t = new String[] {"pokemon", "lower", "removeReplic"};
        manager = new TransformsManager(t, factoryMock);

        manager.applyTransformations("test");

        verify(factoryMock, times(1)).CreatePokemonTransformer(any());
        verify(factoryMock, times(1)).CreateLowerCaseTransformer(any());
        verify(factoryMock, times(1)).CreateReplicRemoval(any());


        InOrder inOrder = inOrder(factoryMock);
        inOrder.verify(factoryMock).CreatePokemonTransformer(any());
        inOrder.verify(factoryMock).CreateLowerCaseTransformer(any());
        inOrder.verify(factoryMock).CreateReplicRemoval(any());
    }

}