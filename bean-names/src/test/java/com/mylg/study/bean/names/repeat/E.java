/**
 * @author mylg
 * @date 2021-07-09
 */
package com.mylg.study.bean.names.repeat;

public class E extends C implements B, D {

    @Override
    public C c() {
        return new C();
    }

    private class F {
    }

    private static class G {
    }

    public static class H {
        public static class I {
        }

        public class J {
        }
    }

    public class K {

    }
}
