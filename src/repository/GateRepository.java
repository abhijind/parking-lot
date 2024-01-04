package repository;

import models.Gate;

import java.util.HashMap;
import java.util.Map;

public class GateRepository {
    private final Map<Long, Gate> gateStore;

    private Long counter;

    public GateRepository() {
        gateStore = new HashMap<>();
        counter = 0L;
    }

    public Gate getGate(Long gateId) {
        return gateStore.get(gateId);
    }

    public Gate saveGate(Gate gate) {
        gate.setId(counter);
        gateStore.put(counter++, gate);
        return gate;
    }

}
