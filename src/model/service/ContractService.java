package model.service;

import models.entities.Contract;
import models.entities.Installment;

public class ContractService {

	public void processContract(Contract contract, int months, OnlinePaymentService onlinePayment) {

		int qtd = 1;
		for (int c = 0; c < months; c++) {

			contract.addList(new Installment(contract.getDate().plusMonths(qtd),
					onlinePayment.interest((contract.getTotalValue() / months), qtd)));
			qtd++;
		}

	}
}
