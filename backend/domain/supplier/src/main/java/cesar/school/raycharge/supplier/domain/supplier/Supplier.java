package cesar.school.raycharge.supplier.domain.supplier;

import cesar.school.raycharge.authentication.domain.user.UserId;
import cesar.school.raycharge.recharge.domain.schedule.ScheduleId;
import cesar.school.raycharge.supplier.domain.station.StationId;
import org.jmolecules.ddd.types.AggregateRoot;

import java.util.List;

public class Supplier implements Cloneable, AggregateRoot<Supplier, SupplierId> {
    private final UserId userId;
    private final SupplierId supplierId;
    private String name;
    private List<StationId> chargingStations;
    private List<ScheduleId> usageHistory;

    public Supplier(UserId userId, SupplierId supplierId, String name, List<StationId> chargingStations, List<ScheduleId> usageHistory) {
        this.userId = userId;
        this.supplierId = supplierId;
        this.name = name;
        this.chargingStations = chargingStations;
        this.usageHistory = usageHistory;
    }

    @Override
    public Supplier clone() {
        try {
            return (Supplier) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public SupplierId getId() {
        return supplierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StationId> getChargingStations() {
        return chargingStations;
    }

    public void setChargingStations(List<StationId> chargingStations) {
        this.chargingStations = chargingStations;
    }

    public List<ScheduleId> getUsageHistory() {
        return usageHistory;
    }

    public void setUsageHistory(List<ScheduleId> usageHistory) {
        this.usageHistory = usageHistory;
    }

    public UserId getUserId() {
        return userId;
    }

}
