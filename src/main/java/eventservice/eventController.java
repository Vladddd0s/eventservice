package eventservice;

import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Qualifier;
import timetable.Train;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

@org.springframework.stereotype.Controller
public class eventController {
    HazelcastInstance hazelcastInstance;
    BlockingQueue<Train> queue;
    public eventController(@Qualifier("hazelcastInstance") HazelcastInstance hazelcastInstance){
        this.hazelcastInstance = hazelcastInstance;
        this.queue = hazelcastInstance.getQueue("queue");
         while(true){

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Train train=new Train();
            queue.add(train);
        }

    }
}

