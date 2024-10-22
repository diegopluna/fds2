package com.cesar.school.fds2.raycharge.motorista.domain.veiculo;

import java.util.Objects;

import static org.apache.commons.lang3.Validate.isTrue;
import org.jmolecules.ddd.types.Identifier;
import org.jmolecules.ddd.types.ValueObject;

public class IdVeiculo implements ValueObject, Identifier {
    private final int id;

    public IdVeiculo(int id) {
        isTrue(id > 0, "O id deve ser positivo");

        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof IdVeiculo) {
            var idVeiculo = (IdVeiculo) obj;
            return id == idVeiculo.id;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return Integer.toString(id);
    }
}
