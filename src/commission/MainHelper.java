package commission;

import java.util.Scanner;

public class MainHelper {
	// 사용자로부터 정수 입력을 받는 메서드
	public int getInputFromUser(Scanner scanner, String message) {
		System.out.print(message);
		return scanner.nextInt();
	}

	// 사용자로부터 실수 입력을 받는 메서드
	public double getInputFromUser1(Scanner scanner, String message) {
		System.out.print(message);
		return scanner.nextDouble();
	}

	// 수수료를 계산하는 메서드
	public double calculateCommission(double commissionRate, double amount) {
		return (commissionRate / 100) * amount;
	}

	// 순수익을 계산하는 메서드
	public double calculateNetAmount(double amount, double commission) {
		return amount - commission;
	}

	// 위탁수수료를 계산하는 메서드
	public double calculateConsignmentCommission(double consignmentAmount) {
		double consignmentRate = 11.0; // 위탁수수료율을 11%로 고정
		return (consignmentRate / 100) * consignmentAmount;
	}

	// 낙찰수수료를 계산하는 메서드
	public double calculateWinningBidCommission(double winningBidAmount) {
		double winningBidRate = 16.5; // 낙찰수수료율을 16.5%로 고정
		return (winningBidRate / 100) * winningBidAmount;
	}

	// 부동산 중개 수수료를 계산하는 메서드
	public int calculateRealEstateCommission(int propertyType, int transactionType, double transactionAmount) {
		double commissionRate = 0.0;
		double limitAmount = Double.MAX_VALUE; // 무제한으로 설정

		// 부동산 유형에 따라 수수료율 설정
		switch (propertyType) {
			case 1: // 주택
				commissionRate = calculateHomeCommissionRate(transactionType, transactionAmount);
				break;
			case 2: // 오피스텔
				commissionRate = (transactionType == 1) ? 0.5 : 0.4; // 매매/교환인 경우 0.5%, 임대차인 경우 0.4%
				break;
			case 3: // 주택이외
				commissionRate = 0.9;
				break;
			case 4: // 고급주택
				commissionRate = (transactionType == 1) ? 0.9 : 0.8; // 매매/교환인 경우 0.9%, 임대인 경우 0.8%
				break;
			default:
				System.out.println("잘못된 부동산 유형입니다.");
				break;
		}

		// 수수료 및 중개보수 한도 계산
		double commission = (commissionRate / 100) * transactionAmount;
		double result = Math.min(commission, limitAmount); // 중개보수 한도를 초과하지 않도록 처리

		// 여기서 int로 변환할 때 적절한 룰을 적용하거나 원하는 방식으로 변환합니다.
		return (int) result;
	}

	// 주택에 대한 중개 수수료율을 계산하는 메서드
	private double calculateHomeCommissionRate(int transactionType, double transactionAmount) {
		if (transactionType == 1) { // 매매/교환인 경우
			if (transactionAmount < 50000000) {
				return 0.6;
			} else if (transactionAmount < 200000000) {
				return 0.5;
			} else if (transactionAmount < 600000000) {
				return 0.4;
			} else if (transactionAmount < 900000000) {
				return 0.5;
			} else {
				return 0.9;
			}
		} else { // 매매/교환 이외의 경우 (임대차 등)
			if (transactionAmount < 50000000) {
				return 0.5;
			} else if (transactionAmount < 100000000) {
				return 0.4;
			} else if (transactionAmount < 300000000) {
				return 0.3;
			} else if (transactionAmount < 600000000) {
				return 0.4;
			} else {
				return 0.8;
			}
		}
	}
}