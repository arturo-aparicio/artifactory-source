/*
 *
 * Artifactory is a binaries repository manager.
 * Copyright (C) 2018 JFrog Ltd.
 *
 * Artifactory is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 * Artifactory is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Artifactory.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package org.artifactory.schedule.mbean;

import org.artifactory.schedule.ArtifactoryConcurrentExecutor;

/**
 * MBean wrapper for {@link org.artifactory.schedule.ArtifactoryConcurrentExecutor}
 *
 * @author mamo
 */
public class ManagedExecutor implements ManagedExecutorMBean {

    private final ArtifactoryConcurrentExecutor artifactoryConcurrentExecutor;

    public ManagedExecutor(ArtifactoryConcurrentExecutor artifactoryConcurrentExecutor) {
        this.artifactoryConcurrentExecutor = artifactoryConcurrentExecutor;
    }

    @Override
    public int getActiveCount() {
        return artifactoryConcurrentExecutor.getActiveCount();
    }

    @Override
    public long getCompletedTaskCount() {
        return artifactoryConcurrentExecutor.getCompletedTaskCount();
    }

    @Override
    public int getCorePoolSize() {
        return artifactoryConcurrentExecutor.getCorePoolSize();
    }

    @Override
    public int getLargestPoolSize() {
        return artifactoryConcurrentExecutor.getLargestPoolSize();
    }

    @Override
    public int getMaximumPoolSize() {
        return artifactoryConcurrentExecutor.getMaximumPoolSize();
    }

    @Override
    public long getTaskCount() {
        return artifactoryConcurrentExecutor.getTaskCount();
    }
}
