package com.travelbackend.travel;

import com.travelbackend.travel.model.Bucket;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class BucketListController {

    private Bucket bucket;

    public BucketListController(){
    }


//    public ResponseEntity index() {
//        return ResponseEntity.ok(myBucketList);
//    }
    @GetMapping(value = "/")
    public ResponseEntity index(Bucket bucket) {
         return ResponseEntity.ok(bucket.getBucketList());
    }

    @GetMapping(value = "/bucket")
    public ResponseEntity getBucket(Bucket bucket, @RequestParam(value="id") Long id) {
        return ResponseEntity.ok(bucket.getBucket(id));
    }

//    @PostMapping(value = "/")
//    public ResponseEntity addToBucketList(@RequestParam(value="name") String name) {
//        myBucketList.add(new BucketList(counter.incrementAndGet(), name));
//        return ResponseEntity.ok(myBucketList);
//          return ResponseEntity.ok(bucket.addBucket(name));
//    }
//
//    @PutMapping(value = "/")
//    public ResponseEntity updateBucketList(@RequestParam(value="name") String name, @RequestParam(value="id") Long id) {
//        myBucketList.forEach(bucketList ->  {
//            if(bucketList.getId() == id){
//                bucketList.setName(name);
//            }
//        });
//        return ResponseEntity.ok(myBucketList);
//    }
//
//    @DeleteMapping(value = "/")
//    public ResponseEntity removeBucketList(@RequestParam(value="id") Long id) {
//        BucketList itemToRemove = null;
//        for(BucketList bucket : myBucketList){
//            if(bucket.getId() == id)
//                itemToRemove = bucket;
//        }
//
//        myBucketList.remove(itemToRemove);
//        return ResponseEntity.ok(myBucketList);
//    }
}