package services;

import models.Operator;
import repository.OperatorRepository;

public class OperatorService {
    private OperatorRepository operatorRepository;

    public Operator getOperator(Long id) {
        return operatorRepository.getOperator(id);
    }

    public Operator saveOperator(Operator operator) {
        return operatorRepository.saveOperator(operator);
    }
}
