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

package org.artifactory.ui.rest.model.admin.configuration.repository.typespecific;

import org.artifactory.addon.AddonsManager;
import org.artifactory.descriptor.repo.RepoType;
import org.artifactory.rest.common.util.JsonUtil;

import static java.util.Optional.ofNullable;
import static org.artifactory.repo.config.RepoConfigDefaultValues.DEFAULT_LIST_REMOTE_ITEMS_SUPPORTED_TYPE;
import static org.artifactory.repo.config.RepoConfigDefaultValues.DEFAULT_LIST_REMOTE_ITEMS_UNSUPPORTED_TYPE;

/**
 * @author Dan Feldman
 */
public class GitLfsTypeSpecificConfigModel implements TypeSpecificConfigModel {

    //remote
    protected Boolean listRemoteFolderItems = DEFAULT_LIST_REMOTE_ITEMS_UNSUPPORTED_TYPE;

    public Boolean isListRemoteFolderItems() {
        return listRemoteFolderItems;
    }

    public void setListRemoteFolderItems(Boolean listRemoteFolderItems) {
        this.listRemoteFolderItems = listRemoteFolderItems;
    }

    @Override
    public void validateRemoteTypeSpecific() {
        setListRemoteFolderItems(ofNullable(isListRemoteFolderItems())
                .orElse(DEFAULT_LIST_REMOTE_ITEMS_SUPPORTED_TYPE));
    }

    @Override
    public void validateVirtualTypeSpecific(AddonsManager addonsManager) {
        setListRemoteFolderItems(ofNullable(isListRemoteFolderItems())
                .orElse(DEFAULT_LIST_REMOTE_ITEMS_SUPPORTED_TYPE));
    }

    @Override
    public RepoType getRepoType() {
        return RepoType.GitLfs;
    }

    @Override
    public String toString() {
        return JsonUtil.jsonToString(this);
    }
}
