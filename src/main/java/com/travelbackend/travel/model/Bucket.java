package com.travelbackend.travel.model;

import com.travelbackend.travel.BucketList;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Bucket {

    public List<BucketList> getTheList() {
        List<BucketList> myBucketList = new ArrayList();
        final AtomicLong counter = new AtomicLong();

        myBucketList.add(new BucketList(counter.incrementAndGet(), "Nyhavn in Copenhagen, Denmark"));
        myBucketList.add(new BucketList(counter.incrementAndGet(), "Rila Monastery in Bulgaria"));

        return myBucketList;
    }

    public List<BucketList> getBucketList() {
        return getTheList();
    }

    public BucketList getBucket(Long id) {

        BucketList itemToReturn = null;
        for(BucketList bucket : getTheList()){
            if(bucket.getId() == id)
                itemToReturn = bucket;
        }
        return itemToReturn;
    }
}
