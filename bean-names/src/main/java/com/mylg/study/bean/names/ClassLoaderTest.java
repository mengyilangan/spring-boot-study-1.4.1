/**
 * @author jiangqiaonan
 * @date 2021-06-05
 */
package com.mylg.study.bean.names;

import org.springframework.core.io.support.SpringFactoriesLoader;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Enumeration;

public class ClassLoaderTest {
    public static void main(String[] args) throws IOException {
        String s = System.getProperty("java.class.path");
        System.out.println(Arrays.toString(s.split(":")));
        System.out.println(Arrays.toString(getClassPath("target/bean-names-0.0.1-SNAPSHOT.jar")));
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader.getResource(SpringFactoriesLoader.FACTORIES_RESOURCE_LOCATION));
        Enumeration<URL> urlList = classLoader.getResources(SpringFactoriesLoader.FACTORIES_RESOURCE_LOCATION);
        while (urlList.hasMoreElements()) {
            URL url = urlList.nextElement();
            System.out.println(url);
        }
    }

    private static File[] getClassPath(String var0) {
        File[] var1;
        if (var0 != null) {
            int var2 = 0;
            int var3 = 1;
            boolean var4 = false;

            int var5;
            int var7;
            for (var5 = 0; (var7 = var0.indexOf(File.pathSeparator, var5)) != -1; var5 = var7 + 1) {
                ++var3;
            }

            var1 = new File[var3];
            var4 = false;

            for (var5 = 0; (var7 = var0.indexOf(File.pathSeparator, var5)) != -1; var5 = var7 + 1) {
                if (var7 - var5 > 0) {
                    var1[var2++] = new File(var0.substring(var5, var7));
                } else {
                    var1[var2++] = new File(".");
                }
            }

            if (var5 < var0.length()) {
                var1[var2++] = new File(var0.substring(var5));
            } else {
                var1[var2++] = new File(".");
            }

            if (var2 != var3) {
                File[] var6 = new File[var2];
                System.arraycopy(var1, 0, var6, 0, var2);
                var1 = var6;
            }
        } else {
            var1 = new File[0];
        }

        return var1;
    }

}
