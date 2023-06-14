import com.google.common.primitives.Booleans;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import io.reactivex.Observable;
import org.apache.commons.lang3.BooleanUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class InterruptThreadWorking {


    public static void main(String[] args) {

        ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(1));

        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        ListenableFuture<?> future = listeningExecutorService.submit(() -> {
            while (true){
                if (atomicBoolean.get()){
                    throw new RuntimeException();
                }
                System.out.println(System.currentTimeMillis());
            }
        });

        try {
            TimeUnit.SECONDS.sleep(3);
            boolean b = atomicBoolean.compareAndSet(false, true);
            if (b){
                atomicBoolean.set(false);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结束");
        listeningExecutorService.shutdownNow();
    }

}
