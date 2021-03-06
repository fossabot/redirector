/**
 * Copyright 2017 Comcast Cable Communications Management, LLC
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package com.comcast.redirector.thucydides.steps.changes;

import com.comcast.redirector.thucydides.pages.GenericPageObjects;
import com.comcast.redirector.thucydides.pages.changes.PendingChangesPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApproveChangesPageSteps extends ScenarioSteps {
    private static final Logger log = LoggerFactory.getLogger(ApproveChangesPageSteps.class);

    PendingChangesPage pendingChangesPage;

    GenericPageObjects genericPage;

    @Step
    public ApproveChangesPageSteps openPage() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            log.error("Failed to pause page opening");
        }
        pendingChangesPage.open();

        return this;
    }

    @Step
    public ApproveChangesPageSteps approveAll() {
        pendingChangesPage.approveAll();
        genericPage.clickModalOkButton();

        return this;
    }

    @Step
    public ApproveChangesPageSteps approveWhitelisted() {
        pendingChangesPage.approveWhitelistedChange();

        return this;
    }

    @Step
    public ApproveChangesPageSteps approveRuleChange(String name) {
        pendingChangesPage.approveRuleChange(name);

        return this;
    }

    @Step
    public ApproveChangesPageSteps approveUrlRuleChange(String name) {
        pendingChangesPage.approveUrlRuleChange(name);

        return this;
    }
}
