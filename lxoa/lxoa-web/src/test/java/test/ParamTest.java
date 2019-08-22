package test;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParamTest {

    String param = "param";

    private void a(List<String> list){
        if(!CollectionUtils.isEmpty(list)){
            list.add("333");
            list.add("444");
        }
    }

    private void b(String s){
        s = "ha";
        param = "after";
    }

    public static void main(String[] args) {
/*        ParamTest test = new ParamTest();
        List<String> aa = Arrays.asList("111","222");
        aa.add("666");
        System.out.println(aa);

        String bb = "ou";
        test.b(bb);
        System.out.println(bb);
        System.out.println(test.param);*/
        System.out.println(128 == new Integer(128));


        Integer a = new Integer(12);
        Integer b = new Integer(12);
        System.out.println(a.toString());
        System.out.println(b.toString());



        System.out.println(new Integer(127) == new Integer(127));
        System.out.println(new Integer(128) == new Integer(128));
/*        String s = "";
        for(int i= 0;i<Integer.MAX_VALUE;i=i+100){
            s += "ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss";
            System.out.println(i);
        }*/

    }
}
