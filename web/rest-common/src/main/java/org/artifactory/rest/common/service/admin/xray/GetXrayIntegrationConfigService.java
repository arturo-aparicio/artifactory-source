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

package org.artifactory.rest.common.service.admin.xray;

import org.artifactory.api.config.CentralConfigService;
import org.artifactory.descriptor.repo.XrayDescriptor;
import org.artifactory.rest.common.model.xray.XrayIntegrationModel;
import org.artifactory.rest.common.service.ArtifactoryRestRequest;
import org.artifactory.rest.common.service.RestResponse;
import org.artifactory.rest.common.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Yuval Reches
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GetXrayIntegrationConfigService implements RestService {

    @Autowired
    private CentralConfigService configService;

    @Override
    public void execute(ArtifactoryRestRequest request, RestResponse response) {
        boolean enabled = false;
        boolean allowBlocked = false;
        boolean allowWhenUnavailable = false;
        boolean bypassDefaultProxy = false;
        String xrayProxy = null;
        int blockUnscannedTimeoutSeconds = 60;
        XrayDescriptor xrayConfig = configService.getDescriptor().getXrayConfig();
        if (xrayConfig != null) {
            enabled = xrayConfig.isEnabled();
            allowBlocked = xrayConfig.isAllowBlockedArtifactsDownload();
            allowWhenUnavailable = xrayConfig.isAllowDownloadsXrayUnavailable();
            bypassDefaultProxy = xrayConfig.isBypassDefaultProxy();
            xrayProxy = xrayConfig.getProxy();
            blockUnscannedTimeoutSeconds = xrayConfig.getBlockUnscannedTimeoutSeconds();
        }
        XrayIntegrationModel xrayIntegrationModel = new XrayIntegrationModel(enabled, allowBlocked,
                allowWhenUnavailable, bypassDefaultProxy, xrayProxy, blockUnscannedTimeoutSeconds);
        response.iModel(xrayIntegrationModel);
    }

}
