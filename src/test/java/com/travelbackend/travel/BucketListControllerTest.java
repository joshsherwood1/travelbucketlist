package com.travelbackend.travel;

import com.travelbackend.travel.model.Bucket;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BucketListControllerTest {
    private List<BucketList> bucket;

    @Mock
    Bucket mockBucket;

    @InjectMocks
    BucketListController subject;

    @Before
    public void setUp() {
        bucket = new ArrayList();
        final AtomicLong counter = new AtomicLong();

        bucket.add(new BucketList(counter.incrementAndGet(), "Nyhavn in Copenhagen, Denmark"));
        bucket.add(new BucketList(counter.incrementAndGet(), "Rila Monastery in Bulgaria"));
    }

    @Test
    public void index_getsIndexPage() {

        when(mockBucket.getBucketList()).thenReturn(bucket);

        ResponseEntity actual = subject.index(mockBucket);
        assertThat(actual.getBody().getClass()).isEqualTo(ArrayList.class);
        assertThat(actual.getBody()).isEqualTo(bucket);
    }
}