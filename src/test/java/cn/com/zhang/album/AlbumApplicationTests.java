package cn.com.zhang.album;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootTest
@EnableScheduling
class AlbumApplicationTests {

    @Test
    void contextLoads() {
        int i = 0;
        System.out.print(i);
    }

}
