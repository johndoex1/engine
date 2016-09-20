package jadx.tests.integration;

import jadx.core.dex.nodes.ClassNode;
import jadx.tests.api.IntegrationTest;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class TestStringBuilderElimination extends IntegrationTest {

    @Test
    public void test() {
        ClassNode cls = getClassNode(MyException.class);
        String code = cls.getCode().toString();

        assertThat(code, containsString("MyException(String str, Exception e) {"));
        assertThat(code, containsString("super(\"msg:\" + str, e);"));

        assertThat(code, not(containsString("new StringBuilder")));
        assertThat(code, containsString("System.out.println(\"k=\" + k);"));
    }

    public static class MyException extends Exception {
        private static final long serialVersionUID = 4245254480662372757L;

        public MyException(String str, Exception e) {
            super("msg:" + str, e);
        }

        public void method(int k) {
            System.out.println("k=" + k);
        }
    }
}