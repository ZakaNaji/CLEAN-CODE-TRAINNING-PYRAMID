import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PyramidTest {

    @Test
    public void buildSimplePyramid() {
        Pyramid pyramid = new Pyramid();
        pyramid.addLayer("250 Slaves, 10 Anks");
        assertEquals("XXXXX",  pyramid.print());
        pyramid.addLayer("150 Slaves, 4 Anks");
        String expected =
              "_VVV_\n"
            + "XXXXX";
  assertEquals(expected, pyramid.print());
        pyramid.addLayer("50 Slaves, 2 Anks");
        String expected2 =
               " _X_ \n"
             + "_VVV_\n"
             + "XXXXX";
  assertEquals(expected2, pyramid.print());
    }

    @Test
    public void collapseLayers() { 
        Pyramid pyramid = new Pyramid(); 
        pyramid.addLayer("250 Slaves, 10 Anks");
        pyramid.addLayer("50 Slaves, 3 Anks");
        String expected =
              "__X__\n"
            + "XXXXX";
  assertEquals(expected, pyramid.print());
        pyramid.addLayer("150 Slaves, 6 Anks");
        String expected2 =
               "_XXX_\n"
             + "XXXXX";
  assertEquals(expected2, pyramid.print());
        pyramid.addLayer("150 Slaves, 3 Anks");
        String expected3 =
               " VVV \n"
             + "_XXX_\n"
             + "XXXXX";
  assertEquals(expected3, pyramid.print());
        pyramid.addLayer("150 Slaves, 3 Anks");
        assertEquals(expected3, pyramid.print());
    }
   

}