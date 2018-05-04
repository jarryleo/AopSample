package cn.leo.aopsample;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        String s = "本次操作需要 [存储空间]  [存储空间] 权限，是否前往开启?";
        String r = s.replaceAll("(\\s\\[.*\\]\\s)\\1+", "$1");
        System.out.println(r);
    }
}