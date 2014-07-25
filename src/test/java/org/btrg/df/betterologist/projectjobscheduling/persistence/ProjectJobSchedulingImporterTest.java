/*
 * Copyright 2013 JBoss Inc
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

package org.btrg.df.betterologist.projectjobscheduling.persistence;

import java.io.File;
import java.util.Collection;

import org.btrg.df.betterologist.common.persistence.AbstractSolutionImporter;
import org.btrg.df.betterologist.common.persistence.SolutionImporterTest;
import org.btrg.df.betterologist.persistence.ProjectJobSchedulingImporter;
import org.junit.runners.Parameterized;

public class ProjectJobSchedulingImporterTest extends SolutionImporterTest {

    @Override
    protected AbstractSolutionImporter createSolutionImporter() {
        return new ProjectJobSchedulingImporter();
    }

    @Parameterized.Parameters(name = "{index}: {0}")
    public static Collection<Object[]> getInputFilesAsParameters() {
        return getInputFilesAsParameters(new ProjectJobSchedulingImporter());
    }

    public ProjectJobSchedulingImporterTest(File solutionFile) {
        super(solutionFile);
    }

}
