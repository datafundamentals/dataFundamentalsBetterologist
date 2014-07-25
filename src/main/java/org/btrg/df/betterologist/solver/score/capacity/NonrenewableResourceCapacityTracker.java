package org.btrg.df.betterologist.solver.score.capacity;

import org.btrg.df.betterologist.domain.Allocation;
import org.btrg.df.betterologist.domain.ResourceRequirement;
import org.btrg.df.betterologist.domain.resource.Resource;

public class NonrenewableResourceCapacityTracker extends ResourceCapacityTracker {

    protected int capacity;
    protected int used;

    public NonrenewableResourceCapacityTracker(Resource resource) {
        super(resource);
        if (resource.isRenewable()) {
            throw new IllegalArgumentException("The resource (" + resource + ") is expected to be nonrenewable.");
        }
        capacity = resource.getCapacity();
        used = 0;
    }

    @Override
    public void insert(ResourceRequirement resourceRequirement, Allocation allocation) {
        used += resourceRequirement.getRequirement();
    }

    @Override
    public void retract(ResourceRequirement resourceRequirement, Allocation allocation) {
        used -= resourceRequirement.getRequirement();
    }

    @Override
    public int getHardScore() {
        if (capacity >= used) {
            return 0;
        }
        return capacity - used;
    }

}