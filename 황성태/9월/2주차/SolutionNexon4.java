import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SolutionNexon4 {
    public static List<Integer> getServerIndex(int n, List<Integer> arrival, List<Integer> burstTime) {
        // 서버의 상태를 나타내는 우선순위 큐 (종료 시간, 서버 번호)
        PriorityQueue<int[]> serverQueue = new PriorityQueue<>(
                Comparator.comparingInt(a -> a[0]) // 종료 시간 기준으로 정렬
        );
        
        // 모든 서버를 초기화 (종료 시간 0, 서버 번호 i+1)
        for (int i = 0; i < n; i++) {
            serverQueue.add(new int[]{0, i + 1}); // 종료 시간 0으로 초기화
        }

        // 결과를 저장할 리스트
        List<Integer> result = new ArrayList<>();

        int m = arrival.size();
        for (int i = 0; i < m; i++) {
            int requestArrival = arrival.get(i);
            int requestBurst = burstTime.get(i);

            // 요청 도착 시간에 사용할 수 있는 서버를 확인
            while (!serverQueue.isEmpty() && serverQueue.peek()[0] <= requestArrival) {
                // 서버를 우선순위 큐에서 제거하고
                int[] server = serverQueue.poll();
                // 사용 가능한 서버가 없을 때 추가
                serverQueue.add(new int[]{server[0], server[1]});
            }

            // 가장 빨리 사용 가능한 서버를 선택
            if (!serverQueue.isEmpty()) {
                int[] server = serverQueue.poll();
                int serverId = server[1];
                result.add(serverId);
                // 새로운 종료 시간 계산 및 서버 추가
                serverQueue.add(new int[]{requestArrival + requestBurst, serverId});
            } else {
                // 사용할 수 있는 서버가 없는 경우
                result.add(-1);
            }
        }

        return result;
    }
}
