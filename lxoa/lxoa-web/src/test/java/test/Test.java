package test;



import java.io.IOException;
import java.io.Writer;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.reflections.Reflections;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;

/**
 * @author shachor
 * @date 2018/12/27 9:04
 */
public class Test {
    int a = 0;
    public static void main(String[] args){
       /* int[] a = new int[10];
        a[0] = 0;
        a[1] = 1;
        a[2] = 2;
        a[3] = 3;
        System.arraycopy(a, 2, a, 3, 1);
        a[2]=99;
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        System.out.println("~~~");
        int b[] =Arrays.copyOf(a,12);
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
        List<String> list =new ArrayList<>();
        Map<String,String> hashMap = new HashMap<>();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(()->{

        });

        AtomicBoolean atomicBoolean = new AtomicBoolean(true);

        AtomicReference atomicReference = new AtomicReference();
        System.out.println("-------------------");
        int i;
        System.out.println("-------------------");
        System.out.println(i = true?1:0);
        System.out.println(i);
        Reflections reflections = new Reflections("com.ab.*");
        reflections.getTypesAnnotatedWith(Controller.class);

        A<String> as = new A<>("123");
        System.out.println(as.getT());*/
        Test test = new Test();
        test.test();


    }

    public void test(){
        for(int s =0;s<100;s++){
            new Thread(()->{
                a++;
                System.out.println(a);
            }).run();
        }


        /*synchronized (test.class){

        }*/
    }
}

class A<T> {
    private T t;
    public A(T t){
        this.t =t;
    }

    public String getT(){
        return t.toString();
    }
}
