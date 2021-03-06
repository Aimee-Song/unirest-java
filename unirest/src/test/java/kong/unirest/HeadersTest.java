/**
 * The MIT License
 *
 * Copyright for portions of unirest-java are held by Kong Inc (c) 2013.
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package kong.unirest;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HeadersTest {
    private String ls  = System.lineSeparator();
    @Test
    public void canGetApacheHeaders() {
        Headers headers = new Headers();
        headers.add("foo","bar");

        Header h = headers.all().get(0);

        assertEquals("foo", h.getName());
        assertEquals("bar", h.getValue());
    }

    @Test
    public void dontBombOnNull(){
        Headers h = new Headers();
        h.add(null, "foo");

        assertEquals(0, h.size());
    }

    @Test
    public void toStringOverride() {
        Headers h  = new Headers();
        h.add("a", "1");
        h.add(null, "2");
        h.add("c", () -> "3");
        h.add("d", (String) null);

        String toString = h.toString();
        assertEquals("a: 1" + ls +
                "c: 3" + ls +
                "d: null" + ls, toString);
    }
}