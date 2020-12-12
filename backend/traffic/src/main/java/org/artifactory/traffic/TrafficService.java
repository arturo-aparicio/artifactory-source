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

package org.artifactory.traffic;

import org.artifactory.traffic.entry.TrafficEntry;

import java.util.Calendar;
import java.util.List;

/**
 * The main interface of the traffic service
 *
 * @author Noam Tenne
 */
public interface TrafficService {
    /**
     * Get a list of traffic entries for the specified time window (edges inclusive)
     */
    List<TrafficEntry> getEntryList(Calendar from, Calendar to);

    /**
     * Get a list of xray traffic entries for the specified time window (edges inclusive)
     */
    List<TrafficEntry> getXrayEntryList(Calendar from, Calendar to);

    /**
     * Store a new traffic entry for later processing (collection) dd
     *
     * @param entry
     */
    void handleTrafficEntry(TrafficEntry entry);

    /**
     * Get transfer usage for the specified time window (edges inclusive) filtered by ips
     */
    TransferUsage getTrafficUsageWithFilterCurrentNode(long startTime, long endTime, List<String> ipToFilter);

    /**
     * return true if The traffic service is active (if the traffic is collected for AOL)
     */
    boolean isActive();

    /**
     * Get transfer usage for the specified time window (edges inclusive) filtered by ips
     * Case the instance is an HA instance - collect traffic from all nodes and aggregate it to TransferUsage
     */
    TransferUsage getTrafficUsageWithFilter(long startLong, long endLong, List<String> ipsToFilter);

    void validateDateRange(Calendar startDate, Calendar endDate);
}