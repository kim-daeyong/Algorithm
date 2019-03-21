package topcorder.kiwi;

public class kiwi {
        /**
         * 타로는 맛있는 키위주스를 준비했습니다. 타로는 0부터 n-1이라 이름을 붙인 n개의 병에 키위주스를 넣었습니다.
         * 이때 i 번째 병의 용은 capacities[i] 리터이며 타로가 i번째 병에 넣은 키위주스의 양을 bottles[i] 리터라고 한다
         * 타로는 병에 키위주스를 재분배하려고 하며 0부터 m-1까지 m 회 조작합니다.
         * 병 fromId[i] 가 비어 있거나 병 toId[i] 가 꽉 차 있는 순간 타로는 더 이상 키위주스를 넣지 않는다.
         * 8개의 요소를 가진 정수배열 int[]를 리턴해주세요 배열의 i번째 요소는 모든 주스를 쏟는 작업이 완료되고 i 번째 병에
         * 남아있는 키위 주스의 양입니다.
         */
    public static int[] thePouring1(int[] capacities, int[] bottles, int[] fromId, int[] toId) {
            // 0 ~ N-1 번째 병의 용량은 capacities[0] ~ capacities[N-1]
            // 0 ~ N-1 번째에 넣은 키위주스 양 bottle[0] ~ capacities[N-1]

            //단순히 반복 작업, 조건문을 적게 하는 것이 중요하다.
            //수용량을 비교하여 반복한다.
            for(int i = 0; i < fromId.length ; i++) {
                int f = fromId[i];  // 주스를 뺄 병
                int t = toId[i];    //주스를 넣을 병

                // 주스를 옮겼을때 넘쳐버린경우 > 수용량보다 옮길 주스양이 많다
                if(capacities[t] <= bottles[f] + bottles[t]) {
                    // f의 남은 용량은 t의 수용량에서 t가 가진 양을 뺀 후 f를 빼면 f에 남은 용량이다.
                    bottles[f] = bottles[f] - (capacities[t] - bottles[t]);
                    bottles[t] = capacities[t];
                }else {
                    // 수용량이 더 크다면 f의 전체 양을 t에 부어준다
                    bottles[t] = bottles[f] + bottles[t];
                    bottles[f] = 0;
                }
            }
            return bottles;
        }



    public static int[] thePouring2(int[] capacities, int[] bottles, int[] fromId, int[] toId) {

            // 조건문을 줄인 경우
            for(int i =0; i< fromId.length ; i++) {

                int f = fromId[i];  // 주스를 뺄 병
                int t = toId[i];    //주스를 넣을 병

                // 옮길 주스의 양과 기존 주스병의 남은 용량을 비교하면 둘중 작은 것이 이동량이 된다
                // Math.min은 둘 중 작은 값을 리턴한다.
                int vol = Math.min(bottles[f], capacities[t] - bottles[t]);

                //이동량 만큼을 기존 주스의 양에서 빼거나 더해준다.
                bottles[f] -= vol;
                bottles[t] += vol;

            }
            return bottles;
        }



    //메인
    public static void main(String[] args) {
        //1
        int[] capacities = {30,20,10};
        int[] bottles = {10,5,5};
        int[] fromId = {0,1,2};
        int[] toId = {1,2,0};

        //2
        int[] capacities2 = {14,35,86,58,25,62};
        int[] bottles2 = {6,34,27,38,9,60};
        int[] fromId2 = {1,2,4,5,3,3,1,0};
        int[] toId2 = {0,1,2,4,2,5,3,1};




        int[] result = thePouring1(capacities, bottles, fromId, toId);
        int[] result2 = thePouring2(capacities2, bottles2, fromId2, toId2);
//        int[] result3 = thePouring3(capacities3, bottles3, fromId3, toId3);

        System.out.print("입력값 1 결과 :  ");
        for(int i =0; i< result.length ; i++) {
            System.out.print(result[i]+"   ");
        }
        System.out.println("\n");


        System.out.print("입력값 2 결과 :  ");
        for(int i =0; i< result2.length ; i++) {
            System.out.print(result2[i]+"   ");
        }


    }
}
