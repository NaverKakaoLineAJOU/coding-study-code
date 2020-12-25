/*
 * 백준 알고리즘 15820
 * 제목: 맞았는데 왜 틀리죠?
 * https://www.acmicpc.net/contest/problem/576/1
 */

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st01 = new StringTokenizer(br.readLine());
		
		int sampleNum = Integer.parseInt(st01.nextToken());
		int systemNum = Integer.parseInt(st01.nextToken());
		int testNum = sampleNum + systemNum;
		
		double realAnswer;
		double myAnswer;
		for(int i = 0; i < testNum; i++) {
			StringTokenizer st02 = new StringTokenizer(br.readLine());	
			realAnswer = Double.parseDouble(st02.nextToken());
			myAnswer = Double.parseDouble(st02.nextToken());
			
			if(realAnswer != myAnswer && i < sampleNum) {
				System.out.println("Wrong Answer");
				break;
			}
			if(realAnswer != myAnswer && i >= sampleNum) {
				System.out.println("Why Wrong!!!");
				break;
			}
		}
		System.out.println("Accepted");
		return;
	}
}

// 샘플 테스트: 유저에게 제공되는 테스트셋
// 시스템 테스트: 전체 테스트셋
// 모든 테스트의 정답과, 코드가 만든 답이 있을 때 결과 예측하기


// <입력>
// 첫줄: 샘플 테스트 케이스 S1개, 시스템 테스트 케이스 S2개
// 두번째줄~S1개줄: 샘플테스트의 정답과 코드의답 공백으로 나뉨.
// 그다음 S2개: 시스템테스트 정답 + 코드의 답

// <출력>
// 모든 테스트 통과시 Accepted
// 샘플 틀리면 Wrong Answer
// 샘플맞고 테스트 틀리면 Why Wrong!!!


/*
 * 스몰
 * 1 ≤ S1 ≤ 100
 * S2 = 0
*/

/*
 * 라지
 * 1 ≤ S1 + S2 ≤ 100
 * 1 ≤ S1 ≤ 100
 * 0 ≤ S2 ≤ 99
 */