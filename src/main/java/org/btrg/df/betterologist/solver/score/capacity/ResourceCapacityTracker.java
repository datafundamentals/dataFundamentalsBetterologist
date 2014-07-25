package org.btrg.df.betterologist.solver.score.capacity;

import org.btrg.df.betterologist.domain.Allocation;
import org.btrg.df.betterologist.domain.ResourceRequirement;
import org.btrg.df.betterologist.domain.resource.Resource;

public abstract class ResourceCapacityTracker {

    protected Resource resource;

    public ResourceCapacityTracker(Resource resource) {
        this.resource = resource;
    }

    public abstract void insert(ResourceRequirement resourceRequirement, Allocation allocation);

    public abstract void retract(ResourceRequirement resourceRequirement, Allocation allocation);

    public abstract int getHardScore();

}
