package com.atguigu.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class ForkJoinDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        test1();//500000000500000000===>3510
//        test2();//500000000500000000===>2124
        test3();//500000000500000000===>266

    }

    static void  test1(){
        Long sum = 0L;
        long s = System.currentTimeMillis();
        for(Long i=1L;i<=10_0000_0000L;i++){
            sum += i;
        }
        long e = System.currentTimeMillis();
        System.out.println(sum+"===>"+(e-s));
    }

    static void  test2() throws ExecutionException, InterruptedException {
        ForkJoinTask<Long>  forkJoinTest = new ForkJoinTest(0l, 10_0000_0000l);
        Long sum = 0l;
        long s = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.submit(forkJoinTest);

        sum = forkJoinTest.get();
        long e = System.currentTimeMillis();
        System.out.println(sum+"===>"+(e-s));
    }

    static void test3(){
        Long sum = 0l;
        long s = System.currentTimeMillis();
        sum = LongStream.rangeClosed(0L,10_0000_0000L).parallel().reduce(0L,Long::sum);
        long e = System.currentTimeMillis();
        System.out.println(sum+"===>"+(e-s));
    }

}



class ForkJoinTest extends RecursiveTask<Long>{

    Long start;

    public ForkJoinTest(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    Long end;
    Long gap = 1000000L;


    @Override
    protected Long compute() {
        Long sum = 0L;
        if((end-start)<gap){
            for(Long i=start;i<=end;i++){
                sum += i;
            }
            return sum;
        }else{
            Long middle = (start+end)/2;
            ForkJoinTest forkJoinTest1 = new ForkJoinTest(start, middle);
            forkJoinTest1.fork();
            ForkJoinTest forkJoinTest2 = new ForkJoinTest(middle+1, end);
            forkJoinTest2.fork();
            sum = forkJoinTest1.join()+forkJoinTest2.join();
            return sum;
        }

    }
}


