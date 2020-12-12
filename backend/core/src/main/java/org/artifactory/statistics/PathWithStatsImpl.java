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

package org.artifactory.statistics;

import org.artifactory.api.statistics.PathWithStats;
import org.artifactory.fs.StatsInfo;
import org.artifactory.repo.RepoPath;

import javax.annotation.Nonnull;

import static java.util.Objects.requireNonNull;

/**
 * @author Yinon Avraham.
 */
public class PathWithStatsImpl implements PathWithStats {

    private final RepoPath path;
    private final StatsInfo stats;

    public PathWithStatsImpl(RepoPath path, StatsInfo stats) {
        this.path = requireNonNull(path, "path is required");
        this.stats = requireNonNull(stats, "stats is required");
    }

    @Override
    @Nonnull
    public RepoPath getPath() {
        return path;
    }

    @Override
    @Nonnull
    public StatsInfo getStats() {
        return stats;
    }
}
