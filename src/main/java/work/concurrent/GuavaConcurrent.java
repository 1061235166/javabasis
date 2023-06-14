package work.concurrent;


import com.google.common.collect.MoreCollectors;
import com.google.common.util.concurrent.*;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

import java.util.concurrent.*;

/**
 * 最近在做跨页操作的需求。完全使用内存操作而不做数据库操作，使用到了监听FutureTask，异步回调
 */
public class GuavaConcurrent {

    static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(100));
    /**
     *
     * ListenableFuture配合Futures
     * guava并发包还有好几个东西可以研究使用
     */
    public static void listenableFutureAndFutures(){

        ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(threadPoolExecutor);

        ListenableFuture<?> submit = listeningExecutorService.submit(() -> {

            try {
                System.out.println("开始操作");
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("工作结束");
        });

        Futures.addCallback(submit, new FutureCallback<Object>() {

            /**
             * 成功回调
             * @param result
             */
            @Override
            public void onSuccess(@NullableDecl Object result) {
                System.out.println("成功");
            }

            /**
             * 失败回调
             * 需要注意，onFailure方法入参没有onSuccess方法的返回值result，需要手动添加
             * @param t
             */
            @Override
            public void onFailure(Throwable t) {
                System.out.println("失败");
            }
        }, Executors.newSingleThreadExecutor());


    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        settable();
    }

    public static void settable() throws ExecutionException, InterruptedException {

        ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(threadPoolExecutor);


        SettableFuture<String> future = SettableFuture.create();
        ListenableFuture<?> submit = listeningExecutorService.submit(() -> {
            try {
                System.out.println("运行中");
                future.set("success");
                /**
                 * 如果set了值，之后使用get获取不会出现异常
                 */
                throw new RuntimeException();
                //do something
            }catch (Exception e){
                throw new RuntimeException();
            }finally {
                future.setException(new RuntimeException());
            }
        });

        try {
            String o = future.get();
            System.out.println(o);
        }catch (Exception  e){
            e.printStackTrace();
        }

    }

}
