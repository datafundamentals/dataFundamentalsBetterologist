/*
 * Copyright 2012 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.btrg.df.betterologist.projectjobscheduling.app;

import java.io.File;

import org.btrg.df.betterologist.common.app.SolverPerformanceTest;
import org.btrg.df.betterologist.common.persistence.SolutionDao;
import org.btrg.df.betterologist.persistence.ProjectJobSchedulingDao;
import org.junit.Test;
import org.optaplanner.core.config.solver.EnvironmentMode;

public class ProjectJobSchedulingPerformanceTest extends SolverPerformanceTest {

    @Override
    protected String createSolverConfigResource() {
        return "/org/btrg/df/betterologist/solver/projectJobSchedulingSolverConfig.xml";
    }

    @Override
    protected SolutionDao createSolutionDao() {
        return new ProjectJobSchedulingDao();
    }

    // ************************************************************************
    // Tests
    // ************************************************************************

    @Test(timeout = 600000)
    public void solveModel_A_4() {
        File unsolvedDataFile = new File("data/projectjobscheduling/unsolved/A-4.xml");
        runSpeedTest(unsolvedDataFile, "0/-152/-69");
    }

    @Test(timeout = 600000)
    public void solveModel_A_4FastAssert() {
        File unsolvedDataFile = new File("data/projectjobscheduling/unsolved/A-4.xml");
        runSpeedTest(unsolvedDataFile, "0/-193/-92", EnvironmentMode.FAST_ASSERT);
    }

}
