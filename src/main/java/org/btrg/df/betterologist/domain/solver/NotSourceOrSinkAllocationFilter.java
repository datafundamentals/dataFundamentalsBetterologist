package org.btrg.df.betterologist.domain.solver;

import org.btrg.df.betterologist.domain.Allocation;
import org.btrg.df.betterologist.domain.JobType;
import org.optaplanner.core.impl.heuristic.selector.common.decorator.SelectionFilter;
import org.optaplanner.core.impl.score.director.ScoreDirector;

public class NotSourceOrSinkAllocationFilter implements SelectionFilter<Allocation> {

    public boolean accept(ScoreDirector scoreDirector, Allocation allocation) {
        JobType jobType = allocation.getJob().getJobType();
        return jobType != JobType.SOURCE && jobType != JobType.SINK;
    }

}
