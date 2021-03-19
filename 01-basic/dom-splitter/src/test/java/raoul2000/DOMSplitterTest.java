package raoul2000;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DOMSplitterTest {
    @Test
    public void nothing() {
        DOMSplitter domSplitter = new DOMSplitter();
    }
    
    @Test
    public void canReturnTheWrappedDocument() {
        DOMSplitter domSplitter = new DOMSplitter();
        assertTrue(domSplitter.getDOM() instanceof Document);

    }
}
