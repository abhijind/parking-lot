package repository;

import models.Gate;
import models.Operator;

import java.util.HashMap;
import java.util.Map;

public class OperatorRepository {
    private final Map<Long, Operator> operatorStore;

    private Long counter;

    public OperatorRepository() {
        operatorStore = new HashMap<>();
        counter = 0L;
    }

    public Operator getOperator(Long operatorId) {
        return operatorStore.get(operatorId);
    }

    public Operator saveOperator(Operator operator) {
        operator.setId(counter);
        operatorStore.put(counter++, operator);
        return operator;
    }

}
