package week02.examples.function;

import java.util.*;

public class IncrementElements {
    // 리스트의 모든 요소를 1 증가시키는 메서드
    public static void incrementElements(List<Integer> data) {
        for (int i = 0; i < data.size(); i++) {
            data.set(i, data.get(i) + 1);  // 리스트의 값을 직접 수정
        }
    }

    public static void main(String[] args) {
        // 원본 리스트 생성
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3));

        // 복사본 생성
        List<Integer> copiedNumbers = new ArrayList<>(numbers);

        // 함수 호출하여 리스트 요소 값 증가
        incrementElements(copiedNumbers);

        // 리스트 출력
        System.out.println("원본 리스트: " + numbers);
        System.out.println("복사본 리스트: " + copiedNumbers);
    }
}