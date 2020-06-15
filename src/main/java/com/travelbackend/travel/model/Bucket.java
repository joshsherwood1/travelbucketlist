package com.travelbackend.travel.model;

import com.travelbackend.travel.BucketList;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Component
public class Bucket {

    public Bucket() {
//        AtomicLong counter = new AtomicLong();
        myBucketList.add(new BucketList(counter.incrementAndGet(), "Nyhavn in Copenhagen, Denmark"));
        myBucketList.add(new BucketList(counter.incrementAndGet(), "Rila Monastery in Bulgaria"));
    }
//
    List<BucketList> myBucketList = new ArrayList();
    AtomicLong counter = new AtomicLong();

//    public List<BucketList> getTheList() {
//        final AtomicLong counter = new AtomicLong();
//
//        myBucketList.add(new BucketList(counter.incrementAndGet(), "Nyhavn in Copenhagen, Denmark"));
//        myBucketList.add(new BucketList(counter.incrementAndGet(), "Rila Monastery in Bulgaria"));
//
//        return myBucketList;
//    }

    public List<BucketList> getBucketList() {
        return myBucketList;
    }

    public BucketList getBucket(Long id) {

        BucketList itemToReturn = null;
        for(BucketList bucket : myBucketList){
            if(bucket.getId() == id)
                itemToReturn = bucket;
        }
        return itemToReturn;
    }


    public List addBucket(String name) {
//        final AtomicLong counter = new AtomicLong();
        myBucketList.add(new BucketList(counter.incrementAndGet(), name));
        return myBucketList;
    }

    public List removeBucket(Long id) {
        for(BucketList bucket : myBucketList){
            if(bucket.getId() == id)
               myBucketList.remove(bucket);
        }
        return myBucketList;
    }
}
