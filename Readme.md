# ThreadPoolPolicyTest

## ThreadPool

- 작업처리에 사용되는 Thread를 제한된 개수만큼 정해놓고 작업 큐에 들어오는 작업을 하나씩 Thread가 맡아 처리.

> 스레드 풀에서 실행할 작업이 서로 독립적인 경우에만 스레드의 개수나 작업 큐의 크기를 제한할 수 있습니다. 다른 작업에 의존성을 갖는 작업을 실행해야 할 때 스레드나 큐의 크기가 제한되어 있다면 스레드 부족 데드락에 걸릴 가능성이 높습니다. 이럴때는 newCachedThreadPool 메소드에서 생성하는 것과 같이 크기가 제한되지 않은 풀을 사용해야 합니다.

## RejectedExecution

- ThreadPoolExecutor에서 Task를 더 이상 받을 수 없을때 호출.
- `큐 허용치 초과` or `Executor down`일 때 발생.

## Saturation Policy

- Executor: 제한된 작업 큐 용량이 꽉 찼을 때 4가지 전챡중 선택해서 사용할 수 있다.

### AbortPolicy

- Default Policy.
- Reject된 Task가 RejectedExecutorException을 Throw.

### CallerRunsPolicy

- 호출한 Thread에서 Reject된 Task를 대신 실행.

### DiscardPolicy

- Reject된 Task는 Trash.
- Exception 발생 X.

### DiscardOldestPolicy

- 실행자를 종료하지 않는 한 가장 오래되며 처리되지 않은 요청을 Delete -> 다시 `Execute()` 시도.
- DiscardPolicy와 마찬가지로 일부 요청은 유실.