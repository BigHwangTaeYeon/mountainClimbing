package side.project.publicapi.scheduler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import lombok.extern.slf4j.Slf4j;

@Slf4j     // 로그를 위해서
@Configuration
public class ScheduledTasks {
    private static final DateTimeFormatter formatter 
            = DateTimeFormatter.ofPattern("mm:ss:SSS");

    //3초 간격으로 실행 (로그 단위 분:초:밀리세컨드)
    // @Scheduled(fixedRate = 3000)
    public void fixedRate() {
        log.info("fixedRate: 현재시간 - {}", formatter.format(LocalDateTime.now()));
    }

    // fixedRate와 마찬가지로 fixedDelay는 일정 간격으로 실행됩니다. 
    // 그러나 fixedDelay는 이전 작업 완료 이후 시간부터 측정됩니다.
    // @Scheduled(fixedDelay = 1000)
    public void fixedDelay() throws InterruptedException {
        log.info("시작시간 - {}", formatter.format(LocalDateTime.now()));
        TimeUnit.SECONDS.sleep(5);
        log.info("종료시간 - {}", formatter.format(LocalDateTime.now()));
    }

    // 첫 작업이 실행되기 전까지 대기할 시간을 지정할 수 있습니다.
    // initialDelay는 fixedRate, fixedDelay 모두 사용할 수 있습니다.
    // @Scheduled(fixedRate = 3000, initialDelay = 5000)
    public void fixedRateAndInitialDelay() {
        log.info("현재시간 - {}", formatter.format(LocalDateTime.now()));
    }

    // 크론 표현식으로 정해진 날짜와 시간으로 작업을 수행
    // 매주 일요일 자정
    @Scheduled(cron = "0 0 0 ? * SUN *")
    public synchronized void cronExpression() {
        log.info("현재시간 - {}", formatter.format(LocalDateTime.now()));
    }

}
