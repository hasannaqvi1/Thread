package ExecutorFrameWork;

import java.util.concurrent.Callable;

public class MyCallable implements Callable {
    int num;
    public MyCallable(int num){
        this.num = num;
    }
    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName() +" is responsible for finding the sum of "+num
        +" numbers");
        int sum =0;
        for(int i=0;i<num;i++){
            sum+=i;
        }
        return sum;
    }


    }

