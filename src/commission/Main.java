package commission;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Scanner 객체 생성
		Scanner scanner = new Scanner(System.in);

		// MainHelper 클래스의 인스턴스 생성
		MainHelper helper = new MainHelper();

		// 사용자에게 가능한 기능을 보여주고 선택하도록 안내
		System.out.println("1. 수수료 계산기");
		System.out.println("2. 위탁수수료");
		System.out.println("3. 낙찰수수료");
		System.out.println("4. 부동산 중개 수수료 계산");

		// 사용자의 선택을 입력받음
		int choice = helper.getInputFromUser(scanner, "원하는 기능을 선택하세요: ");

		// 사용자의 선택에 따라 처리
		switch (choice) {
			case 1:
				// 수수료 계산 로직
				double commissionRate = helper.getInputFromUser1(scanner, "수수료율을 입력하세요: ");
				double transactionAmount = helper.getInputFromUser1(scanner, "거래 금액을 입력하세요: ");

				// 수수료와 순수익 계산
				double commission = helper.calculateCommission(commissionRate, transactionAmount);
				double netAmount = helper.calculateNetAmount(transactionAmount, commission);

				// 결과 출력
				System.out.println("계산된 수수료: " + commission);
				System.out.println("순수익(거래금액 - 수수료): " + netAmount);
				break;

			case 2:
				// 위탁수수료 계산 로직
				double consignmentAmount = helper.getInputFromUser1(scanner, "위탁 금액을 입력하세요: ");
				double consignmentCommission = helper.calculateConsignmentCommission(consignmentAmount);

				// 결과 출력
				System.out.println("위탁수수료: " + consignmentCommission);
				break;

			case 3:
				// 낙찰수수료 계산 로직
				double bidAmount = helper.getInputFromUser1(scanner, "낙찰 금액을 입력하세요: ");
				double bidCommission = helper.calculateWinningBidCommission(bidAmount);

				// 결과 출력
				System.out.println("낙찰 수수료: " + bidCommission);
				break;

			case 4:
				// 부동산 중개 수수료 계산 로직
				int propertyType = helper.getInputFromUser(scanner, "부동산 유형을 선택하세요 (1. 주택, 2. 오피스텔, 3. 주택이외, 4. 고급주택): ");
				int transactionType = helper.getInputFromUser(scanner, "거래 유형을 선택하세요 (1. 매매/교환, 2. 임대): ");
				double realEstateTransactionAmount = helper.getInputFromUser1(scanner, "거래 금액을 입력하세요: ");

				// 부동산 중개 수수료 계산
				int estateCommission = helper.calculateRealEstateCommission(propertyType, transactionType, realEstateTransactionAmount);

				// 결과 출력
				System.out.println("부동산 중개 수수료: " + estateCommission);
				break;

			default:
				// 잘못된 선택 시 안내 메시지 출력
				System.out.println("다시 선택해주세요");
				break;
		}

		// Scanner 닫기
		scanner.close();
	}
}